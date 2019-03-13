package com.nf511.flower.entity;


public class Messagecontent {

  private long messageContentId;
  private String messageContent;
  private String messageContentDate;
  private long messageId;
  private long stateId;

  private Message message;
  private User user;


  public long getMessageContentId() {
    return messageContentId;
  }

  public void setMessageContentId(long messageContentId) {
    this.messageContentId = messageContentId;
  }


  public String getMessageContent() {
    return messageContent;
  }

  public void setMessageContent(String messageContent) {
    this.messageContent = messageContent;
  }

  public String getMessageContentDate() {
    return messageContentDate;
  }

  public void setMessageContentDate(String messageContentDate) {
    this.messageContentDate = messageContentDate;
  }

  public long getMessageId() {
    return messageId;
  }

  public void setMessageId(long messageId) {
    this.messageId = messageId;
  }


  public long getStateId() {
    return stateId;
  }

  public void setStateId(long stateId) {
    this.stateId = stateId;
  }

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "Messagecontent{" +
            "messageContentId=" + messageContentId +
            ", messageContent='" + messageContent + '\'' +
            ", messageContentDate='" + messageContentDate + '\'' +
            ", messageId=" + messageId +
            ", stateId=" + stateId +
            ", message=" + message +
            ", user=" + user +
            '}';
  }
}
