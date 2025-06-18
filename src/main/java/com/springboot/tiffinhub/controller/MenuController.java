package com.springboot.tiffinhub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.tiffinhub.model.Menu;
import com.springboot.tiffinhub.service.MenuService;

@RestController
@RequestMapping("tiffin")
public class MenuController {
	
	@Autowired
	private MenuService ms;
	
	@GetMapping("getAllMenu")
	public List<Menu> gettingItems(){
		return ms.getItems();
	}
	
	
	@PostMapping("addOneMenu")
	public String addItem(@RequestBody Menu menu){
		ms.adding(menu);
		return "ITEM ADDED SUCCESSFULLY";
	}
	
	@GetMapping("getBy/{id}")
	public Optional<Menu> getById(@PathVariable int id){
		return ms.getById(id);
	}
	
	@PutMapping("updateMenu/{id}")
	public String updateItem(@PathVariable int id ,@RequestBody Menu menu) {
		ms.updateit(id,menu);
		return "ITEM UPDATED SUCCESSFULL";
	}
	
	@DeleteMapping("deleteMenu/{id}")
	public String deleteOne(@PathVariable int id) {
		ms.deleteItem(id);
		return "ITEM DELETED SUCCESSFULLY";
	} 

}
