package com.kunlunrisk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kunlunrisk.model.StandardItem;
import com.kunlunrisk.repository.StandardItemRepository;


@RestController
@RequestMapping("/standardItems")
public class StandardItemController {

	@Autowired
	private StandardItemRepository standardItemRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<StandardItem> findStandardItems(){
		return standardItemRepository.findAll();
	}
	
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	public StandardItem findStandardItem(@PathVariable Integer id){
		return standardItemRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public StandardItem addStandardItem(@RequestBody StandardItem standardItem){
		standardItem.setId(null);
		return standardItemRepository.saveAndFlush(standardItem);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public StandardItem updateStandardItem(@RequestBody StandardItem entity, @PathVariable Integer id){
		entity.setId(id);
		return standardItemRepository.saveAndFlush(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteStandardItem(@PathVariable Integer id){
		standardItemRepository.delete(id);
	}
	
}
