package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXpath {

	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();   
		driver.manage().deleteAllCookies();
	
		
		//Both waits are Dynamic wait aka GLOBAL wait. Dynamic because it only waits for relevant loading time, and move onto action after. Where is STATIC WAIT like Thread.sleep(); hard coded and does not save time when page fully loaded
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Wait 40 seconds for page to load fully then perform some actions, if page loaded faster rest of the time is ignored
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Wait 30 seconds to load all elements then perform actions based on the script of that certain element. Some elements may not be loaded within 40 seconds explicit wait
		
		driver.get("https://www.ebay.com/"); 
		
		
		
		//driver.findElement(By.xpath("//input[@type=\'text\']")).sendKeys("Can't Hurt Me"); //Here I customized xpath with the first attribute after input
		
		//driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("Can't Hurt Me"); //Here I used the xpath from cropath
		
		driver.findElement(By.xpath("//input[@placeholder='Search for anything']")).sendKeys("Can't Hurt Me"); //Using @placeholder properties' value
		
		//driver.findElement(By.xpath("//input[(@class,'gh-tb ui-autocomplete-input']")).sendKeys("Can't Hurt Me");
		
		//driver.findElement(By.xpath("//input[contains(@class='gh-tb ui-autocomplete-input']")).sendKeys("Can't Hurt Me"); //Couldn't get class attribute & value to work in input[@class or input[contains(@class 

		
		//Dynamic id: input (let's say it's input field tag from inspect)  | Every time you reload or refresh the page, the id is being changed. 
		

		//****IQ: How do you handle dynamic ID? Ans: 
		
		//To handle dynamic ID, we can use contain function.. and underscore, starts-with, or ends-with functions leaves it dynamic so selenium will fill in what ever the current id is.
		//So look for pattern then pick the appropriate function to handle dynamic ID
				
		//Dynamic id:
		//id = test+123
		//By.id("test_123")
		
		//driver.findElement(By.xpath("//input[contains@id,'test_')]")).sendKeys("Test");  

		
		//--starts-with
		//id = test_456
		//id = test_789
		//id = test_test_7890_test
		
		//driver.findElement(By.xpath("//input[starts-with(@id,'test_')]")).sendKeys("Test");

		
		//--ends-with
		//id = 1234_test_t
		//id = 23456_test_t
		//id = 6789_test_t
		
		//driver.findElement(By.xpath("//input[ends-with(id,'_test_t')]")).sendKeys("Test");
		
		
		//IQ: How do you customize xpath for links?
		//All links  are represented by <a> html tag, so start with a...
		
		driver.findElement(By.xpath("//a[contains(text(),' My eBay')]")).click();
		
		
		//Problem with Absolute xpath:
		//1. Performace issues, slow
		//2. Not reliable
		//3. Can be changed at any time in the future
		

		
		Thread.sleep(5000);
		
		
		driver.quit();
		
		
		
	}

}
