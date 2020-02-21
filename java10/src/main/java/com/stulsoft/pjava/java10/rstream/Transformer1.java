/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.pjava.java10.rstream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Function;

/**
 * Playing with reactive stream with transformer
 *
 * @author Yuriy Stul
 */
public class Transformer1 {
    private static final Logger logger = LoggerFactory.getLogger(RStream1.class);

    private static class MySubscriber implements Flow.Subscriber<String> {
        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            logger.info("==>onSubscribe, subscriber: {}", subscription.toString());
            this.subscription = subscription;
            this.subscription.request(1);
            logger.info("onSubscribe requested 1 item");
        }

        @Override
        public void onNext(String item) {
            logger.info("==>onNext, item: {}", item);
            this.subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            logger.info("==>onError, subscriber: {}", throwable.getMessage());
        }

        @Override
        public void onComplete() {
            logger.info("==>onComplete");
        }
    }

    private static class MyProcessor extends SubmissionPublisher<String> implements Flow.Processor<String, String> {
        private final Function<String, String> transformer;

        private Flow.Subscription subscription;

        MyProcessor(final Function<String, String> transformer) {
            super();
            this.transformer = transformer;
        }

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            logger.info("==>onSubscribe, subscriber: {}", subscription.toString());
            this.subscription = subscription;
            this.subscription.request(1);
            logger.info("onSubscribe requested 1 item");
        }

        @Override
        public void onNext(String item) {
            logger.info("==>onNext, item: {}", item);
            submit(transformer.apply(item));
            this.subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            logger.info("==>onError, subscriber: {}", throwable.getMessage());
        }

        @Override
        public void onComplete() {
            logger.info("==>onComplete");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        logger.info("==>main");
        Transformer1.MySubscriber subscriber = new Transformer1.MySubscriber();

        SubmissionPublisher<String> publisher = new SubmissionPublisher<>() {
        };
        Transformer1.MyProcessor processor = new Transformer1.MyProcessor(s -> s + " TRANSFORMED");

        //Create chain of publisher, processor and subscriber
        publisher.subscribe(processor);     // publisher -> processor
        processor.subscribe(subscriber);    // processor -> subscriber

        var items = List.of("line 1",
                "line 2",
                "line 3",
                "line 4",
                "line 5");
        items.forEach(publisher::submit);

        Thread.sleep(1000);

        publisher.close();
        logger.info("<==main");
    }
}
