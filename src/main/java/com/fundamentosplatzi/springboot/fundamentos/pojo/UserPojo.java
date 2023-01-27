package com.fundamentosplatzi.springboot.fundamentos.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;




@ConstructorBinding // se utiliza esta anotación para que se construya este POJO (class) a partir de estas propiedades de la clase
@ConfigurationProperties(prefix = "user") // anotar esta clase con el prefijo que representa la propiedad a nivel del properties , se utilizara una anotacion @ConfigurationProperties y esta anotación tiene un valor que se llama prefix y este prefix representa a user que son los user que se utilizo en resource
public class UserPojo {
	
	//Utilizar propiedades que se crearon en el application.properties
	
	private String email;
	private String password;
	private int edad;
	
	// creación del constructor  de las variables creadas
	public UserPojo(String email, String password, int edad) {
	
		this.email = email;
		this.password = password;
		this.edad = edad;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	

}
