package com.test;

import org.testng.annotations.Test;

public class InvocationCountTest {
	
	@Test(invocationCount=10)  //Keyword let's execute the same TC repeatedly. If we want to dump the data in the system 10X then use it.
	public void sum() {
		int a = 10;
		int b = 20;
		int c = a+b;
		System.out.println("sum is==="+ c);
	}

}
