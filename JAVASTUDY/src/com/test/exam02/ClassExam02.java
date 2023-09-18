package com.test.exam02;

public class ClassExam02 {
    public static void main(String[] args) {
        Parent parent = new Parent();
        Child child1 = new Child();
        Child2 child2 = new Child2();
        // AbstractClass abstract
        child1.ParentHello();
        child2.print1();
        child2.print2();
    }
}

class Parent {
    int a = 10;
    int b = 20;

    public void ParentHello() {
        System.out.println("Hello");
    }
}

class Child extends Parent {
    @Override // Annotation --> 컴파일러에게 통지 -> 상속받은 메소드의 내용을 조금 바꾸겠다 그리고 바꾼 것을 사용하겠다
    public void ParentHello() {
        // super.ParentHello();
        System.out.println("안녕 ~");
    }
}

// 추상클래스 -- 업무 지시서, Framework
abstract class AbstractClass {
    int c = 100;
    int d = 200;

    public void print1() { // 추상클래스는 실행부가 있는 일반 메소드도 가질수 있음.
        System.out.println("#1 출력");
    }

    abstract public void print2(); // 추상 메소드
}

class Child2 extends AbstractClass {

    @Override
    public void print2() {
        System.out.println("추상클래스");
    }

}
