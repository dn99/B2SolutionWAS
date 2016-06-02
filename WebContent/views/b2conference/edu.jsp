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

</head>
<body>
<h3>SOLUTION LMS TEST - 야마구치 이러닝</h3>
<label>테스트용&nbsp;&nbsp; </label>
<button onclick="openEdu(true)">강사 입장</button>
<button onclick="openEdu(false)">학생 입장</button>
</body>
</html>