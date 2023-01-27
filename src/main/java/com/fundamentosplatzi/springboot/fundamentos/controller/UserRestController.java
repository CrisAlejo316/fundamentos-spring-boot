package com.fundamentosplatzi.springboot.fundamentos.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fundamentosplatzi.springboot.fundamentos.caseuse.CreateUser;
import com.fundamentosplatzi.springboot.fundamentos.caseuse.DeleteUser;
import com.fundamentosplatzi.springboot.fundamentos.caseuse.GetUser;
import com.fundamentosplatzi.springboot.fundamentos.caseuse.UpdateUser;
import com.fundamentosplatzi.springboot.fundamentos.entity.User;

@RestController //esta anotación hereda de la anotación @controller y a su vez nos permite que todos los metodos que se creen aca se formateen con el formato JSON
@RequestMapping("/api/usuarios") // Con esta anotación sera la que contendra por medio de los parentesis y las comillas dobles la ruta por donde sera consumido este servicio 
public class UserRestController {// esta clase estaran creados todos los servicios REST que van hacer consumidos por un cliente

	//crear una capa con los servicios que vamos a desplegar
	/*SERVICIOS:
	 * create 
	 * get
	 * update
	 * delete
	 * */
	
	// llamamos para inyectar por dependencia
	private GetUser getUser;
	// llamamos a nuesto caso de uso
	private CreateUser createUser;
	// llamamos a nuesto caso de uso
	private DeleteUser deleteUser;
	// llamamos a nuesto caso de uso
	private UpdateUser updateUser;
	
	//inyectamos por constructor
	public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser) {
		
		this.getUser = getUser;
		this.createUser = createUser;
		this.deleteUser = deleteUser;
		this.updateUser= updateUser;
	}
	
	@GetMapping("/")//a nivel de este metodo se indica por donde sera consumido a nivel de HTTP, el consumo es anotado por @GetMapping, la barra / que esta dentro del parametro osea dentro de las comillas dobles, es la que mostrara todos los usarios de ese metodo List y para que los muestre debe primero el cliente consumir este servicio por medio de esta ruta("/api/usuarios")  
	
	//creamos un metodo que nos devuelve o retorna una lista de todos los usuarios
	List<User>get(){
	
		//llamamos a nuestra dependencia getUser y a nuestro metodo getAll 
		return getUser.getAll();
	}

	
	// se crea el metodo post, este metodo es para crear los usuarios
	@PostMapping("/")
	ResponseEntity<User> newUser(@RequestBody User newUser1){// se crea un metodo y dentro de los <> se responde la entidad que es User, el @RequestBody es para tener un cuerpo de entrada osea, cuando se consuma este servicio va a venir un cuerpo y ese cuerpo se va a obtener dentro de una variable y esa variable sera de tipo User y a ese tipo de variable se le coloca un nombre sera newUser1
		
		return new ResponseEntity<>(createUser.save(newUser1),HttpStatus.CREATED);// retornamos un save y enviaremos el nuevo parametro que es newUser1, CREATED es un enum y nos devuelve un 201 y que se creo correctamente
	}

	//se creara el metodo Delete, este metodo es para eliminar los usuarios
	@DeleteMapping("/{id}")// se programara el path que sera en este caso por el id y es por donde sera consumido este servicio y tambien se eliminara por el id
	ResponseEntity<User> deleteUser(@PathVariable Long id){//Este entity sera vacio y tendra un nombre que es deleteUSer, el id se mapea con la variable @PathVariable y sera de tipo Long, el id debe ser el mismo del path 
		
		deleteUser.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); //retornamos un NO_CONTENT y es que no vamos a responder nada , solo se responde un status, no se tiene un contenido a nivel de respuesta del servicio, se responde un 204 
	}
	
	//se creara el metodo update y sera consumido con el metodo put, este metodo es para actualizar
	@PutMapping("/{id}")
	ResponseEntity<User> replaceUser(@RequestBody User newUser1, @PathVariable Long id){ // se crea un metodo y dentro de los <> se responde la entidad que es User y tendra como nombre replaceUser que es para reemplazar, dentro de los parentesis se utilizara un cuerpo con @RequestBody y tambien se revise un @pathVariable, que es el id que se va a utilizara para actualizar el usuario 
		return new ResponseEntity<>(updateUser.update(newUser1, id), HttpStatus.OK); //este metodo recibe al newUser1 y el id y se coloca Ok porque solo recibe un 200
	}
	
}
