package com.ajonbin.javalab.generics;


//Number is the Bounded Type, Generic Type T must be instance of Number or its subclass
public class BoundedType< T extends Number> {
	private T value;

	public BoundedType(T value){
		this.value = value;
	}

	public int getIntValue(){
		//You can call the method of Bounded Type.
		return value.intValue();
	}


	public static void main(String[] argv){
		BoundedType<Double> boundedType = new BoundedType<>(66.6);
		System.out.println(boundedType.getIntValue());

		//Error: BoundedType boundedTypeString = new BoundedType("hello");
		//Error: BoundedType<String> boundedTypeString = new BoundedType<>("hello");

	}
}
