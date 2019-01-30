package jayAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleDropBox {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://dmv.ny.gov/");
		
		//Handle drop box:  IQ: How do you handle drop box? 
		Select select = new Select(driver.findElement(By.id("select-language")));
		select.selectByVisibleText("Bengali");
		
		driver.findElement(By.xpath("     ")).click();
		
		// How to handle check box? (Like in I agree to male female box to check)
	    //Ans: driver . find element BY xpath or what ever then .click... for check box .click will work 

		
		
		
		
	}

}
