package com.kunlunrisk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kunlunrisk.model.StandardItem;
import com.kunlunrisk.repository.ItemRepository;
import com.kunlunrisk.repository.StandardItemRepository;


@RestController
@RequestMapping("/standardItems")
public class StandardItemController {

	@Autowired
	private StandardItemRepository standardItemRepository;
	@Autowired
	private ItemRepository itemRepository;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<StandardItem> findStandardItems(){
		return standardItemRepository.findAll();
	}
	
	
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	public StandardItem findStandardItem(@PathVariable Integer id){
		return standardItemRepository.findOne(id);
	}
	
	@RequestMapping(value = "/add/{standardId}", method = RequestMethod.POST)
	public String addStandardItem(@PathVariable Integer standardId,Integer itemId,Double price){
		StandardItem standardItem = new StandardItem();
		standardItem.setId(null);
		standardItem.setStandardId(standardId);
		standardItem.setItem(itemRepository.getOne(itemId));
		standardItem.setPrice(price);
		//System.out.println("aaaaaaaaa");
		standardItemRepository.saveAndFlush(standardItem);
		return "success";
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
