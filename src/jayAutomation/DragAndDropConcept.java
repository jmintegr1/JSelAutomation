package jayAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropConcept {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("http://jqueryui.com/droppable/");
		
		driver.switchTo().frame(0); //Switch to frame if it is present. If only one frame then zero inside frame parameter
		//To find frame, right click for page source code, then command f and type frame, will see it next to iframe.
	
		//****IQ: How will you perform drag & drop using selenium? Ans: Driver do switch to dot frame
		
		Actions action = new Actions(driver); //For D&D we have to use ACTION classes
		
		
		action.clickAndHold(driver.findElement(By.id("draggable")))  //Used ID here
		.moveToElement(driver.findElement(By.id("droppable")))
		.release()
		.build()
		.perform();
		
		Thread.sleep(4000);  //Have to use throws 
		
		driver.quit();
	
		
	}

}
