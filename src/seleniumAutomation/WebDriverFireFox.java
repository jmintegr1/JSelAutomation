package seleniumAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFireFox {

	public static void main(String[] args) throws InterruptedException {
		
		//WebDriver driver;
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		
		//driver.get(baseURL);	
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);    //This part is Automation 
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
	
		driver.get("https://www.google.com");
	
		String title = driver.getTitle();
	
		System.out.println(title);
		
		//Validation point = Actual thing VS. Expected thing, this is basically testing itself 
		if(title.equals("Google")) {
			System.out.println("correct title");      //Including validation point = Automation Testing 
		}
		else {   //This is complete TC = Test Case is combination of different how to steps to reproduce expected results vs. actual result                                       
			System.out.println("in-corret title");
		}
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getPageSource()); //To get the entire front end page source code of HTML & Java Script..
		
		Thread.sleep(3000);
		
		driver.quit();   //Quit the browser 
		
	}

}
