<%@page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>JSP/Servlet 버전 확인</title>
    <style>
        .info {
            position: relative;
            top: 150px;
            width: 60%;
            margin: auto;
            padding-left: 30px;
            font-size: 300%;
            border: solid 1px gray;
        }
    </style>
</head>
<body>
    <div class="info">
        <ul>
            <li>
                <%=application.getServerInfo() %>
            </li>
            <li>
                <%=application.getMajorVersion() %>.<%= application.getMinorVersion() %>
            </li>
            <li>
                <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>
            </li>
        </ul>
    </div>

</body>
</html>