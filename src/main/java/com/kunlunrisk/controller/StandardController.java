package com.kunlunrisk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kunlunrisk.model.Item;
import com.kunlunrisk.model.Standard;
import com.kunlunrisk.model.StandardItem;
import com.kunlunrisk.repository.ItemRepository;
import com.kunlunrisk.repository.StandardRepository;

@RestController
@RequestMapping("/standards")
public class StandardController {

	@Autowired
	private StandardRepository standardRepository;
	@Autowired
	private ItemRepository itemRepository;

	@RequestMapping(method = RequestMethod.GET)
	public List<Standard> findStandards() {
		return standardRepository.findAll();
	}

	@RequestMapping(value = "/get/items/{id}", method = RequestMethod.GET)
	public List<StandardItem> findItems(@PathVariable Integer id) {
		return standardRepository.findOne(id).getItem();
	}

	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Standard findStandard(@PathVariable Integer id) {
		return standardRepository.findOne(id);
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Standard addStandard(@RequestBody Standard standard) {
		standard.setId(null);
		Standard s = standardRepository.saveAndFlush(standard);
		return s;
	}

	@RequestMapping(value = "/getItemData", method = RequestMethod.GET)
	public List<Item> getItemData() {
		List<Item> list = itemRepository.findAll();
		return list;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Standard updateStandard(@RequestBody Standard entity, @PathVariable Integer id) {
		entity.setId(id);
		return standardRepository.saveAndFlush(entity);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteStandard(@PathVariable Integer id) {
		standardRepository.delete(id);
	}

}
