package com.ajonbin.javalab.annotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AUnitTestRunner {
	public static void run(Class<?> testClass){
		System.out.println(String.format("Testing for %s", testClass.getName()));
		int totalCase = 0, runnedCase = 0, passedCase = 0, failedCase = 0;

		for(Method method : testClass.getDeclaredMethods()){
			System.out.println("Running Test: " + method.getName());

			if(method.isAnnotationPresent(AUnitTestInfo.class)){
				AUnitTestInfo[] infos = method.getAnnotationsByType(AUnitTestInfo.class);
				for(AUnitTestInfo info :infos){
					System.out.println(info.info());
				}
			}

			if(method.isAnnotationPresent(AUnitTest.class)){
				AUnitTest aUnitTest = method.getAnnotation(AUnitTest.class);
				if(aUnitTest.enabled()){
					if(aUnitTest.delay() != 0){
						try {
							System.out.println(String.format("Delay test for %d ms", aUnitTest.delay()));
							Thread.sleep(aUnitTest.delay());
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}

					try {
						runnedCase++;
						method.invoke(testClass.newInstance());
						passedCase++;
					} catch (IllegalAccessException e) {
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						if(e.getTargetException().getClass() == aUnitTest.expectedException()){
							System.out.println("Catch expected Exception: " + aUnitTest.expectedException());
							passedCase++;
						}else{
							failedCase++;
						}
					} catch (InstantiationException e) {
						e.printStackTrace();
					}

				}else{
					System.out.println("The test case is disabled, skip it");
				}

			}else{
				try {
					runnedCase++;
					method.invoke(testClass.newInstance());
					passedCase++;
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
					failedCase++;
				} catch (InstantiationException e) {
					e.printStackTrace();
				}
			}

			System.out.println();

			totalCase++;
		}
		System.out.println(String.format("Total %d cases runned. %d passed. %d failed. %d skipped",
			runnedCase,passedCase,failedCase,(totalCase-runnedCase)));
	}
}
