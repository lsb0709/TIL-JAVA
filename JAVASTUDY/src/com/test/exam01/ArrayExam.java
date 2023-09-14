package com.test.exam01;

import java.util.Arrays;

public class ArrayExam {
    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 3, 4, 5, 6};

        // For문을 이용하여 배열의 요소값을 추출 #1
        for(int i = 0; i < a.length; i++)
        System.out.println(a[i] + " ");
        System.out.println("\n");

        // 배열 전용 for문을 이용하겨 배열의 요소값을 추출 #2
        for(int i: a) System.out.println(i + " ");
        System.out.println("\n");
        
        // For문을 이용하여 배열의 요소값을 추출 #1
        System.out.println(Arrays.toString(a));
        
        int[][] b = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("b[0][2] = " + b[0][2]);
        System.out.println("b[1][2] = " + b[1][2]);
        System.out.println("b[2][0] = " + b[2][0]);
        
        for(int i = 0; i < b.length; i++)
        System.out.println(Arrays.toString(b[i]));


    ////////////////// 2차원 동적 배열 예제 ///////////////////////
    int intArray[][] = new int[4][];
    intArray[0] = new int[3];
    intArray[1] = new int[2];
    intArray[2] = new int[3];
    intArray[3] = new int[2];

    for(int i = 0; i < intArray.length; i++)
        for(int j = 0; j < intArray[i].length; j++)
            intArray[i][j] = (i + 1) * 10 + j;

    for(int i = 0; i < intArray.length; i++){
        for(int j = 0; j < intArray[i].length; j++)
                System.out.print(intArray[i][j] + " ");
            System.out.println();
        }
    }
}

