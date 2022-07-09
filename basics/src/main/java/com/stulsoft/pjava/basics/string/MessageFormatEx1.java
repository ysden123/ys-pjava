package com.stulsoft.pjava.basics.string;

import java.text.MessageFormat;
import java.util.Date;

/**
 * @author Yuriy Stul
 **/
public class MessageFormatEx1 {
    public static void main(String[] args) {
        System.out.println(MessageFormat.format("at {0, time} {0, date} - {0}", new Date()));
        System.out.println(MessageFormat.format("at {0, Time} {0, Date} - {0}", new Date()));
    }
}
