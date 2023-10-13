package board;

import java.io.IOException;
import jakarta.servlet.*;
import java.sql.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/modify")
public class modify extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        String uri = "jdbc:oracle:thin:@localhost:1521:xe";
        String userid = "springdev";
        String userpw = "1234";

        Connection con = null;
        Statement stmt = null;

        int seqno = Integer.parseInt(request.getParameter("seqno"));
        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        String query = "update tbl_board set writer = '" + writer + "',title = '"
                + title + "',content = '" + content + "' where seqno = " + seqno;
        System.out.println("게시물 수정 SQL : " + query);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(uri, userid, userpw);
            stmt = con.createStatement();
            stmt.executeUpdate(query);

            if (stmt != null)
                stmt.close();
            if (con != null)
                stmt.close();

            response.sendRedirect("/board/view.jsp?seqno=" + seqno);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
