package com.b2max.solution.b2conference.domain;

public class AttachFileVO 
{
	static final long serialVersionUID = 103844514947365244L;
	
    private int idx;
    private int siteIdx;
    private String fileName;
    private String realName;
    private int orderNo;
    private String regDate;
    private String modDate;
    private String regUserId;
    private String modUserId;
    private String delYn;

    private String name;
    private String extension;
    private long size;
    
    /**
     * @return the idx
     */
    public int getIdx() {
        return idx;
    }

    /**
     * @param idx
     *            the idx to set
     */
    public void setIdx(int idx) {
        this.idx = idx;
    }

    /**
     * @return the siteIdx
     */
    public int getSiteIdx() {
        return siteIdx;
    }

    /**
     * @param siteIdx
     *            the siteIdx to set
     */
    public void setSiteIdx(int siteIdx) {
        this.siteIdx = siteIdx;
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName
     *            the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the realName
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param realName
     *            the realName to set
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * @return the orderNo
     */
    public int getOrderNo() {
        return orderNo;
    }

    /**
     * @param orderNo
     *            the orderNo to set
     */
    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * @return the regDate
     */
    public String getRegDate() {
        return regDate;
    }

    /**
     * @param regDate
     *            the regDate to set
     */
    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    /**
     * @return the modDate
     */
    public String getModDate() {
        return modDate;
    }

    /**
     * @param modDate
     *            the modDate to set
     */
    public void setModDate(String modDate) {
        this.modDate = modDate;
    }

    /**
     * @return the regUserId
     */
    public String getRegUserId() {
        return regUserId;
    }

    /**
     * @param regUserId
     *            the regUserId to set
     */
    public void setRegUserId(String regUserId) {
        this.regUserId = regUserId;
    }

    /**
     * @return the modUserId
     */
    public String getModUserId() {
        return modUserId;
    }

    /**
     * @param modUserId
     *            the modUserId to set
     */
    public void setModUserId(String modUserId) {
        this.modUserId = modUserId;
    }

    /**
     * @return the delYn
     */
    public String getDelYn() {
        return delYn;
    }

    /**
     * @param delYn
     *            the delYn to set
     */
    public void setDelYn(String delYn) {
        this.delYn = delYn;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }
    
    /**
     * @return the size
     */
    public long getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(long size) {
        this.size = size;
    }
}
