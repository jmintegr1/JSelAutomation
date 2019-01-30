package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigations {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();   
		driver.manage().deleteAllCookies();
	
		
		//Both waits are Dynamic wait aka GLOBAL wait. Dynamic because it only waits for relevant loading time, and move onto action after. Where is STATIC WAIT like Thread.sleep(); hard coded and does not save time when page fully loaded
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Wait 40 seconds for page to load fully then perform some actions, if page loaded faster rest of the time is ignored
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Wait 30 seconds to load all elements then perform actions based on the script of that certain element. Some elements may not be loaded within 40 seconds explicit wait
		
		driver.get("https://www.google.com/"); 
		
		driver.navigate().to("https://www.amazon.com");
		
		driver.navigate().back();
		
		Thread.sleep(2000);           //*IQ How will you navigate forward and navigate browser?
		
		driver.navigate().forward();  //Called: Back & forward simulation, which I will use to anser above
		
		Thread.sleep(2000);
		
		driver.navigate().back();
		
		driver.navigate().refresh();  //How to simulate refresh?
		
		Thread.sleep(4000);        //**IQ: What is the difference between driver.navigate to vs. driver.get?
                            //Well both are used to launch the url, and navigate comes after to basically move navigate away from first webpage or domain
		
		driver.quit();
		
		
		
	}

}
