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
<h3>SOLUTION LMS</h3>
<label>개발자용&nbsp;&nbsp; </label>
<button onclick="openLMS1('0')">LMS 강사</button>
<button onclick="openLMS1('1')">LMS 학생</button>
<button onclick="openLMS1('2')">LMS 옵저버</button>
<br>
<!-- <br> -->
<!-- <label>테스트용&nbsp;&nbsp; </label> -->
<!-- <button onclick="openLMS('0')">LMS 강사</button> -->
<!-- <button onclick="openLMS('1')">LMS 학생</button> -->
<!-- <button onclick="openLMS('2')">LMS 옵저버</button> -->
<!-- <br> -->
<br>
<label>REAL TEST 개발자용&nbsp;&nbsp; </label>
<button onclick="openLMS5('0')">LMS 강사</button>
<button onclick="openLMS5('1')">LMS 학생</button>
<button onclick="openLMS5('2')">LMS 옵저버</button>
<br>
<!-- <br> -->
<!-- <label>REAL TEST 테스트용&nbsp;&nbsp; </label> -->
<!-- <button onclick="openLMS4('0')">LMS 강사</button> -->
<!-- <button onclick="openLMS4('1')">LMS 학생</button> -->
<!-- <button onclick="openLMS4('2')">LMS 옵저버</button> -->
<!-- <br> -->
<br>
<label>REAL 개발자용&nbsp;&nbsp; </label>
<button onclick="openLMS3('0')">LMS 강사</button>
<button onclick="openLMS3('1')">LMS 학생</button>
<button onclick="openLMS3('2')">LMS 옵저버</button>
<br>
<!-- <br> -->
<!-- <label>REAL 테스트용&nbsp;&nbsp; </label> -->
<!-- <button onclick="openLMS2('0')">LMS 강사</button> -->
<!-- <button onclick="openLMS2('1')">LMS 학생</button> -->
<!-- <button onclick="openLMS2('2')">LMS 옵저버</button> -->
<!-- <br> -->
<br>
<label>웹인증&nbsp;&nbsp; </label>
<button onclick="openAuth('roomID', 'roomName')">RoomID 있음</button>
<button onclick="openAuth('', '')">RoomID 없음</button>
<br>
<br>
<label>신규디자인&nbsp;&nbsp; </label>
<button onclick="openWebedu('0', 'testRoom')">LMS 강사</button>
<button onclick="openWebedu('1', 'testRoom')">LMS 학생</button>
<button onclick="openWebedu('2', 'testRoom')">LMS 옵져버</button>
<button onclick="openWebconf('roomID', 'roomName')">RoomID 있음</button>
<button onclick="openWebconf('', '')">RoomID 없음</button>
<br>
<br>
<label>로컬 LMS&nbsp;&nbsp; </label>
<button onclick="openWebeduApi('0')">LMS 강사</button>
<button onclick="openWebeduApi('1')">LMS 학생</button>
<button onclick="openWebeduApi('2')">LMS 옵져버</button>

<%-- ${serverTime} --%>
<%-- <%= application.getRealPath("/") %> --%>
</body>
</html>