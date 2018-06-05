package com.ajonbin.javalab.generics;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;


class GenericTypeStringInteger extends GenericType<String,Integer>{

}

public class GetGenericParameterType{

	public static Type[] getSuperClassParameterType(Class<?> clz){
		System.out.println(String.format("Generic Super Class of %s is %s", clz,clz.getGenericSuperclass()));

		Type superClassType = clz.getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) superClassType;
		System.out.println("Super Class's Raw Type is : " + parameterizedType.getRawType());

		Type[] typeParameters = ((Class<?>)parameterizedType.getRawType()).getTypeParameters();
		System.out.println("Super Class's Type Parameters are :");
		for(Type type : typeParameters){
			System.out.println("\t" + type);
		}

		Type[] types = parameterizedType.getActualTypeArguments();
		System.out.println("Super Class's Actual Type Parameters are :");

		for(Type type : types){
			System.out.println("\t" + type);
		}
		return types;
	}

	public static void main(String[] argv){
		getSuperClassParameterType(GenericTypeStringInteger.class);
	}
}


