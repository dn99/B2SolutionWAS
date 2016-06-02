<%@page import="com.b2max.solution.util.StringUtil"%>
<%@page import="com.b2max.solution.data.AppProperties"%>
<%@page import="java.net.URLDecoder"%>
<%@ page contentType="text/html; charset=utf-8"%>
<%
	String siteIdx = request.getParameter("siteIdx");
	String roomID = request.getParameter("roomID");
	String roomName = request.getParameter("roomName");
	String userID = request.getParameter("userID");
	String userName = request.getParameter("userName");
	String userState = request.getParameter("userState");
	String courseIdx = request.getParameter("courseIdx");
	String authKey = request.getParameter("authKey");
	String actionTp = request.getParameter("actionTp");
	
	siteIdx = StringUtil.hasNull(siteIdx) ? null : siteIdx;
	roomID = StringUtil.hasNull(roomID) ? null : roomID;
	roomName = StringUtil.hasNull(roomName) ? null : roomName;
	userID = StringUtil.hasNull(userID) ? null : userID;
	userName = StringUtil.hasNull(userName) ? null : userName;
	userState = StringUtil.hasNull(userState) ? null : userState;
	courseIdx = StringUtil.hasNull(courseIdx) ? null : courseIdx;
	authKey = StringUtil.hasNull(authKey) ? null : authKey;
	actionTp = StringUtil.hasNull(actionTp) ? null : actionTp;
	
	System.out.println( ":: siteIdx : " + siteIdx );		// 도메인 구분
	System.out.println( ":: roomID : " + roomID );
	System.out.println( ":: roomName : " + roomName );
	System.out.println( ":: userID : " + userID );
	System.out.println( ":: userState : " + userState );	// 0: 선생, 1: 학생, 2: 옵저버
	System.out.println( ":: userName : " + userName );
	System.out.println( ":: courseIdx : " + courseIdx );
	System.out.println( ":: authKey : " + authKey );
	System.out.println( ":: actionTp : " + actionTp );		//  0:기존방식, 1:api연동방식
	
	System.out.println(request.getRemoteAddr());
	System.out.println(request.getRequestURL());
	//System.out.println(request.getQueryString());
	
	String remoteIP = request.getRemoteAddr();
	Boolean isAllowIP = AppProperties.hasAllowIP(remoteIP);
	
	System.out.println(":: isAllowIP : " + isAllowIP);
	
// 	if (StringUtil.hasNull(roomName) == false)
// 	{
// 		LMSInfoVO lmsInfoVO = new LMSInfoVO();
// 		lmsInfoVO.setRoomName(roomName);
// 		lmsInfoVO.setUserID(userID);
// 		lmsInfoVO.setUserName(userName);
// 		lmsInfoVO.setTeacherYN(teacherYN);
// 		lmsInfoVO.setCourseIdx(courseIdx);
// 		lmsInfoVO.setAuthKey(authKey);
		
// 		ServletContext servletContext = getServletContext();
// 		WebApplicationContext wac = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		
// 		B2ConfService service = (B2ConfService) wac.getBean("b2confService");
// 		service.setLMSInfoVO(lmsInfoVO);
// 	}
%>
<!DOCTYPE html>
<html>
<head>
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>B2MAX Conference</title>
<script src="AC_OETags.js" type="text/javascript"></script>
<script src="/resources/flex/b2conf/swfobject.js" type="text/javascript"></script>
<script src="/resources/js/b2conf.js" type="text/javascript"></script>
<script type="text/javascript" src="/resources/js/deployJava.js"></script>
<style>
html, body 
{
	 height:100%; 
}

body 
{
	margin: 0px;
	overflow: hidden;
}
</style>
</head>
<body>

	<div id="flashcontent">&nbsp;</div>
	<script type="text/javascript">

		/**
	    // for SWF Object 1.5 use legacy mode:

	    var so = new SWFObject("RightClick.swf", "customRightClick", "560", "420", "9", "#CCCCCC");
	    so.addParam("quality", "high");
		so.addParam("name", "customRightClick");
		so.addParam("id", "customRightClick");
		so.addParam("AllowScriptAccess", "always");
		so.addParam("wmode", "opaque");
		so.addParam("menu", "false");
		so.addVariable("variable1", "value1");
		so.write("flashcontent");
		
	    */
	   	
	    console.log("================");
	    
	    var siteIdx = <%=siteIdx%>;
	    var roomID = <%=roomID%>;
	    var userID = <%=userID%>;
	    var userState = <%=userState%>;
	    var courseIdx = <%=courseIdx%>;
	    var authKey = "<%=authKey%>";
	    var actionTp = <%=actionTp%>;
	    var isAllowIP = <%=isAllowIP%>;
	   
	    var roomName = decodeURI(unescape(<%=roomName%>));
	    var userName = decodeURI(unescape(<%=userName%>));
	    
	    console.log("siteIdx : " + siteIdx);
	    console.log("roomID : " + roomID);
	    console.log("userID : " + userID);
	    console.log("userState : " + userState);
	    console.log("courseIdx : " + courseIdx);
	    console.log("authKey : " + authKey);
	    console.log("actionTp : " + actionTp);
	    console.log("roomName : " + roomName);
	    console.log("userName : " + userName);
	    console.log("isAllowIP : " + isAllowIP);
	    
	    var swfVersionStr = "12.0.0";
	    var xiSwfUrlStr = "/resources/flex/b2conf/playerProductInstall.swf";
	    var flashvars = {
	    		"siteIdx": siteIdx,
	    		"roomID": roomID,
	    		"roomName": roomName,
	    		"userID": userID,
	    		"userName": userName,
	    		"userState": userState,
	    		"courseIdx": courseIdx,
	    		"authKey": authKey,
	    		"actionTp": actionTp,
	    		"isAllowIP": isAllowIP
	    };
	    
	    var attributes = { id: "Conference", name: "Conference" };
	    
	    //if ( flashvars.roomID == null || flashvars.roomID == "" ) flashvars = {};
	    
	    // BUG : wmode: "opaque" 속성을 주면 safari에서 키보드가 동작하지 않는다.
		var params = {
				quality: "high",			
			    menu: "false",
			    AllowScriptAccess: "always",
			    AllowFullScreen: "true",
			    allowFullScreenInteractive: "true"
		};

		console.log("flashvars : " + JSON.stringify(flashvars,null,4));
		console.log("flashvars.actionTp : " + flashvars.actionTp);
	    
		swfobject.embedSWF("/resources/flex/b2conf/ConfWeb.swf", "flashcontent", "100%", "100%", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);

	</script>

</body>
</html>
