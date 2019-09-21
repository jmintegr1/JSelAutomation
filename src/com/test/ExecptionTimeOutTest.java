package com.test;

import org.testng.annotations.Test;         //THIS IS A TEST of CHANGE FROM GITHUB THEN PULLING IN ECLIPSE

public class ExecptionTimeOutTest {
	
	                       //**IQ: If you want to handle exceptions in TestNG, what is the keyword used to achieve that?  
	                      //Ans: exceptedExceptions
/*	@Test(invocationTimeOut=2000,expectedExceptions=NumberFormatException.class) //The program works by running infinite loop but throwing failure ThreadTimeoutException as I set to 2 milli-seconds 
	public void infintLoopTest(){ 
		int i = 1;                   
		while(i==1){
			System.out.println(i);
		}
	}*/
	
	@Test  (expectedExceptions=NumberFormatException.class)  //Once we added the keyword = and name of the exception then TC will pass cuz we are expecting it & informed Selenium
	public void test1() {
		String x = "100A";
		Integer.parseInt(x);
	}

}
