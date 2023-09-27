package board;

import java.io.IOException;
import jakarta.servlet.*;
import java.sql.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board/delete")
public class delete extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int seqno = Integer.parseInt(request.getParameter("seqno"));

        String uri = "jdbc:oracle:thin:@localhost:1521:xe";
        String userid = "springdev";
        String userpw = "1234";

        String query = "delete from tbl_board where seqno=" + seqno;

        Connection con;
        Statement stmt;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection(uri, userid, userpw);
            stmt = con.createStatement();
            stmt.executeUpdate(query);

            response.sendRedirect("/board/list.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }
}
