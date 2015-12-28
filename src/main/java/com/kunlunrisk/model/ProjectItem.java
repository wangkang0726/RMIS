package com.kunlunrisk.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "R_PROJECT_ITEM")
public class ProjectItem {

	@Id
	@GeneratedValue(generator = "custom-id")
	@GenericGenerator(name = "custom-id", strategy = "increment")
	private Integer id;
	@Column
	private Integer projectId;
	@Column
	private Double price; // 价格
	@Column
	private Double amount; // 损失数量
	@Column
	private Double realPrice; // 实际损失金额
	@Column
	private Double expectPrice; // 核算损失金额
	@ManyToOne
	private Standard standard;

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

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getRealPrice() {
		return realPrice;
	}

	public void setRealPrice(Double realPrice) {
		this.realPrice = realPrice;
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public Double getExpectPrice() {
		return expectPrice;
	}

	public void setExpectPrice(Double expectPrice) {
		this.expectPrice = expectPrice;
	}


	

}
