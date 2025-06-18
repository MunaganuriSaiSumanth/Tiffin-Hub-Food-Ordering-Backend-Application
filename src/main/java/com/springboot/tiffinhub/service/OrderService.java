package com.springboot.tiffinhub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.springboot.tiffinhub.model.Menu;
import com.springboot.tiffinhub.model.Order;
import com.springboot.tiffinhub.repository.MenuRepository;
import com.springboot.tiffinhub.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository or;
	
	@Autowired
	private MenuRepository mr;
	

	public List<Order> getOrders() {
		return or.findAll();
	}


	public void addOrder(Order addorder) {
		List<Menu> addingMenu = new ArrayList<Menu>();
		for(Menu menu : addorder.getMenuItems()) {
			Menu m = mr.findById(menu.getId()).orElseThrow(null);
			addingMenu.add(m);
		}
	    addorder.setMenuItems(addingMenu);
		or.save(addorder);
	}


	public List<Order> getByName(String name) {
		List<Order> order = or.findByCustomerName(name) ;
		return order.isEmpty() ? null : order;
	}


	@Transactional
	public String deleteOrderByCustomerName(String name) {
		List<Order> od =or.findByCustomerName(name);
		if(od.isEmpty()) {
			return "NO CUSTOMER IS FOUND WITH THIS NAME";
		}
		or.deleteByCustomerName(name);
		return "Order Deleted Successfully";
	}

	@Transactional
	public String updateOrder(String name, Order uod) {
		List<Order> od= or.findByCustomerName(name);
		List<Menu> addingMenu = new ArrayList<Menu>();
		or.deleteByCustomerName(name);
		for(Menu menu : uod.getMenuItems()) {
			Menu m = mr.findById(menu.getId()).orElseThrow(null);
			addingMenu.add(m);
		}
	    uod.setMenuItems(addingMenu);
		or.save(uod);
		return "updated successfull";
	}


	
}
