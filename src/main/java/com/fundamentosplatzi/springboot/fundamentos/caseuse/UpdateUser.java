package com.fundamentosplatzi.springboot.fundamentos.caseuse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

@Component
public class UpdateUser {
	
	//llamamos a la dependencia o capa userService
	private UserService userService;
	
	
	//inyectamos a partir del constructor
    public UpdateUser(UserService userService) {
		
		this.userService = userService;
	}

    //creamos el metodo update para actualizar la información
	public User update(User newUser1, Long id) {
		//return userService.
		return userService.update(newUser1,id);
	}


	

}
