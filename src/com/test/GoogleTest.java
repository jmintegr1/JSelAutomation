package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {   //Proper convention to use the keyword "Test" in your Test Class 
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		driver = new ChromeDriver();  //Launch Chrome 
		
//		WebDriver driver = new SafariDriver();
		
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("http://www.google.com");
	}
	              //,groups="......" helps to organize   also ***IQ: How will you define the grouping in TestNG? Ans: we use KEYWORD: groupS (with "S" plural)  
	@Test(priority=1,groups="Title")       //Test #1
	public void googleTitleTest() {         //Although sequence is paired like: 1st BeforeMethod, 2nd all TCs, and 3rd AfterMethod but Selenium randomly picks 1 TC at time
		String title = driver.getTitle();   //so it can pick #2 googleLogoTest before googleTitleTes. 
		System.out.println(title);
	}                                              //**IQ: How will you prioritize your TC, or deal with randomness? 
	                                              //Ans: Once I put (priority=1, 2, or  3) then Selenium picks TC chronologically
	
	@Test(priority=2,groups="Logo")              //Test#2
	public void googleLogoTest() {
		boolean b = driver.findElement(By.id("hplogo")).isDisplayed();  //Testing if Google logo is displayed or not?
	}
	
	@Test(priority=3,groups="Link Test")     //Test #3
	public void mailLinkTest() {
		driver.findElement(By.linkText("Gmails")).isDisplayed();   //isDisplayed() method to test if Gmail link is displayed or not?
	}
	
	@Test(priority=4,groups="Test")  //#4 Chronologically going down
	public void test1() {
		System.out.println("test1");
	}
	
	@Test(priority=5,groups="Test")
	public void test2() {                //**IQ:How do you get index.HTMLFile report? Ans: 1. After execution, I refresh the project >> (right click on project.. go down  
		System.out.println("test2");    //the list and click on REFRESH, which will create a test-output folder >> click to expand drop down..) 
		                               //2. Go down to Properties then Right click on index.html  
	}                                 //3. Copy the location path & paste in URL bar, or give it to our manager  
	
	@Test(priority=6,groups="Test")
	public void test3() {
		System.out.println("test3");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
}
