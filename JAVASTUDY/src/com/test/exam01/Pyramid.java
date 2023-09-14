package com.test.exam01;

public class Pyramid {
    public static void main(String[] args) {
        int num = 10;
        System.out.println("\n 왼쪽에서 오른쪽으로 *이 하나씩 증가\n");

        for(int i=0; i<num; i++){ // 0~9까지 반복 할때
            for(int j=0; j<=i; j++) // 1 0 => 1 1
                System.out.print("*");
            System.out.println("");
        }

        System.out.println("\n 오른쪽에서 왼쪽으로 *이 하나씩 증가\n");
        for(int i=0; i<num; i++) {
            for(int j=0; j<(num-1)-i; j++)
                System.out.print(" ");
            for(int j=0; j<=i; j++)
                System.out.print("*");
            System.out.println("");
            
        }
    }
}
