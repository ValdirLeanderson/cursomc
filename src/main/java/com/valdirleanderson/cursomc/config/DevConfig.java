package com.valdirleanderson.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.valdirleanderson.cursomc.services.DBService;

@Configuration
@Profile("dev")
public class DevConfig {

	@Autowired
	private DBService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public Boolean instantiateDataBase() throws ParseException {
		
		if (!strategy.trim().equals("create")) {
			return false;
		}
		
		dbService.instatiateDataBase();
		return true;
		
	}
}
