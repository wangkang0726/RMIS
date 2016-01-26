package com.kunlunrisk.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.kunlunrisk.model.ProjectItem;
import com.kunlunrisk.repository.ItemRepository;
import com.kunlunrisk.repository.ProjectItemRepository;
import com.kunlunrisk.repository.ProjectRepository;
import com.kunlunrisk.repository.StandardItemRepository;
import com.kunlunrisk.repository.StandardRepository;

@RestController
@RequestMapping("/projectItems")
public class ProjectItemController {

	@Autowired
	private ProjectItemRepository projectItemRepository;
	@Autowired
	private StandardRepository standardRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private StandardItemRepository standardItemRepository;
	@Autowired
	private ProjectRepository projectRepository;
	
	
	@RequestMapping(method = RequestMethod.GET) 
	public List<ProjectItem> findProjectItems() {
		return projectItemRepository.findAll();
	}
	
	//获得项目核算编辑时的值
	@RequestMapping(value = "/get/{projectId}", method = RequestMethod.GET)
	public ProjectItem findProjectItem(@PathVariable Integer projectId, ModelAndView m) {
		m.addObject("projectId", projectId);
		projectItemRepository.findOne(projectId);
		return projectItemRepository.findOne(projectId) ;
	}
	
	//获得项目核算编辑时的值
	@RequestMapping(value = "/find/{projectId}", method = RequestMethod.GET)
	public List<ProjectItem> findProjectItems(@PathVariable Integer projectId, ModelAndView m) {
		m.addObject("projectId", projectId);
		projectItemRepository.findAll();
		List<ProjectItem> a = new ArrayList<ProjectItem>();
		List<ProjectItem> list  = projectItemRepository.findAll();
		for (ProjectItem projectItem : list) {
			if(projectItem.getProjectId() == projectId){
				a.add(projectItem);
			}
			
		}
		//Collections.sort(a);
		return a ;
	}
	
	
	@RequestMapping(value = "/add/{projectId}", method = RequestMethod.POST)
	public String addProjectItem(@PathVariable Integer projectId, Integer itemId, Double realPrice, Double amount,  Integer standardId, 
			Integer standardItemId, Double length, Double width, Double height, String place, Double reportedLoss ,Double price, String remark ) {
		ProjectItem projectItem = new ProjectItem();
		projectItem.setId(null);
		projectItem.setProjectId(projectId);
		projectItem.setRealPrice(realPrice);
		projectItem.setAmount(amount);
		projectItem.setLength(length);
		projectItem.setWidth(width);
		projectItem.setHeight(height);
		projectItem.setPlace(place);
		projectItem.setPrice(price);
		projectItem.setRemark(remark);
		projectItem.setReportedLoss(reportedLoss);
		projectItem.setStandard(standardRepository.getOne(standardId));
		projectItem.setItem(itemRepository.getOne(itemId));
		projectItem.setStandardItem(standardItemRepository.getOne(standardItemId));
		projectItemRepository.saveAndFlush(projectItem);
		return "success";
	}

	@RequestMapping(value = "/update/{projectId}", method = RequestMethod.POST)
	public String updateProjectItem(@PathVariable Integer projectId, String place, Double length, Double width, Double height,Double amount, 
			Double price,  Double realPrice, String remark, Double reportedLoss,   Integer standardId, Integer itemId, Integer standardItemId) {
		ProjectItem projectItem = projectItemRepository.findOne(projectId);
		projectItem.setPlace(place);
		projectItem.setAmount(amount);
		projectItem.setRealPrice(realPrice);
		projectItem.setLength(length);
		projectItem.setWidth(width);
		projectItem.setHeight(height);
		projectItem.setPrice(price);
		projectItem.setRemark(remark);
		projectItem.setReportedLoss(reportedLoss);
		projectItem.setStandard(standardRepository.getOne(standardId));
		projectItem.setItem(itemRepository.getOne(itemId));
		projectItem.setStandardItem(standardItemRepository.getOne(standardItemId));
		//projectItem.setProjectId(projectId);
		projectItemRepository.saveAndFlush(projectItem);
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProjectItem(@PathVariable Integer id) {
		projectItemRepository.delete(id);
	}

}
