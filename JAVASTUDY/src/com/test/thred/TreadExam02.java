package com.test.thred;

class ExamClass02 extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 작동");
        }
    }
}

public class TreadExam02 {
    public static void main(String[] args) throws InterruptedException {
        ExamClass02 examClass02 = new ExamClass02();
        examClass02.start();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("철수 안녕 !!!");
        }
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("영희 안녕 !!!");
        }
    }
}
