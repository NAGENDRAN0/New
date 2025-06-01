package com.App.HMS.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.App.HMS.chat.ChatMessage;
import com.App.HMS.repository.chatMessageRepository;

@Controller
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private chatMessageRepository chatMessageRepository;
	
	@Autowired
    private SimpMessagingTemplate messagingTemplate;

	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	public ChatMessage sendmessage(@Payload ChatMessage chatMessage, Principal principal) {
	    chatMessage.setSender(principal.getName());  
	    ChatMessage savedMessage = chatMessageRepository.save(chatMessage);
	    
	    // Broadcast message to all users
	    messagingTemplate.convertAndSend("/topic/public", savedMessage);
	    
	    return savedMessage;
	}

	
	
	@MessageMapping("/chat.adduser")
	@SendTo("/topic/public")
	public ChatMessage adduser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
	    headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
	    
	    // Fetch old messages and send them to the user
	    List<ChatMessage> oldMessages = chatMessageRepository.findAll();
	    for (ChatMessage oldMessage : oldMessages) {
	        messagingTemplate.convertAndSend("/topic/public", oldMessage);
	    }
	    
	    return chatMessage;
	}

	
	 @GetMapping("/history")
	 @ResponseBody
	    public List<ChatMessage> getChatHistory() {
	        return chatMessageRepository.findAll(); // Return stored messages
	    }
	
}
