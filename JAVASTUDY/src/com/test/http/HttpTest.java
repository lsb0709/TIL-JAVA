package com.test.http;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTest {
    public static void main(String[] args) {
        String targetURL = "http://127.0.0.1/servelet/jdbctest_registry";
        String parameters = "rname=최민철&gender=남성&age=30";
        TestHttpRequest.testHttpRequest(targetURL, parameters);

    }
}

class TestHttpRequest {
    public static void testHttpRequest(String targetURL, String parameters) {

        HttpURLConnection connection = null;

        // connection 생성
        try {
            URL url = new URL(targetURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            connection.setRequestProperty("Content-Language", "ko-KR");
            connection.setUseCaches(false);
            connection.setDoOutput(true); // OutputStream으로 POST 데이터를 넘겨주겠다는 옵션

            // Request 처리
            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
            wr.write(parameters.getBytes("utf-8"));
            wr.flush();
            wr.close();

            // Response 처리
            int responseCode = connection.getResponseCode();
            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line).toString();
                response.append("\r\n");
            }
            rd.close();

            System.out.println("HTTP 응답 코드 : " + responseCode);
            System.out.println("HTTP 응답 헤더" + connection.getHeaderFields());
            System.out.println("HTTP BODY : " + response.toString());

        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
        }

    }
}