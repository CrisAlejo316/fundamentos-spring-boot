package com.fundamentosplatzi.springboot.fundamentos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity // es una entidad de persistencia, cuyo estado es persistido de manera asociada a una tabla en una base de datos relacional
@Table(name="post")
public class Post // esta clase va a representar los Post de un usuario 
{
	// esta clase debe tener siempre un id, que representar la entidad a nivel de la tabla en la base de datos
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) // esta notación es para crear un id unico
	@Column(name="id_post", nullable = false,unique = true)
		private Long id;//representar la columna de la base de datos con id como una propiedad a nivel de clase
	
	@Column(name="description", length = 255) // esta columna tiene de largo 255
	private String description; // representa la columna de la base de datos con una descripcion
	
	@ManyToOne // esta relacion tiene muchos post y un solo usuario 
	@JsonBackReference
	// creación de relación con una entidad usuario
	private User user;

	// se crea un metodo constructor vacio
	public Post() {
		
	}
     // se creo un constructor para hacer el registro a nivel de bases de datos
	public Post(String description, User user) {
		
		this.description = description;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// El método toString nos permite mostrar la información completa de un objeto, es decir, el valor de sus atributos.
	@Override
	public String toString() {
		return "Post ["
				+ "id=" + id 
				+ ", description=" + description 
				+ ", user=" + user 
				+ "]";
	}
	
	
	
	
	
}
