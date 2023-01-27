package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component
public class MyBeanImplement implements MyBean{

	 // llamar a la clase log para hacer uso del level info:
	Log LOGGER =LogFactory.getLog(MyBeanImplement.class);
	
	/*Sobreescribir metodo void print() de la interfaz MyBean*/
	/*Con alt+shift+s, le damos en implements methods, y seleccionamos el metodo print()*/
	@Override
	public void print() {
		// imprimir información con el metodo Log
		LOGGER.info("Hemos ingresado al metodo print, para mostrar el mensaje de este metodo"); // este nivel es muy general sirve para visualizar o depurar que nos encontramos dentro de un metodo o una clase o algun lugar del aplicativo, es el mas comun cuando tenemos desplegada nuestra aplicación en un servidor 
		System.out.println();
		System.out.println("Hola desde mi implementación propia del bean");
	}

	
}
