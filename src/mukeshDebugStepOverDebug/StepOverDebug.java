/**
 * 
 */
package mukeshDebugStepOverDebug;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * @author jewellmehedi Debugging example from Mukesh's video
 */

public class StepOverDebug {
		
	WebDriver driver = null; //Right now it is not assigned to anything so it is pointing to null, so when test2() from line 47 is trying to 
	//run it, it says says null.quit() instead of actual driver.quit() so it will throw NullPointerException if you have line 32 active
	
	@Test
	public void test1(){
		
		//System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");

		 driver = new FirefoxDriver();
		//This is local variable, the scope of this variable is this test1() method only, sine we cannot access this "driver" outside of this method
		//so test2() will take the driver from the global variable 
		
		//WebDriver driver = new FirefoxDriver(); //However, if you have this line of code then it become an issue because then both test 1 use its local variable and because its limited scope just test 1
		 
		//Test2() cannot access driver because it  test1() limitation, to fix it just take out WebDriver so use line 28 then both tests can access driver from global variable  

		
		driver.get("http://www.naveenautomationlabs.com/");
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		
		String title = driver.getTitle();
		
		boolean value = title.contains("Naveen AutomationLabs");
		
		System.out.println("Status value is " + value);
}
	
	@Test
	public void test2(){
		driver.quit();   //This driver is coming from the global variable from line 18 
		
	}
	
}
	
