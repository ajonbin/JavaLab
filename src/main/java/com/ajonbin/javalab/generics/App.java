package com.ajonbin.javalab.generics;


public class App {
	public static void main(String[] argv){
		GenericType<String,String> genericsString = new GenericType<>();
		GenericType<Integer,Integer> genericsInt = new GenericType<>();

		System.out.println("Class of genericsString is " + genericsString.getClass());
		System.out.println("Class of genericsInt is " + genericsString.getClass());
		assert genericsString.getClass() == genericsInt.getClass();

		if(genericsString instanceof GenericType){
			System.out.println("genericsString IS instanceof Generics");
		}else{
			System.out.println("genericsString IS NOT instanceof Generics");
		}


	}
}
