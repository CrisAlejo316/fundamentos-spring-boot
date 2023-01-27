package com.fundamentosplatzi.springboot.fundamentos.dto;

import java.time.LocalDate;

//en esta clase vamos a representar los valores que queremos obtener en nuestra Query
public class UserDto {
	private Long id;
	private String nameUser;
	private LocalDate birthDate;
	

	//creación del constructor
	public UserDto(Long id, String nameUser, LocalDate birthDate) {
		
		this.id = id;
		this.nameUser = nameUser;
		this.birthDate = birthDate;
	}
	
	//creacion de los metodos get y set
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNameUser() {
		return nameUser;
	}


	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}


	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}
	
	//se implementa nuestro toString

	@Override
	public String toString() {
		return "UserDto [id=" + id 
				+ ", nameUser=" + nameUser 
				+ ", birthDate=" + birthDate 
				+ "]";
	}
	
	
	
	
	

}
