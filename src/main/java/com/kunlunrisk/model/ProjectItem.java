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
	private Double amount; // 损失数量
	// @Column
	// private Double reportedLoss; // 报损金额
	@Column
	private Double realPrice; // 实际损失金额
	@Column
	private String place; // 地点（桩号）
	@Column
	private Double length; // 长
	@Column
	private Double width; // 宽
	@Column
	private Double height; // 高
	@Column
	private Double price; // 标准单价
	@Column
	private String remark; // 备注

	@ManyToOne
	private Standard standard;
	@ManyToOne
	private Item item;
	@ManyToOne
	private StandardItem standardItem;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public StandardItem getStandardItem() {
		return standardItem;
	}

	public void setStandardItem(StandardItem standardItem) {
		this.standardItem = standardItem;
	}

}
