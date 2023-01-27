package com.fundamentosplatzi.springboot.fundamentos.caseuse;

import java.util.List;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;
import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

public class GetUserImplement implements GetUser{

	//llamamos a la dependencia o capa userService
	private UserService userService;
	
	//inyectamos a partir del constructor
	public GetUserImplement(UserService userService) {// tendremos el parametro UserService userService, ya que esta inyectado por dependencia 
		
		this.userService = userService;
	}
	
	//en este metodo vamos a tener el nombre del objeto de la dependencia o capa que es userService y tendra el metodo que devuelve la lista getAllUsers
	@Override
	public List<User> getAll() {
		
		return userService.getAllUsers() ;// en este metodo nos va a retornar todos los usuarios
	}

	

	
}
