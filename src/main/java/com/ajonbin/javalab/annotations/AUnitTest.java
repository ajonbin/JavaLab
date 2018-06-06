package com.ajonbin.javalab.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AUnitTest {

	boolean enabled() default true;
	Class<? extends Throwable> expectedException() default None.class;
	int delay() default 0;

	class None extends Throwable{
		private None(){}
	}
}
