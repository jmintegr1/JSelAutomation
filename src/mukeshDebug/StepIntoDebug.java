package mukeshDebug;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StepIntoDebug {

		//public static WebDriver driver; 
		
		public static void main(String[] args) {  //Always run from main method
			
			
			System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
			
			//driver = new FirefoxDriver();
			
			WebDriver driver = new FirefoxDriver();  //You can do this way as well
			
			driver.get("http://opensource.demo.orangehrmlive.com/");
			
			Helper.typeIntoInputBox(driver, "txtUsername", "admin");
			
			driver.quit();
				
		}	
		
	}
