<%@page import="org.apache.catalina.connector.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.net.ConnectException"%>

<%
	int sizeLimit = 100 * 1024 * 1024; // 파일크기 100MB로 제한

	request.setCharacterEncoding("UTF-8");
	String savePath = request.getParameter("savePath");
	String uuid = request.getParameter("uuid");
	
	File f = new File(savePath);
	if (!f.exists())
		f.mkdir();

	String fileName="";
	String originalFileName="";
	String type="";
	
	try {
		MultipartRequest multi = new MultipartRequest(request,	savePath, sizeLimit, "UTF-8",	new DefaultFileRenamePolicy());

		
		Enumeration formNames = multi.getFileNames(); //전송한 파일 정보를 가져옴
		
		String formName = (String)formNames.nextElement(); //input 태그의 속성이 file인 태그의 name 속성값: 파라미터이름
		System.out.println("formName : " + formName);
		
		fileName = multi.getFilesystemName(formName); //서버에 저장된 파일이름
		System.out.println("서버에 저장된 파일이름 fileName : " + fileName);
		
		originalFileName = multi.getOriginalFileName(formName); //전송전 원래의 파일이름
		System.out.println("전송전 원래의 파일이름 originalFileName : " + originalFileName);
		
		type = multi.getContentType(formName); //전송된 파일의 내용타입
		System.out.println("전송된 파일의 내용타입 type : " + type);
						
		if(uuid == null){
			System.out.println("이미지아님");
			return;
		}else{
			System.out.println("이미지임");
		}
		int pos = fileName.lastIndexOf(".");
		String fileExt = fileName.substring(pos+1); 		// 업로드된 확장자
		String uuidFilename = uuid+"."+fileExt;				// 새로 변경될 파일명
		String fileUrl = savePath + "/" + uuidFilename;		// 새로운 파일경로
		
		
		if(fileName == null){
			System.out.print("파일업로드 실패");
		} else {
			System.out.println("savePath + fileName : " + savePath + "/" + fileName);
			File file = new File(savePath, fileName);
			File newFile = new File(savePath, uuidFilename);
			
			System.out.println("fileUrl : " + fileUrl);

			if(file.renameTo(newFile)){
				System.out.println("파일명 변경 성공");
				out.println("파일명 변경 성공");
				
			}else{
				System.out.println("파일명 변경 실패");
			}
				
			
		}
	} catch (Exception e) {
		System.out.println("Error Message : " + e.getMessage());
	}
%>







