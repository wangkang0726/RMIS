package com.kunlunrisk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity(name="T_STANDARDITEM")
public class StandardItem {

	  @Id
	  @GeneratedValue(generator = "custom-id")
	  @GenericGenerator(name = "custom-id", strategy = "increment")
	  private Integer id;
	  @Column
	  private Integer itemId;
	  @Column
	  private Double price;  //价格
	  @Column
	  private Long areaId;
	  
	  
	  
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getAreaId() {
		return areaId;
	}
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	  
	  
}
