package com.fundamentosplatzi.springboot.fundamentos.caseuse;

import org.springframework.stereotype.Component;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

@Component // esta anotación es para hacer algo muy general, en este caso nos conviene porque son casos de uso
public class CreateUser {

	//llamamos a la dependencia o capa userService
		private UserService userService;

    //inyectamos a partir del constructor
	public CreateUser(UserService userService) {
		
		this.userService = userService;
	}

	//se crea un metodo tipo save para registrar la información este metodo returna un parametro newUser1 
	public User save(User newUser1) {
		
		return userService.save(newUser1);
	}

	
		
}
