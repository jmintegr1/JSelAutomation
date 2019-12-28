package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;

//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
//		driver = new SafariDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS); //Because it is GLOBAL wait, it will wait for all WebElements thereafter, it will wait in Dynamic fashion for the this WebElement to wait and if there were more, it will wait for those as well
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		driver.get("https://dmv.ny.gov/");
		
		Select select = new Select(driver.findElement(By.id("select-language")));
			
		select.selectByVisibleText("Bengali");
		//select.selectByValue("#$%^");
	    //select.selectByIndex(01);  Total of 3 different ways to use Select Class
		
		// **IQ: How do you handle drop down box?  
		
		//Ans: I will create an object of SELECT CLASS and parameterize it with appropriate Element for the drop down (in this case it is ID) then use the instance reference variable to 
		//call select.selectByVisibleText() method to select the thing I want.  (I have to import it from Selenium support.) 
		
		// VT, IV = selectByVisibleText(), selectByIndex() or selectByValue() 
		
		
		//OR select.selectByValue(""#$%^"");
	    //select.selectByIndex(01);
		
		//****IQ: How to handle check box, Like in I agree to permission asked or male female box or any box to check off?
		
		//Ex: driver.findElement(By.xpath("sflsldj")).click();

	    //Ans: I will use driver. (dot) findElement(By.xpath) or whatever the locator I need to check and pass its element to check then dot .click() method for check box or whatever I want to check off. 
	
		Thread.sleep(4000); //Write Static wait (Thread.sleep() ) we'll get error in red and once we put mouse on it, we'll get options for throws or try/catch block to handle it
		
		driver.quit();
		
	}

}
    