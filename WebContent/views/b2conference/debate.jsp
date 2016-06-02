<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>  
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>${serverTime}</title>
<!-- <title>B2MAX DebateReport</title> -->

<style type="text/css" media="screen">
html {
  height: 100%;
  overflow: hidden; /* Hides scrollbar in IE */
}
 
body {
  height: 100%;
  margin: 0;
  padding: 0;
}
 
#flashcontent {
  height: 100%;
}
</style>

<script type="text/javascript" src="/resources/flex/b2conference/swfobject.js"></script>
<script type="text/javascript" src="/resources/js/flexiframe.js"></script>
<script type="text/javascript" src="/resources/js/rightClick.js"></script>
<script type="text/javascript" src="/resources/js/b2conference.js"></script>
<script type="text/javascript">
	var x = 100;
	var y = 100;
	var w = 440;
	var h = 550;
</script>
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
	   
	    var swfVersionStr = "12.0.0";
	    var xiSwfUrlStr = "/resources/flex/b2conference/playerProductInstall.swf";
	    var flashvars = {};
	    
		var params = {
		  wmode: "opaque",
		  menu: "false",
		  AllowScriptAccess: "always"
		};

		var attributes = {
		  id: "customRightClick",
		  name: "customRightClick"
		};
	
		swfobject.embedSWF("/resources/flex/b2conference/DebateReport.swf", "flashcontent", "100%", '100%', swfVersionStr, xiSwfUrlStr, flashvars, params, attributes);

	</script>

</body>
</html>