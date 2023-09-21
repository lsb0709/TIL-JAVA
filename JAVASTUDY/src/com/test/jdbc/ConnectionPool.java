package com.test.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test.member.Member;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionPool {
    public static void main(String[] args) {
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        hikariConfig.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:xe");
        hikariConfig.setUsername("springdev");
        hikariConfig.setPassword("1234");
        hikariConfig.setConnectionTestQuery("select sysdate from dual");
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setLeakDetectionThreshold(30000);
        hikariConfig.setPoolName("Orcle-HikariCP");

        String query = "select id, name, gender, age from tbl_test order by id asc";
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        HikariDataSource ds = new HikariDataSource(hikariConfig);

        List<Member> list = new ArrayList<>();

        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            list = new ArrayList<>();

            while (rs.next()) {
                list.add(new Member.Builder()
                        .id(rs.getInt("id"))
                        .name(rs.getString("name"))
                        .gender(rs.getString("gender"))
                        .age(rs.getInt("age"))
                        .build());
            }

            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();

        } catch (SQLException e) {

            e.printStackTrace();
        }

        list.stream().filter(member -> member != null).forEach(l -> System.out.println(
                "번호 : " + l.getid() + "\t" +
                        "이름 : " + l.getName() + "\t" +
                        "성별 : " + l.getGender() + "\t" +
                        "나이 : " + l.getAge()));

    }
}
