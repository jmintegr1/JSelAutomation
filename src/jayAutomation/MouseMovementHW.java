package jayAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementHW {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://us.puma.com/en/us/home/");
		
				
		Actions action = new Actions(driver); 
		
		
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Womens')]"))).build().perform();
		
		//span[@class='site-nav__list__name hovered']
		
		action.moveToElement(driver.findElement(By.xpath("		//span[@class='site-nav__list__name hovered']\n" + 
				""))).build().perform();

		
				
		
		Thread.sleep(5000);

		
		//driver.quit();
		
		
		
		
	}

}
