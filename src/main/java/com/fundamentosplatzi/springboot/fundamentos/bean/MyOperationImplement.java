package com.fundamentosplatzi.springboot.fundamentos.bean;

public class MyOperationImplement implements MyOperation {

	/*Sobreescribir metodo int sum() de la interfaz MyOperation*/
	@Override
	public int sum(int numberEntere) // se implememnta el metodo int sum 
	{
		
		return numberEntere+1;// se le suma un 1 a ese numero entero
	}

}
