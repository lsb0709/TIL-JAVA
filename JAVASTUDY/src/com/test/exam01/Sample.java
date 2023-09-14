package com.test.exam01;

public class Sample {
    int x, y;
    static int result;

    void add(int a, int b)
    {
        x = a;
        y = b;
        int sum = x + y;
        System.out.println("Sum = " + sum);
    }

    public static void main(String[] args) {
        Sample obj = new Sample();
        obj.add(10, 20);    
    }
}
