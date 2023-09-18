package com.test.exam02;

public class ExceptionExam01 {
    public static void main(String[] args) throws ArithmeticException, Exception {
        /*
         * try-catch-finally 예제
         * int c; // 원래 c는 양수가 나오기로 되어 있다라고 가정
         * int b = 0;
         * int a;
         * try{
         * c = 4/b;
         * a = 100;
         * }catch(ArithmeticException e){
         * c = -1; // 예외 발생 시 처리하는 명령어
         * e.printStackTrace();
         * System.out.println("c = " + c);
         * }finally{ // 예외가 발생하더라도 반드시 실행해야 할 명령문
         * a = 100;
         * System.out.println("a = " + a);
         * }
         * 
         * // throws 예제
         * System.out.println("a= " + a);
         */

        // int c;
        // int b = 0;
        // int a;

        ErrorTest errorTest = new ErrorTest();
        // errorTest.sayNickName("천재");
        errorTest.sayNickName("fool");

    }
}

class FoolException extends Exception {
} // 개발자가 직접 예외처리클래스를 만들수도 있음

class ErrorTest {
    public void sayNickName(String nickname) {

        try {
            if (nickname.equals("fool"))
                throw new FoolException();
            System.out.println("당신의 별명은 " + nickname + "입니다.");
        } catch (FoolException e) {
            System.out.println("뭐지???");
        }
    }
}
