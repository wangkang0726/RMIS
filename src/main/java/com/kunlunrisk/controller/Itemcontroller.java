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
import com.kunlunrisk.repository.ItemRepository;
import com.mathworks.mps.client.MWClient;
import com.mathworks.mps.client.MWHttpClient;
import com.mathworks.mps.client.MWInvokable;

@RestController
@RequestMapping("/items")
public class Itemcontroller {
	@Autowired
	private ItemRepository itemRepository;
//	private SimpleJpaRepository<Item, Integer> itemRepository =new SimpleJpaRepository<Item,Integer>();
	

	@RequestMapping(method = RequestMethod.GET)
	public List<Item> findItems(){
		return itemRepository.findAll();
	}
	
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	public Item findItem(@PathVariable Integer id){
		return itemRepository.findOne(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Item addItem(@RequestBody Item item){
		item.setId(null);
		return itemRepository.saveAndFlush(item);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Item updateItem(@RequestBody Item entity, @PathVariable Integer id){
		entity.setId(id);
		return itemRepository.saveAndFlush(entity);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteItem(@PathVariable Integer id){
		itemRepository.delete(id);
	}
	
	public void cal(){
		double[] myRange = new double[]{2,5,7,100,0.5};
		MWClient myClient = new MWHttpClient();

		URL archiveURL;
		try {
			archiveURL = new URL("http://192.168.162.128:9910/c1c");
			MWInvokable myProxy =  myClient.createComponentProxy(archiveURL);
			
			String result = myProxy.invoke("c1c",String.class,"9.1");
//			double myMin = ((Double) myLimits[0]).doubleValue(); 
//			double myMax = ((Double) myLimits[1]).doubleValue();
//			System.out.printf(result[0] +"\n"+ result[1]);
		} catch (Throwable e) {
			e.printStackTrace();
		} finally{
			myClient.close();
		}
	}
	
}
