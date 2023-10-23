<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<meta charset="UTF-8">


<%
    session.setAttribute("username","김민수"); // JSP 세션 생성
%>


<body>

    <h1>LB 서버 01</h1>
    <!-- JSP 세션 가져오기 -->
    <h1>세션 = <%=(String)session.getAttribute("username")%> </h1>

</body>

</html>