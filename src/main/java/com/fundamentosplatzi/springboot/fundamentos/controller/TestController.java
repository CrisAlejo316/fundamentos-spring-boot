package com.fundamentosplatzi.springboot.fundamentos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	@RequestMapping // esta anotación que sirve para aceptar todas las solicitudes dentro de este metodo a nivel HTTP
	@ResponseBody // esta anotación es para responder un cuerpo a nivel del servicio
	public ResponseEntity<String>function() // retorno de respuesta, y lo que devuelve es un String
	{
		 return new ResponseEntity<String>("Hello from controller", HttpStatus.OK);// retorna un tipo String y devuleve el estado de respuesta via Http puede ser OK
	}
}
