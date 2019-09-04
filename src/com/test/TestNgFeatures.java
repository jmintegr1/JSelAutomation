package com.test;

import org.testng.annotations.Test;

public class TestNgFeatures {
	
	@Test
	public void loginTest() {
		System.out.println("LoginTest");
		//int i = 9/0;   //If this line of code is active then it will fail therefore all the subsequent TC will not execute
	}

	@Test(dependsOnMethods="loginTest")     //EXACT METHOD NAME FROM ABOVE HAS TO BE COPIED & PASTED HERE... EXACT!
	public void HomePageTest(){
		System.out.println("Home Page Test");  //Depends keyword makes it depend on above TC, so if 1st TC fails then latter will not execute 
	}

	@Test(dependsOnMethods="loginTest")                                    
	public void SearchPageTest1() {
		System.out.println("SearchPageTest");
	}  
	
	@Test(dependsOnMethods="loginTest")                                    
	public void RegPageTest() {
		System.out.println("RegPageTest");
	} 
}
