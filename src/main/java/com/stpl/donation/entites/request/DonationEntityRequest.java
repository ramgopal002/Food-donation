package com.stpl.donation.entites.request;

import java.util.Date;

public class DonationEntityRequest {

  private String name;
  private String address;
  private String phone;
  private String foodname;
  private String event;
  private Long foodqty;
  private Date collectiondtime;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getFoodname() {
    return foodname;
  }

  public void setFoodname(String foodname) {
    this.foodname = foodname;
  }

  public String getEvent() {
    return event;
  }

  public void setEvent(String event) {
    this.event = event;
  }

  public Long getFoodqty() {
    return foodqty;
  }

  public void setFoodqty(Long foodqty) {
    this.foodqty = foodqty;
  }

  public Date getCollectiondtime() {
    return collectiondtime;
  }

  public void setCollectiondtime(Date collectiondtime) {
    this.collectiondtime = collectiondtime;
  }


}
