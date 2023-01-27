package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyBeanWithPropertiesImplement implements MyBeanWithProperties// esta clase recibira unos parametros que son los value o propiedades
{
	private String name;
	private String apellido;
	
	
	// se crea un metodo constructor para recibir los valores
	public MyBeanWithPropertiesImplement(String name, String apellido) {
		this.name = name;
		this.apellido = apellido;
	}



	// implementa su metodo
	@Override
	public String function()// esta function retornara un nombre y un apellido 
	{
		
		return name + "-" + apellido; // retorna un nombre y un apellido
	}

	
}
