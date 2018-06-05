package com.ajonbin.javalab.generics;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wildcards {

	//Type parameter must be subtype of Number
	public static double upperBoundedSumOfList(List< ? extends Number > numbers){
		double s = 0.0;
		for(Number number : numbers){
			s += number.doubleValue();
		}
		return s;
	}

	//Type parameter must be super type of Integer
	public static void lowerBoundedAddToList(List< ? super Integer> list){
		for(int i = 0; i < 5; i++){
			list.add(i);
		}

	}


	//Unbounded Wildcard
	public static void printListUseObject(List<Object> objects){
		for(Object o: objects){
			System.out.println(o);
		}
	}

	public static void printListUnbounded(List<?> objects){
		for(Object o : objects){
			System.out.println(o);
		}
	}

	//Wildcard subtyping
	public static void wildcardSubtyping(){

		{
			//List<Integer> is not subtype of List<Number>
			List<Integer> integers = new ArrayList<>();
			//Can't compile: List<Number> numbers1 = integers;
		}

		{
			//List<? extends Integer> is subtype of List<? extends Number>, subtype of List<?>
			List<Integer> integers = new ArrayList<>();
			List<? extends Integer> intList = integers;
			List<? extends Number> numList = intList;
			List<?> wildcardList = numList;
			System.out.println("List<Integer> --> List<? extends Integer> --> List<? extends Number> --> List<?>");
		}

		{
			//Number's super class must be super class of Integer
			//So List<? super Number> is an instance of List<? super Integer>
			List<Number> numbers = new ArrayList<>();
			List<? super Number> numList = numbers;
			List<? super Integer> intList = numList;
			List<?> wildcardList = intList;
			System.out.println("List<Number> --> List<? super Number> --> List<? super Integer> --> List<?>");
		}



	}


	public static void main(String[] argv){
		{
			//Upper Bounded
			Double[] doubles = new Double[]{1.1, 2.2, 3.3};
			double sum = upperBoundedSumOfList(Arrays.asList(doubles));
			System.out.println(String.format("Sum : %f", doubles));
			assert sum == 6.6;
			System.out.println();
		}

		{
			Double[] doubles = new Double[]{1.1, 2.2, 3.3};

			//Error: List<Double> is not subtype of List<Object>
			//printListUseObject(Arrays.asList(doubles));

			//Must be casted
			printListUseObject(Arrays.<Object>asList(doubles));
			System.out.println();
			printListUnbounded(Arrays.asList(doubles));
			System.out.println();
		}


		{
			//Lower Bounded
			List<Number> numbers = new ArrayList<>();
			lowerBoundedAddToList(numbers);
			List<Double> doubles = new ArrayList<>();
			//Can't compile: lowerBoundedAddToList(doubles1);
		}

		//Wildcard Subtyping
		wildcardSubtyping();

		{
			//
			List<Integer> integers = new ArrayList<>();
			List<? extends Number> numbers = integers;
			//Compile Error: numbers.add(new Integer(10));

		}
	}
}
