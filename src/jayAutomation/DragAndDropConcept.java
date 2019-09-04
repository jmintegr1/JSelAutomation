package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

public class DragAndDropConcept {

	public static void main(String[] args) throws InterruptedException {

//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		WebDriver driver = new ChromeDriver();	
		
		WebDriver driver = new SafariDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0); //Use SwitchTo()  .frame() if FRAME is PRESENT. If only one frame then ZERO inside the frame parameter
		//To find frame, right click for page source code, then command f and type frame, will see it next to Iframe.
	
		//****IQ: How will you perform drag & drop using Selenium? 
		
		//Ans: For Drag & Drop we have to use ACTIONS class object...  
		
		Actions action = new Actions(driver);
		
		//(if asked to elaborate)
	    //action instance variable I will call .clickAndHold() method to grab the 1st box and moveToElement() to drag to the 2nd box 
		 action.clickAndHold(driver.findElement(By.id("draggable"))).moveToElement(driver.findElement(By.id("droppable"))).release().build().perform();
		                                    //Used ID here                                                .ID here
		 
		 
		 //Actions class object has Build() and Perform() method.. (think of action as to perform)
		
		 
		Thread.sleep(4000);  //Have to use throws 
		
		
		driver.quit();
	
	}

}
