package com.springboot.tiffinhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.tiffinhub.model.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer>{
	
}

