package com.kunlunrisk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kunlunrisk.model.ProjectItem;
import com.kunlunrisk.repository.ItemRepository;
import com.kunlunrisk.repository.ProjectItemRepository;

@RestController
@RequestMapping("/projectItems")
public class ProjectItemController {

	@Autowired
	private ProjectItemRepository projectItemRepository;
	@Autowired
	private ItemRepository itemRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<ProjectItem> findProjectItems() {
		return projectItemRepository.findAll();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ProjectItem findProjectItem(@PathVariable Integer id) {
		return projectItemRepository.findOne(id);
	}

	@RequestMapping(value = "/add/{projectId}", method = RequestMethod.POST)
	public String addProjectItem(@PathVariable Integer projectId, Integer itemId, Double price) {
		ProjectItem projectItem = new ProjectItem();
		projectItem.setId(null);
		projectItem.setProjectId(projectId);
		projectItem.setPrice(price);
		projectItemRepository.saveAndFlush(projectItem);
		return "success";
	}

	@RequestMapping(value = "/update/{productId}", method = RequestMethod.POST)
	public String updateProjectItem(@PathVariable Integer projectId, Integer id, Double price) {
		ProjectItem projectItem = projectItemRepository.findOne(id);
		projectItem.setPrice(price);
		projectItemRepository.saveAndFlush(projectItem);
		return "success";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProjectItem(@PathVariable Integer id) {
		projectItemRepository.delete(id);
	}

}
