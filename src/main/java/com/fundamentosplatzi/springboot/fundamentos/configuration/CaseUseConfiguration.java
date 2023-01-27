package com.fundamentosplatzi.springboot.fundamentos.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentosplatzi.springboot.fundamentos.caseuse.GetUser;
import com.fundamentosplatzi.springboot.fundamentos.caseuse.GetUserImplement;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

@Configuration
public class CaseUseConfiguration {

	//creacion de un @Bean retornara un GetUser
	@Bean
	GetUser getUser(UserService userService) {//dentro de los parentesis se coloca la implementacion de la dependencia userService
		return new GetUserImplement(userService); //retornamos nuestro caso de uso, que es GetUserImplement y que tiene como parametro (userService)
	}
}
