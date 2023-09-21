package com.test.string;

import java.util.HashMap;
import java.util.Map;

public class MapExam {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("key01", "value01");
        map.put("key02", "value02");
        map.put("key03", "value03");
        map.put("key04", "value04");
        map.put("key05", "value05");

        // 전체 값을 불러오는 방법
        // 방법1 : entrySet() : key와 value 모두 반환
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("[key]:" + entry.getKey() + ",[value]:" + entry.getValue());
        }
    }
}
