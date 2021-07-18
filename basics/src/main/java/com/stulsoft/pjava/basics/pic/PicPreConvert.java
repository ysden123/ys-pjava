/*
 * Copyright (c) 2021. Yuriy Stul
 */

package com.stulsoft.pjava.basics.pic;

import java.io.FileOutputStream;
import java.util.Base64;

/**
 * @author Yuriy Stul
 */
public class PicPreConvert {
    public static void main(String[] args) {
        System.out.println("==>main");
        test1();
    }
    private static void test1(){
        System.out.println("==>test1");

        try {
            var file = TxtToJpeg.class.getClassLoader().getResourceAsStream("picQA.txt");
            var output = new FileOutputStream("c:/work/picQAConverted.jpeg");
            var bytes = file.readAllBytes();
            for(int i = 0; i < bytes.length;++i){
                if (bytes[i] == '_')
                    bytes[i] = '/';
                else if (bytes[i] == '-')
                    bytes[i] = '+';
                if (bytes[i] == '0'){
                    System.out.println("i = " + i);
                }
            }
            var newBytes = new byte[bytes.length + 1];
            newBytes[bytes.length] = '=';

            output.write(Base64.getDecoder().decode(newBytes));
            file.close();
            output.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
