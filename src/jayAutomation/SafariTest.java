package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class SafariTest {

	public static void main(String[] args) throws InterruptedException {
		
//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		WebDriver driver = new ChromeDriver();
		
		//WebDriver driver = new SafariDriver();
		WebDriver driver = new SafariDriver();

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  
		//Because it is GLOBAL wait, it will wait for all WebElements thereafter, it will wait in Dynamic fashion for the this WebElement to wait and if there were more, it will wait for those as well
		
		
		driver.get("https://www.ebay.com/");
		
		System.out.println(driver.getTitle());
		
		
		Thread.sleep(3000);
		
		driver.quit();
		
		
		//How exactly is safari browser is launching?   
		//Ans: I need to enable allow remote automation.  
		//(To do that: 1) go to preferences on Safari 
		//2) Click on ADVANCE and check Show DEVELOP MENU software testing types in the menu bar 
		//3) Develop and check Allow remote automation) 
		
	}

}
