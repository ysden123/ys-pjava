/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.pjava.basics.exam;

//import java.util.Arrays;

/**
 * @author Yuriy Stul
 */
public class Exam {
/*
    public int missing(int[] A){
        int[] sorted= Arrays.copyOf(A, A.length);

        Arrays.sort(sorted);
        int n = sorted[sorted.length -1] + 1;
        for(int i =0; i < sorted.length -1;++i){
            if (sorted[i + 1] - sorted[i] > 1){
                n=sorted[i] + 1;
                break;
            }
        }
        return n <= 0? 1: n;
    }
*/

    /*
        public int solution(int[] blocks) {
            try {
                if (blocks == null)
                    throw new RuntimeException("Wrong data: blocks is null");
                for(var i : blocks){
                    if (i < 0) {
                        throw new RuntimeException("Wrong data: blocks contains negative value");
                    }
                }
                Integer sumMax = null;
                int start;
                var distanceMax = 0;
                int i;

                if (blocks.length < 2) {
                    distanceMax = blocks.length;
                } else {
                    i = 0;
                    while (i < blocks.length - 1) {
                        while ((i - 1 >= 0) && (i < blocks.length) && (blocks[i - 1] == blocks[i]))
                            --i;
                        start = i;
                        var sumDown = blocks[i];
                        while ((i + 1 < blocks.length) && (blocks[i + 1] <= blocks[i])) {
                            sumDown += blocks[++i];
                        }
                        var sumUp = 0;
                        while ((i + 1 < blocks.length) && (blocks[i + 1] >= blocks[i])) {
                            sumUp += blocks[++i];
                        }
                        var sum = sumUp + sumDown;
                        if ((sumMax == null) || (sum > sumMax)) {
                            sumMax = sum;
                            distanceMax = i - start + 1;
                        }
                    }
                }
                return distanceMax;
            }catch(Exception exception){
                exception.printStackTrace();
                throw exception;
            }
        }
    */
    int solution(int n) {
        System.out.println(n);
        int[] d = new int[Integer.toBinaryString(Integer.MAX_VALUE).length()];
        int l = 0;
        int p;
        while (n > 0) {
            d[l] = n % 2;
            n /= 2;
            l++;
        }
        for (p = 1; p < 1 + l; ++p) {
            int i;
            boolean ok = true;
            for (i = 0; i < l - p; ++i) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return p;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Exam exam = new Exam();
/*
        System.out.printf("n=%d%n", exam.missing(new int[]{1,2,3}));
        System.out.printf("n=%d%n", exam.missing(new int[]{1,5,7}));
        System.out.printf("n=%d%n", exam.missing(new int[]{-1,1}));
        System.out.printf("n=%d%n", exam.missing(new int[]{-1,2}));
        System.out.printf("n=%d%n", exam.missing(new int[]{-1,0}));
*/
/*
        System.out.printf("%d%n", exam.solution(new int[]{1, 5, 5, 2, 6}));
        System.out.printf("%d%n", exam.solution(new int[]{1, 1}));
*/
        System.out.printf("%d%n", exam.solution(955));
        System.out.printf("%d%n", exam.solution(1));
        System.out.printf("%d%n", exam.solution(656757657));
        System.out.printf("%d%n", exam.solution(Integer.MAX_VALUE));
    }
}
