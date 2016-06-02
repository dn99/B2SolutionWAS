package com.b2max.solution.blazeds;

import org.springframework.flex.messaging.MessageTemplate;

import flex.messaging.MessageBroker;
import flex.messaging.messages.AsyncMessage;
import flex.messaging.util.UUIDUtils;

public class BlazedsUtil {
	
	public static void pushAsyncMessage(String destination, Object data, String subtopic) 
	{
		MessageTemplate template = new MessageTemplate();
		
		MessageBroker messageBroker = MessageBroker.getMessageBroker(null);
		template.setMessageBroker(messageBroker);
		
		String clientID = UUIDUtils.createUUID();  
		System.out.println("★★★★ " + clientID );
		AsyncMessage asyncMessage = new AsyncMessage();  
		asyncMessage.setDestination(destination);  
		asyncMessage.setClientId(clientID);
		asyncMessage.setMessageId(UUIDUtils.createUUID());
		asyncMessage.setTimestamp(System.currentTimeMillis());
		if ( subtopic != "" && subtopic != null ) asyncMessage.setHeader(AsyncMessage.SUBTOPIC_HEADER_NAME, subtopic);
		
        asyncMessage.setBody(data);  
        template.getMessageBroker().routeMessageToService(asyncMessage, null);
	}
}
