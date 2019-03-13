package com.nf511.flower.entity;


public class Cartcheckedlist {

  private long cartCheckedListId;
  private long flowerId;
  private long cartAmount;
  private long orderId;
  private long userId;



  public long getCartCheckedListId() {
    return cartCheckedListId;
  }

  public void setCartCheckedListId(long cartCheckedListId) {
    this.cartCheckedListId = cartCheckedListId;
  }

  public long getFlowerId() {
    return flowerId;
  }

  public void setFlowerId(long flowerId) {
    this.flowerId = flowerId;
  }

  public long getCartAmount() {
    return cartAmount;
  }

  public void setCartAmount(long cartAmount) {
    this.cartAmount = cartAmount;
  }


  public long getOrderId() {
    return orderId;
  }

  public void setOrderId(long orderId) {
    this.orderId = orderId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "Cartcheckedlist{" +
            "cartCheckedListId=" + cartCheckedListId +
            ", flowerId=" + flowerId +
            ", cartAmount=" + cartAmount +
            ", orderId=" + orderId +
            ", userId=" + userId +
            '}';
  }
}
