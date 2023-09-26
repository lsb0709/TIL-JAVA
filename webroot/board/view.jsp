<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물 내용보기</title>
<%
    int seqno = Integer.parseInt(request.getParameter("seqno"));
    String uri = "jdbc:oracle:thin:@localhost:1521:xe";
    String userid = "springdev";
    String userpw = "1234";
    String query = "select seqno, writer, title, to_char(regdate,'YYYY-MM-DD HH24:MI:SS') as regdate, content from tbl_board order where seqno = " + seqno;
    System.out.println("게시물 상세 보기 SQL = " + query);

    String writer = "";
    String title = "";
    String regdate = "";
    String content = "";

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

        .topBanner {
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

        #topBanner {
            margin-top: 10px;
            margin-bottom: 10px;
            max-width: 500px;
            height: auto;
            display: block;
            margin: auto;
        }
        .main {
            text-align: center;
        }
        .boardView{
            width: 60%;
            height: auto;
            margin: auto;
            padding: 20px, 20px;
            background-color: white;
            border: solid 4px gray;
            border-radius: 20px;
        }
        .items {
            width: 90%;
            height: 25px;
            outline: none;
            color: #636e72;
            font-size: 16px;
            background:none;
            border-bottom: 2px solid #adadad;
            margin: 30px;
            padding: 10px 10px;
            text-align: left;
        }
        .textArea{
            width: 90%;
            height: 350px;
            overflow: auto;
            margin: 22px;
            padding: 10px;
            box-sizing: border-box;
            border: 2px solid #adadad;
            text-align: left;
            font-size: 16px;
            resize: both;
        }
    </style>
</head>

<body>
    <div class="main">
        <img src="/images/logo.jpg" class = "topBanner" alt="대한상공회의소" ><br>
        <h1 style="text-align: center;">게시물 목록</h1>
        <br>
        
        <div class="boardView">
            <div class="items">
                글쓴이 : <%=writer %>
            </div>
            <div class="items">
                제목 : <%=title %>
            </div>
            <div class="items">
                날짜 : <%=regdate %>
            </div>
            <div class="textArea">
                <pre><%=content %></pre>
            </div>
        </div>
        <%
            try {
                Class.forName("oracle.jdbc.driver.OracleDriver");
                con = DriverManager.getConnection(uri, userid, userpw);
                stmt = con.createStatement();
                stmt.executeQuery(query);
                rs = stmt.executeQuery(query);

                if(rs.next()){
        %>
                    writer = rs.getString("writer");
                    title = rs.getString("title");
                    regdate = rs.getString("regdate");
                    content = rs.getString("content");
        <%
                }
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
                
            }catch(Exception e){
                e.printStackTrace();
            }
        %>

        <div class="bottom_menu">
            <a href="/board/list.jsp">목록가기</a>&nbsp;&nbsp;
            <a href="/board/write.jsp">글 작성</a>&nbsp;&nbsp;
            <a href="/board/modify.jsp">글 수정</a>&nbsp;&nbsp;
            <a href="#">글 삭제</a>
        </div>
    </div>
</body>
</html>