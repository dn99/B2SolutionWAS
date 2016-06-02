<%@page import="org.apache.catalina.connector.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.net.ConnectException"%>

<%
	int sizeLimit = 100 * 1024 * 1024;
	//String savePath = "C:/Tomcat6/webapps/Conference/uploadFiles/";
	String savePath = "D:/project/jsp/conference/uploadFiles/";
	
	try {
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
		String userID = multi.getParameter("userID");
		String roomID = multi.getParameter("roomID");
		
		System.out.println("roomID : " + roomID);
		System.out.println("userID : " + userID);
		
		/*
		 *	파일이름의 공백을 '_' 로 바꾼다.
		 */
		String originFileName = multi.getOriginalFileName("fileform");
		String newFileName = multi.getOriginalFileName("fileform").replace(' ', '_');
		File originFile = new File(savePath, originFileName);
		File newFile = new File(savePath, newFileName);
		originFile.renameTo(newFile);
		
		/*
		 * 파일명, 확장자명을 구한다.
		 */
		int lastDot = newFile.getName().lastIndexOf(".");
		String fileName = newFile.getName().substring(0, lastDot);
		String extension = newFile.getName().substring(lastDot + 1);
		
	} catch (Exception e) {
		System.out.print("Error Message : " + e.getMessage());
	}
%>







