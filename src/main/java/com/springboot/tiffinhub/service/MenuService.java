package com.springboot.tiffinhub.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.tiffinhub.model.Menu;
import com.springboot.tiffinhub.repository.MenuRepository;



@Service
public class MenuService {
	
	@Autowired
	private MenuRepository mr;

	public List<Menu> getItems() {
		
		return mr.findAll();
	}

	public void adding(Menu menu) {
		mr.save(menu);	
	}

	public void upadting(Menu menu) {
		mr.save(menu);
		
	}

	public Optional<Menu> getById(int id) {
		return mr.findById(id) ;
	}

	public void updateit(int id, Menu menu) {
		Menu menu1 = mr.findById(id).orElseThrow();
		menu1.setId(menu.getId());
		menu1.setItem(menu.getItem());
		menu1.setPrice(menu.getPrice());
		menu1.setDiscription(menu.getDiscription());
		
		mr.save(menu1);
		
	}

	public void deleteItem(int id) {
		mr.deleteById(id);
		
	}
		

}
