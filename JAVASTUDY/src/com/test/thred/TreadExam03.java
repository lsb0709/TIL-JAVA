package com.test.thred;

public class TreadExam03 {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {

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

        }).start(); // Thead.start()

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
