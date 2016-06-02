package com.b2max.solution.b2conference.domain;

public class FileVO 
{
	static final long serialVersionUID = 103844514947365244L;
	
	private int idx;
	private int siteIdx;
	private String docID;
	private String fileName;
	private String realName;
	private String fileType;
	private String swfFileName;
	private String uploaderUserID;
	private int uploaderUserName;
	private int uploadTime;
	private int totalPage;
	private String fileURL;
	
	private Boolean selected;

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public int getSiteIdx() {
		return siteIdx;
	}

	public void setSiteIdx(int siteIdx) {
		this.siteIdx = siteIdx;
	}

	public String getDocID() {
		return docID;
	}

	public void setDocID(String docID) {
		this.docID = docID;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getSwfFileName() {
		return swfFileName;
	}

	public void setSwfFileName(String swfFileName) {
		this.swfFileName = swfFileName;
	}

	public String getUploaderUserID() {
		return uploaderUserID;
	}

	public void setUploaderUserID(String uploaderUserID) {
		this.uploaderUserID = uploaderUserID;
	}

	public int getUploaderUserName() {
		return uploaderUserName;
	}

	public void setUploaderUserName(int uploaderUserName) {
		this.uploaderUserName = uploaderUserName;
	}

	public int getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(int uploadTime) {
		this.uploadTime = uploadTime;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
}
