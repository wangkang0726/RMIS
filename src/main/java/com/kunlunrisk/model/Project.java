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

@Entity(name = "R_PROJECT")
public class Project {
	@Id
	@GeneratedValue(generator = "custom-id")
	@GenericGenerator(name = "custom-id", strategy = "increment")
	private Integer id;
	@Column
	private String name; // 公估项目名称
	@Column
	private Date accountDate; // 核算日期
	@Column
	private String userName; // 核算人员

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



}
