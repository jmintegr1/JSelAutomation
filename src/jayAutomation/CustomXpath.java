package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CustomXpath {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver; 
		
//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
		//driver = new SafariDriver();
		
		driver.manage().window().maximize();   
		driver.manage().deleteAllCookies();
	
		//Both waits are Dynamic wait aka GLOBAL wait. Dynamic because it only waits for relevant loading time, and move onto action after. Where is STATIC WAIT like Thread.sleep(); hard coded and does not save time when page fully loaded
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Wait 40 seconds for full page to load then perform some actions, if page loaded faster rest of the time is ignored
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Wait 30 seconds to load "all elements" then perform actions based on the script of that certain element. Some elements may not be loaded within 40 seconds explicit wait
        //Because it is GLOBAL wait, it will wait for all WebElements thereafter, it will wait in Dynamic fashion for the this WebElement to wait and if there were more, it will wait for those as well
		
		driver.get("https://www.ebay.com/"); 
		
//		driver.findElement(By.xpath("//input[@type=\'text\']")).sendKeys("Can't Hurt Me"); //I customized xpath with the first attribute after input
		
//		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Can't Hurt Me"); //I used the xpath from cropath
		
//		driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys("Can't Hurt Me"); //Using @placeholder properties' value
		
//		driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Pink Floyd");
		
		
		//WITH CONTAINS
		driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-input')]")).sendKeys("Dark side of the moon"); //Couldn't get class attribute & value to work with contains()

		
		//Dynamic id: input (let's say it's input field tag from inspect)  | Every time you reload or refresh the page, the id is being changed. 
		

		//****IQ: How do you handle dynamic ID? Ans:   | Or: WHEN TO USE CONTAINS?
		
		//Answer: To handle dynamic ID, we can use CONTAINS() function.. and underscore, starts-with(), or ends-with() functions which leaves it dynamic & flexible so selenium will fill in whatever the current ID is.
		// OR: When we want to handle dynamic ID
		
		//So look for pattern then pick the appropriate function to handle that dynamic ID
				
		//Dynamic id: let's its input field..
		//All STARTS-WITH(): test
		//id = test+123
		//By.id("test_123") 
		//id = test_456  
		//id = test_789   After refresh the page the ID comes like this so there is a challenge as after underscore some # changing on every refresh 
//		driver.findElement(By.xpath("//input[contains@id,'test_')]")).sendKeys("Test");  //Leaving as UNDERSCORE after test_ it let's selenium fill in with the dynamic id when it changes
                                   //Here it starts with: test       //This xpath is only for demo, not real so don't run them for test
		
	
		//id = test_test_7890_test  |  In a big weird ID, starts-with() is best to use because 7890_test can change so use like this //input[starts-with]
		
//		driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("Test");                               //This xpath is only for demo
                                  
		//Instead of contains we are using starts-with so BOTH can be used.. though starts-with() sounds better
		
		
		//Here it ENDS-WITH() test_t    Here the ENDS is stationary and front #s are transient so it's ENDS-WITH() 
		//id = 1234_test_t
		//id = 23456_test_t
		//id = 6789_test_t
		
//		driver.findElement(By.xpath("//input[ends-with(id,'_test_t')]")).sendKeys("Test");  //This xpath is only for demo, not real so do not run them for test
		
		
		//**IQ: How do you customize xpath, especially for LINKS?
		
		//All links  are represented by html < a tag, so start with //a[] then we can use Contains() or Text() to customize Xpath or combination of both. 
		
		driver.findElement(By.xpath("//a[contains(text(),'My eBay') and @class='gh-eb-li-a']")).click();
		
	
		//Problem with Absolute xpath:
		//1. Performance issues, it's slow
		//2. Not reliable
		//3. Can be changed at any time in the future by dev, then it's useless
		//4. 1% chance that we use absolute Xpath.. SUPER MAJORITY OF THE TIME WE USE CUSTOMIZED XPATH
		
		driver.findElement(By.xpath("//input[@id='gh-btn']")).click(); // This is to CLICK on the search button after writing what we want to search via send.Keys() method 

		Thread.sleep(4000); //Write a Static wait (Thread.sleep() ) we'll get error in red and once we put mouse on it, we'll get options for throws or try/catch block to handle it
		 
		driver.quit();
		
	}

}
