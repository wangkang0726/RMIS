package com.kunlunrisk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
@Entity(name="T_STANDARD_ITEM")
public class StandardItem {

  @Id
  @GeneratedValue(generator = "custom-id")
  @GenericGenerator(name = "custom-id", strategy = "increment")
  private Integer id;
  @Column
  private Integer standardId;
  @Column
  private Double price;  //价格
  @ManyToOne
  private Item item;
  
  
    
  	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStandardId() {
		return standardId;
	}
	public void setStandardId(Integer standardId) {
		this.standardId = standardId;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	  
	  
}
