package com.b2max.solution.b2conference.domain;

import java.io.Serializable;

import com.b2max.solution.util.CommonUtil;

/**
 * 로그인 인증시 웹연동 데이타
 */
public class AuthenticateDomain implements Serializable {
    private static final long serialVersionUID = -3639142870583296217L;

    private int userIdx;
    private int siteIdx;
    private String id;
    private String name;
    private String mobileNo;
    private String email;
    private String nickName;
    private String userPic;
    private String approvedStatusCd;
    private String companyName;
    private String siteStateCd;
    private String mgrDiskSize;
    private String logoName;
    private int enterCnt;
    private String solution1;
    private String solution2;
    private String solution3;
    private String solution4;
    private String solution5;
    private String solution6;
    private String solution7;
    
    private String sol1UseYn;
    private String sol2UseYn;
    private String sol3UseYn;
    private String sol4UseYn;
    private String sol5UseYn;    
    private String sol7UseYn;
    
    private String sol1ConnUserCount;
    private String sol2ConnUserCount;
    private String sol3ConnUserCount;
    private String sol4ConnUserCount;
    private String sol5ConnUserCount;
    
    private String sol1ConnIpNation;
    private String sol2ConnIpNation;
    private String sol3ConnIpNation;
    private String sol4ConnIpNation;
    private String sol5ConnIpNation;
    
    private String sol1Options;
    private String sol2Options;
    private String sol3Options;
    private String sol4Options;
    private String sol5Options;
    private String sol6Options;
    private String sol7Options;
    
    private boolean isAuth = false;
    private String transactionId;
    
	/**
	 * @return the userIdx
	 */
	public int getUserIdx() {
		return userIdx;
	}
	/**
	 * @param userIdx the userIdx to set
	 */
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	/**
	 * @return the siteIdx
	 */
	public int getSiteIdx() {
		return siteIdx;
	}
	/**
	 * @param siteIdx the siteIdx to set
	 */
	public void setSiteIdx(int siteIdx) {
		this.siteIdx = siteIdx;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
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
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * @return the userPic
	 */
	public String getUserPic() {
		return userPic;
	}
	/**
	 * @param userPic the userPic to set
	 */
	public void setUserPic(String userPic) {
		this.userPic = userPic;
	}
	/**
	 * @return the approvedStatusCd
	 */
	public String getApprovedStatusCd() {
		return approvedStatusCd;
	}
	/**
	 * @param approvedStatusCd the approvedStatusCd to set
	 */
	public void setApprovedStatusCd(String approvedStatusCd) {
		this.approvedStatusCd = approvedStatusCd;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the siteStateCd
	 */
	public String getSiteStateCd() {
		return siteStateCd;
	}
	/**
	 * @param siteStateCd the siteStateCd to set
	 */
	public void setSiteStateCd(String siteStateCd) {
		this.siteStateCd = siteStateCd;
	}
	/**
	 * @return the mgrDiskSize
	 */
	public String getMgrDiskSize() {
		return mgrDiskSize;
	}
	/**
	 * @param mgrDiskSize the mgrDiskSize to set
	 */
	public void setMgrDiskSize(String mgrDiskSize) {
		this.mgrDiskSize = mgrDiskSize;
	}
	/**
	 * @return the logoName
	 */
	public String getLogoName() {
		return logoName;
	}
	/**
	 * @param logoName the logoName to set
	 */
	public void setLogoName(String logoName) {
		this.logoName = logoName;
	}
	/**
	 * @return the enterCnt
	 */
	public int getEnterCnt() {
		return enterCnt;
	}
	/**
	 * @param enterCnt the enterCnt to set
	 */
	public void setEnterCnt(int enterCnt) {
		this.enterCnt = enterCnt;
	}
	/**
	 * @return the solution1
	 */
	public String getSolution1() {
		return solution1;
	}
	/**
	 * @param solution1 the solution1 to set
	 */
	public void setSolution1(String solution1) {
		this.solution1 = solution1;
	}
	/**
	 * @return the solution2
	 */
	public String getSolution2() {
		return solution2;
	}
	/**
	 * @param solution2 the solution2 to set
	 */
	public void setSolution2(String solution2) {
		this.solution2 = solution2;
	}
	/**
	 * @return the solution3
	 */
	public String getSolution3() {
		return solution3;
	}
	/**
	 * @param solution3 the solution3 to set
	 */
	public void setSolution3(String solution3) {
		this.solution3 = solution3;
	}
	/**
	 * @return the solution4
	 */
	public String getSolution4() {
		return solution4;
	}
	/**
	 * @param solution4 the solution4 to set
	 */
	public void setSolution4(String solution4) {
		this.solution4 = solution4;
	}
	/**
	 * @return the solution5
	 */
	public String getSolution5() {
		return solution5;
	}
	/**
	 * @param solution5 the solution5 to set
	 */
	public void setSolution5(String solution5) {
		this.solution5 = solution5;
	}
	/**
	 * @return the solution6
	 */
	public String getSolution6() {
		return solution6;
	}
	/**
	 * @param solution6 the solution6 to set
	 */
	public void setSolution6(String solution6) {
		this.solution6 = solution6;
	}
	/**
	 * @return the solution7
	 */
	public String getSolution7() {
		return solution7;
	}
	/**
	 * @param solution7 the solution7 to set
	 */
	public void setSolution7(String solution7) {
		this.solution7 = solution7;
	}
	public String getSol1UseYn() {
		if ("".equals(CommonUtil.sNull(sol1UseYn))) {
			sol1UseYn = getSplitStr(0, solution1, "\\^");
        }
		
		return sol1UseYn;
	}
	
	public void setSol1UseYn(String sol1UseYn) {
		this.sol1UseYn = sol1UseYn;
	}
	
	public String getSol1ConnUserCount() {
		if ("".equals(CommonUtil.sNull(sol1ConnUserCount))) {
			sol1ConnUserCount = getSplitStr(1, solution1, "\\^");
        }
		
		return sol1ConnUserCount;
	}

	public void setSol1ConnUserCount(String sol1ConnUserCount) {
		this.sol1ConnUserCount = sol1ConnUserCount;
	}
	
	public String getSol1ConnIpNation() {
		if ("".equals(CommonUtil.sNull(sol1ConnIpNation))) {
			sol1ConnIpNation = getSplitStr(2, solution1, "\\^");
        }
		
		return sol1ConnIpNation;
	}

	public void setSol1ConnIpNation(String sol1ConnIpNation) {
		this.sol1ConnIpNation = sol1ConnIpNation;
	}
	
	public String getSol1Options() {
		if ("".equals(CommonUtil.sNull(sol1Options))) {
			sol1Options = getSplitStr(3, solution1, "\\^");
        }
		
		return sol1Options;
	}
	
	public void setSol1Options(String sol1Options) {
		this.sol1Options = sol1Options;
	}
	
	public String getSol2UseYn() {
		if ("".equals(CommonUtil.sNull(sol2UseYn))) {
			sol2UseYn = getSplitStr(0, solution2, "\\^");
        }
		
		return sol2UseYn;
	}
	
	public void setSol2UseYn(String sol2UseYn) {
		this.sol2UseYn = sol2UseYn;
	}
	
	public String getSol2ConnUserCount() {
		if ("".equals(CommonUtil.sNull(sol2ConnUserCount))) {
			sol2ConnUserCount = getSplitStr(1, solution2, "\\^");
        }
		
		return sol2ConnUserCount;
	}

	public void setSol2ConnUserCount(String sol2ConnUserCount) {
		this.sol2ConnUserCount = sol2ConnUserCount;
	}
	
	public String getSol2ConnIpNation() {
		if ("".equals(CommonUtil.sNull(sol2ConnIpNation))) {
			sol2ConnIpNation = getSplitStr(2, solution2, "\\^");
        }
		
		return sol2ConnIpNation;
	}

	public void setSol2ConnIpNation(String sol2ConnIpNation) {
		this.sol2ConnIpNation = sol2ConnIpNation;
	}
	
	public String getSol2Options() {
		if ("".equals(CommonUtil.sNull(sol2Options))) {
			sol2Options = getSplitStr(3, solution2, "\\^");
        }
		
		return sol2Options;
	}
	
	public void setSol2Options(String sol2Options) {
		this.sol2Options = sol2Options;
	}
	
	public String getSol3UseYn() {
		if ("".equals(CommonUtil.sNull(sol3UseYn))) {
			sol3UseYn = getSplitStr(0, solution3, "\\^");
        }
		
		return sol3UseYn;
	}
	
	public void setSol3UseYn(String sol3UseYn) {
		this.sol3UseYn = sol3UseYn;
	}
	
	public String getSol3ConnUserCount() {
		if ("".equals(CommonUtil.sNull(sol3ConnUserCount))) {
			sol3ConnUserCount = getSplitStr(1, solution3, "\\^");
        }
		
		return sol3ConnUserCount;
	}

	public void setSol3ConnUserCount(String sol3ConnUserCount) {
		this.sol3ConnUserCount = sol3ConnUserCount;
	}
	
	public String getSol3ConnIpNation() {
		if ("".equals(CommonUtil.sNull(sol3ConnIpNation))) {
			sol3ConnIpNation = getSplitStr(2, solution3, "\\^");
        }
		
		return sol3ConnIpNation;
	}

	public void setSol3ConnIpNation(String sol3ConnIpNation) {
		this.sol3ConnIpNation = sol3ConnIpNation;
	}
	
	public String getSol3Options() {
		if ("".equals(CommonUtil.sNull(sol3Options))) {
			sol3Options = getSplitStr(3, solution3, "\\^");
        }
		
		return sol3Options;
	}
	
	public void setSol3Options(String sol3Options) {
		this.sol3Options = sol3Options;
	}
	
	public String getSol4UseYn() {
		if ("".equals(CommonUtil.sNull(sol4UseYn))) {
			sol4UseYn = getSplitStr(0, solution4, "\\^");
        }
		
		return sol4UseYn;
	}
	
	public void setSol4UseYn(String sol4UseYn) {
		this.sol4UseYn = sol4UseYn;
	}
	
	public String getSol4ConnUserCount() {
		if ("".equals(CommonUtil.sNull(sol4ConnUserCount))) {
			sol4ConnUserCount = getSplitStr(1, solution4, "\\^");
        }
		
		return sol4ConnUserCount;
	}

	public void setSol4ConnUserCount(String sol4ConnUserCount) {
		this.sol4ConnUserCount = sol4ConnUserCount;
	}
	
	public String getSol4ConnIpNation() {
		if ("".equals(CommonUtil.sNull(sol4ConnIpNation))) {
			sol4ConnIpNation = getSplitStr(2, solution4, "\\^");
        }
		
		return sol4ConnIpNation;
	}

	public void setSol4ConnIpNation(String sol4ConnIpNation) {
		this.sol4ConnIpNation = sol4ConnIpNation;
	}
	
	public String getSol4Options() {
		if ("".equals(CommonUtil.sNull(sol4Options))) {
			sol4Options = getSplitStr(3, solution4, "\\^");
        }
		
		return sol4Options;
	}
	
	public void setSol4Options(String sol4Options) {
		this.sol4Options = sol4Options;
	}
	
	public String getSol5UseYn() {
		if ("".equals(CommonUtil.sNull(sol5UseYn))) {
			sol5UseYn = getSplitStr(0, solution5, "\\^");
        }
		
		return sol5UseYn;
	}
	
	public void setSol5UseYn(String sol5UseYn) {
		this.sol5UseYn = sol5UseYn;
	}
	
	public String getSol5ConnUserCount() {
		if ("".equals(CommonUtil.sNull(sol5ConnUserCount))) {
			sol5ConnUserCount = getSplitStr(1, solution5, "\\^");
        }
		
		return sol5ConnUserCount;
	}

	public void setSol5ConnUserCount(String sol5ConnUserCount) {
		this.sol5ConnUserCount = sol5ConnUserCount;
	}
	
	public String getSol5ConnIpNation() {
		if ("".equals(CommonUtil.sNull(sol5ConnIpNation))) {
			sol5ConnIpNation = getSplitStr(2, solution5, "\\^");
        }
		
		return sol5ConnIpNation;
	}

	public void setSol5ConnIpNation(String sol5ConnIpNation) {
		this.sol5ConnIpNation = sol5ConnIpNation;
	}
	
	public String getSol5Options() {
		if ("".equals(CommonUtil.sNull(sol5Options))) {
			sol5Options = getSplitStr(3, solution5, "\\^");
        }
		
		return sol5Options;
	}
	
	public void setSol5Options(String sol5Options) {
		this.sol5Options = sol5Options;
	}
	
	public String getSol7UseYn() {
		if ("".equals(CommonUtil.sNull(sol7UseYn))) {
			sol7UseYn = getSplitStr(0, solution7, "\\^");
        }
		
		return sol7UseYn;
	}
	
	public void setSol7UseYn(String sol7UseYn) {
		this.sol7UseYn = sol7UseYn;
	}
	
	public String getSol7Options() {
		if ("".equals(CommonUtil.sNull(sol7Options))) {
			sol7Options = getSplitStr(1, solution7, "\\^");
        }
		
		return sol7Options;
	}
	
	public void setSol7Options(String sol7Options) {
		this.sol7Options = sol7Options;
	}
	/**
	 * @return the isAuth
	 */
	public boolean isAuth() {
		return isAuth;
	}
	/**
	 * @param isAuth the isAuth to set
	 */
	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}
	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}
	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
     * Solution Use 값 분할
     * 
     * @param idx
     * @return
     */
    private String getSplitStr(int idx, String targetStr, String delim) {
        String[] str = null;

        if (!"".equals(CommonUtil.sNull(targetStr))) {
            str = targetStr.split(delim);
        }
        if (str == null || str.length == 0) {
            return "";
        } else {
            if (str.length > idx) {
                return str[idx];
            } else {
                return "";
            }
        }
    }
}
