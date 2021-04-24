/*
 * Copyright (c) 2021. Yuriy Stul
 */

package com.stulsoft.pjava.basics.regex;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Parser for MongoDB connection string
 *
 * @author Yuriy Stul
 */
public class MongodbConnectionStringParser {
    private static final Logger logger = LoggerFactory.getLogger(MongodbConnectionStringParser.class);

    private static final Pattern connectionStringPattern = Pattern.compile("^mongodb://(.*)@(.*)");

    public static void main(String[] args) {
        logger.info("==>main");
        test1();
        test2();
        test3();
        test4();
    }

    private static void test1() {
        logger.info("==>test1");
        try {
            MongoConnection mongoConnection = MongoConnection.create("mongodb://user:pass@host1:1234,host2:1234");
            logger.info("{}", mongoConnection);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    private static void test2() {
        logger.info("==>test2");
        try {
            MongoConnection mongoConnection = MongoConnection.create("mongodb://user:pass@host1:1234");
            logger.info("{}", mongoConnection);
        } catch (Exception exception) {
            logger.error(exception.getMessage());
        }
    }

    private static void test3() {
        logger.info("==>test3");
        var connectionString = "mon222godb://user:pass@host1:1234";
        try {
            MongoConnection mongoConnection = MongoConnection.create(connectionString);
            logger.info("{}", mongoConnection);
        } catch (Exception exception) {
            logger.error(exception.getMessage() + ": " + connectionString);
        }
    }

    private static void test4() {
        logger.info("==>test3");
        var connectionString = "mongodb://user:pass@host1!!!1234";
        try {
            MongoConnection mongoConnection = MongoConnection.create(connectionString);
            logger.info("{}", mongoConnection);
        } catch (Exception exception) {
            logger.error(exception.getMessage() + ": " + connectionString);
        }
    }

    static class MongoCredentials {
        private final String username;
        private final String password;

        public MongoCredentials(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "MongoCredential{" +
                    "username='" + getUsername() + '\'' +
                    ", password='" + getPassword() + '\'' +
                    '}';
        }
    }

    static class MongoServerAddress {
        private final String host;
        private final int port;

        public MongoServerAddress(String host, int port) {
            this.host = host;
            this.port = port;
        }

        @Override
        public String toString() {
            return "MongoServerAddress{" +
                    "host='" + host + '\'' +
                    ", port=" + port +
                    '}';
        }
    }

    static class MongoConnection {
        private final MongoCredentials mongoCredentials;
        private final List<MongoServerAddress> mongoServerAddressList;

        private MongoConnection(MongoCredentials mongoCredentials, List<MongoServerAddress> mongoServerAddressList) {
            this.mongoCredentials = mongoCredentials;
            this.mongoServerAddressList = mongoServerAddressList;
        }

        public static MongoConnection create(final String connectionString) throws IllegalArgumentException {
            try {
                var matcher = connectionStringPattern.matcher(connectionString);
                if (matcher.find()) {
                    if (matcher.groupCount() == 2) {
                        MongoCredentials mongoCredentials;
                        var usernameAndPass = matcher.group(1).split(":");
                        if (usernameAndPass.length != 2) {
                            var errMsg = "Wrong format: invalid credentials";
                            throw new IllegalArgumentException(errMsg);
                        } else {
                            mongoCredentials = new MongoCredentials(usernameAndPass[0], usernameAndPass[1]);
                        }

                        var serverAddresses = new ArrayList<MongoServerAddress>();
                        var hostsAndPorts = matcher.group(2).split(",");
                        for (var hostAndPortItem : hostsAndPorts) {
                            var hostAndPort = hostAndPortItem.split(":");
                            if (hostAndPort.length == 2) {
                                serverAddresses.add(new MongoServerAddress(hostAndPort[0], Integer.parseInt(hostAndPort[1])));
                            } else {
                                throw new IllegalArgumentException("Wrong format: invalid hosts");
                            }
                        }
                        return new MongoConnection(mongoCredentials, serverAddresses);
                    } else {
                        throw new IllegalArgumentException("Wrong format");
                    }
                } else {
                    throw new IllegalArgumentException("Wrong format");
                }
            } catch (Exception exception) {
                logger.error(exception.getMessage());
                throw new IllegalArgumentException(exception.getMessage());
            }
        }

        public MongoCredentials getMongoCredentials() {
            return mongoCredentials;
        }

        public List<MongoServerAddress> getMongoServerAddressList() {
            return mongoServerAddressList;
        }

        @Override
        public String toString() {
            return "MongoConnection{" +
                    "mongoCredentials=" + getMongoCredentials() +
                    ", mongoServerAddressList=" + getMongoServerAddressList() +
                    '}';
        }
    }
}
