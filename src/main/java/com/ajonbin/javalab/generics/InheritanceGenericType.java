package com.ajonbin.javalab.generics;

public class InheritanceGenericType<T,S,U> extends GenericType<T,S>{
	protected U anotherValue;


	public static void main(String[] argv){

		InheritanceGenericType<String,String,String> inheritanceGenericType = new InheritanceGenericType<>();
		System.out.println(inheritanceGenericType.getClass().getGenericSuperclass());

		/*
		InheritanceGenericType<Number,String,String> is subclass of GenericType<Number,String>, so cast is OK
		 */
		InheritanceGenericType<Number,String,String> inheritanceGenericType1 = new InheritanceGenericType<>();
		GenericType<Number,String> genericType1 = inheritanceGenericType1;


		/*
		InheritanceGenericType<Integer,String,String> is NOT subclass of GenericType<Number,String>, although Integer is subclass of Number.
		So cast is Error.
		 */
		InheritanceGenericType<Integer,String,String> inheritanceGenericType2 = new InheritanceGenericType<>();
		//Error: GenericType<Number,String> genericType2 = (GenericType<Number,String>) inheritanceGenericType2;


	}

}
