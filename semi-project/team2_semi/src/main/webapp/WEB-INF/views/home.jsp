<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1>
	테스트용 임시 페이지
</h1>

<P>  The time on the server is ${serverTime}. </P>
<p>자동로그인상태</p>
<p>현재 아이디 : ${LogId} / 로그인 상태 : ${LogStatus}</p>
<a href="${pageContext.servletContext.contextPath}/minihome?id=${LogId}">미니홈이동(임시)</a><br/>
<a href="${pageContext.servletContext.contextPath}/myPage">마이페이지이동(임시)</a><br/>
<a href="${pageContext.servletContext.contextPath}/AuthCommunity/write">인증게시판 작성</a><br/>
<a href="${pageContext.servletContext.contextPath}/FreeCommunity/write">자유게시판 작성</a><br/>
<a href="${pageContext.servletContext.contextPath}/QaCommunity/write">QNA게시판 작성</a><br/>
<a href="${pageContext.servletContext.contextPath}/home">시작페이지 이동</a><br/>
<br/>
<a href="${pageContext.servletContext.contextPath}/board/list?board=free">자유게시판 테스트</a><br/>
<a href="${pageContext.servletContext.contextPath}/board/list?board=auth">인증게시판 테스트</a><br/>
<a href="${pageContext.servletContext.contextPath}/board/list?board=qna">QNA게시판 테스트</a><br/>
