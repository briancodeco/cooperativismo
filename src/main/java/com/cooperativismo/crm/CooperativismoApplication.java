package com.cooperativismo.crm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.web.config.EnableSpringDataWebSupport;



@SpringBootApplication
public class CooperativismoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CooperativismoApplication.class, args);
	}

}
