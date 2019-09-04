package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {

	public static void main(String[] args) throws InterruptedException {

//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new SafariDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		driver.get("https://dmv.ny.gov/");
		
		Select select = new Select(driver.findElement(By.id("select-language")));

		select.selectByVisibleText("Bengali");
		//select.selectByValue("#$%^");
	    //select.selectByIndex(01);
		
		// **IQ: How do you handle drop down box?  
		
		//Ans: I will create an object of SELECT CLASS and parameterize it with appropriate Element for the drop down (in this case it is ID) then use the instance reference variable to 
		//call select.selectByVisibleText() method to select the thing I want.   (I have to import it from Selenium support.) 
		
		// VT, IV = selectByVisibleText(), selectByIndex() or selectByValue() 
		
		
		//OR select.selectByValue(""#$%^"");
	    //select.selectByIndex(01);
		
		//****IQ: How to handle check box, Like in I agree to permission asked or male female box or any box to check off?
		
		//Ex: driver.findElement(By.xpath("sflsldj")).click();

	    //Ans: I will use driver. (dot) findElement(By.xpath) or whatever locator I need to check and pass its element to check then dot .click() method for check box or whatever I want to check off. 
	
		Thread.sleep(4000);
		
		driver.quit();
		
	}

}
    