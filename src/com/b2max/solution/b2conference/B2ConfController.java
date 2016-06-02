package com.b2max.solution.b2conference;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.b2max.solution.b2conference.service.B2ConfService;

@Controller("b2confController")
@RemotingDestination(channels={"my-amf"})
public class B2ConfController {
	
	private static final Logger logger = LoggerFactory.getLogger(B2ConfController.class);
	
	@Autowired
	private B2ConfService b2confService;
	
	@RequestMapping("/b2conference")	
    public String getIndex(Locale locale, Model model) 
	{
//    	logger.info("Welcome home! The client locale is {}.", locale);
//    	
//    	Date date = new Date();
//    	DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//    	
//    	String formattedDate = dateFormat.format(date);
//    	
//    	model.addAttribute("serverTime", formattedDate );  
    	
//    	return "b2conference/index";
    	return "b2conference/confweb";
    }
	
	@RequestMapping("/b2conference/fileUpload")	
	public String getFileUpload(Locale locale, Model model) 
	{
		return "b2conference/fileUpload";
	}
	
	@RequestMapping("/b2conference/debate")	
    public String getDebate(Locale locale, Model model) 
	{
		return "b2conference/debate";
	}
	
	@RequestMapping("/lms")	
	public String getLms(Locale locale, Model model) 
	{
		return "b2conference/lms";
	}
	
	@RequestMapping("/auth")	
	public String getAuth(Locale locale, Model model) 
	{
		return "b2conference/auth";
	}
	
	@RequestMapping("/edu")	
	public String getEdu(Locale locale, Model model) 
	{
		return "b2conference/edu";
	}
	
	@RequestMapping("/conf")	
	public String getConf(Locale locale, Model model) 
	{
		return "b2conference/conf";
	}
	
	@RequestMapping("/test")	
	public String getTest(Locale locale, Model model) 
	{
		return "b2conference/test";
	}
}
