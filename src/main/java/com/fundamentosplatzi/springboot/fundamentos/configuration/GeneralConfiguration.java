package com.fundamentosplatzi.springboot.fundamentos.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithPropertiesImplement;
import com.fundamentosplatzi.springboot.fundamentos.pojo.UserPojo;

@Configuration
//@PropertySource("classpath.connections.properties")// con esta anotación llamaramos a los valores o propiedades del archivo connections.properties
@EnableConfigurationProperties(UserPojo.class)// con esta anotación se utiliza para que pueda funcionar la class UserPojo y pueda ser inyectada en cualquier parte de la aplicación, tambien con la clase UserPojo.class es la que se va a representar unas propiedades como una aplicación
public class GeneralConfiguration {

	@Value("${value.name}") // esta anotación nos va a permitir llamar a los valores o propiedades que hemos creado
	// se crea una variable private que solo tenga acceso en esta clase y es de tipo String que se llamara name
	private String name;
	
	@Value("${value.apellido}") // esta anotación nos va a permitir llamar a los valores o propiedades que hemos creado
	// se crea una variable private que solo tenga acceso en esta clase y es de tipo String que se llamara apellido
	private String apellido;
	
	@Value("${value.random}") // esta anotación nos va a permitir llamar a los valores o propiedades que hemos creado
	// se crea una variable private que solo tenga acceso en esta clase y es de tipo String que se llamara random
	private String random;
	
	//llamaremos a nuestras propiedades del archivo connection.properties
	//@Value("${jdbc.url}")
	// se mapea con una variable tipo String
	//private String  jdbcurl;
	
	//@Value("${driver}")
	// se mapea con una variable tipo String
	//private String driver;
	
	//@Value("${Username}")
	// se mapea con una variable tipo String
	//private String  Username;
	
	//@Value("${password}")
	// se mapea con una variable tipo String
	//private String  password;
	
	
	@Bean // se utiliza un bean para utilizarlas
	// Este bean se llamara MyBeanWithProperties que viene siendo la dependnecia o interfaz
	public MyBeanWithProperties function(){
		
		return new MyBeanWithPropertiesImplement(name,apellido);
	}
	
	/*@Bean
	public DataSource dataSource() {// DataSource viene siendo una interfaz
		// llamaremos a la clase DataSourceBilder, se le crea un objeto y se le instancia que es dataSourceBuilder y llamamos a create()
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		dataSourceBuilder.url("jdbc:h2:mem:testdb");
		dataSourceBuilder.username("SA");
		dataSourceBuilder.password("");
		//return la implementación
		return dataSourceBuilder.build();
	}*/
	
	@Bean
	//@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource dataSource() {// DataSource viene siendo una interfaz
		return DataSourceBuilder.create()
				.url("jdbc:h2:mem:testdb")
				.username("SA")
				.password("")
				.driverClassName("org.h2.Driver")
				.build();
	}
	
	
}
