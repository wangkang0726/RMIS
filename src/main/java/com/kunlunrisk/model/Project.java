package com.kunlunrisk.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity(name = "R_PROJECT")
public class Project {
	@Id
	@GeneratedValue(generator = "custom-id")
	@GenericGenerator(name = "custom-id", strategy = "increment")
	private Integer id;
	@Column
	private String name; // 公估项目名称
	@DateTimeFormat
	private Date accountDate; // 核算日期
	@Column
	private String userName; // 核算人员
	@Column
	private Double expectTotal; // 核算损失金额
	@Column
	private Double realTotal; // 实际损失金额

	@OneToMany(targetEntity = ProjectItem.class, mappedBy = "projectId", fetch = FetchType.LAZY)
	private List<ProjectItem> projectItem;

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


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Date getAccountDate() {
		return accountDate;
	}

	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}


	public List<ProjectItem> getProjectItem() {
		return projectItem;
	}

	public void setProjectItem(List<ProjectItem> projectItem) {
		this.projectItem = projectItem;
	}

	public Double getExpectTotal() {
		return expectTotal;
	}

	public void setExpectTotal(Double expectTotal) {
		this.expectTotal = expectTotal;
	}

	public Double getRealTotal() {
		return realTotal;
	}

	public void setRealTotal(Double realTotal) {
		this.realTotal = realTotal;
	}



}
