package com.App.HMS.config;

import java.awt.TrayIcon.MessageType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.App.HMS.chat.ChatMessage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class WebSocketEventListener {
	
//	@Autowired
//	private ChatMessage chatMessage;
	
	 private static final Logger log = LoggerFactory.getLogger(WebSocketEventListener.class);

	    private final SimpMessageSendingOperations messageTemplate;

	    @Autowired 
	    public WebSocketEventListener(SimpMessageSendingOperations messageTemplate) {
	        this.messageTemplate = messageTemplate;
	    }

	@EventListener
	private void handleWebSocketDisconnect(SessionDisconnectEvent event) {
		StompHeaderAccessor headerAccessor=StompHeaderAccessor.wrap(event.getMessage());
		String username=(String) headerAccessor.getSessionAttributes().get("username");
		
		if (username!=null) {
			log.info("User {} disconnected", username);
			var chatMessage = ChatMessage.builder()
				    .sender("System")  
				    .content("User has left the chat") 
				    .messagetype(com.App.HMS.chat.MessageType.LEAVE)
				    .build();

				messageTemplate.convertAndSend("/topic/public", chatMessage);

		}

	}

}
