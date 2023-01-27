package com.fundamentosplatzi.springboot.fundamentos.bean;

import org.springframework.stereotype.Component;

@Component
public class MyBeanImplement2 implements MyBean{

	/*Sobreescribir metodo void print() de la interfaz MyBean*/
	@Override
	public void print() {
		System.out.println();
		System.out.println("Hola desde mi implementación 2 propia del bean 2");
	}

	
}
