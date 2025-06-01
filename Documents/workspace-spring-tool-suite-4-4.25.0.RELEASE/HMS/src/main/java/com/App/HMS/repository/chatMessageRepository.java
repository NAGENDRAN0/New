package com.App.HMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.App.HMS.chat.ChatMessage;

@Repository
public interface chatMessageRepository extends JpaRepository<ChatMessage, Long> {
    List<ChatMessage> findTop20ByOrderByIdAsc(); // Fetch last 20 messages
}
