package com.test.board;

import java.io.IOException;
import jakarta.servlet.*;
import java.sql.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/board/write")
public class write extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        request.setCharacterEncoding("UTF-8");
        String uri = "jdbc:mariadb://172.20.0.4:3306/springdev";
        String userid = "springdev";
        String userpw = "12345";

        Connection con = null;
        Statement stmt = null;

        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        System.out.println("writer = " + writer);

        String query = "insert into tbl_board(userid,writer,title,content) values" +
                " ('springdev','" + writer + "','" + title + "','" + content + "')";

        System.out.println("게시물 등록 SQL : " + query);

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(uri, userid, userpw);
            stmt = con.createStatement();
            stmt.executeUpdate(query);

            if (stmt != null)
                stmt.close();
            if (con != null)
                stmt.close();

            response.sendRedirect("/board/list.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
