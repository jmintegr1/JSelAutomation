package com.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgBasics {
	
	/*
@BeforeSuite --Setup System Property for Chrome
@BeforeTest --Launch Browser
@BeforeClass --Login to App


@BeforeMethod enter URL
@Test --- Search Test
@AfterMethod --- Logout from App

@BeforeMethod enter URL
@Test --- Google Logo Test
@AfterMethod --- Logout from App

@BeforeMethod enter URL
@Test --- Google Title Test@AfterMethod --- Logout from App     //WHY TWO METHODS JUMBLED UP?

@AfterClass --- Close Browser
@AfterTest --- Delete all Fing Cookies

   **IQ: How many annotation are available in TestNG?        
   *
   *Ans: The different annotations are: prerequisite annotations, test case annotations, and post condition 
   annotation so we can design our test cases in a sequencing manner. 
   
   
	*/
	
	
	//A test is warped in 2 conditions: Pre-condition, Test, and Post-Condition
	
	
	//Pre-conditions Annotation are annotations starting with @BEFORE
	
	@BeforeSuite  //1st
	public void setUp() {       //Prerequisite annotation 
		System.out.println("@BeforeSuite --Setup System Property for Chrome");
	}
	
	@BeforeTest   //2nd
	public void launchBrowser() {
	System.out.println("@BeforeTest --Launch Browser");
	}
	
	@BeforeClass    //3rd 
	public void Login() {
		System.out.println("@BeforeClass --Login to App");
	}
                                                        //VIDEO TIME: 36:12 HIS RESULT AND MINE RESULT DOES NOT MATCH
	
	/*Sequence flows like this     | During interview sequence will be asked
	 * 
	 * @BeforeMethod
	 * @Test -1
	 * @AfterMethod
	 * 
	 * 
	 *@BeforeMethod
	 *@GTest -2
	 *@AfterMethod
	 * 
	 *BeforeMethod
	 *@GTest -3
	 *@AfterMethod
	 */

	
	@BeforeMethod     //4
	public void enterURL() {
		System.out.println("@BeforeMethod enter URL");
	}
	
	//Test case --starting with @TEST      //If IQ: How many Test Case we have in this class? Ans: We just count how many @TEST annotation are there = 1 TC in this class
	@Test   //5th
	public void googleTitleTest() {          //Why @Test merging with @AfterMethod below in console? According to Nav, it suppose to execute @AfterMethod before 
		System.out.print("@Test --- Google Title Test");                
	}
	

	@Test
	public void SearchTest() {
		System.out.println("@Test --- Search Test");
	}
	
	@Test
	public void googleLogoTest() {
		System.out.println("@Test --- Google Logo Test");
	}
	
	
	//Post Conditions are annotation starting with @AFTER
	
	@AfterMethod //6th
	public void logout() {
		System.out.println("@AfterMethod --- Logout from App");
	}
	
	@AfterClass   //7th
	public void closeBrowser() {
		System.out.println("@AfterClass --- Close Browser");
	}	
	
	@AfterTest   //8th
	public void deleteAllCookies() {
		System.out.println("@AfterTest --- Delete all Fing Cookies");
		
	}

}
