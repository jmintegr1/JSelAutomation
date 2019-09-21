package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;              //We use mouse movement to get option of the drop down window to take further action 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver;
		
//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		driver = new ChromeDriver();	
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
		//driver = new SafariDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //Because it is GLOBAL wait, it will wait for all WebElements thereafter, it will wait in Dynamic fashion for the this WebElement to wait and if there were more, it will wait for those as well

		
		driver.get("https://www.spicejet.com/");
				
		Actions action = new Actions(driver); 
		
		//***IQ: How do you simulate mouse movement or mouse hover?

		//Mouse movement is done by ACTIONS (w/ S) class so I will instantiate that and use it's object reference to call 
		//movetoElement() method to move the mouse to... then finish it off with .build() .perform();
		
		action.moveToElement(driver.findElement(By.xpath("//a[@id='highlight-addons']"))).build().perform(); //Customized xpath		
		
		//action.moveToElement(driver.findElement(By.linkText("Add-Ons"))).build().perform(); //This link text we didn't get it to work so customize xpath above
		
		Thread.sleep(4000);
		
		driver.findElement(By.linkText("International Connection Baggage")).click(); //When "a" right after a TAG ( < ) it's LinkText, which is after 1st tag so use the exact text
		
		Thread.sleep(5000);

		driver.quit(); 
		
	}	
}
