package com.test.exam01;

public class Sample {
    int x, y; // 전역변수 (Global 변수)
    static int result;

    void add(int a, int b){ // 매개변수, Parameter
        x = a;
        y = b;
        int sum = x + y; // 로컬변수, 지역변수
        System.out.println("Sum = " + sum);
    }

    public static void main(String[] args) {
        Sample obj = new Sample();
        obj.add(10, 20);    
    }
}