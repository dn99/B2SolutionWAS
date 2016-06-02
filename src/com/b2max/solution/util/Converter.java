package com.b2max.solution.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.oreilly.servlet.MultipartRequest;
 
public class Converter {
	
	public static final String ALLOWED_CHARS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-_.!~*'()";

	public Converter(){
	}

	//map을 json으로 변환
	public static String convertJson(Map<String, Object> map) throws Exception{
        return new ObjectMapper().writeValueAsString(map);
	}
	
	//json을 map으로 변환
	public static HashMap<String, Object> convertMap(String json) throws Exception{
        return new ObjectMapper().readValue(json, new TypeReference<HashMap<String, Object>>() {});  
	}
	
	//json을 List로 변환
	public static List<HashMap<String, Object>> convertList(String json) throws Exception{
        return new ObjectMapper().readValue(json, new TypeReference<List<HashMap<String, Object>>>() {});  
	}
	
	//request getParameter를  Map로 변환
	public static Map<String, Object> convertRequest(HttpServletRequest req) throws Exception{
		Enumeration em = req.getParameterNames();
		Map<String, Object> postData = new HashMap<String, Object>();
		while (em.hasMoreElements()) {
		    String k = (String) em.nextElement();
		    String v =  CommonUtil.getParameter(req,k);
		    
		    if(k != null && v != null && !v.equals("")){
		    	postData.put(k, v);
		    }
		}
        return postData;
	}
	
	//MultipartRequest getParameter를  Map로 변환
	public static Map<String, Object> convertRequest(MultipartRequest multi) throws Exception{
		Enumeration em = multi.getParameterNames();
		Map<String, Object> postData = new HashMap<String, Object>();
		while (em.hasMoreElements()) {
		    String k = (String) em.nextElement();
		    String v =  multi.getParameter(k);
		    
		    if(k != null && v != null && !v.equals("")){
		    	postData.put(k, v);
		    }
		}
        return postData;
	}
	
	//MultipartRequest 파일  추가
	public static void convertFile(MultipartRequest multi, Http http, String path) throws Exception{
		Enumeration formNames = multi.getFileNames();  // 폼의 이름 반환

		String fileOrder = "";
		String fileInput = "";
		String fileName = "";
		String fileOrigin = "";
		String fileExtend = "";
		
		File file = null;  
		File sendFile = null;  
		
		boolean flag = false;

		while(formNames.hasMoreElements()) {
			fileInput = (String)formNames.nextElement();                		// 파일인풋 이름
			fileName = multi.getFilesystemName(fileInput);            			// 파일명
			fileOrder = CommonUtil.replace(fileInput, "file", "");				// 파일순서

			if (fileName != null) {
				file = multi.getFile(fileInput);                             //파일객체
				fileOrigin = fileName.substring(0,fileName.lastIndexOf(".")); 	//파일명
				fileExtend = fileName.substring(fileName.lastIndexOf(".")+1); 	//파일 확장자
				
				flag = true;
				
				file.renameTo(new File(path+"upload/temp/"+fileOrder+"#"+fileOrigin+"."+fileExtend));	//받는곳에서 파일의 순서를 알아내기 위해 파일순서로 파일명을 수정
				
				sendFile = new File(path+"upload/temp/"+fileOrder+"#"+fileOrigin+"."+fileExtend);
				
				http.addParam("file", sendFile);
			}
		}
		
		if(!flag){
			http.addParam("file", new File(path+"upload/blank.txt"));	//파일은 없으면 빈파일 넣어줘야 함
		}
	}

	//encodeURIComponent
	public static String encodeURIComponent(String input) {
		if(input == null || input.equals("")) {
			return input;
		}

		int l = input.length();
		StringBuilder o = new StringBuilder(l * 3);
		try {
			for (int i = 0; i < l; i++) {
				String e = input.substring(i, i + 1);
				if (ALLOWED_CHARS.indexOf(e) == -1) {
					byte[] b = e.getBytes("utf-8");
					o.append(getHex(b));
					continue;
				}
				o.append(e);
			}
			return o.toString();
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return input;
	}
	  
	private static String getHex(byte buf[]) {
		StringBuilder o = new StringBuilder(buf.length * 3);
		for (int i = 0; i < buf.length; i++) {
			int n = (int) buf[i] & 0xff;
			o.append("%");
			if (n < 0x10) {
				o.append("0");
			}
			o.append(Long.toString(n, 16).toUpperCase());
		}
		return o.toString();
	}
	 
	//decodeURIComponent
	public static String decodeURIComponent(String encodedURI) {
		char actualChar;

		StringBuffer buffer = new StringBuffer();

		int bytePattern, sumb = 0;

		for (int i = 0, more = -1; i < encodedURI.length(); i++) {
			actualChar = encodedURI.charAt(i);

			switch (actualChar) {
				case '%': {
					actualChar = encodedURI.charAt(++i);
					int hb = (Character.isDigit(actualChar) ? actualChar - '0'
					: 10 + Character.toLowerCase(actualChar) - 'a') & 0xF;
					actualChar = encodedURI.charAt(++i);
					int lb = (Character.isDigit(actualChar) ? actualChar - '0'
					: 10 + Character.toLowerCase(actualChar) - 'a') & 0xF;
					bytePattern = (hb << 4) | lb;
					break;
				}
				case '+': {
					bytePattern = ' ';
					break;
				}
				default: {
					bytePattern = actualChar;
				}
			}

			if ((bytePattern & 0xc0) == 0x80) { // 10xxxxxx
				sumb = (sumb << 6) | (bytePattern & 0x3f);
				if (--more == 0)
					buffer.append((char) sumb);
			} else if ((bytePattern & 0x80) == 0x00) { // 0xxxxxxx
				buffer.append((char) bytePattern);
			} else if ((bytePattern & 0xe0) == 0xc0) { // 110xxxxx
				sumb = bytePattern & 0x1f;
				more = 1;
			} else if ((bytePattern & 0xf0) == 0xe0) { // 1110xxxx
				sumb = bytePattern & 0x0f;
				more = 2;
			} else if ((bytePattern & 0xf8) == 0xf0) { // 11110xxx
				sumb = bytePattern & 0x07;
				more = 3;
			} else if ((bytePattern & 0xfc) == 0xf8) { // 111110xx
				sumb = bytePattern & 0x03;
				more = 4;
			} else { // 1111110x
				sumb = bytePattern & 0x01;
				more = 5;
			}
		}
		return buffer.toString();
	}
}