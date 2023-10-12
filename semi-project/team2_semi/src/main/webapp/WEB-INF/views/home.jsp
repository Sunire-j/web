<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	테스트용 임시 페이지
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>자동로그인상태</p>
<p>현재 아이디 : ${LogId} / 로그인 상태 : ${LogStatus}</p>
<a href="${pageContext.servletContext.contextPath}/minihome?id=${LogId}">미니홈이동(임시)</a>
<a href="${pageContext.servletContext.contextPath}/myPage">마이페이지이동(임시)</a>
</body>
</html>
