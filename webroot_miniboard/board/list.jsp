<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 목록 보기</title>
</head>

<%
    String uri = "jdbc:mariadb://172.20.0.4:3306/springdev";
    String userid = "springdev";
    String userpw = "12345";
    String query = "select seqno, writer, title, to_char(regdate,'YYYY-MM-DD HH24:MI:SS') as regdate, hitno from tbl_board order by seqno desc";

    // Response 시에 브라우저에 한글 출력을 UTF-8로 인코딩해서 출력
    response.setCharacterEncoding("utf-8");

    Connection con;
    Statement stmt;
    ResultSet rs;
%>
<style>
        .InfoTable {
        border-collapse: collapse;
        border: 3px solid #168;
        width: 800px;
        margin: auto;
        text-align: center;
        }

        #topBanner {
            margin-top: 10px;
            margin-bottom: 10px;
            max-width: 500px;
            height: auto;
            display: block;
            margin: auto;
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
            text-align: center;
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
        body {font-family: "나눔고딕", "맑은고딕";}
        h1 {font-family:  "HY견고딕";}
        a:link {color: black;}
        a:visited {color: black;}
        a:hover {color: red;}
        a {text-decoration: none; cursor: hand;}

        .main {
            text-align: center;
        }

        .bottom_menu > a:hover, .bottom_menu > a:active {
            background-color: #1E90FF;
            text-decoration: none;
        }

</style>
<body>
    <div class="main">
        <img src="/images/logo.jpg" id = "topBanner" alt="대한상공회의소" ><br>
        <h1 style="text-align: center;">게시물 목록</h1>
        <table class="InfoTable">
            <tr>
                <th>
                    번호
                </th>
                <th>
                    제목
                </th>
                <th>
                    작성자
                </th>
                <th>
                    작성일
                </th>
                <th>
                    조회수
                </th>
            </tr>
            
            <%
                try {
                    Class.forName("org.mariadb.jdbc.Driver");
                    con = DriverManager.getConnection(uri, userid, userpw);
                    stmt = con.createStatement();
                    stmt.executeQuery(query);
                    rs = stmt.executeQuery(query);

                    while(rs.next()){
            
        %>
            <tr onMouseover="this.style.background='#46D2D2'" onMouseout="this.style.background='white'">
                <td><%= rs.getInt("seqno")%></td>
                <td style="text-align: left;"><a href="/board/view.jsp?seqno=<%=rs.getInt("seqno") %>" onMouseover="this.style.textDecoration='underline'" onMouseout="this.style.textDecoration='none'"><%= rs.getString("title")%></a></td>
                <td><%= rs.getString("writer")%></td>
                <td><%= rs.getString("regdate")%></td>
                <td><%= rs.getInt("hitno")%></td>
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
        <br>
        
        <div class="bottom_menu">
            <a href="/board/write.jsp">글쓰기</a>
        </div>

        <br><br>
    
    </div>

</body>
</html>