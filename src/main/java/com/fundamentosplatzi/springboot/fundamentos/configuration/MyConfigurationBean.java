package com.fundamentosplatzi.springboot.fundamentos.configuration;// con este package se van a configurar todos nuestros beans o dependencias propias

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fundamentosplatzi.springboot.fundamentos.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanImplement;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanImplement2;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyBeanWithDependencyImplement;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyOperation;
import com.fundamentosplatzi.springboot.fundamentos.bean.MyOperationImplement;

@Configuration // se crea esta anotación para que spring boot determine que acabamos de tener una configuración adicional de nuestros beans y simplemente utilizamos nuestra notación @bean
public class MyConfigurationBean {

	@Bean // con esta anotación se utiliza para crear una implementacion bean 
	public MyBean beanOperation() // con este metodo se retorna una interfaz que es MyBean
	{
		// regresamos la implementacion de ese bean osea MyBeanImplement que viene siendo la clase donde se implemento la interfaz
		return new MyBeanImplement2(); // se le agrega new para instanciar esa implementación
	}
	

	//Creación de un bean diferente al anterior
	@Bean // con esta anotación se utiliza para crear una implementacion bean 
	public MyOperation beanOperation1() // con este metodo se regresa una interfaz que es MyOperation
	{
		// regresamos la implementacion de ese bean osea MyOperationImplement que viene siendo la clase donde se implemento la interfaz
		return new MyOperationImplement(); // se le agrega new para instanciar esa implementación
	}
	
	//Creación de un bean nuevo
		@Bean // con esta anotación se utiliza para crear una implementacion bean 
		public MyBeanWithDependency beanOperation2(MyOperation myOperation) // con este metodo se regresa una interfaz que es MyBeanWithDependency beanOperation2(MyOperation myOperation), Dentro de estos parentesis se coloca el nombre del metodo anterios o interfaz MyOperation myOperation, ya que la dependencia MyBeanWithDependencyImplement(), trae como dependencia dento de los parentesis (MyOperation)
		{
			// regresamos la implementacion de ese bean osea MyBeanWithDependencyImplement() que viene siendo la clase donde se implemento la interfaz
			return new MyBeanWithDependencyImplement(myOperation); // se le agrega new para instanciar esa implementación, en este caso esta dependencia MyBeanWithDependencyImplement() trae como parametros otra dependencia que es MyOperation myOperation
		}
		
}
