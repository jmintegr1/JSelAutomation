package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class MouseMovementHW {

	public static void main(String[] args) throws InterruptedException {

//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		WebDriver driver = new ChromeDriver();	
		
		WebDriver driver = new SafariDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://us.puma.com/en/us/home/");
		
				
		Actions action = new Actions(driver);    //Action object's instance variable is what we need to call .moveToElement() method so we can move the mouse to a tab..  
		
		
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Womens')]"))).build().perform();  //Finish it off with .build().perform() for mouse hover, drag & drop, double click & right click
		
		
		//Now inside of moveToElement(we pramaterize it so start with drver.findElement to call...  )

		
		//span[@class='site-nav__list__name hovered']
		
		action.moveToElement(driver.findElement(By.xpath("//span[@class='site-nav__list__name hovered']\n" + ""))).build().perform();
		
		
		Thread.sleep(5000);

		
		driver.quit();	
		
	}

}
