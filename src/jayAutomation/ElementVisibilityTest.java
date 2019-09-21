package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver; 

//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
		driver = new SafariDriver();
		
		
		driver.manage().window().maximize();   
		driver.manage().deleteAllCookies();
	
		//Dynamic wait aka GLOBAL wait. Dynamic because it only waits for relevant loading time, and move onto action after. Where is STATIC WAIT like Thread.sleep(); hard coded and does not save time when page fully loaded
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//Wait for page to load fully, even if few elements are not loaded yet, that's why implicit wait comes in
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Wait 30 seconds to load ALL ELEMENTS then perform actions based on the script of that certain element. Some elements may not be loaded within 40 seconds explicit wait
        //Because it is GLOBAL wait, it will wait for all WebElements thereafter, it will wait in Dynamic fashion for the this WebElement to wait and if there were more, it will wait for those as well

		
		driver.get("https://classic.crmpro.com/index.html"); 
		
		//1. isDisplayed() method: applicable for all the elements
		boolean b1 = driver.findElement(By.id("submitButton")).isDisplayed(); //For submit button
		                            //Used id locator 
		
		System.out.println(b1); //We get True, if it was not displayed then it would have returned false
		
		//2. isEnabled() method:
		boolean b2 = driver.findElement(By.id("submitButton")).isEnabled();  //This is the prep stage before clicking on "agreeTerms" check box
		System.out.println(b2); //False, because we are requesting it to be enable but it is NOT until it changes to Enabled in the subsequent step by CLICKING
		
		// *IQ: Give me an example of enabled? Ans: Select I Agree checkbox...
		
		driver.findElement(By.name("agreeTerms")).click(); //By clicking now Submit button is enabled 
		boolean b3 = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println(b3); //True @ print out
		
		
		//3. isSelected() method: only applicable for check box, drop down, radio button 
		boolean b4 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(b4); //True
		
		//de-select the checkbox:
		driver.findElement(By.name("agreeTerms")).click();
		boolean b5 = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println(b5); //False
		
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}
}
