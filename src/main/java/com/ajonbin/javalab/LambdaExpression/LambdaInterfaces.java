package com.ajonbin.javalab.LambdaExpression;

public class LambdaInterfaces {

	@FunctionalInterface
	public interface NumbericCompute {
		boolean numbericTest(int n);
	}

	@FunctionalInterface
	public interface GenericCompute<T> {
		T compute(T t);
	}
}
