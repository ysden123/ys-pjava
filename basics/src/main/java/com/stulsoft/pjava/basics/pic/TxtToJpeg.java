/*
 * Copyright (c) 2021. Yuriy Stul
 */

package com.stulsoft.pjava.basics.pic;

import java.io.FileOutputStream;
import java.util.Base64;

/**
 * @author Yuriy Stul
 */
public class TxtToJpeg {
    public static void main(String[] args) {
        System.out.println("==>main");
//        convert("picSTG.txt","c:/work/picSTG.jpeg");
        convert("picDev.txt","c:/work/picDev.jpeg");
//        convert("picQA.txt","c:/work/picQA.jpeg");
//        convert("picQA1.txt","c:/work/picQA1.jpeg");
    }

    private static void convert(String source, String destination){
        System.out.println("==>convert");
        try {
            var file = TxtToJpeg.class.getClassLoader().getResourceAsStream(source);
            var output = new FileOutputStream(destination);
            var bytes = file.readAllBytes();
            output.write(Base64.getDecoder().decode(bytes));
            file.close();
            output.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
