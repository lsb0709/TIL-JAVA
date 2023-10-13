<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>멤버 등록</title>
    <style>
        body {font-family: "나눔고딕", "맑은고딕";}
        h1 {font-family:  "HY견고딕";}
        a:link {color: black;}
        a:visited {color: black;}
        a:hover {color: red;}
        a {text-decoration: none; cursor: hand;}

        .main {
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

        .WriteForm {
            width: 60%;
            height: auto;
            margin: auto;
            padding: 20px;
            background-color: white;
            text-align: center;
            border: 4px solid gray;
            border-radius: 30px;
        }

        .items {
            width: 90%;
            border: none;
            border-bottom: 2px solid gray;
            padding: 10px 10px;
            outline: none;
            color: #636e72;
            height: 25px;
            background: none;
        }

        #content {
            width: 90%;
            height: 300px;
            box-sizing: border-box;
            border: solid gray;
            font-size: 16px;
            resize: both;
        }

        .btn_write {
            position: relative;
            margin-top: 20px;
            margin-bottom: 10px;
            width: 40%;
            height: 40px;
            background: red;
            color: white;
            font-weight: bold;
            border: none;
            cursor: pointer;
            display: inline;
        }

        .btn_cancel {
            position: relative;
            margin-top: 20px;
            margin-bottom: 10px;
            width: 40%;
            height: 40px;
            background: pink;
            background-size: 200%;
            color: white;
            font-weight: bold;
            border: none;
            cursor: pointer;
            display: inline;
        }
    </style>

    <script>
        function registerForm(){
            let rname = document.querySelector('#rname');
            let gender = document.querySelector('#gender');
            let age = document.querySelector('#age');

            // 필수값 등록시 값 입력 여부 확인
            if(rname.value === ''){ //window.document.WriteForm.Writer.Value --> DOM : DOcument Object
                alert('멤버 이름을 입력하세요!!!');
                rname.focus();
                return false;
            }
            if(gender.value === ''){
                alert('성별을 입력하세요!!!');
                gender.focus();
                return false;
            }
            if(age.value === ''){
                alert('나이를 입력하세요!!!');
                age.focus();
                return false;
            }
            
            document.WriteForm.action = '/servlet/jdbctest_registry';
            document.WriteForm.submit();
        }
    </script>
</head>

<body>
    <div class = "main">
        <h1>멤버 등록</h1>
        <br>
        <div id="formZone">
            <form class="WriteForm" name="WriteForm" method="post">
                <input type="text" id ="rname" class="items" name="rname" placeholder="멤버 이름을 입력하세요">
                <input type="text" id ="gender" class="items" name="gender" placeholder="성별을 입력하세요">
                <input type="text" id ="age" class="items" name="age" placeholder="나이를 입력하세요">
                <input type="button" class="btn_write" value="등록" onclick="registerForm()">
                <input type="button" class="btn_cancel" value="취소" onclick="history.back()">
            </form>
        </div>
        <br><br>
    </div>

</body>
</html>