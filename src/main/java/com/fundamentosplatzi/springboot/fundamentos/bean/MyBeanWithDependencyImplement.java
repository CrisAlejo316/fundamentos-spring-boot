package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

	    // llamar a la clase log para hacer uso del level info:
		Log LOGGER =LogFactory.getLog(MyBeanWithDependencyImplement.class);
		
	
	
	// llamaremos a nuetra dependencia MyOperation con su nombre de esa interfaz o dependencia
	private MyOperation myOperation; // se crea el objeto Nombre de clase o interfaz: MyOperation en seguida el nombre del objeto myOperation
	
	// crear constructor de la clase MyBeanWithDependencyImplement, para la dependencia MyOperation
	public MyBeanWithDependencyImplement(MyOperation myOperation) {
		
		this.myOperation = myOperation;
	}
	
	/*Sobreescribir metodo void printWithDependency() de la interfaz MyBeanWithDependency*/
	@Override
	public void printWithDependency() {
		// imprimir información con el metodo Log
		LOGGER.info("Hemos ingresado al metodo printWithDependency"); // este nivel es muy general sirve para visualizar o depurar que nos encontramos dentro de un metodo o una clase o algun lugar del aplicativo, es el mas comun cuando tenemos desplegada nuestra aplicación en un servidor 
		int numeroDentroDeSum=7;
		LOGGER.debug("El numero enviado como parametro a la dependencia myOperation es: "+numeroDentroDeSum);
		System.out.println(myOperation.sum(numeroDentroDeSum)); // llamamos a nuestra dependencia, el nombre del objeto creado y luego implementa a nuestro metodo int sum() y dentro de los parentesis se le coloca la variable numeroDentroDeSum ya que ese metodo dentro de sum tiene una variable entera 
		System.out.println("Hola desde la implementación de un bean con dependencia");
		
	}

	

	
}
