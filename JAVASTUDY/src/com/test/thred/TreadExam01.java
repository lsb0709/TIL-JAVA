package com.test.thred;

class ExamClass implements Runnable {

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

// 자바에서 Tread란 비동기 처리를 하기 위한 모듈 클래스
public class TreadExam01 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ExamClass());
        thread.start();

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
