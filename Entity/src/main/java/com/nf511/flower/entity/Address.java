package com.nf511.flower.entity;


public class Address {

  private long addressId;
  private long userId;
  private String consigneeName;
  private String consigneePhone;
  private String address;
  private String detailedAddress;
  private long stateId;

  private State state;


  public long getAddressId() {
    return addressId;
  }

  public void setAddressId(long addressId) {
    this.addressId = addressId;
  }


  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }


  public String getConsigneeName() {
    return consigneeName;
  }

  public void setConsigneeName(String consigneeName) {
    this.consigneeName = consigneeName;
  }


  public String getConsigneePhone() {
    return consigneePhone;
  }

  public void setConsigneePhone(String consigneePhone) {
    this.consigneePhone = consigneePhone;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getDetailedAddress() {
    return detailedAddress;
  }

  public void setDetailedAddress(String detailedAddress) {
    this.detailedAddress = detailedAddress;
  }

  public long getStateId() {
    return stateId;
  }

  public void setStateId(long stateId) {
    this.stateId = stateId;
  }

  public State getState() {
    return state;
  }

  public void setState(State state) {
    this.state = state;
  }

  @Override
  public String toString() {
    return "Address{" +
            "addressId=" + addressId +
            ", userId=" + userId +
            ", consigneeName='" + consigneeName + '\'' +
            ", consigneePhone='" + consigneePhone + '\'' +
            ", address='" + address + '\'' +
            ", detailedAddress='" + detailedAddress + '\'' +
            ", stateId=" + stateId +
            ", state=" + state +
            '}';
  }
}
