package com.ajonbin.javalab.generics;

import java.io.Serializable;
import java.util.ArrayList;

public class TypeInference {

	public static <T> T pickType(T v1, T v2){
		return v1;
	}
	public static void main(String[] argv){
		//Inference algorithm tries to find the most specific type that works with all of the arguments.
		//In this case, the common type of String and ArrayLlist<> is Serializable
		Serializable s  = pickType("Hello", new ArrayList<>()).getClass();

	}
}
