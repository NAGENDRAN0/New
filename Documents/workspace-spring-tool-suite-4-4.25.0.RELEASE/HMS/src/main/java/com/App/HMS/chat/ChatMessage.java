package com.App.HMS.chat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "chat_messages")
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;
    private String sender;

    @Enumerated(EnumType.STRING)
    private MessageType messagetype;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public MessageType getMessagetype() {
		return messagetype;
	}

	public void setMessagetype(MessageType messagetype) {
		this.messagetype = messagetype;
	}
	// Custom Builder remains
    public static class Builder {
        private String content;
        private String sender;
        private MessageType messagetype;

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder sender(String sender) {
            this.sender = sender;
            return this;
        }

        public Builder messagetype(MessageType messagetype) {
            this.messagetype = messagetype;
            return this;
        }

        public ChatMessage build() {
            return new ChatMessage(content, sender, messagetype);
        }
    }
    public ChatMessage() {
        // Default constructor for Hibernate
    }
    public static Builder builder() {
        return new Builder();
    }
    public ChatMessage(String content, String sender, MessageType messagetype) {
        this.content = content;
        this.sender = sender;
        this.messagetype = messagetype;
    }

	
	}

