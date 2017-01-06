/*
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */
package com.stulsoft.pjava.basics.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Usage Files walkFileTree
 *
 * @author Yuriy Stul
 */
public class FileTreeWalk {
    private static void test01() {
        System.out.println("==>test01");
        String startFolder = "d:/work";
        try {
            StringBuilder buffer = new StringBuilder();
            Files.walkFileTree(Paths.get(startFolder), new SimpleFileVisitor<Path>() {
                /*
                 * (non-Javadoc)
                 *
                 * @see java.nio.file.SimpleFileVisitor#visitFile(java.lang.Object, java.nio.file.attribute.BasicFileAttributes)
                 */
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    String message = String.format("file: %s, parent: %s", file.getFileName(), file.getParent());
                    System.out.println(message);
                    buffer.append(message);
                    buffer.append("\n");
                    return super.visitFile(file, attrs);
                }

                /*
                 * (non-Javadoc)
                 *
                 * @see java.nio.file.SimpleFileVisitor#postVisitDirectory(java.lang.Object, java.io.IOException)
                 */
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    String message = String.format("directory: %s, parent: %s", dir.getFileName(), dir.getParent());
                    System.out.println(message);
                    buffer.append(message);
                    buffer.append("\n");
                    return super.postVisitDirectory(dir, exc);
                }
            });
            System.out.println("buffer:\n" + buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("<==test01");
    }

    public static void main(String[] args) {
        System.out.println("==>main");
        test01();
        System.out.println("<==main");

    }
}
