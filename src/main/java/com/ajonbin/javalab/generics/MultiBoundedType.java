package com.ajonbin.javalab.generics;

class A{

}

interface B{

}

interface C{

}

class ABC extends A implements B,C{

}




//Bounded Class must be the first one < T extends A & B & C >
//Error: <T extends B & C & A>
public class MultiBoundedType < T extends A & B & C> {
	T instance;

	public MultiBoundedType (T instance){
		this.instance = instance;
	}


	public static void main(String argv[]){
		//Error: MultiBoundedType<A> multiBoundedType = new MultiBoundedType<>(new A());
		MultiBoundedType<ABC> multiBoundedType = new MultiBoundedType<>(new ABC());
		System.out.println(multiBoundedType);

	}
}
