package com.test.exam02;

enum Week1 { // 특정 상수들을 모아서 관리할 목적으로 사용하는 클래스
    SUN, MON, TUE, WED, THU, FRI, SAT
}

enum Week2 { // aliasing
    SUN("일"), MON("월"), TUE("화"), WED("수"), THU("목"), FRI("금"), SAT("토");

    private final String day;
    // 이런 형태의 enum 클래스에서는 멤버변수를 하나 만들고, 이것을 getter 타입으로 추출하면
    // ()내의 상수값이 추출됨

    Week2(String day) {
        this.day = day;
    }

    String getDay() {
        return this.day;
    }
}

public class EnumExam {

    /*
     * 열거형은 enum 키워드를 사용하여 정의하며, 열거형의 이름은 보통 클래스명과 같이 첫글자를 대문자로 시작
     * { } 안에 열거값은 ,로 구분하며 상수와 같이 대문자를 사용
     * 열거형의 선언은 클래스 안에서도 선언할 수 있고, 클래스 밖에서도 선언할 수 있음
     * 
     * enum 메소드
     * - valueOf(String str) : 문자열 str과 일치하는 열거값을 반환
     * - values() : 열거값 전부를 배열로 반환
     * - ordinal() : 열거값의 순서를 반환 : 시작은 0부터
     * - name() : enum 타입의 값이 가지고 있는 문자열을 반환
     */

    public static void main(String[] args) {

        String s = "MON";
        Week1 w1 = Week1.SUN;
        Week2 w2 = Week2.valueOf(s); // 문자열 s와 일치하는 열거값을 반환

        System.out.println(w1);
        System.out.println(w2);

        Week1[] arrayWeek1 = Week1.values(); // { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" }

        for (Week1 w : arrayWeek1) {
            switch (w) {
                case SAT:
                    System.out.print("토요일" + ",");
                    break;
                case SUN:
                    System.out.print("일요일" + ",");
                    break;
                default:
                    System.out.print("평일" + ",");
            }
        }

        System.out.println();

        Week2[] arrayWeek2 = Week2.values();

        for (Week2 w : arrayWeek2) {
            System.out.println(" " + w.name());
            if (w == Week2.WED) {
                System.out.println();
                System.out.println(w.ordinal() + "번쨰 요일은 " + w.getDay());
            }
        }

    }
}
