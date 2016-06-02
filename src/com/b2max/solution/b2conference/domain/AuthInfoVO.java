package com.b2max.solution.b2conference.domain;

import java.io.Serializable;

/**
 * LMS 파라미터 구분자에 따른 웹연동 데이타
 */
public class AuthInfoVO implements Serializable {
	
	static final long serialVersionUID = 103844514947365244L;
	
	private String siteIdx;
	private String roomID;
	private String roomName;
	private String userID;
	private String userName;
	private String userState;
	private String courseIdx;
	private String authKey;
	private String actionTp;
	
	private String nickName;
	private String companyName;
	private String siteStateCd;
	private int mgrDiskSize;
	private String logoName;
	private int enterCnt;
	private String solution1;
	private String solution2;
	private String solution3;
	private String solution4;
	private String solution5;
	private String solution6;
	private String solution7;
	private Boolean result;
	private String resMsg;
	
	private Boolean isAllowIP;
	
	public String getSiteIdx() {
		return siteIdx;
	}
	public void setSiteIdx(String siteIdx) {
		this.siteIdx = siteIdx;
	}
	public String getRoomID() {
		return roomID;
	}
	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}
	public String getRoomName() {
		return roomName;
	}
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserState() {
		return userState;
	}
	public void setUserState(String userState) {
		this.userState = userState;
	}
	public String getCourseIdx() {
		return courseIdx;
	}
	public void setCourseIdx(String courseIdx) {
		this.courseIdx = courseIdx;
	}
	public String getAuthKey() {
		return authKey;
	}
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
	public String getActionTp() {
		return actionTp;
	}
	public void setActionTp(String actionTp) {
		this.actionTp = actionTp;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSiteStateCd() {
		return siteStateCd;
	}
	public void setSiteStateCd(String siteStateCd) {
		this.siteStateCd = siteStateCd;
	}
	public int getMgrDiskSize() {
		return mgrDiskSize;
	}
	public void setMgrDiskSize(int mgrDiskSize) {
		this.mgrDiskSize = mgrDiskSize;
	}
	public String getLogoName() {
		return logoName;
	}
	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}
	public int getEnterCnt() {
		return enterCnt;
	}
	public void setEnterCnt(int enterCnt) {
		this.enterCnt = enterCnt;
	}
	public String getSolution1() {
		return solution1;
	}
	public void setSolution1(String solution1) {
		this.solution1 = solution1;
	}
	public String getSolution2() {
		return solution2;
	}
	public void setSolution2(String solution2) {
		this.solution2 = solution2;
	}
	public String getSolution3() {
		return solution3;
	}
	public void setSolution3(String solution3) {
		this.solution3 = solution3;
	}
	public String getSolution4() {
		return solution4;
	}
	public void setSolution4(String solution4) {
		this.solution4 = solution4;
	}
	public String getSolution5() {
		return solution5;
	}
	public void setSolution5(String solution5) {
		this.solution5 = solution5;
	}
	public String getSolution6() {
		return solution6;
	}
	public void setSolution6(String solution6) {
		this.solution6 = solution6;
	}
	public String getSolution7() {
		return solution7;
	}
	public void setSolution7(String solution7) {
		this.solution7 = solution7;
	}
	public Boolean getResult() {
		return result;
	}
	public void setResult(Boolean result) {
		this.result = result;
	}
	public String getResMsg() {
		return resMsg;
	}
	public void setResMsg(String resMsg) {
		this.resMsg = resMsg;
	}

	public Boolean getIsAllowIP() {
		return isAllowIP;
	}
	public void setIsAllowIP(Boolean isAllowIP) {
		this.isAllowIP = isAllowIP;
	}
}
