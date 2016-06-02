<%@page import="java.io.IOException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@page import="org.apache.commons.io.IOUtils"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.nio.ByteOrder"%>
<%@page import="java.nio.ByteBuffer"%>
<%@page import="javax.sound.sampled.AudioFormat"%>
<%@page import="javax.sound.sampled.AudioSystem"%>
<%@page import="javax.sound.sampled.AudioInputStream"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.sun.xml.internal.messaging.saaj.util.Base64"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.nio.file.Paths"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.DataOutputStream"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.DataInputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.File"%>

<%	
		request.setCharacterEncoding("UTF-8");

	try {
		DataInputStream dis = new DataInputStream(request.getInputStream());
		
		String selectedLang = request.getParameter("selectedLang");
		String googleSTTKey = request.getParameter("googleSTTKey");
		
		System.out.println("selectedLang : " + selectedLang + ", googleSTTKey : " + googleSTTKey);
		
 		byte[] data = IOUtils.toByteArray(request.getInputStream());

 		String urlAddress = "https://www.google.com/speech-api/v2/recognize?output=json&lang="+ selectedLang + "&key="+ googleSTTKey;
		
		URL url = new URL(urlAddress);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setDoInput(true);
		connection.setInstanceFollowRedirects(false);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "audio/x-flac; rate=44100");
		connection.setRequestProperty("User-Agent", "speech2text");
		connection.setConnectTimeout(6000);
		connection.setUseCaches(false);

		DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
		wr.write(data);
		wr.flush();
		wr.close();
		connection.disconnect();

		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
		String decodedString;
		
		while ((decodedString = in.readLine()) != null) 
		{
			System.out.println(decodedString);
 			out.println(URLEncoder.encode(decodedString, "UTF-8"));
		}

	} catch (IOException e) {
		//response.getWriter().write("Error"); 
		System.out.println("Error : " + e.getMessage());
		out.println(e.getMessage());
	} 
%>