package com.nf511.flower.service;

import com.nf511.flower.entity.Message;

import java.util.List;

public interface MessageService {

    List<Message> selectAllMessage(Message message);

    int MessageCount(Message message);

    int insertMessage(Message message);

    Message selectMessage(Message message);

}
