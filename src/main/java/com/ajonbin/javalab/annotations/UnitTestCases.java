package com.ajonbin.javalab.annotations;

import com.google.j2objc.annotations.AutoreleasePool;

import java.io.IOException;

public class UnitTestCases {

	@AUnitTestInfo(info = "testDisabled: A Unit Test to test disabled Unit Test")
	@AUnitTestInfo(info = "testDisabled: You should not see this info")
	@AUnitTest(enabled = false)
	public void testDisabled(){
		System.out.println("testDisabled is executed");

	}

	@AUnitTestInfo(info = "testException: A Unit Test to test expected Exception")
	@AUnitTestInfo(info = "testException: IOException is expected")
	@AUnitTest(expectedException = IOException.class)
	public void testException() throws Exception{
		System.out.println("testException is executed");
		throw new IOException("IOException happened.");
	}

	@AUnitTestInfo(info = "testDelayed: A Unit Test to test delayed execution")
	@AUnitTest(delay = 10000)
	public void testDelayed(){
		System.out.println("testDelayed is executed");
	}

	public void testUnexpectedException() throws Exception{
		System.out.println("testUnexpectedException is executed");
		throw new IOException("IOException happened.");
	}
}
