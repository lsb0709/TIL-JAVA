package com.test.exam02;

public class ClassExam01 {
    public static void main(String[] args) {
        Sum sum = new Sum(); // 클래스 참조형 변수 선언 미 정의 --> 인스턴스화(Instance)
        System.out.println("Sum 클래스의 멤버변수 a = " + sum.a);
        System.out.println("Sum 클래스의 멤버변수 b = " + sum.b);
        System.out.println("4와 5의 합은 " + sum.sum(4, 5) + "입니다.");
    }
}

class Sum { // 객체의 속성과 액션을 코드화한 템플리트(틀)
    int a = 3;
    int b = 4;
    public int sum(int a, int b){
        return a + b;
    }
}
