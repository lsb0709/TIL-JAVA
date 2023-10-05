package com.test.http;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.HashMap;

public class HttpClientTest {
    public static void main(String[] args) throws Exception {

        // URL 주소
        String address = "http://127.0.0.1/jsp/jdbctest_oracle.jsp";

        // URL Query --> 파라미터
        Map<String, String> params = new HashMap<>();
        params.put("rname", "최지훈");
        params.put("gender", "남자");
        params.put("age", "30");

        // Request 헤더 정보
        String[] headers = { "content-type", "application/x-www-form-urlencoded" };

        // POST 방식으로 서버에 값을 전달하여 Request 처리를 하고 Response로 페이지 Body를 가져 옴
        HttpClientRun.post(address, params, headers);

        // GET 방식으로 서버에 페이지 요청을 해서 Response로 페이지 Body를 가져 옴
        // HttpClientRun.get(address);
    }
}

class HttpClientRun {

    // GET 처리
    public static void get(String address) throws Exception {
        String[] headers = { "content-type", "text/html" };
        HttpClient client = HttpClient.newBuilder().version(Version.HTTP_1_1).build();

        String result = client.sendAsync(
                HttpRequest.newBuilder(new URI(address)) // 빌드 패턴으로 설정값 받음
                        .GET().headers(headers).build(), // GET 방식으로 Request
                HttpResponse.BodyHandlers.ofString() // Response를 문자열로 받는다
        ).thenApply(HttpResponse::body) // thenApply 메소드로 Respone의 Body를 받음
                .get().toString(); // get 메소드로 body의 내용를 받아서 문자열 타입으로 변환
        System.out.println("HTTP 본문 : " + result);

    }

    // POST 처리
    public static void post(String address, Map<String, String> params, String[] headers) throws Exception {
        BodyPublisher body = BodyPublishers.ofString(getFormDataAsString(params));
        HttpClient client = HttpClient.newBuilder().version(Version.HTTP_1_1).build();

        HttpResponse<String> response = client.send(
                HttpRequest.newBuilder(new URI(address)) // 빌드 패턴으로 설정값 받음
                        .POST(body).headers(headers).build(), // POST 방식 요청
                HttpResponse.BodyHandlers.ofString()); // Response
        System.out.println(response);
    }

    public static String getFormDataAsString(Map<String, String> formData) {
        StringBuilder formBodyBuilder = new StringBuilder();

        // formData.entrySet() --> {{"name", "김철수"}, {"gender", "남성"}, {"age", "30"}...}
        for (Map.Entry<String, String> singleEntry : formData.entrySet()) {

            if (formBodyBuilder.length() > 0) {
                formBodyBuilder.append("&"); // name=김철수&gender=남성&age=30
            }
            formBodyBuilder.append(URLEncoder.encode(singleEntry.getKey(), StandardCharsets.UTF_8));
            formBodyBuilder.append("=");
            formBodyBuilder.append(URLEncoder.encode(singleEntry.getValue(), StandardCharsets.UTF_8));

        }

        return formBodyBuilder.toString();
    }
}
