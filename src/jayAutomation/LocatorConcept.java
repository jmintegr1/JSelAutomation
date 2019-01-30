package jayAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorConcept {
	
	private static final CharSequence[] Pan = null;
	private static final CharSequence[] Peter = null;

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver(); //Launch chrome
		
		driver.get("https://reg.ebay.com/reg/PartialReg?ru="); //enter url after
		
		
		//1.xpath: (**2nd Priority) Do not use hierarchy based xpath, can use xpath on second priority 
		//Absolute xpath should not be used cuz if div changes, your path is lost : /html[1]/body[1]/div[1]/div[5]/div[3]/div[1]/div[1]/button[1] 
		
		//driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Peter");
		
		//driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys("Pan");

		//driver.findElement(By.xpath("//input[@id='email']")).sendKeys("jmintegr1@gmail.com");
		
		//2. id:  (****1st Priority)    Here you look for the element called first/last name after id= 
		//driver.findElement(By.id("firstname")).sendKeys("Roofio");
		//driver.findElement(By.id("lastname")).sendKeys("Salazar");
		
		//3. Name: (3rd Priority)  You can only use by name if name element is available! 
		driver.findElement(By.name("firstname")).sendKeys("Barak");  //SendKeys is to fill in something
		driver.findElement(By.name("lastname")).sendKeys("Obama");
		
		//4. LinkText: (just for LINKS, 1st Priority) this is only for links and better to use LinkText instead of PartialLinkTest
		//driver.findElement(By.linkText("Sign in")).click(); //If id is available then I will use it instead of LinkText 
		
		//5.PartialLinkText: not useful and recommended, it is big ass link just pick the first 2-3 words of the link
		//driver.findElement(By.partialLinkText("Create a business")).click();
		
		//6. CSS Selector: (****2nd Priority as well) After highlighting with inspector, right click then pick selector or from 
		//cropath use drop down menu to CSS Selector
		//1 way: if id is there then your css selector will be #{id} whatever the id value, so you can convert the id to css selector by putting # front of it  
		//2nd: if class is there then .{class} ... so this 2nd way put dot then what ever the class name 
		//driver.findElement(By.cssSelector("#PASSWORD")).sendKeys("1zengogo");
		
		//7. (4th Priority) Class name: not useful as another element may have the same class name 
		
		driver.findElement(By.className("socWrap")).click();
		
		driver.quit();
		
	}

}
