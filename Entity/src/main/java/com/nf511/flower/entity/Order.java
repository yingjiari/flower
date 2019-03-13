package com.nf511.flower.entity;


import java.util.List;

public class Order {

  private long orderId;
  private double orderPrice;
  private long orderState;
  private String orderDate;
  private String orderConsigneeName;
  private String orderConsigneePhone;
  private String orderAddress;
  private String orderDetailedAddress;
  private String orderDeliveryTime;
  private String orderDeliveryTimeFrame;
  private String orderBuyerName;
  private String orderBuyerPhone;
  private String orderMailbox;
  private String orderGreetingMessage;
  private long userId;

  private int skip;
  private int size;

  private List<Orderflower> orderflowerList;
  private Flower flower;
  private User user;
  private State state;


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public double getOrderPrice() {
    return orderPrice;
  }

  public void setOrderPrice(double orderPrice) {
    this.orderPrice = orderPrice;
  }


  public long getOrderState() {
    return orderState;
  }

  public void setOrderState(long orderState) {
    this.orderState = orderState;
  }


  public String getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(String orderDate) {
    this.orderDate = orderDate;
  }


  public String getOrderConsigneeName() {
    return orderConsigneeName;
  }

  public void setOrderConsigneeName(String orderConsigneeName) {
    this.orderConsigneeName = orderConsigneeName;
  }


  public String getOrderConsigneePhone() {
    return orderConsigneePhone;
  }

  public void setOrderConsigneePhone(String orderConsigneePhone) {
    this.orderConsigneePhone = orderConsigneePhone;
  }


  public String getOrderAddress() {
    return orderAddress;
  }

  public void setOrderAddress(String orderAddress) {
    this.orderAddress = orderAddress;
  }


  public String getOrderDetailedAddress() {
    return orderDetailedAddress;
  }

  public void setOrderDetailedAddress(String orderDetailedAddress) {
    this.orderDetailedAddress = orderDetailedAddress;
  }


  public String getOrderDeliveryTime() {
    return orderDeliveryTime;
  }

  public void setOrderDeliveryTime(String orderDeliveryTime) {
    this.orderDeliveryTime = orderDeliveryTime;
  }


  public String getOrderBuyerName() {
    return orderBuyerName;
  }

  public void setOrderBuyerName(String orderBuyerName) {
    this.orderBuyerName = orderBuyerName;
  }


  public String getOrderBuyerPhone() {
    return orderBuyerPhone;
  }

  public void setOrderBuyerPhone(String orderBuyerPhone) {
    this.orderBuyerPhone = orderBuyerPhone;
  }


  public String getOrderGreetingMessage() {
    return orderGreetingMessage;
  }

  public void setOrderGreetingMessage(String orderGreetingMessage) {
    this.orderGreetingMessage = orderGreetingMessage;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getOrderDeliveryTimeFrame() {
    return orderDeliveryTimeFrame;
  }

  public void setOrderDeliveryTimeFrame(String orderDeliveryTimeFrame) {
    this.orderDeliveryTimeFrame = orderDeliveryTimeFrame;
  }

  public String getOrderMailbox() {
    return orderMailbox;
  }

  public void setOrderMailbox(String orderMailbox) {
    this.orderMailbox = orderMailbox;
  }

  public int getSkip() {
    return skip;
  }

  public void setSkip(int skip) {
    this.skip = skip;
  }

  public int getSize() {
    return size;
  }

  public void setSize(int size) {
    this.size = size;
  }

  public List<Orderflower> getOrderflowerList() {
    return orderflowerList;
  }

  public void setOrderflowerList(List<Orderflower> orderflowerList) {
    this.orderflowerList = orderflowerList;
  }

  public Flower getFlower() {
    return flower;
  }

  public void setFlower(Flower flower) {
    this.flower = flower;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "Order{" +
            "orderId=" + orderId +
            ", orderPrice=" + orderPrice +
            ", orderState=" + orderState +
            ", orderDate='" + orderDate + '\'' +
            ", orderConsigneeName='" + orderConsigneeName + '\'' +
            ", orderConsigneePhone='" + orderConsigneePhone + '\'' +
            ", orderAddress='" + orderAddress + '\'' +
            ", orderDetailedAddress='" + orderDetailedAddress + '\'' +
            ", orderDeliveryTime='" + orderDeliveryTime + '\'' +
            ", orderDeliveryTimeFrame='" + orderDeliveryTimeFrame + '\'' +
            ", orderBuyerName='" + orderBuyerName + '\'' +
            ", orderBuyerPhone='" + orderBuyerPhone + '\'' +
            ", orderMailbox='" + orderMailbox + '\'' +
            ", orderGreetingMessage='" + orderGreetingMessage + '\'' +
            ", userId=" + userId +
            ", skip=" + skip +
            ", size=" + size +
            ", orderflowerList=" + orderflowerList +
            ", flower=" + flower +
            ", user=" + user +
            ", state=" + state +
            '}';
  }
}
