package com.ajonbin.javalab.generics;

public class GenericMethods {

	//This create a Raw Type (GenericType)
	public static <T,S> GenericType createRawGenericType(T value, S subvalue){
		GenericType<T,S> genericType = new GenericType<>();
		genericType.setValue(value);
		genericType.setSubValue(subvalue);
		return genericType;
	}
	//This create a Generic Type(GenericType<T,S>)
	public static <T,S> GenericType<T,S> createGenericType(T value, S subvalue){
		GenericType<T,S> genericType = new GenericType<>();
		genericType.setValue(value);
		genericType.setSubValue(subvalue);
		return genericType;
	}

	public <T> boolean compareValue(T value1, T value2){
		return value1 == value2;
	}


	public static void main(String argv[]){
		GenericType<String, Integer> genericType = GenericMethods.<String,Integer>createGenericType("Generic Type",8);
		GenericType genericTypeRaw = GenericMethods.createRawGenericType("Raw Type",8);


		GenericMethods genericMethods = new GenericMethods();
		assert !genericMethods.compareValue(genericType.getValue(),genericTypeRaw.getValue());
		assert !genericMethods.<String>compareValue(genericType.getValue(),(String)genericTypeRaw.getValue());

	}
}
