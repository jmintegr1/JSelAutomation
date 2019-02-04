package com.test;

import org.testng.annotations.Test;

public class TestnNGFeatures {
	
	@Test
	public void loginTest() {
		System.out.println("Login Test");
	}

	@Test (dependsOnMethods="Login Test")     //CAN'T SEEM MAKE THIS METHOD WORK.. WILL MAKE PROGRESS TOMORROW!!!
	public void HomePageTest(){
		System.out.println("Home Page Test");
	}
	

//	@Test                                    
//	public void SearchPageTest() {
//		System.out.println("Login Test");
//	}                                             
	
//	
	

}
