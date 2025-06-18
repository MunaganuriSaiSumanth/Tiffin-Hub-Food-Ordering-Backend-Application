package com.springboot.tiffinhub.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "CustomerOrders")
public class Order {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int orderId;
	
	@Column(name="customer_name")
	private String customerName;
	
	@ManyToMany
	@JoinTable(
	  name = "Order_Menu",
	  joinColumns = @JoinColumn(name= "Order_Id"),
	  inverseJoinColumns = @JoinColumn(name = "Menu_Id")
			)
	private List<Menu>  menuItems;
	
	

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Menu> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<Menu> menuItems) {
		this.menuItems = menuItems;
	}

	
	

}
 