package com.test.exam02;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface // 여기 아래에 나오는 인터페이스는 람다표현식으로 만들 떄 사용할 인터페이스 --> 컴파일러에게 통지
interface MyLambdaFunction {
    int sum(int a, int b);
}

@FunctionalInterface
interface MyPrint {
    String printLambda();
}

public class LambdaExam01 {
    public static void main(String[] args) {

        // 람다식을 이용한 익명함수 : 2개의 인자를 받아서 메소드로 계산 후 그 값을 반환하는 형태
        MyLambdaFunction lambdaFunction = (int a, int b) -> a + b; // 인터페이스 내의 메소드 선언을 구현

        /*
         * public int sum(int a, int b){
         * return a + b;
         * }
         */

        System.out.println(lambdaFunction.sum(3, 4));

        // 람다식을 이용한 익명함수 : 인자 없이 문자열만 반환
        MyPrint myPrint = () -> "Hello World"; // 람다표현식으로 구현체를 만듬
        /*
         * public String printLambda(){
         * return "Hello World";
         * }
         */

        System.out.println(myPrint.printLambda());

        // 위에 코드는 개발자가 람다표현식으로 인터페이스 내에 선언된 메소드를 구현하는 방법을 구현
        // 아래 코드부터는 이미 만들어진 람다표현식을 위한 인터페이스를 가져다가 활용하는 예제를 구현
        // 인터페이스 종류 : Supplier, Consumer, Function, Predicate

        // supplier : 매개변수 없이 반환값만 갖는 함수형 인터페이스
        Supplier<String> supplier = () -> "매개변수 없이 반환값만 갖는 함수형 인터페이스";
        System.out.println(supplier.get()); // 위 코드에서 만든 람다표현식을 정의한 메소드를 실행

        // Consumer : 객체 T를 매개변수로 받아서 사용하며, 반환값은 없는 함수형 인터페이스
        // Consumer<String> consumer = (str) -> System.out.println(str.split(" ")[0]);
        Consumer<String> consumer = (s) -> System.out.println("오늘은 " + s + "요일");
        // (str) -> System.out.println(str.split(" ")[0]); split은 문자열을 구분자로 쪼개 주는 메소드
        // (s) -> System.out.println("오늘은 " + s + "요일")
        consumer.accept("수");

        // Function : 객체 T를 매개변수로 받아서 처리한 후 R로 반환하는 함수형 인터페이스
        Function<String, Integer> function = (str) -> str.length();
        System.out.println(function.apply("안녕하세요? 좋은 하루..."));

        // 매소드 참조(method referance)
        // 클래스 이름::메소드이름 or 참조변수이름::메소드이름
        // String s; --> s가 참조변수 이름
        Function<String, Integer> function2 = String::length;
        System.out.println(function2.apply("좋은 아침 ~~"));

        // 생성자 참조(constructor refernce)
        // Function<Integer, double[]> function3 = a -> double[]::new; => 거의 쓰이진 않지만 이런
        // 방법도 있다.

        // Predicate : 객체 T를 매개변수로 받아 처리한 후 Boolean을 반환
        Predicate<String> predicate = (str) -> str.equals("Hello");
        System.out.println(predicate.test("Hello1"));

    }
}
