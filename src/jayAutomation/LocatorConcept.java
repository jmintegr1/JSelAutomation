package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LocatorConcept {                             //VIDEO LOCATORS IN WEBDRIVER (ID, XPATH, CSSSelector etc) 
	
	private static final CharSequence[] Pan = null;
	private static final CharSequence[] Peter = null;

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
		
//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		driver = new ChromeDriver(); //Launch chrome
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
		//driver = new SafariDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);   //Because it is GLOBAL wait, it will wait for all WebElements thereafter, it will wait in Dynamic fashion for the this WebElement to wait and if there were more, it will wait for those as well
		
		
		driver.get("https://reg.ebay.com/reg/PartialReg?ru="); //enter url after
		
		
		//1.xpath: (**2nd** Priority) Do not use hierarchy based xpath (absolute xpath), can use xpath on second priority 
		//Absolute xpath should not be used cuz if div changes, your path is lost : /html[1]/body[1]/div[1]/div[5]/div[3]/div[1]/div[1]/button[1] 
		//ONLY USE RELATIVE XPATH
		
		                 //By is a CLASS from selenium
//		driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Peter"); //sendKeys() method is same as fill/type in the text	
		
//		driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Pan");  //Select and fill in FIELDS by using XPATHS

		 
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("jmintegr1@gmail.com");
		
		
		//2. id:  (****1st Priority****) if ID is Avaliable.  For "NAMES" or say I don't want to use Xpath then 2 take priority over Xpath
		//Here you look for the element called first/last name after ID= 
		driver.findElement(By.id("firstname")).sendKeys("Roofio");  //For ID just put the STRING inside  "......" that's it!!!  So if ID is not available then Xpath is #1
		driver.findElement(By.id("lastname")).sendKeys("Salazar"); //For filling name it makes sense to use NAMES locator then it is 1st priority.. practical so less code to write like above Xpath
		
		         
		
		//3. Name: (3rd Priority)  You can only use by name if NAME element is available! 
//		driver.findElement(By.name("firstname")).sendKeys("Barak");  //SendKeys is to fill in the text or characters
//		driver.findElement(By.name("lastname")).sendKeys("Obama");
		
		
		//4. LinkText: (for LINKS, LinkText takes Priority over PartialLinkText)
		driver.findElement(By.linkText("Sign in")).click(); //If ID or NAME is available then I will use those instead of LinkText   | All links are represented by <a (a tag)
		//If <a is there then you won't find ID or NAME but you'll find href after the <a href
		
		
		//5.PartialLinkText: not useful and recommended, it is for big ass link/sentence text so just pick the first 2-3 words of the link, better to use LinkText
		//driver.findElement(By.partialLinkText("Create a business")).click();
		
		
		//6. CSSSelector: (****2nd Priority as well) After highlighting with inspector, right click then put mouse on copy and get options, pick selector or from 
		//cropath use drop down menu to CSS Selector
		
		//1 way: If ID is there then your cssSelector will be # & the ID. So whatever the ID value, you can convert the ID into cssSlector by putting # front of it.  
		
		//2nd: If ID is not there but CLASS is there then . Class Name, so Dot Class Name after. So this 2nd way put dot then whatever the class name is..
		
		//driver.findElement(By.cssSelector("#PASSWORD")).sendKeys("1zengogo"); 
		
		//#PASSWORD     #pass 
		
		//7. Class:   not recommended (4th Priority) Class name: not useful as another element may have the same class name for different elements so there can be duplicate classes 
		//driver.findElement(By.className("socWrap")).click();
		
		Thread.sleep(5000); //Write Static wait (Thread.sleep() ) we'll get error in red and once we put mouse on it, we'll get options for throws or try/catch block to handle it
		
		//driver.quit();       //Quit() is to close ALL opened window associated with the object that ran it. BEST ELEMENTS TO USE: XPATH, ID, NAME & CSSSelector 
		//driver.close(); //Close is to close just the current window that run..        VIDEO CONTINUES to HandleDropBox class @ 40:40  
		
	}
}
