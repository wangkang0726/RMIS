package com.kunlunrisk.controller;

import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kunlunrisk.model.Item;
import com.kunlunrisk.model.Menu;
import com.kunlunrisk.repository.MenuRepository;
import com.mathworks.mps.client.MWClient;
import com.mathworks.mps.client.MWHttpClient;
import com.mathworks.mps.client.MWInvokable;

@RestController
@RequestMapping("/menus")
public class MenuController {
	@Autowired
	private MenuRepository menuRepository;
//	private SimpleJpaRepository<Item, Integer> itemRepository =new SimpleJpaRepository<Item,Integer>();
	

	@RequestMapping(method = RequestMethod.GET)
	public List<Menu> findItems(){
		return menuRepository.findAll();
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Menu addMenu(@RequestBody Menu menu){
		menu.setId(null);
		return menuRepository.saveAndFlush(menu);
	}
	
	
}
