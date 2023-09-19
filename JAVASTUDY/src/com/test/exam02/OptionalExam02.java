package com.test.exam02;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalExam02 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("Hello");
        list1.add("Java");
        list1.add("World");

        // ifPresent() 사용 예제: null이 발생하면 실행하지 않음
        Optional<List<String>> option1 = Optional.ofNullable(list1);
        option1.ifPresent(s -> System.out.println(s));

        System.out.println(list1.toString());

        // Optional 객체의 함수형 프로그램 특성 사용
        String a = "ABCD";
        String result;
        Optional<String> optional2 = Optional.ofNullable(a);

        result = optional2.filter(s -> s.startsWith("AB")).orElse("A로 시작되는 값이 없어요");
        System.out.println(result);

        System.out.println(Optional.of("XYZ").map(String::toLowerCase).orElse("오류 발생 !!!"));
    }
}
