package com.springboot.tiffinhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.springboot.tiffinhub.repository" )
public class TiffinhubApplication {

	public static void main(String[] args) {
		SpringApplication.run(TiffinhubApplication.class, args);
	}

}
