package com.springboot.tiffinhub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.tiffinhub.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{

	List<Order> findByCustomerName(String name);
	

	@Modifying
	@Query("DELETE FROM Order o WHERE LOWER(o.customerName) = LOWER(:name)")
	void deleteByCustomerName( @Param("name") String name);

}
