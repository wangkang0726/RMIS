package com.kunlunrisk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kunlunrisk.model.Model;
import com.kunlunrisk.repository.ModelRepository;

@RestController
@RequestMapping("/models")
public class ModelController {

	@Autowired
	private ModelRepository modelRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Model> findModels(){
		return modelRepository.findAll();
	}
	
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	public Model findModel(@PathVariable Integer id){
		return modelRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Model addModel(@RequestBody Model model){
		model.setId(null);
		return modelRepository.saveAndFlush(model);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Model updateModel(@RequestBody Model entity, @PathVariable Integer id){
		entity.setId(id);
		return modelRepository.saveAndFlush(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteModel(@PathVariable Integer id){
		modelRepository.delete(id);
	}
	
}
