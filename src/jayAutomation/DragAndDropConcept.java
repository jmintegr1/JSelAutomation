package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class DragAndDropConcept {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver; 
		
//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		driver = new ChromeDriver();	
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
//		WebDriver driver = new FirefoxDriver(); //This is if we want to instantiate in one shot and not use code lines 16 & 19
		
		//driver = new SafariDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //Because it is GLOBAL wait, it will wait for all WebElements thereafter, it will wait in Dynamic fashion for the this WebElement to wait and if there were more, it will wait for those as well
		
		
		driver.get("http://jqueryui.com/droppable/");
		            
		
		 //Use SwitchTo().frame() if FRAME is PRESENT. 
		driver.switchTo().frame(0); //If only ONE frame then ZERO inside the frame parameter
		//To find frame, right click for page source code, then command f and type frame, will see it next to Iframe.
	
		//****IQ: How will you perform drag & drop using Selenium? 
		
		//Ans: For Drag & Drop we have to use ACTIONS class object...  
		
		Actions action = new Actions(driver);
		
		//(if asked to elaborate)
	    //action instance variable I will call .clickAndHold() method to grab the 1st box and call moveToElement() method to drag to the 2nd box 
		 action.clickAndHold(driver.findElement(By.id("draggable"))).moveToElement(driver.findElement(By.id("droppable"))).release().build().perform();
		                                    //Used ID here                                                .ID here
		 
		 //Actions class object has Release(), Build() and Perform() method.. (think of action as to perform)
		 
		Thread.sleep(4000);  //Write Static wait (Thread.sleep() ) we'll get error in red and once we put mouse on it, we'll get options for throws or try/catch block to handle it
		
		driver.quit();
	
	}
}
