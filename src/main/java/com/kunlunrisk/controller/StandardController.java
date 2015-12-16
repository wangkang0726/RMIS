package com.kunlunrisk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kunlunrisk.model.Standard;
import com.kunlunrisk.repository.StandardRepository;

@RestController
@RequestMapping("/standards")
public class StandardController {

	@Autowired
	private StandardRepository standardRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Standard> findStandards(){
		return standardRepository.findAll();
	}
	
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	public Standard findStandard(@PathVariable Integer id){
		return standardRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Standard addStandard(@RequestBody Standard standard){
		standard.setId(null);
		return standardRepository.saveAndFlush(standard);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Standard updateStandard(@RequestBody Standard entity, @PathVariable Integer id){
		entity.setId(id);
		return standardRepository.saveAndFlush(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteStandard(@PathVariable Integer id){
		standardRepository.delete(id);
	}
	
}
