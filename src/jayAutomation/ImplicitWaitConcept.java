package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ImplicitWaitConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver; 
		
//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
		//WebDriver driver = new FirefoxDriver(); To initialize WebDriver in one shot
		
		
		//driver = new SafariDriver();  // If I want to run it on Safari, seems like now I don't need to download the safari driver as long as I activate it from preferences and Developer menu for automation  
		
		driver.get("https://www.ebay.com/"); //Do this 3 steps below right away then go into actions 
		
		driver.manage().window().maximize();   
		driver.manage().deleteAllCookies();
		                                      //Because it is GLOBAL wait, it will wait for all WebElements thereafter, it will wait in Dynamic fashion for the this WebElement to wait and if there were more, it will wait for those as well
		//Both waits are Dynamic wait aka GLOBAL wait, waits right after WebDriver initialization is global wait. Dynamic because it only waits for relevant loading time, and move onto other action after. Where is STAIC WAIT like Thread.sleep(); hard coded and does not save time when page fully loaded
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Wait 40 seconds for PAGE to load fully then perform some actions, if page loaded faster rest of the time is ignored as it moves on to...
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Wait 30 seconds to load "ALL THE ELEMENTS" which are applicable on the page. Because some time the page maybe fully loaded, but say GO button or some other element is not fully loaded. So wait then perform actions based on the 
		//script of that certain ELEMENTS. Some ELEMENTS may not be loaded within 40 seconds explicit wait. So exception will be thrown after the time alloted and it is still not loaded 
		
		//IMPLICIT WAIT will only wait for "WebElements" like button, it will not wait for Title!!!
		
		//PageloadTimeout has different criteria.. so if it gets loaded fast then implicitlyWait has its own criteria so it is a backup to wait further until all the ELEMENTS are loaded along with the Page... 
		
		
		Thread.sleep(3000); //Write Static wait (Thread.sleep() ) we'll get error in red and once we put mouse on it, we'll get options for throws or try/catch block to handle it
		
		driver.quit();
		
	}
	
}
