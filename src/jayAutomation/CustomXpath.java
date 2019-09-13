package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CustomXpath {

	public static void main(String[] args) throws InterruptedException {

		
//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new SafariDriver();
		
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
		
//		driver.findElement(By.xpath("//input[(@class,'gh-tb ui-autocomplete-input']")).sendKeys("Pink Floyd");
		
		
		//WITH CONTAINS
		//driver.findElement(By.xpath("//input[contains(@class,'gh-tb ui-autocomplete-input')]")).sendKeys("Can't Hurt Me"); //Couldn't get class attribute & value to work in input[@class or input[contains(@class 

		
		//Dynamic id: input (let's say it's input field tag from inspect)  | Every time you reload or refresh the page, the id is being changed. 
		

		//****IQ: How do you handle dynamic ID? Ans:   | Or: WHEN TO USE CONTAINS?
		
		//Answer: To handle dynamic ID, we can use CONTAINS() function.. and underscore, starts-with(), or ends-with() functions which leaves it dynamic & flexible so selenium will fill in whatever the current id is.
		
		//So look for pattern then pick the appropriate function to handle that dynamic ID
				
		//Dynamic id: let's its input field..
		//All STARTS-with: test
		//id = test+123
		//By.id("test_123") 
		//id = test_456  
		//id = test_789   After refresh the page the id comes like this so there is a challenge as after underscore some # changing on every refresh 
		driver.findElement(By.xpath("//input[contains@id,'test_')]")).sendKeys("Test");  //Leaving as Underscore let's selenium fill in with the dynamic id when it changes
                                   //Here it starts with: test       //This xpath is only for demo, not real so don't run them for test
		
	
		//id = test_test_7890_test  |    In this situation starts-with is best to use
		
		driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("Test");    //This xpath is only for demo, not real so do not run them for test
                                   //Instead of contains we are using starts-with so they can be used interchangeably
		
		
		//Here it ENDS-with test_t
		//id = 1234_test_t
		//id = 23456_test_t
		//id = 6789_test_t
		
		driver.findElement(By.xpath("//input[ends-with(id,'_test_t')]")).sendKeys("Test");  //This xpath is only for demo, not real so do not run them for test
		
		
		//**IQ: How do you customize xpath, especially for LINKS?
		
		//All links  are represented by html < a tag, so start with //a[].. then we can use Contains() or Text() to customize Xpath.
		driver.findElement(By.xpath("//a[contains(text(),' My eBay')]")).click();
		
	
		//Problem with Absolute xpath:
		//1. Performance issues, it's slow
		//2. Not reliable
		//3. Can be changed at any time in the future by dev, then it's useless
		//.1 percent chance that we use absolute Xpath.. SUPER MAJORITY OF THE TIME WE USE CUSTOMIZED XPATH
		
		Thread.sleep(4000);
		 
		driver.quit();
		
	}

}
