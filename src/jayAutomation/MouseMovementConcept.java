package jayAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.spicejet.com/");
		
				
		Actions action = new Actions(driver); 
		//if you are using Actions Class then you'll use .build.perfrom as below to move mouse at point
		
		//MovetoElement method is to move mouse to..
		action.moveToElement(driver.findElement(By.xpath("//a[@id='highlight-addons']"))).build().perform(); //STUCK AT 6:00 on MOUSE MOVEMENT
		//action.moveToElement(driver.findElement(By.linkText("Add-Ons"))).build().perform(); //This link text we didn't get it to work so customize xpath
		
		Thread.sleep(4000);
		
		driver.findElement(By.linkText("International Connection Baggage")).click(); //When "a" right after a tag it's LinkText, which is after 1st tag

		Thread.sleep(5000);

		
		driver.quit();
		 
	
	}

}
