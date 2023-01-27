package com.fundamentosplatzi.springboot.fundamentos.entity;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="user")
public class User { // esta entidad tendra la misma notación entity

	// esta clase debe tener siempre un id, que representar la entidad a nivel de la tabla en la base de datos
		@Id
	    @GeneratedValue(strategy=GenerationType.AUTO) // esta notación es para que se auto incremente el usuario cuando se agregue un usuario
		@Column(name="id_user", nullable = false,unique = true) // esta propiedad id tiene nombre de columna id_user a nivel de bases de datos
		private Long id;//representar la columna de la base de datos con un id, que es de tipo long, como una propiedada nivel de clase
		
		@Column(length = 50) // tiene un tamaño de largo de 50
		private String nameUser; // se representa esta notación de forma de columna en una variable llamada nameUser, que viene siendo una propiedad
		
		@Column(length = 50, unique = true) // tiene un tamaño de largo de 50, con la anotacion @column se generara un atributo unique=true, esto quire decir que el correo debe ser unico, si hay un email que sea igual genera un error
		private String email; // se representa esta notación de forma de columna en una variable llamada email, que viene siendo una propiedad
		
		private LocalDate birthDate; // se representa esta notación de forma de  columna en una variable llamada birthDate, en este caso se va a representar con un tipo de dato LocalDate Java 8
		
		@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER) // un usuario puede tener muchos post, se mapea por la propiedad user donde se encuentra la creación de la entidad usuario en este caso es de la clase Post
		
		//creación de la lista post
		@JsonManagedReference // esta notación es para que cuando accedamos a este servicio a nivel de servicio REST  no nos de un error a nivel de StackOveerFlow
		private java.util.List<Post> posts = new ArrayList<>();// se iniciliza esta lista tiene como nombre post

		//se crea un constructor vacio
		public User() {
				
		}

		// luego se crea un constructor con los parametros o metodos, para hacer el registro a nivel de bases de datos
		public User(String nameUser, String email, LocalDate birthDate) {
			
			this.nameUser = nameUser;
			this.email = email;
			this.birthDate = birthDate;
		}

		public User(Long id) {
			this.id=id;
		}

		//se crea los metodos get y set
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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public LocalDate getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(LocalDate birthDate) {
			this.birthDate = birthDate;
		}

		public java.util.List<Post> getPosts() {
			return posts;
		}

		public void setPosts(java.util.List<Post> posts) {
			this.posts = posts;
		}

		// se genera el metodo toString, el método toString nos permite mostrar la información completa de un objeto, es decir, el valor de sus atributos.
		@Override
		public String toString() {
			return "User ["
					+ "id=" + id 
					+ ", nameUser=" + nameUser 
					+ ", email=" + email 
					+ ", birthDate=" + birthDate
					+ ", posts=" + posts 
					+ "]";
		}

		
		
		
		
		
}
