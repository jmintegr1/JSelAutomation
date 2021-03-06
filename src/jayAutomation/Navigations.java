package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Navigations {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;

//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
		//driver = new SafariDriver();
		
		
		driver.manage().window().maximize();   
		driver.manage().deleteAllCookies();
		
		//Both waits below are Dynamic wait aka GLOBAL wait. Dynamic because it only waits for relevant loading time, and move onto action after. Where is STATIC WAIT like Thread.sleep(); hard coded and does not save time when page fully loaded
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Wait 40 seconds for page to load fully then perform some actions, if page loaded faster rest of the time is ignored as it move on... implicit wait below for Elements
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Wait 30 seconds to load all Elements then perform actions based on the script of that certain Element. Some Elements may not be loaded within 30 seconds explicit wait
        //Because it is GLOBAL wait, it will wait for all WebElements thereafter, it will wait in Dynamic fashion for the this WebElement to wait and if there were more, it will wait for those as well

		driver.get("https://www.nfl.com/"); 
		
		driver.navigate().to("https://www.nba.com");
		//driver.navigate().to....
	
		driver.navigate().back();
		
		Thread.sleep(2000);           //*IQ How will you navigate backward & forward in a browser?
		
		driver.navigate().forward();  //I will use navigate() method with Back & forward() method to simulate the motion to basically perform those functions. 
		
		Thread.sleep(2000); //Write Static wait (Thread.sleep() we'll get error in red and once we put mouse on it, we'll get options for throws or try/catch block to handle it
		
		driver.navigate().back();
		
		driver.navigate().refresh();  //How to simulate refresh?
		
		Thread.sleep(5000);        //**IQ: What is the difference between driver.navigate to vs. driver.get?
                            //Well both are used to launch the url so driver.get comes First as it is populating the 1st page / url we want and then driver.navigate comes after to basically to navigate away to the following page
		driver.quit();
		
	}

}
