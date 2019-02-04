package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();   
		driver.manage().deleteAllCookies();
	
		
		//Dynamic wait aka GLOBAL wait. Dynamic because it only waits for relevant loading time, and move onto action after. Where is STATIC WAIT like Thread.sleep(); hard coded and does not save time when page fully loaded
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//Wait for page to load fully, even if few elements are not loaded yet, that's why implicit wait comes in
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Wait 30 seconds to load ALL ELEMENTS then perform actions based on the script of that certain element. Some elements may not be loaded within 40 seconds explicit wait
		
		
		driver.get("https://www.facebook.com/"); 
		
		//clickOn(driver, driver.findElement(By.xpath("//input[@id='u_0_2']")), 20); //Login button    | One element at a time will work
		clickOn(driver, driver.findElement(By.xpath("//a[@id='birthday-help']")), 10);  //Why do I need to provide my birthday?
		
	}
		
		
		public static void clickOn(WebDriver driver, WebElement locator, int timeout) throws InterruptedException {   //Explicit wait, telling selenium to wait for specific element to load before.. 
			new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
			locator.click();    
		
			Thread.sleep(4000);
		
			driver.quit();	
			
	}

}
