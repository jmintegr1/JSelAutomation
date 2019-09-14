package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncWait {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		
		WebDriver driver = new FirefoxDriver();
		driver = new FirefoxDriver(); 
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("https://app.hubspot.com/login"); 
		//Global wait - this is applied on all the web elements
		
		//Thread.sleep(10000); //Static wait
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.titleContains("HubSpot Login"));
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("username")).sendKeys("jmintegr1@gmail.com");
		driver.findElement(By.id("password")).sendKeys("1Zengogo");
		driver.findElement(By.id("loginBtn")).click();
		//Thread.sleep(4000);  //It is static wait where is explict & implicit waits are dynamic
		
		//By header = By.xpath("//h1[@class='private-page__title']");  //"By" you have to create with By (class)......... 
		//wait.until(ExpectedConditions.presenceOfElementLocated(header));
		                              //This method expects "By locator" so we have to create it like above
		
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='private-page__title']"))); //If you don't want to write line 38 & 39 then this one line will do
		
		          //WebDriver you create like this driver.findElement()..........
		boolean flag = driver.findElement(By.xpath("//h1[@class='private-page__title']")).isDisplayed();
		System.out.println(flag);
		
		System.out.println(driver.getTitle());
		
		
	}
	
}
