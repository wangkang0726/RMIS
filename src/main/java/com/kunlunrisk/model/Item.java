package com.kunlunrisk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity(name="T_ITEM")
public class Item {
  @Id
  @GeneratedValue(generator = "custom-id")
  @GenericGenerator(name = "custom-id", strategy = "increment")
  private Integer id;
 
  @Column
  private String description;
//@Column
//private String property;
  @Column
  private String NO;//编号
  @Column
  private String name;//项目名称
  @Column
  private Integer parent;//上级项目
  @Column
  private String parentName;//单价单位
  @Column
  private String moneyType;//单价单位
  @Column
  private String numeraire;//记账单位，定价单位

  
  
  
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNO() {
		return NO;
	}
	public void setNO(String nO) {
		NO = nO;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getParent() {
		return parent;
	}
	public void setParent(Integer parent) {
		this.parent = parent;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getMoneyType() {
		return moneyType;
	}
	public void setMoneyType(String moneyType) {
		this.moneyType = moneyType;
	}
	public String getNumeraire() {
		return numeraire;
	}
	public void setNumeraire(String numeraire) {
		this.numeraire = numeraire;
	}
	  
	
  
}
