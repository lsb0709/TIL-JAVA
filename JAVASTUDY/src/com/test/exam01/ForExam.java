package com.test.exam01;

public class ForExam {
    public static void main(String[] args) {

        // 조건문 예제 //

        int a = 3;
        if (a > 5) {
            System.out.println("5보다 크네요..");
            System.out.println("값이 뭔가요?");
        } else if (a > 3) {
            System.out.println("3보다 크네요..");
            System.out.println("값이 뭔가요?");
        } else if (a > 2) {
            System.out.println("2보다 크네요...");
            System.out.println("값이 뭔가요?");
        }

        int b;
        b = a == 3 ? 5 : 6;
        System.out.println("b의 값은 " + b + "입니다");

        int c = 3;
        switch (c) {
            case 3:
                System.out.println("3 입니다.");
                break; // 일치할 경우 블록에서 빠져 나와라
            case 4:
                System.out.println("4 입니다.");
                break;
            default:
                System.out.println("무슨 값인지 모르겠습니다."); // 생략 가능. 맞는 조건이 없을 때 수행

        }

        // 반복문 예제 //

        int i = 0;
        int sum = 0;

        // for(시작; 조건; 증가) { }
        for (i = 0; i <= 100; i++) {
            sum = sum + i;
        }
        System.out.println("For문을 이용하여 1부터 100까지 합 구하기 #1 = " + sum);

        sum = 0;
        for (i = 0; i <= 100; sum += i++)
            ;
        System.out.println("For문을 이용하여 1부터 100까지 합 구하기 #2 = " + sum);

        // while(조건) { };
        i = 0;
        sum = 0;
        while (true) {
            sum += i++;
            if (i > 100)
                break;
        }
        System.out.println("while 문을 이용하여 1부터 100까지 합 구하기 #1 = " + sum);

        i = 0;
        sum = 0;
        while (true) { // 조건이 맞으면 반복을 실행
            sum += i++;
            if (i <= 100)
                continue;
            else
                break;
        }
        System.out.println("while 문을 이용하여 1부터 100까지 합 구하기 #2 = " + sum);

        // do while문 : do{ } while(조건)
        i = 0;
        sum = 0;
        do {
            sum += i++;
        } while (i <= 100); // 조건이 맞으면 반복을 실행
        System.out.println("do~while 문을 이용하여 1부터 100까지 합 구하기 #1 = " + sum);

    }

}