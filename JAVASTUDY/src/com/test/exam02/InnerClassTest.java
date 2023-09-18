package com.test.exam02;

public class InnerClassTest {
    public static void main(String[] args) {
        OutClass outClass = new OutClass(); // 1. 외부클래스를 인스턴스화 시킨다. 클래스변수 outClass 정의

        // OutClass의 내부 클래스인 InClass를 인스턴스화해서 메모리에 생성하고 그 클래스변수 이름을
        // inClass라고 함
        OutClass.InClass inClass = outClass.new InClass(); // 1에서 만든 외부클래스 변수(outClass).new 내부클래스명 생성자
        inClass.inTest();
        outClass.usingClass();
        System.out.println("inClass.inNum = " + inClass.inNum);
    }

}

class OutClass {

    private int num = 10; // OutClass의 멤버 변수
    private static int sNum = 20; // OutClass의 멤버 변수
    private InClass inClass; // OutClass의 멤버 변수

    public OutClass() { // OutClass의 생성자
        // 내부 클래스를 인스턴스화 시켜 OutClass가 인스턴스화해서 생성될 때 같이 생성되도록 함
        inClass = new InClass();
    }

    // OutClas의 메소드
    public void usingClass() {
        inClass.inTest();
    }

    // OutClass의 내부 클래스
    class InClass {
        int inNum = 100; // OutClass의 내부 클래스인 InClass의 멤버 변수

        void inTest() { // OutClass의 내부
            System.out.println("외부 클래스의 인스턴스 변수 : " + num);
            System.out.println("외부 클래스의 정적 변수 : " + sNum);
        }
    }

}
