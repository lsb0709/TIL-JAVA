package com.test.thred;

class ExamClass04 {
    public void examA() {

        synchronized (this) {
            System.out.println("ExamA의 시작");
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("철수 안녕 !!!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("ExamA의 끝");
        }
    }

    public synchronized void examB() {
        System.out.println("ExamB의 시작");
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("영희 안녕 !!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("ExamB의 끝");
    }
}

public class TreadExam04 {
    public static void main(String[] args) {
        ExamClass04 examClass04 = new ExamClass04();

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                examClass04.examA();
            }
        });

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                examClass04.examB();
            }
        });

        thread1.start();
        thread2.start();
    }
}
