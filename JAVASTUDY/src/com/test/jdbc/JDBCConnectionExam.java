package com.test.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.test.member.Member;

public class JDBCConnectionExam {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        String uri = "jdbc:oracle:thin:@localhost:1521:xe";
        String userid = "springdev";
        String userpw = "1234";
        String query = "select id, name, gender, age from tbl_test order by id asc";
        String query1 = "insert into tbl_test(id, name, gender, age) values (tbl_test_seq.nextval,\'김길동\', \'남성\', '23')";

        Connection con; // 파이프라인
        Statement stmt;
        ResultSet rs;

        Class.forName("oracle.jdbc.driver.OracleDriver"); // JDBC 드라이버를 로딩
        con = DriverManager.getConnection(uri, userid, userpw); // uri, userid, userpw 값으로 DB 연결 시도
        stmt = con.createStatement(); // SQL이 실행 될 수 있는 환경 생성
        stmt.executeUpdate(query1); // insert, update, delete 같은 DML 명령문을 실행
        rs = stmt.executeQuery(query); // SQL문을 실행해서 그 결과를 ResultSet이란 Collection 객체에 담는다.

        List<Member> list = new ArrayList<>();

        // rs.next() --> DB에서 읽어와서 ResultSet()에 저장된 값들을 한줄씩 읽고 더 이상 읽을 줄이 없으면 false를 리턴
        while (rs.next()) {
            // list.add(new Member(rs.getInt("id"),
            // rs.getString("name"),
            // rs.getString("gender"),
            // rs.getInt("age")));

            // 빌드 패턴을 이용해서 Member 클래스에 값을 입력
            list.add(new Member.Builder()
                    .id(rs.getInt("id"))
                    .name(rs.getString("name"))
                    .gender(rs.getString("gender"))
                    .age(rs.getInt("age"))
                    .build());
        }

        // for (Member member : list) {
        // System.out.println(
        // "번호 : " + member.getid() + "\t" +
        // "이름 : " + member.getName() + "\t" +
        // "성별 : " + member.getGender() + "\t" +
        // "나이 : " + member.getAge());
        // }

        list.stream().filter(member -> member != null).forEach(l -> System.out.println(
                "번호 : " + l.getid() + "\t" +
                        "이름 : " + l.getName() + "\t" +
                        "성별 : " + l.getGender() + "\t" +
                        "나이 : " + l.getAge()));

        if (rs != null)
            rs.close();
        if (stmt != null)
            stmt.close();
        if (con != null)
            con.close();
    }
}
