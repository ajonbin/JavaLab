package com.ajonbin.javalab.generics;

public class RawType {

	public static void main(String argv[]){
		/*
		  	Raw Type (Mainly for backward compatibility)
		 */
		GenericType genericsRaw = new GenericType();
		System.out.println("Class of genericsRaw is " + genericsRaw.getClass());

		//OK: Assigning a parameterized type to its raw type is allowed:
		GenericType<String,String> genericsString1 = new GenericType<>();
		genericsString1.setValue("hello");
		System.out.println(genericsString1.value.getClass());
		genericsRaw = genericsString1;
		//Waring: Use a raw type to invoke generic methods defined in the corresponding generic type
		genericsRaw.setValue(8);
		//Cause a Runtime Error: System.out.println(genericsString1.value.getClass());
		System.out.println("Value: " + genericsRaw.getValue());

		genericsRaw = new GenericType();
		//Warning: Assign a raw type to a parameterized type, you will get a warning:
		GenericType<String,String> genericsString2 = genericsRaw;
		//genericsRaw.setValue(9);  //==> Will cause exception: java.lang.Integer cannot be cast to java.lang.String
		System.out.println("Value: " + genericsString2.getValue());

	}
}
