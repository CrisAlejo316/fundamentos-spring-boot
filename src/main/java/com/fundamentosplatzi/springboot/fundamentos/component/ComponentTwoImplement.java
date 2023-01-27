package com.fundamentosplatzi.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component // agregar anotación @component
public class ComponentTwoImplement implements ComponentDependency // a esta clase se le implementa la interfaz ComponentDependency
{

	/*Con alt+shift+s, le damos en implements methods, y seleccionamos el metodo saludar*/
	@Override
	public void saludar() {
		System.out.println();
		System.out.println("Hola mundo desde mi componente dos");
		
	}

	
}
