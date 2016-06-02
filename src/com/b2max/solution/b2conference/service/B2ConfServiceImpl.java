package com.b2max.solution.b2conference.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.artofsolving.jodconverter.DefaultDocumentFormatRegistry;
import com.artofsolving.jodconverter.DocumentFamily;
import com.artofsolving.jodconverter.DocumentFormat;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.b2max.common.presentation.EncodingDetector;
import com.b2max.common.presentation.Office2PdfConverter;
import com.b2max.common.presentation.imp.Pdf2SwfConverter;
import com.b2max.common.presentation.imp.PdfPageCounter;
import com.b2max.solution.b2conference.domain.AuthenticateDomain;
import com.b2max.solution.b2conference.domain.FileVO;
import com.b2max.solution.b2conference.domain.AuthInfoVO;
import com.b2max.solution.blazeds.BlazedsConstant;
import com.b2max.solution.blazeds.BlazedsUtil;
import com.b2max.solution.util.Converter;
import com.b2max.solution.util.Http;

import flex.messaging.io.ArrayCollection;
import flex.messaging.io.amf.ASObject;

@Service("b2confService")
@RemotingDestination
public class B2ConfServiceImpl implements B2ConfService{

	private final Log logger = LogFactory.getLog(getClass());

	//	@Autowired
	//	private DepartmentDao departmentDao;
	//	
	//	public void setDepartmentDao(DepartmentDao departmentDao)
	//	{
	//		this.departmentDao = departmentDao;
	//	}

	private AuthInfoVO lmsInfoVO;
	
	private String FilePath;
	private PdfPageCounter pageCounter = new PdfPageCounter();
	private Office2PdfConverter office2pdfConverter = new Office2PdfConverter();
	private Pdf2SwfConverter pdf2swfConverter = new Pdf2SwfConverter();

	private @Value("${info.api.host}") String apiHost;
	
	
	
	/*********************************** 웹연동 REST API 호출부 ***************************************************/
	
	/**
	 * REST API 호출 - 로그인 인증시 웹연동 데이타 반환
	 */
	@Override
	public AuthenticateDomain getLogonAuthInfo(String id, String pw)
	{
		AuthenticateDomain authInfo = null;
		try {
			SimpleClientHttpRequestFactory requestFactory =  new SimpleClientHttpRequestFactory();
			requestFactory.setConnectTimeout(500);
			requestFactory.setReadTimeout(10000);
		
			RestTemplate restTemplate = new RestTemplate(requestFactory);
			
			String restUrl = "";
			//Map map = new HashMap();
			//map.put("id", id);
			//map.put("pw", pw);
			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			map.add("id", id);
			map.add("pw", pw);
			
			ResponseEntity responseEntity = restTemplate.postForEntity(restUrl, map, AuthenticateDomain.class);
			
			System.out.println("Printing responseBody.getBody()");
			System.out.println("Client Result : " + responseEntity.getBody());
			
			//HashMap<String, Object> resMap = (HashMap<String, Object>) ;
			authInfo = (AuthenticateDomain)responseEntity.getBody();
			//System.out.println("authInfo : " + authInfo.getUserPic());
		}
		catch (RestClientException e) {
			System.out.println(e);
			return authInfo;
		}	
		
		//System.out.println("========> apiHost : " + apiHost );
		return authInfo;
	}
	
	/**
	 * REST API 호출 - LMS 파라미터 구분자에 따른 웹연동 데이타 반환
	 */
	@Override
	public AuthInfoVO getAuthInfo(String authKey, String roomID)
	{
		AuthInfoVO authInfo = null;
		System.out.println("================== getAuthInfo");
		
		try {
			SimpleClientHttpRequestFactory requestFactory =  new SimpleClientHttpRequestFactory();
			requestFactory.setConnectTimeout(500);
			requestFactory.setReadTimeout(10000);
		
			RestTemplate restTemplate = new RestTemplate(requestFactory);
			
			String restUrl = "";
			
			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			map.add("authKey", authKey);
			map.add("roomID", roomID);
			
			ResponseEntity responseEntity = restTemplate.postForEntity(restUrl, map, HashMap.class);
			
			System.out.println("Printing responseBody.getBody()");
			System.out.println("Client Result : " + responseEntity.getBody());
			
			//HashMap<String, Object> resMap = (HashMap<String, Object>) ;
			HashMap<String, Object> resultMap = (HashMap<String, Object>)responseEntity.getBody();
			HashMap<String, Object> data = (HashMap<String, Object>)resultMap.get("data");
			System.out.println("infoData : " + resultMap.get("resMsg"));
			
			authInfo = new AuthInfoVO();
			Boolean result = (Boolean)resultMap.get("result");
			authInfo.setResult(result);
			authInfo.setResMsg((String)resultMap.get("resMsg"));
			
			if ( result == false )
			{
				return authInfo;
			}
			
			authInfo.setSiteIdx((String)data.get("siteIdx"));
			authInfo.setRoomID((String)data.get("roomID"));
			authInfo.setRoomName((String)data.get("roomName"));
			authInfo.setUserID((String)data.get("userID"));
			authInfo.setUserName((String)data.get("userName"));
			authInfo.setUserState((String)data.get("userState"));
			authInfo.setCourseIdx(Integer.toString((int)data.get("courseIdx")));
			authInfo.setAuthKey((String)data.get("authKey"));
			authInfo.setActionTp((String)data.get("actionTp"));
			authInfo.setNickName((String)data.get("nickName"));
			authInfo.setCompanyName((String)data.get("companyName"));
			authInfo.setSiteStateCd((String)data.get("siteStateCd"));
			authInfo.setMgrDiskSize((int)data.get("mgrDiskSize"));
			authInfo.setLogoName((String)data.get("logoName"));
			authInfo.setEnterCnt((int)data.get("enterCnt"));
			authInfo.setSolution1((String)data.get("solution1"));
			authInfo.setSolution2((String)data.get("solution2"));
			authInfo.setSolution3((String)data.get("solution3"));
			authInfo.setSolution4((String)data.get("solution4"));
			authInfo.setSolution5((String)data.get("solution5"));
			authInfo.setSolution6((String)data.get("solution6"));
			authInfo.setSolution7((String)data.get("solution7"));
			authInfo.setResult(result);
		}
		catch (RestClientException e) {
			System.out.println(e);
			return authInfo;
		}	
		
		//BlazedsUtil.pushAsyncMessage(BlazedsConstant.PUSH_SERVICE, "getAuthInfo", "subtopic");
		return authInfo;
	}
	
	/**
	 * REST API 호출 - 해당 강의의 EBOOK 목록 반환
	 */
	@Override
	public ArrayList<FileVO> getLMSDocList(String courseIdx)
	{
		ArrayList<FileVO> returnlist = new ArrayList<FileVO>();
		System.out.println("========> getLMSDocList : " + courseIdx + "   apiHost : " + apiHost );
		
		String restUrl = "";
		
		HashMap<String, Object> resultMap = null;
		try 
		{
			Http http = new Http("");
			http.addParam("courseIdx", courseIdx);
			
			String json = http.submit();
			resultMap = Converter.convertMap(json);										//결과를 Map으로 변환
			
			List<HashMap<String, Object>> dataList = (List<HashMap<String, Object>>) resultMap.get("data");			//게시물
			
			String fileURL = "";
			FileVO fileVO = null;
			for (HashMap<String, Object> map : dataList)
			{
				System.out.println(map);
				fileVO = new FileVO();
				fileVO.setIdx((int)map.get("idx"));
				fileVO.setSiteIdx((int)map.get("siteIdx"));
				fileVO.setFileName((String)map.get("fileName"));
				fileVO.setRealName((String)map.get("realName"));
				fileURL = "" + map.get("siteIdx") + "/file/" + map.get("fileName");
				fileVO.setFileURL(fileURL);
				
				returnlist.add(fileVO);
			}
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return returnlist;
	}
	
	/*********************************** 웹연동 REST API 호출부 ***************************************************/
	
	/**
	 * 파일업로드  
	 */
	@Override
	public Boolean doFileUpload(String storagePath, String roomID, String fileName, byte[] data)
	{
		System.out.println("storagePath : " + storagePath + ", roomID : " + roomID + ", fileName : " + fileName);
		
		try{
			FilePath = storagePath;
			fileName = new String(fileName.getBytes("UTF-8"), "UTF-8");
			
			// 해당 RoomID로 디렉토리 검사 후, 존재하지않으면 생성
			File f = new File(FilePath+roomID);
			if(!f.exists())	f.mkdir();

			// 파일객체에 스트림데이터를 쓴다. (파일읽어들이기) 
			File file = new File(FilePath + fileName);
			FileOutputStream output = new FileOutputStream(file);
			output.write(data);
			output.close();
			
			// 해당 RoomID로 된 디렉토리로 이동
			System.out.println();
			//file.renameTo(new File(f.getPath() + "\\" + fileName)); // 해당코드는 플랫폼 제약이 있음. (리눅스에서 동작안함)
			String source = FilePath + fileName;
			String dest = f.getPath() + "/" + fileName;
			moveFile(source, dest);
			return true;
		}
		catch(IOException e){
			return false;
		}
	}

	@Override
	public Boolean doUpload(String storagePath, String fileName, byte[] data)
	{
		System.out.println("storagePath : " + storagePath + ", fileName : " + fileName);
		
		try{
			FilePath = storagePath;
			fileName = new String(fileName.getBytes("UTF-8"), "UTF-8");
			File file = new File(FilePath + fileName);
			FileOutputStream output = new FileOutputStream(file);
			output.write(data);
			output.close();

			File newFile = new File(FilePath, fileName.replace(' ', '_'));

			System.out.println("FILE NAME : " + newFile.getName());

			if(file.renameTo(newFile))
				return true;
			else
				return false;
			
		}
		catch(IOException e){
			return false;
		}
	}


	/**
	 * 총페이지 수를 구한다. 
	 */
	@Override
	public ArrayList<HashMap> getTotalPage(String fileName){

		String newFileName = fileName.replace(' ', '_');
		int lastDot = fileName.lastIndexOf('.');							 // 확장자 구하기 위한 '.' 위치
		String extension = fileName.substring(lastDot+1, fileName.length()); // 파일의 확장자를 구한다.
		File file = null;
		File newFile = new File(FilePath, newFileName);
		File pdfFile = new File(FilePath+newFileName.substring(0, lastDot)+".pdf");

		
		if( !extension.equals("pdf") && !extension.equals("PDF") )
		{
			// .txt파일일 경우 인코딩 검사후, chatset 인코딩 방식을 UTF-8로 바꾼다. 
			if(extension.equals("txt") || extension.equals("TXT"))
			{
				EncodingDetector encodingDetector = new EncodingDetector();
				String encoding = encodingDetector.getEncoding(newFile);	// .txt파일의 인코딩을 알아낸다.
				BufferedReader br = null;
				FileInputStream fis;
				FileOutputStream fos;
				File encodedFile;

				System.out.println("텍스트파일 인코딩 : " + encoding);
				
				try {
					if(encoding.equals("KOI8-R") || encoding.equals("No encoding detected."))
						br = new BufferedReader(new InputStreamReader(fis = new FileInputStream(newFile), "EUC-KR"));
					else
						br = new BufferedReader(new InputStreamReader(fis = new FileInputStream(newFile), encoding));

					System.out.println("텍스트파일의 인코딩을 UTF-8로 바꾼다.!!!!!!!!!!");
					
					encodedFile = new File(FilePath, newFile.getName().substring(0, newFile.getName().lastIndexOf('.')) + "_encoded_UTF-8.txt");
					fos = new FileOutputStream(encodedFile);
					OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
					Writer out = new BufferedWriter(osw);
					int ch;
					while ((ch = br.read()) > -1) {
						out.write(ch);
					}
					out.close();
					fis.close();
					br.close(); 
					fos.close();
					osw.close();

					newFile.delete();
					
					file = new File(FilePath, newFileName);
										
					System.out.println("encodedFile이름 변경 전 " + encodedFile.getName() + ", " + file.getName());
					if(encodedFile.renameTo(file))
					{
						System.out.println("encodedFile이름 변경 성공 " + encodedFile.getName());
					}
					else
					{
						System.out.println("encodedFile이름 변경 실패");
					}
					System.out.println("encodedFile이름 변경 후 " + encodedFile.getName() + ", " + file.getName());
				
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} catch(Error e){
				}
			}	// End of .txt 인코딩 변환

			// 문서파일을 PDF파일로 변환한다.
			//System.out.println("문서파일을 PDF파일로 변환한다.^^^");
			
			// delay발생
			//office2pdfConverter.convert(newFile, pdfFile);
			
			//System.out.println("변경될 PDF파일 pdfFile.getAbsolutePath() - " + pdfFile.getAbsolutePath() + ", pdfFile.getName() - " + pdfFile.getName());
			//office2pdfConverter.convert(file, pdfFile);
			//office2pdfConverter.convert(file, new File(FilePath+newFileName.substring(0, lastDot)+".pdf"));
			//if(file != null) file.delete();
			
			//newFile.delete();
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			SocketOpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
			try {
				//System.out.println("OpenOffice접속시도!!!: " + connection.isConnected());
				
				connection.connect();  
				
				//System.out.println("OpenOffice접속!!! : " + connection.isConnected());
				

				DefaultDocumentFormatRegistry registry = new DefaultDocumentFormatRegistry();
				OpenOfficeDocumentConverter converter = new OpenOfficeDocumentConverter(connection, registry);
				
				DocumentFormat pdf = registry.getFormatByFileExtension("pdf");
				Map<String, Object> pdfOptions = new HashMap<String, Object>();
				pdfOptions.put("ReduceImageResolution", Boolean.TRUE);
				pdfOptions.put("MaxImageResolution", Integer.valueOf(300));
				pdf.setExportOption(DocumentFamily.TEXT, "FilterData", pdfOptions);

				//System.out.println("-- 변환시작 : ");
				converter.convert(newFile, pdfFile, pdf);
				//System.out.println("-- 변환완료 : ");
				//converter.convert(newFile, pdfFile, pdf);
				//converter.convert(presentation, output, pdf);
				
				connection.disconnect();
				
				if (pdfFile.exists()) {
					System.out.println("PDF변경성공!");
				} else {
					System.out.println("PDF변경실패!");
					System.out.println("------> Failed to convert: " + pdfFile.getAbsolutePath() + " does not exist.");
				}

			} catch(Exception e) {
				System.out.println("Exception: Failed to convert " + pdfFile.getAbsolutePath() + ", 에러메시지 : " + e.getMessage());
			}
			
			////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
		}

		// 변환된 PDF파일의 총 페이지 수를 구해서 클라이언트로 리턴
		//System.out.println("변환된 PDF파일의 총 페이지 수를 구해서 클라이언트로 리턴");
		int totalPage = pageCounter.countNumberOfPages(pdfFile);
		System.out.println("----------> totalPage : " + totalPage);
		ArrayList<HashMap> fileInfo = new  ArrayList<HashMap>();
		HashMap map = new HashMap();
		map.put("fileName", newFileName);
		map.put("totalPage", totalPage);
		fileInfo.add(map);
		return fileInfo;
	}

	/**
	 * PDF파일을 SWF파일로 바꾼다. 
	 */
	@Override
	public void convertPDFtoSWF(ArrayCollection data){

		ASObject obj = (ASObject) data.get(0);
		String fileName = (String) obj.get("fileName");
		String roomID = (String) obj.get("roomID");
		String userID = (String) obj.get("userID");

		int lastDot = fileName.lastIndexOf('.');
		File pdfFile = new File(FilePath, fileName.substring(0, lastDot) + ".pdf");
		File swfFile = new File(FilePath, fileName.substring(0, lastDot)+".swf");

		if(pdf2swfConverter.convert(pdfFile, swfFile, userID))
		{
			// 컨버팅 완료
			BlazedsUtil.pushAsyncMessage(BlazedsConstant.PUSH_SERVICE_DOC, "complete", userID);
			//pdfFile.delete();
			File f = new File(FilePath+roomID);
			if(!f.exists())	f.mkdir();
			// Storage디스크의 파일스스템에 따라 되는 경우가 있고, 되지 않는 경우가 있어 아래 코드는 쓰지 못한다.
			// NIO Channel을 이용해자.
			//swfFile.renameTo(new File(f.getPath() + "\\" + fileName.substring(0, lastDot)+".swf"));
			//System.out.println("swfFile.getAbsolutePath() : " + swfFile.getAbsolutePath() + ", " + f.getAbsolutePath() + "/" + swfFile.getName());
			moveFile(swfFile.getAbsolutePath(), f.getAbsolutePath() + "/" + swfFile.getName());
		}
	}

	/**
	 * 파일명 변경 
	 */
	Path newName(Path oldFile, String newNameString){
	    // the magic is done by Path.resolve(...)
	    return oldFile.getParent().resolve(newNameString);
	}
	
	/**
	 * 파일이동
	 */ 
	public boolean moveFile(String source, String dest) {
		boolean result = false;

		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;

		try {
			inputStream = new FileInputStream(source);
			outputStream = new FileOutputStream(dest);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			result = false;
		}

		FileChannel fcin = inputStream.getChannel();
		FileChannel fcout = outputStream.getChannel();

		long size = 0;
		try {
			size = fcin.size();
			fcin.transferTo(0, size, fcout);

			fcout.close();
			fcin.close();
			outputStream.close();
			inputStream.close();

			result = true;
		} catch (IOException e) {
			e.printStackTrace();
			result = false;
		}

		File f = new File(source);
		if (f.delete()) {
			result = true;
		}
		return result;
	}


	/**
	 * 파일복사 
	 */
	public void copy(String source, String target) {

		//복사 대상이 되는 파일 생성 
		File sourceFile = new File( source );

		//스트림, 채널 선언
		FileInputStream inputStream = null;
		FileOutputStream outputStream = null;
		FileChannel fcin = null;
		FileChannel fcout = null;
		try {

			//스트림 생성
			inputStream = new FileInputStream(sourceFile);
			outputStream = new FileOutputStream(target);

			//채널 생성
			fcin = inputStream.getChannel();
			fcout = outputStream.getChannel();


			//채널을 통한 스트림 전송
			long size = fcin.size();
			fcin.transferTo(0, size, fcout);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			//자원 해제
			try{
				fcout.close();
			}catch(IOException ioe){}
			try{
				fcin.close();
			}catch(IOException ioe){}
			try{
				outputStream.close();
			}catch(IOException ioe){}
			try{
				inputStream.close();
			}catch(IOException ioe){}
		}
	}


	static public void countConverting(int page, String userID){
		System.out.println("userID : " + userID);
		BlazedsUtil.pushAsyncMessage(BlazedsConstant.PUSH_SERVICE_DOC, page, userID);
	}
	
	public void runScreenShareApp()
	{
		System.out.println("runScreenShareApp()");
	}
}
