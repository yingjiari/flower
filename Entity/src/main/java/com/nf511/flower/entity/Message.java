package com.nf511.flower.entity;


import java.util.List;

public class Message {

  private long messageId;
  private long senderId;
  private long recipientId;
  private long stateId;

  private List<Messagecontent> messagecontentList;
  private User user;



  public long getMessageId() {
    return messageId;
  }

  public void setMessageId(long messageId) {
    this.messageId = messageId;
  }


  public long getSenderId() {
    return senderId;
  }

  public void setSenderId(long senderId) {
    this.senderId = senderId;
  }


  public long getRecipientId() {
    return recipientId;
  }

  public void setRecipientId(long recipientId) {
    this.recipientId = recipientId;
  }

  public List<Messagecontent> getMessagecontentList() {
    return messagecontentList;
  }

  public void setMessagecontentList(List<Messagecontent> messagecontentList) {
    this.messagecontentList = messagecontentList;
  }

  public long getStateId() {
    return stateId;
  }

  public void setStateId(long stateId) {
    this.stateId = stateId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Message{" +
            "messageId=" + messageId +
            ", senderId=" + senderId +
            ", recipientId=" + recipientId +
            ", stateId=" + stateId +
            ", messagecontentList=" + messagecontentList +
            ", user=" + user +
            '}';
  }
}
