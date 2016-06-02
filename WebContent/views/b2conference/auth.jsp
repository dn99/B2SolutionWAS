<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<%-- <script src="<%=request.getContextPath()%>/js/jquery.min.js"></script> --%>
<%-- <script src="<%=request.getContextPath()%>/js/jquery-migrate-1.2.1.js"></script> --%>

<link type="text/css" href="/resources/css/jquery-ui.css" rel="stylesheet">

<script src="/resources/js/jquery-2.1.1.min.js"></script>
<script src="/resources/js/jquery-migrate-1.2.1.min.js"></script>
<script src="/resources/js/jquery-ui.min.js"></script>

<script type="text/javascript" src="/resources/js/b2conference.js"></script>
<!--  
<script type="text/javascript">
	$(window).load(function() {
		openPopUp();
		document.body.style.overflow = 'hidden';
	});
</script>
-->
</head>
<body>
<h3>:::::::::: SOLUTION VIEWER ::::::::::</h3>
<br>
<label>API 로그인인증&nbsp;&nbsp; </label>
<button onclick="openWebconf('', '')">로그인인증 입장</button>
<br>
<br>
<label>파라미터 웹인증&nbsp;&nbsp; </label>
<button onclick="openWebedu('0', 'testRoom')">LMS 강사</button>
<button onclick="openWebedu('1', 'testRoom')">LMS 학생</button>
<button onclick="openWebedu('2', 'testRoom')">LMS 옵져버</button>
<button onclick="openWebedu('0', '')">ROOM ID없음</button>
<br>
<br>
<label>API 웹인증&nbsp;&nbsp; </label>
<button onclick="openWebeduApi('0')">강의실입장</button>
<br>
<br>

</body>
</html>