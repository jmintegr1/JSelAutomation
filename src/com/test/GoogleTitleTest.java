package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitleTest {
	
WebDriver driver;   // Since splitting up the WebDriver object so declare the variable here then fully instantiate on line 23	
	

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
	    //WebDriver driver = new ChromeDriver();  //Launch Chrome in one shot, or split it up by line 16 and line 23
	    //driver  = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");   //FireFox Driver added
		driver = new FirefoxDriver();
	    
	    //WebDriver driver = new SafariDriver(); //SAFARI

		
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.get("http://www.google.com");
	}
	
	              //,group="......" helps to organize   also ***IQ: How will you define the grouping in TestNG? Ans: we use "groups" keyword, with S for plural 
	@Test()      
	public void googleTitleTest() {         //Although sequence is paired like: 1st BeforeMethod, 2nd Test, and 3rd AfterMethod but Selenium randomly picks the test case
		String title = driver.getTitle();   //so it can pick #2 googleLogoTest before googleTitleTes. 
		System.out.println(title);
	                                             //**IQ: How will prioritize your TC? Ans: Once I put (priority=1, 2, and 3) then Selenium picks TC chronologically
	
		                // Expected vs.title Actual 
		Assert.assertEquals(title, "Google", "title is not matched");  //How Assert() method helps? Assert helps to NOT write if else condition for validation 
                                               //IF assertion fails then print this message
	}
	
	@Test()       
	public void googleLogoTest() {
		boolean b = driver.findElement(By.id("Googlelogo")).isDisplayed();  //Testing if Google logo is displayed or not?
        //Boolean Above just state True or False so TC can passed either way. So give clear COMMAND by Assertion.. so we want clear true/pass if logo is there or fail it
		Assert.assertEquals(b, true);  // OR Assert.assertTrue(b);
	}    //Two ways to Assert, pick one
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}	
}

