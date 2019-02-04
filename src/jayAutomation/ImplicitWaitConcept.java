package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitConcept {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ebay.com/"); //Do this 3 steps below right away then go into actions 
		
		driver.manage().window().maximize();   
		driver.manage().deleteAllCookies();
	
		
		//Both waits are Dynamic wait aka GLOBAL wait. Dynamic because it only waits for relevant loading time, and move onto action after. Where is STATIC WAIT like Thread.sleep(); hard coded and does not save time when page fully loaded
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Wait 40 seconds for page to load fully then perform some actions, if page loaded faster rest of the time is ignored
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Wait 30 seconds to load "all elements" then perform actions based on the script of that certain element. Some elements may not be loaded within 40 seconds explicit wait
	
		
		
		
	}

}
