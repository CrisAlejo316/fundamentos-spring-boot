package com.fundamentosplatzi.springboot.fundamentos.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;


@Component // agregar anotación @component
public class ComponentImplement implements ComponentDependency // a esta clase se le implementa la interfaz ComponentDependency
{
	
	// llamar a la clase log para hacer uso del level info:
		Log LOGGER =LogFactory.getLog(ComponentImplement.class);
	
   /*Con alt+shift+s, le damos en implements methods, y seleccionamos el metodo saludar*/
	@Override
	public void saludar() {
		
		// imprimir información con el metodo Log
		LOGGER.info("Hemos ingresado al metodo saludar de la clase ComponentImplement"); // este nivel es muy general sirve para visualizar o depurar que nos encontramos dentro de un metodo o una clase o algun lugar del aplicativo, es el mas comun cuando tenemos desplegada nuestra aplicación en un servidor 
		System.out.println();
		System.out.println("Hola mundo desde mi componente");
		
	}

	
}
