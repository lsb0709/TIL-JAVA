package com.test.exam02;

public class GenericTest01 {
    public static void main(String[] args) {
        GStack<String> strinGStack = new GStack<String>(); // String 타입 자체를 인자로 넘김.

        strinGStack.push("Seoul");
        strinGStack.push("Busan");
        strinGStack.push("LA");

        for (int i = 0; i < 3; i++) {
            System.out.println(strinGStack.pop());
        }

    }
}

class GStack<T> {
    int tos; // 선언 --> 컴파일러에게 공지
    Object[] stck; // 배열 요소의 타입은 Object 선언

    public GStack() { // 생성자
        tos = 0;
        stck = new Object[10]; // 10개의 Object를 가진 배열을 생셩
    }

    public void push(T item) {
        if (tos == 10)
            return;
        stck[tos] = item;
        tos++;
    }

    public T pop() {
        // 넣은 순서 반대로. 즉, 가장 늦게 넣은 값이 가장 먼저 나온다 --> Last Input First Out(LIFO)
        // 자료 구조에서 LIFO 방식으로 데이터를 관리하는 메모리 공간을 Stack 이라 함. => 후입선출
        // 반대로 가장 먼저 넣은 값이 가장 먼저 나오는 방식을 First Input First Out(FIFO)
        // 자료 구조에서 FIFO 방식으로 데이터를 관리하는 메모리 공간을 Queue => 선입선출
        if (tos == 0)
            return null; // T에 뭐가 들어 올지 아직 정해지지 않았기 때문에 뭔가 리턴해줘야 하기 때문에 null을 사용함
        tos--;
        return (T) stck[tos];
    }
}
