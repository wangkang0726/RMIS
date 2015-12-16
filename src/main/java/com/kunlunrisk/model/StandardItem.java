package com.kunlunrisk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
@Entity(name="T_STANDARD_ITEM")
public class StandardItem {

	  @Id
	  @GeneratedValue(generator = "custom-id")
	  @GenericGenerator(name = "custom-id", strategy = "increment")
	  private Integer id;
	  @Column
	  private Integer standardId;
	  
	  public Integer getStandardId() {
		return standardId;
	}
	public void setStandardId(Integer standardId) {
		this.standardId = standardId;
	}
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
