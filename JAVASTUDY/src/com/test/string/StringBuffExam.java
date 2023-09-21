package com.test.string;

public class StringBuffExam {
    public static void main(String[] args) {
        // StringBuffer는 대용량 데이터 처리와 멀티 쓰레드 환경에서 우수한 성능을 발휘
        // StringBuilder는 StringBuffer보다는 멀티쓰레드 환경에서의 안전성은 다소 낮지만, StringBuffer보다 성능이 우수
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Hello");
        stringBuffer.append(" ");
        stringBuffer.append("My World");
        String result1 = stringBuffer.toString();
        System.out.println(result1);

        stringBuffer.insert(0, "Everyone, ");
        String result2 = stringBuffer.toString();
        System.out.println(result2);

        // 문자열 0부터 시작해서 8번째 자리까지의 "문자열을 리턴"
        String result3 = stringBuffer.substring(0, 8);
        System.out.println(result3);
    }
}
