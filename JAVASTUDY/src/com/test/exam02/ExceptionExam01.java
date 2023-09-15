package com.test.exam02;

public class ExceptionExam01 {
    public static void main(String[] args) {
        int c; // 원래 c는 양수가 나오기로 되어 있다라고 가정
        int b = 0;
        int a;
        try{
            c = 4/b;
            a = 100;
        }catch(ArithmeticException e){
            c = -1; // 예외 발생 시 처리하는 명령어
            e.printStackTrace();
            System.out.println("c = " + c);
        }finally{ // 예외가 발생하더라도 반드시 실행해야 할 명령문
            a = 100;
            System.out.println("a = " + a);
        }
    }
}
