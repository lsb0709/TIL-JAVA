package com.test.exam02;

interface InterfaceTest {
    public void print1(); // 구현해야 하는 메서드 목록

    public void print2();
}

class InterfaceChild implements InterfaceTest {

    @Override // 부모가 가지고 있는 메서드를 재정의 했다는 의미
    public void print1() {
        System.out.println("#1 출력");
    }

    @Override
    public void print2() {
        System.out.println("#2 출력");
    }

}

public class InterfaceExam {
    public static void main(String[] args) {
        InterfaceChild InterfaceChild = new InterfaceChild();
        InterfaceChild.print1();
        InterfaceChild.print2();
    }
}
