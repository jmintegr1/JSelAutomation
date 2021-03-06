package jayAutomation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadPropertiesFile {
	
	static WebDriver driver; //Took the local variable "WebDriver driver" from line 42 & turned it into Global variable so we can use that "driver" @ line 42 or any where else where DRIVER is needed in the rest of the class

	public static void main(String[] args) throws IOException, InterruptedException {

		Properties prop = new Properties();   
		
		                                          //I want to read the file from config.properties so right click, go to properties & get the path  
		FileInputStream ip = new FileInputStream("/Users/jewellmehedi/eclipse-workspace/JayNavAutomation/src/jayAutomation/config.properties");
		
		prop.load(ip); //Properties class instantiate to an object then works in conjunction with FileInputStream Object reference variable
		
			System.out.println(prop.getProperty("name"));  //Used # (hash) in config.properties to comment out
			
			System.out.println(prop.getProperty("age"));

			String url = prop.getProperty("URL");
			
			System.out.println(url);
			
			String browserName = prop.getProperty("browser");
			
			System.out.println(browserName);
			
						
			//if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
			
			{
				
			driver = new ChromeDriver(); //Then turn driver to static, which will reflect in Global variable on line 14
			
			} 
			
			/*else if(browserName.equals("FF")) {
				System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
				driver = new FireFoxDriver();
			}*/
			
			/*else if(browserName.equals("IE"));
				//System.setProperty("webdriver.internetexplorer.driver", "/Users/jewellmehedi/Downloads/internetexplorerdriver");
				//driver = new InternetExplorerDriver();
			}
			*/
			
			driver.get(url);
			
			driver.findElement(By.xpath(prop.getProperty("Firstname_xapth"))).sendKeys(prop.getProperty("FirstName"));
			
			driver.findElement(By.xpath(prop.getProperty("LastName_xpath"))).sendKeys(prop.getProperty("LastName"));
			
			driver.findElement(By.xpath(prop.getProperty("email_xpath"))).sendKeys(prop.getProperty("Email"));

			
			Thread.sleep(4000); //Write Static wait (Thread.sleep() ) we'll get error in red and once we put mouse on it, we'll get options for throws or try/catch block to handle it
			
			driver.quit();
			
	}
	
}
