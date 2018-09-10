package com.ajonbin.javalab.LambdaExpression;

/*
An interface with only one method is known as "Functional Interface"
 */

public class LambdaMain {
	private String valueOne = "valueOne in LambdaMain";

	public static void main(String[] args){
		System.out.println("Lambda Expression:");
		System.out.println("\t* More elegant and readable code");
		System.out.println("\t* Make Collection Libraries easier to iterate through, filter, extract data");
		System.out.println("\t* Makes new Concurrency features improve performance in multicore environments");

		System.out.println("---- Self-defined Functional Interface----");
		LambdaInterfaces.NumbericCompute isEven = n -> (n % 2) == 0;
		LambdaInterfaces.NumbericCompute isPositive = n -> n > 0;
		System.out.println(isEven.numbericTest(10));
		System.out.println(isPositive.numbericTest(-10));


		System.out.println("---- Self-defined Generic Functional Interface----");
		LambdaInterfaces.GenericCompute<String> toUppercase = str -> str.toUpperCase();
		LambdaInterfaces.GenericCompute<Integer> doubleInt = (n) -> {
			return n * 2;
		};
		System.out.println(toUppercase.compute("hello, lambda"));
		System.out.println(doubleInt.compute(-10));


		System.out.println("---- Anonymous Runnable V.S. Lambda Runnable");
		Runnable r1 = new Runnable() {
			@Override
			public void run() {
				System.out.println("Greeting from Anonymous Runnable");
			}
		};
		Runnable r2 = () -> System.out.println("Greeting from Lambda Runnable");
		r1.run();
		r2.run();


		System.out.println("---- Different Scope of Inner Classes and Lambda Expression");
		LambdaMain lambdaMain = new LambdaMain();
		lambdaMain.scopeTest();
	}
	public void scopeTest(){
		LambdaInterfaces.GenericCompute<String> innerClassScope = new LambdaInterfaces.GenericCompute<String>() {
			private String valueOne = "valueOne in InnerClass";
			@Override
			public String compute(String s) {
				System.out.println(this.valueOne);
				return this.valueOne;
			}
		};

		LambdaInterfaces.GenericCompute<String> lambdaScope = (str) -> {
			String valueOne = "valueOne in lambda";
			System.out.println(this.valueOne);
			return valueOne;
		};

		innerClassScope.compute("");
		lambdaScope.compute("");

	}
}
