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
	
	System.out.println( ":: siteIdx : " + siteIdx );		// 도메인 구분
	System.out.println( ":: roomID : " + roomID );
	System.out.println( ":: roomName : " + roomName );
	System.out.println( ":: userID : " + userID );
	System.out.println( ":: userState : " + userState );	// 0: 선생, 1: 학생, 2: 옵저버
	System.out.println( ":: userName : " + userName );
	System.out.println( ":: courseIdx : " + courseIdx );
	System.out.println( ":: authKey : " + authKey );
	
	System.out.println(request.getRequestURL());
	System.out.println(request.getQueryString());
	
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
<script type="text/javascript" src="/resources/flex/b2conference/swfobject.js"></script>
<script type="text/javascript" src="/resources/js/b2conference.js"></script>
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
	   	
	    var roomName = decodeURI(unescape(<%=roomName%>));
	    var userName = decodeURI(unescape(<%=userName%>));
	    
	    var swfVersionStr = "12.0.0";
	    var xiSwfUrlStr = "/resources/flex/b2conference/playerProductInstall.swf";
	    var flashvars = {
	    		siteIdx: <%=siteIdx%>,
	    		roomID: <%=roomID%>,
	    		roomName: roomName,
	    		userID: <%=userID%>,
	    		userName: userName,
	    		userState: <%=userState%>,
	    		courseIdx: <%=courseIdx%>,
	    		authKey: <%=authKey%>
	    };
	    
	    var attributes = { id: "Conference", name: "Conference" };
	    
	    if ( flashvars.roomID == null || flashvars.roomID == "" ) flashvars = {};
	    
		var params = {
				quality: "high",
			    wmode: "opaque",
			    menu: "false",
			    AllowScriptAccess: "always",
			    AllowFullScreen: "true",
			    allowFullScreenInteractive: "true"
		};
	
		swfobject.embedSWF("/resources/flex/b2conference/Conference.swf", "flashcontent", "100%", "100%", swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);
		
		
	</script>
</body>
</html>
