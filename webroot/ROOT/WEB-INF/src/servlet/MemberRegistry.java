package com.test.servlet;

import java.io.IOException;
import jakarta.servlet.*;
import java.sql.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/servlet/jdbctest_registry")
public class MemberRegistry extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        String uri = "jdbc:oracle:thin:@localhost:1521:xe";
        String userid = "springdev";
        String userpw = "1234";

        Connection con = null;
        Statement stmt = null;

        String name = request.getParameter("rname");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");

        String query = "insert into tbl_test (id, name, gender, age) values "
                + "(tbl_test_seq.nextval,'" + name + "','" + gender + "'," + age + ")";

        System.out.println("멤버 등록 SQL : " + query);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(uri, userid, userpw);
            stmt = con.createStatement();
            stmt.executeUpdate(query);

            if (stmt != null)
                stmt.close();
            if (con != null)
                stmt.close();

            response.sendRedirect("/jsp/jdbctest_oracle.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
