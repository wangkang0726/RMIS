package com.kunlunrisk.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity(name="T_MODEL")
public class Model {
  @Id
  @GeneratedValue(generator = "custom-id")
  @GenericGenerator(name = "custom-id", strategy = "increment")
  private Integer id;
  @Column
  private String name;
  @Column
  private Date date1;
  @Column
  private String expectPrice;
  @Column
  private String realPrice;
  @Column
  private String accountName;
  
  
public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


public Date getDate1() {
	return date1;
}

public void setDate1(Date date1) {
	this.date1 = date1;
}

public String getExpectPrice() {
	return expectPrice;
}

public void setExpectPrice(String expectPrice) {
	this.expectPrice = expectPrice;
}

public String getRealPrice() {
	return realPrice;
}

public void setRealPrice(String realPrice) {
	this.realPrice = realPrice;
}

public String getAccountName() {
	return accountName;
}

public void setAccountName(String accountName) {
	this.accountName = accountName;
}
  
  
}
