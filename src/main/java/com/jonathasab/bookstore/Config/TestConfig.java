package com.jonathasab.bookstore.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jonathasab.bookstore.service.DBService;

@Configuration
@Profile("test")
public class TestConfig {

	@Autowired
	DBService dBService;
	
	@Bean
	public void InstanciaBaseDeDados()
	{
		dBService.InstanciaBaseDeDados();
	}
}
