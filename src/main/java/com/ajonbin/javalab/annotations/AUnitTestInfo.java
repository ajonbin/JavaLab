package com.ajonbin.javalab.annotations;

import java.lang.annotation.*;

@Repeatable(AUnitTestInfos.class)
public @interface AUnitTestInfo {
	String info();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface AUnitTestInfos{
	AUnitTestInfo[] value();
}

