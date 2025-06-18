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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.tiffinhub.model.Menu;
import com.springboot.tiffinhub.model.Order;
import com.springboot.tiffinhub.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderService os;
	
	@GetMapping("getAllOrders")
	public List<Order> getOrders() {
		return os.getOrders();
	}
	
	@PostMapping("addOneOrder")
	public String addOrderItem(@RequestBody Order addorder) {
		os.addOrder(addorder);
		return "Successfully order is added";
	}
	
	@GetMapping("getBy/{name}")
	public List<Order> getById(@PathVariable String name ) {
		return os.getByName(name);
	}
	
	@DeleteMapping("deleteOrder/{name}")
	public String deleteOneOrder(@PathVariable String name) {
		String result = os.deleteOrderByCustomerName(name);
		return result;
	}
	
	@PutMapping("updateOrder/{name}")
	public String updateOneOrder(@PathVariable String name, @RequestBody Order uod) {
		String res = os.updateOrder(name,uod);
		return res;
	}
}

