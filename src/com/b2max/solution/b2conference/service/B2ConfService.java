package com.b2max.solution.b2conference.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.b2max.solution.b2conference.domain.AuthenticateDomain;
import com.b2max.solution.b2conference.domain.FileVO;
import com.b2max.solution.b2conference.domain.AuthInfoVO;

import flex.messaging.io.ArrayCollection;



public interface B2ConfService {
	
	public AuthenticateDomain getLogonAuthInfo(String id, String pw);
	public AuthInfoVO getAuthInfo(String authKey, String roomID);
	public ArrayList<FileVO> getLMSDocList(String courseIdx);
	
	public Boolean doUpload(String storagePath, String fileName, byte[] data);
	public Boolean doFileUpload(String storagePath, String roomID, String fileName, byte[] data);
	public ArrayList<HashMap> getTotalPage(String fileName);
	public void convertPDFtoSWF(ArrayCollection data);
	
	public void runScreenShareApp();
}