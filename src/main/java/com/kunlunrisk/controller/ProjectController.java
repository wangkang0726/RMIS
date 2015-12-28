package com.kunlunrisk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kunlunrisk.model.Project;
import com.kunlunrisk.model.Standard;
import com.kunlunrisk.repository.ItemRepository;
import com.kunlunrisk.repository.ProjectRepository;
import com.kunlunrisk.repository.StandardRepository;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private StandardRepository standardRepository;
	@Autowired
	@RequestMapping(method = RequestMethod.GET)
	public List<Project> findProjects() {
		return projectRepository.findAll();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Project findProject(@PathVariable Integer id) {
		return projectRepository.findOne(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Project addProject(@RequestBody Project project) {
		project.setId(null);
		Project p = projectRepository.saveAndFlush(project);
		return p;
	}

	@RequestMapping(value = "/getData", method = RequestMethod.GET)
	public List<Standard> getData() {
		List<Standard> list = standardRepository.findAll();
		return list;
	}
	@RequestMapping(value ="/getData/{standardId}", method = RequestMethod.GET)
	public Standard getStandardData(@PathVariable Integer standardId){
		return  standardRepository.findOne(standardId);
	
	}
	
	

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Project updateProject(@RequestBody Project entity, @PathVariable Integer id) {
		entity.setId(id);
		return projectRepository.saveAndFlush(entity);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteProject(@PathVariable Integer id) {
		projectRepository.delete(id);
	}

}
