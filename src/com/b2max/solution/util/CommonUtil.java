package com.b2max.solution.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class CommonUtil {
    public static final String EMPTY_STRING = "";

    public static String filter(String value) {
        if (value == null) {
            return null;
        }

        value = xssFilter(value);

        StringBuffer result = new StringBuffer(value.length());

        for (int i = 0; i < value.length(); ++i) {
            switch (value.charAt(i)) {
            case '<':
                result.append("&lt;");
                break;
            case '>':
                result.append("&gt;");
                break;
            case '"':
                result.append("&quot;");
                break;
            case '\'':
                result.append("&#39;");
                break;
            case '%':
                result.append("&#37;");
                break;
            case ';':
                result.append("&#59;");
                break;
            case '(':
                result.append("&#40;");
                break;
            case ')':
                result.append("&#41;");
                break;
            case '&':
                result.append("&amp;");
                break;
            case '+':
                result.append("&#43;");
                break;
            case '/':
                result.append("&#x2F;");
                break;
            default:
                result.append(value.charAt(i));
                break;
            }
        }

        return result.toString().trim();
    }

    public static String xssFilter(String str) {
        String filstr = "script"; // 필터링 할 문자열(,)

        if (!filstr.equals("")) {
            filstr.replaceAll(" ", "");
            String[] st = filstr.split(",");

            for (int x = 0; x < st.length; x++) {
                str = str.replaceAll(st[x], "_" + st[x] + "_");
            }
        }

        return str;
    }

    public static String clear(String str) {
        str = replace(str, "&lt;", "<");
        str = replace(str, "&gt;", ">");
        str = replace(str, "&quot;", "\"");
        str = replace(str, "&#39;", "'");
        str = replace(str, "&#37;", "%");
        str = replace(str, "&#59;", ";");
        str = replace(str, "&#40;", "(");
        str = replace(str, "&#41;", ")");
        str = replace(str, "&amp;", "&");
        str = replace(str, "&#43;", "+");
        str = replace(str, "&#x2F;", "/");

        return str;
    }

    public static String getAttribute(HttpServletRequest req, String strName) {
        return (String) req.getAttribute(strName) == null ? "" : (String) req.getAttribute(strName);
    }

    public static String getAttribute(HttpServletRequest req, String strName, String defaultValue) {
        String temp = (String) req.getAttribute(strName);

        if (temp == null || temp.equals("")) {
            temp = defaultValue;
        }

        return temp;
    }

    public static int getAttribute(HttpServletRequest req, String strName, int defaultValue) {
        String temp = (String) req.getAttribute(strName);

        if (temp == null || temp.equals("")) {
            temp = defaultValue + "";
        }

        return Integer.parseInt(temp);
    }

    public static String getParameter(MultipartRequest multi, String strName) {
        return multi.getParameter(strName) == null ? "" : multi.getParameter(strName);
    }

    /**
     * 웹의 Request 파라미터의 정보를 가져온다. 파라미터명이 존재하지 않을 경우는 빈 문자열로 세팅한다.
     * 
     * @param req
     *            HttpServletRequest
     * @param strName
     *            파라미터 이름
     * @return 파라미터가 존재하지 않으면 빈 문자열로 리턴한다.
     * 
     * @see HttpServletRequest#getParameter(String name)
     */
    public static String getParameter(HttpServletRequest req, String strName) {
        return getParameter(req, strName, "", true);
    }

    /**
     * 웹의 Request 파라미터의 정보를 가져온다. 파라미터명이 존재하지 않을 경우는 빈 문자열로 세팅한다.
     * 
     * @param javax
     *            .servlet.http.HttpServletRequest req
     * @param String
     *            strName
     * @param int defaultValue
     * @return int
     */

    public static int getParameter(HttpServletRequest req, String strName, int defaultValue) {
        int iRtn = 0;

        try {
            iRtn = req.getParameter(strName) == null ? defaultValue : Integer.parseInt(req.getParameter(strName));
        } catch (NumberFormatException e) {
            iRtn = defaultValue;
        }

        return iRtn;
    }

    /**
     * 웹의 Request 파라미터의 정보를 가져온다. 파라미터명이 존재하지 않을 경우는 빈 문자열로 세팅한다.
     * 
     * @param javax
     *            .servlet.http.HttpServletRequest req
     * @param String
     *            strName
     * @param String
     *            strDefaultValue
     * @return String
     */
    public static String getParameter(HttpServletRequest req, String strName, String strDefaultValue) {
        return getParameter(req, strName, strDefaultValue, false);
    }

    /**
     * 웹의 Request 파라미터의 정보를 가져오는데 문자열의 오른쪽 빈칸을 제거한다. 파라미터명이 존재하지 않을 경우는 디폴트 값으로
     * 세팅한다.
     * 
     * @param javax
     *            .servlet.http.HttpServletRequest req
     * @param String
     *            strName
     * @param String
     *            strDefaultValue
     * @param boolean bTrim 글자 뒷부분 공백 자르기
     * @return String
     */
    public static String getParameter(javax.servlet.http.HttpServletRequest req, String strName, String strDefaultValue, boolean bTrim) {
        String strTemp = req.getParameter(strName);

        if (strTemp == null || strTemp.equals("")) {
            strTemp = strDefaultValue;
        }

        return bTrim == false ? strTemp : strTemp.trim();
    }

    /**
     * 웹의 Request 파라미터의 정보를 가져오는데 문자열의 오른쪽 빈칸을 제거한다. 파라미터명이 존재하지 않을 경우는 디폴트 값으로
     * 세팅한다.
     * 
     * @param req
     * @param strName
     * @param bTrim
     * @return
     */
    public static String getParameter(javax.servlet.http.HttpServletRequest req, String strName, boolean bTrim) {
        String strTemp = req.getParameter(strName);

        return (strTemp == null || strTemp.equals("") ? "" : (bTrim == false ? strTemp : strTemp.trim()));
    }

    /**
     *
     * @param javax
     *            .servlet.http.HttpServletRequest req
     * @param String
     *            strName
     * @param int iIdx
     * @return String
     */
    public static String getParameterValues(javax.servlet.http.HttpServletRequest req, String strName, int iIdx) {
        String strParameter[] = req.getParameterValues(strName);
        if (strParameter == null)
            return "";
        if (iIdx < strParameter.length)
            return strParameter[iIdx] == null ? "" : strParameter[iIdx];
        else
            return "";
    }

    /**
     *
     * @param javax
     *            .servlet.http.HttpServletRequest req
     * @param String
     *            strName
     * @param int iIdx
     * @param String
     *            strDefaultValue
     * @return String
     */
    public static String getParameterValues(javax.servlet.http.HttpServletRequest req, String strName, int iIdx, String strDefaultValue) {
        String strParameter[] = req.getParameterValues(strName);
        if (strParameter == null)
            return strDefaultValue;
        else if (iIdx < strParameter.length)
            return strParameter[iIdx] == null ? strDefaultValue : strParameter[iIdx];
        else
            return strDefaultValue;
    }

    /**
     * 캐싱을 설정한다. iFlag의 값이 0이면 캐싱하지 않음. iFlag의 값이 1이면 캐싱함.
     * 
     * @param javax
     *            .servlet.http.HttpServletResponse res
     * @param iFlag
     * @return javax.servlet.http.HttpServletResponse
     */
    public static javax.servlet.http.HttpServletResponse setCaching(javax.servlet.http.HttpServletResponse res, int iFlag) {
        if (iFlag == 0) {
            res.setHeader("Cache-Control", "no-cache");
            res.setHeader("Expires", "0");
            res.setHeader("Pragma", "no-cache");
        } else if (iFlag == 1) {
            res.setHeader("Cache-Control", "store");
            res.setHeader("Pragma", "");
        }
        return res;
    }

    /*********************************************************************************
     * src에서 str1와 str2를 replace하는 메소드
     *
     * @param src
     *            소스 파라메터
     * @param String
     *            str1 페턴 문자열
     * @param String
     *            str2 바꿀 문자열
     * @return String
     *********************************************************************************/
    public static String replace(String src, String str1, String str2) {
        // argument가 null 일 경우 EMPTY_STRING 을 리턴
        if ((src == null) || (str2 == null) || (str1 == null))
            return EMPTY_STRING;

        // argument의 length가 0 일 경우 EMPTY_STRING 을 리턴
        if ((src.length() == 0) || (str1.length() == 0))
            return EMPTY_STRING;

        // 일치하는 패턴이 없을경우 src를 그대로 return
        if (src.indexOf(str1) < 0)
            return src;

        String tmp = new String(src);
        StringBuffer sbTemp = new StringBuffer();

        int idx = 0;
        int len = str1.length();

        while ((idx = tmp.indexOf(str1)) > -1) {
            if (idx == 0)
                sbTemp.append(str2);
            else {
                sbTemp.append(tmp.substring(0, idx));
                sbTemp.append(str2);
            }

            tmp = tmp.substring(idx + len);
        }
        sbTemp.append(tmp);

        return sbTemp.toString();
    }

    public static String returnScript(String src) {
        src = CommonUtil.replace(src, "OK", "");

        if (!src.equals("")) {
            src += "alert('" + src + "');";
        }

        return src;
    }

    /*********************************************************************************
     * string에 "'" 가 들어가 있을 경우 "''"로 변환하는 메소드
     *
     * @param String
     *            src 소스 데이터
     *
     * @return String
     *********************************************************************************/
    public static String encodeQuot(String src) {
        return replace(src, "'", "''");
    }

    /*********************************************************************************
     * string의 양 끝에 '"'를 붙이는 메소드
     *
     * @param String
     *            src 소스 데이터
     *
     * @return String
     *********************************************************************************/
    public static String addQuot(String src) {
        if (src == null)
            return EMPTY_STRING;

        return new String("'" + src + "'");
    }

    /*********************************************************************************
     * string src을 "'"를 "''"로 Convert한다.<br>
     * string src의 양끝에 "'"를 붙이는 메소드
     *
     * @param src
     *            String type의 데이터
     *
     * @return String 변환된 데이터
     *********************************************************************************/
    public static String sqlCharTypeNoTrim(String src, int i) {
        src = nvl(src, "");
        src = encodeQuot(src);

        if (i == 0)
            return new String(src);
        else
            return new String("'" + src + "'");
    }

    /*********************************************************************************
     * oracle의 nvl(...)과 동일한 기능을 하는 메소드
     *
     * @param src
     *            String type의 데이터
     * @param ret
     *            String type의 리턴되어질 테이터
     *
     * @return String
     *********************************************************************************/
    public static String nvl(String src, String ret) {
        if (src == null || src.equals("null") || src.equals(""))
            return ret;
        else
            return src;
    }

    /*********************************************************************************
     * 숫자형 문자열에 콤마 유무에 상관없이 천단위로 콤마를 찍어준다.<br>
     * 숫자를 999,999,999 또는 999,999,999.99 형식으로 변환하는 메소드
     *
     * @param src
     *            String type의 숫자 데이터
     *
     * @return String 세자리마다 콤마를 찍어주는 변환된 String
     *********************************************************************************/
    public static String substring(String src, int fIdx, int tIdx) {
        if (src == null)
            return "";

        src = src.trim();

        if (fIdx < 0) {
            fIdx = 0;
        } else if (fIdx > src.length()) {
            fIdx = src.length();
        }

        if (tIdx < 0) {
            tIdx = 0;
        } else if (tIdx > src.length()) {
            tIdx = src.length();
        }

        if (fIdx == tIdx) {
            return src.substring(tIdx);
        } else if (fIdx > tIdx) {
            return "";
        } else {
            return src.substring(fIdx, tIdx);
        }
    }

    public static String getImageSize(String path, String file_name, int width, int height) {
        String returnValue = "";

        try {
            File file = new File(path + File.separator + file_name);
            BufferedImage bi = ImageIO.read(file);
            int o_width = bi.getWidth();
            int o_height = bi.getHeight();

            if (o_width < width && o_height < height) {
                return "width='" + o_width + "' height='" + o_height + "'";
            }

            double cnt = 0.01;
            while (true) {
                if ((int) (o_width / cnt) < width && (int) (o_height / cnt) < height) {
                    returnValue = "width='" + (int) (o_width / cnt) + "' height='" + (int) (o_height / cnt) + "'";
                    break;
                }

                if ((int) cnt > 10) {
                    returnValue = "width='" + width + "' height='" + height + "'";
                    break;
                }

                cnt = cnt + 0.01;
            }

            return returnValue;
        } catch (Exception e) {
            // e.printStackTrace();
            return "width='" + width + "' height='" + height + "'";
        }
    }
    
    //로그인페이지 이동
    public static String getLoginString(HttpServletRequest req, String key) {
    	StringBuffer sb = new StringBuffer();
    	
    	String goUrl = req.getRequestURI()+"?key="+CommonUtil.getParameter(req,"key")+"&selectType="+CommonUtil.getParameter(req,"selectType")+"&searchType="+CommonUtil.getParameter(req,"searchType")+"&searchValue="+CommonUtil.getParameter(req,"searchValue")+"&page="+CommonUtil.getParameter(req,"page")+"&idx="+CommonUtil.getParameter(req,"idx");

    	sb.append("<html><body><form name='goFrm' method='post' action='/jsp/api/login.jsp?key="+key+"'>");
    	sb.append("<input type='hidden' name='goUrl' value='"+goUrl+"'>");
    	sb.append("</form></body></html>");
    	sb.append("<script>document.goFrm.submit();</script>");	
    	
    	return sb.toString();
    }

    /**
     * 메소드 설명을 삽입하십시오.<br>
     * 작성 날짜: (2001-04-09 오후 4:15:41)
     * 
     * @return java.site_idx.String
     */
    public static String getSysDateTime() {
        // Date클래스에서 현재의 날짜 시간을 가져옴
        java.util.Date datetime = new java.util.Date();
        java.text.SimpleDateFormat formattime = new java.text.SimpleDateFormat("yyyyMMddHH");
        String texttime = formattime.format(datetime);

        return texttime;
    }

    /**
     * 사용자 테그 사용 불가
     * 
     * @param str
     * @return String
     */
    public static String changeOrigin(String str, String path) {
        String convStr = null;

        str = replace(str, "!이미지경로", path + "/images");
        str = replace(str, "!플래쉬경로", path + "/flash");

        convStr = str;

        return convStr;
    }

    /**
     * 사용자 테그 사용 불가
     * 
     * @param str
     * @return String
     */
    public static String checkAllTag(String str) {
        String convStr = null;

        str = replace(str, "&", "&amp;");
        str = replace(str, "<", "&lt;");
        str = replace(str, ">", "&gt;");
        // str = replace(str, " ", "&nbsp;");
        // str = replace(str, "\n", "<BR>");
        // str = replace(str, "\t", "&nbsp;&nbsp;");
        // str = replace(str, "\"", "&quot;");

        convStr = str;

        return convStr;
    }

    /**
     * 임시번호 발급
     * 
     * @param int iStart 임시 발급 번호의 시작
     * @param int iEnd 임시 발급 번호 끝
     * @return boolean 계약 사항 확인
     */
    public static int getRandomNum(int iStart, int iEnd) {
        int iReturn = 0;

        Random rand = new Random(new Date().getTime());
        iReturn = rand.nextInt();
        if (iReturn < 0)
            iReturn = iReturn * -1;
        iReturn = (iReturn % (iEnd - iStart)) + iStart;

        return iReturn;
    }

    /**
     * 파일 삭제
     * 
     * @param String
     *            ePath 파일 경로
     * @param String
     *            eFname 파일 이름
     */
    public static boolean deleteFile(String ePath, String eFname) {
        try {
            java.io.File dir = new java.io.File(ePath);
            if (!dir.exists()) {
                return false;
            }

            java.io.File eF = new java.io.File(dir + java.io.File.separator + eFname);

            if (eF.exists()) {
                if (eF.delete()) {
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * NULL 값일 경우 ""로 바꾸기
     * 
     * @param String
     *            str
     * @return String 만약 Null 이면 "", Null이 아니면 str
     */
    public static String sNull(String str) {
        if (str == null)
            return "";
        return str;
    }

    public static int sNum(String str) {
        if (str == null || str.equals(""))
            return 0;
        return Integer.parseInt(str);
    }

    public static String nl2br(String str) {
        str = str.replaceAll("\r\n", "\n");
        str = str.replaceAll("\r", "<br>");
        str = str.replaceAll("\n", "<br>");

        return str;
    }

    public static String br2nl(String str) {
        str = str.replaceAll("<BR>", "\n");
        str = str.replaceAll("<br>", "\n");

        return str;
    }

    public static String sqlQuote(String str) {
        String convStr = null;

        if (str == null)
            return "";

        convStr = replace(str.trim(), "'", "&#039;");
        convStr = replace(convStr, "\'", "&#039;");
        convStr = replace(convStr, "\"", "&quot;");

        return convStr;
    }

    public static String content(String str) {
        String convStr = null;

        if (str.toLowerCase().startsWith("<br>")) {
            convStr = str.substring(str.indexOf(">") + 1);
            convStr = replace(convStr, "&#039;", "\'");
            convStr = replace(convStr, "&quot;", "\"");
        } else {
            convStr = replace(str, "&#039;", "\'");
            convStr = replace(convStr, "&quot;", "\"");
        }

        return convStr;
    }

    public static String faq(String str) {
        String convStr = null;

        if (str.toLowerCase().startsWith("<br>")) {
            convStr = str.substring(str.indexOf(">") + 1);
            convStr = replace(convStr, "&#039;", "\'");
            convStr = replace(convStr, "&quot;", "\"");
            convStr = replace(convStr, "<P>", "");
            convStr = replace(convStr, "</P>", "");
            convStr = replace(convStr, "<CENTER>", "");
            convStr = replace(convStr, "</CENTER>", "");
        } else {
            convStr = replace(str, "&#039;", "\'");
            convStr = replace(convStr, "&quot;", "\"");
            convStr = replace(convStr, "<P>", "");
            convStr = replace(convStr, "</P>", "");
            convStr = replace(convStr, "<CENTER>", "");
            convStr = replace(convStr, "</CENTER>", "");
        }

        return convStr;
    }

    public static String show(String str) {
        String convStr = null;

        convStr = replace(str, "<P>", "<BR>");
        convStr = replace(convStr, "</P>", "");
        convStr = replace(convStr, "amp;apos;", "");
        convStr = replace(convStr, "&rsquo;", "\'");
        convStr = replace(convStr, "&amp;", "&");
        convStr = replace(convStr, "&quot;&quot;", "\'");
        convStr = replace(convStr, "&quot;", "\"");
        convStr = replace(convStr, ":QUOT;:QUOT;", "\"");
        convStr = replace(convStr, "&QUOT;&QUOT;", "\"");
        convStr = replace(convStr, "&QUOT;", "\'");
        convStr = replace(convStr, ":QUOT;", "\'");
        convStr = replace(convStr, "&NBSP;", "&nbsp;");
        convStr = replace(convStr, "NBSP;", "&nbsp;");
        convStr = replace(convStr, "&nbsp;</td>", "</td>");

        return convStr;
    }

    public static String showTag(String str) {
        String convStr = null;

        convStr = replace(str, "<P>", "");
        convStr = replace(convStr, "</P>", "");
        convStr = replace(convStr, "amp;apos;", "");
        convStr = replace(convStr, "&rsquo;", "\'");
        convStr = replace(convStr, "&amp;", "&");
        convStr = replace(convStr, "&quot;&quot;", "\'");
        convStr = replace(convStr, "&quot;", "\'");
        convStr = replace(convStr, "&nbsp;</td>", "</td>");
        convStr = replace(convStr, "\r\n", "");

        return convStr;
    }

    public static String removeBr(String str) {
        String convStr = null;

        convStr = replace(str, "<br>", "");
        convStr = replace(convStr, "<BR>", "");

        return convStr;
    }

    public static String removeTag(String str) {
        int lt = str.indexOf("<");

        if (lt != -1) {
            int gt = str.indexOf(">", lt);
            if ((gt != -1)) {
                str = str.substring(0, lt) + str.substring(gt + 1);
                // 재귀 호출
                str = removeTag(str);
            }
        }
        return str;
    }

    public static String getFormUrl(String url, String msg) {
        return "";
    }

    public static synchronized String toKorean(String english) {
        String korean = null;

        if (english == null)
            return null;
        // if (english == null ) return "";

        try {
            korean = new String(new String(english.getBytes("8859_1"), "KSC5601"));
        } catch (Exception e) {
            korean = new String(english);
        }
        return korean;
    }

    public static synchronized String toEnglish(String korean) {
        String english = null;

        if (korean == null)
            return null;

        english = new String(korean);
        try {
            english = new String(new String(korean.getBytes("KSC5601"), "8859_1"));
        } catch (Exception e) {
            english = new String(korean);
        }
        return english;
    }

    public String getChangeMonth(int year, int month, int day, int addmonth) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.set(year, month - 1 + addmonth, day);
        String stryear = String.valueOf(cal.get(Calendar.YEAR)).toString();
        String strmonth = toLen2(cal.get(Calendar.MONTH) + 1);
        String strday = toLen2(cal.get(Calendar.DATE));

        return stryear + strmonth + strday;
    }

    public String toLen1(int nums) {
        if (nums < 10 && nums >= 0) {
            return "0" + nums;
        } else {
            return nums + "";
        }
    }

    public String toLen2(int nums) {
        if (nums < 10 && nums >= 0) {
            return "0" + nums;
        } else {
            return nums + "";
        }
    }

    public String toLen3(int nums) {
        if (nums < 10 && nums >= 0) {
            return "0" + nums;
        } else {
            return nums + "";
        }
    }

    /**
     * 년월일시분초밀리세컨 값으로 파일명 생성
     * 
     * @return
     */
    public static String generateFileName(String orgFileName) {
        String dTime = getCurrentDateTime("yyyyMMddHHmmssSSS");

        String type = orgFileName.substring(orgFileName.lastIndexOf('.') + 1);
        StringBuffer sb = new StringBuffer();
        sb.append(dTime);
        sb.append(".");
        sb.append(type);
        return sb.toString();
    }

    /**
     * <pre>
     * 입력받은 format으로 날짜정보 반환
     * </pre>
     * 
     * @param dateFormat
     * @return
     */
    public static String getCurrentDateTime(String dateFormat) {
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat, Locale.KOREA);
        Date currentTime = new Date();
        String dTime = formatter.format(currentTime);
        return dTime;
    }
}