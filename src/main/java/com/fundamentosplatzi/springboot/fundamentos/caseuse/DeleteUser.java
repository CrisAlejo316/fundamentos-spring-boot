package com.fundamentosplatzi.springboot.fundamentos.caseuse;

import org.springframework.stereotype.Component;

import com.fundamentosplatzi.springboot.fundamentos.service.UserService;

@Component // esta anotación es para hacer algo muy general, en este caso nos conviene porque son casos de uso
public class DeleteUser {

	// llamamos a la dependencia o capa userService
	private UserService userService;

	// inyectamos a partir del constructor
	public DeleteUser(UserService userService) {

		this.userService = userService;
	}

	// se crea el metodo remove, para remover el usuario
	public void remove(Long id) {

		userService.delete(id);// con la depenencia llamamos al metodo delete y que retornara un parametro id

	}

}
