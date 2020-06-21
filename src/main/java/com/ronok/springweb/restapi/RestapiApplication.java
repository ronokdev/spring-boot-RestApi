package com.ronok.springweb.restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
//This will exclue the auto configuration of the 'DataSourceAutoConfiguration.class' on application startup
//@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class RestapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestapiApplication.class, args);
	}

}
