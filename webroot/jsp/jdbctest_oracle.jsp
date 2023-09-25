<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>

<%
    String uri = "jdbc:oracle:thin:@localhost:1521:xe";
    String userid = "springdev";
    String userpw = "1234";
    String query = "select id, name, gender, age from tbl_test order by id asc";

    Connection con;
    Statement stmt;
    ResultSet rs;
%>

<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>JDBC 연동 JSP 예제</title>
        <style>
            .InfoTable {
            border-collapse: collapse;
            border: 3px solid #168;
            width: 800px;
            margin: auto;
            text-align: center;
            }
            .InfoTable th {
                color: #168;
                background: #f0f6f9;
            }
            .InfoTable th, .InfoTable td {
                padding: 10px;
                border: 1px solid #ddd;
            }
            .InfoTable th:first-child, .InfoTable td:first-child {
                border-left: 0;
            }
            .InfoTable th:last-child, .InfoTable td:last-child {
                border-right: 0;
            }
            .InfoTable tr td:first-child{
                text-align: center;
            }

            .bottom_menu {
                position:relative; 
                top: 30px;
                left: 800px;
            }

            .bottom_menu > a:link, .bottom_menu > a:visited {
                background-color: #FFA500;
                color: maroon;
                padding: 15px 25px;
                text-align: center;
                display: inline-block;
                text-decoration : none;
            }
            .bottom_menu > a:hover, .bottom_menu > a:active {
                background-color: #1E90FF;
                text-decoration : none;
            }
        </style>
    </head>
    <body>
        <h1>JDBC 연동 JSP 예제 - DBMS : Oracle</h1>
        <table class="InfoTable">
            <tr>
                <th>
                    번호
                </th>
                <th>
                    이름
                </th>
                <th>
                    성별
                </th>
                <th>
                    나이
                </th>
            </tr>

            <%
                try {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    con = DriverManager.getConnection(uri, userid, userpw);
                    stmt = con.createStatement();
                    rs = stmt.executeQuery(query);

                    while(rs.next()){
                
            %>

            <tr>
                <td>
                    <%= rs.getInt("Id")%>
                </td>
                <td>
                    <%= rs.getString("name")%>
                </td>
                <td>
                    <%= rs.getString("gender")%>
                </td>
                <td>
                    <%= rs.getInt("age")%>
                </td>
            </tr>

            <%
                    }                  
                    if (rs != null) rs.close();
                    if (stmt != null) stmt.close();
                    if (con != null) con.close();
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
            %>
        </table>
    </body>
</html>