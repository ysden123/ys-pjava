package com.stulsoft.pjava.basics.regex;

import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class GlobEx01 {
    public static void main(String[] args) {
        System.out.println("==>main");
        test1();
    }

    private static void test1() {
        System.out.println("==>test1");
        String globPattern = "glob:*.txt";
        List<String> filenames= Arrays.asList(
                "123.txt",
                "654.ttt"
        );
        test(globPattern, filenames);
    }

    private static void test(String globPattern, List<String> filenames){
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher(globPattern);
        for(String filename:filenames){
            System.out.printf("%s matches %s = %b%n", filename, globPattern, pathMatcher.matches(Paths.get(filename)));
        }
    }
}
