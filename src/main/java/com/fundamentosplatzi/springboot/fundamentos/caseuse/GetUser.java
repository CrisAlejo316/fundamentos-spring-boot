package com.fundamentosplatzi.springboot.fundamentos.caseuse;

import java.util.List;

import com.fundamentosplatzi.springboot.fundamentos.entity.User;

public interface GetUser {

	//esta interfaz va a retribuir la lista de los usuarios
	List<User> getAll(); //se crea una lista con la entidad User y se le asigna un nombre que es getAll
}
