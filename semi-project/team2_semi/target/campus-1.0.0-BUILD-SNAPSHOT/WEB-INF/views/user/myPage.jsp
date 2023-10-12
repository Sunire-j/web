<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.servletContext.contextPath}/css/sign-up.css">
<main>
    <h1>마이페이지</h1>

    <div id="warning"></div>

    <div class="signup-area">

        <form action="#" method="post">
            <div class="id-input">
                <input type="text" name="userid" id="userid" value="${uservo.userid}"
                       class="inputtext">
                <input type="button" value="중복 확인" class="id-check" id="id-check">
            </div>
            <div class="pwd-input">
                <input type="password" name="originpwd" id="originpwd" class="inputtext"
                       placeholder="기존비번">
            </div>
            <div class="pwd-input">
                <input type="password" name="newpwd" id="newpwd" class="inputtext"
                       placeholder="새비번">
            </div>
            <div class="pwd-input">
                <input type="password" name="newpwd-check" id="newpwd-check" class="inputtext"
                       placeholder="새비번 확인">
            </div>
            <div class="name-input">
                <input type="text" name="username" id="username" class="inputtext" value="${uservo.username}">
            </div>
            <div class="email-input">
                <input type="text" name="useremail" id="useremail" class="inputtext" value="${uservo.email}" disabled>
            </div>
            <div class="Question">
                <select name="find-q" id="find-q" class="find-q">
                    <option value="none">비밀번호 찾기 질문</option>
                    <option value="내가 태어난 도시 이름은?">내가 태어난 도시 이름은?</option>
                    <option value="어릴 적 다닌 초등학교 이름은?">어릴 적 다닌 초등학교 이름은?</option>
                    <option value="어머니 이름은?">어머니 이름은?</option>
                    <option value="아버지 이름은?">아버지 이름은?</option>
                    <option value="본인의 좌우명?">본인의 좌우명?</option>
                </select>
            </div>
            <script>
                var pwd_q='${uservo.pwd_q}';
                $('#find-q option').each(function(){
                    if($(this).text()==pwd_q){
                        var temp = $(this).text();
                        $(this).prop('selected',true);
                    }
                });
            </script>
            <div class="Answer">
                <input type="text" name="useranswer" id="useranswer" class="inputtext" value="${uservo.pwd_a}">
            </div>
            <input type="submit" value="정보 수정" class="signup-submit">

        </form>
    </div>

    <script src="${pageContext.servletContext.contextPath}/js/community-default.js"></script>
</main>