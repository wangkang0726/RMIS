package com.kunlunrisk.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="T_STANDARD")
public class Standard  {
  @Id
  @GeneratedValue(generator = "custom-id")
  @GenericGenerator(name = "custom-id", strategy = "increment")
  private Integer id;
  @Column
  private Integer year;  //年份
  @Column
  private String area;   //地区
  @Column
  private String name;  //标准名称
  @Column
  private String property;  //项目性质
  @ManyToOne(targetEntity=StandardItem.class)
  private List<StandardItem> Item;

  
  
public List<StandardItem> getItem() {
	return Item;
}

public void setItem(List<StandardItem> item) {
	Item = item;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Integer getYear() {
	return year;
}

public void setYear(Integer year) {
	this.year = year;
}

public String getArea() {
	return area;
}

public void setArea(String area) {
	this.area = area;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getProperty() {
	return property;
}

public void setProperty(String property) {
	this.property = property;
}


  
  
  
}