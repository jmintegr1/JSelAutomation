package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class HandleFileUploadPopUp {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver; 
		
//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
		//WebDriver = new FirefoxDriver(); To do it in one shot
		
		//driver = new SafariDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Because it is GLOBAL wait, it will wait for all WebElements thereafter, it will wait in Dynamic fashion for the this WebElement to wait and if there were more, it will wait for those as well

		
		driver.get("https://html.com/input-type-file/");
		
		//Do not use .click on browser button or choose file, then you are stuck coz that will take you away from browser and into your computer and selenium is web based, not desktop based  
		driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("/Users/jewellmehedi/Documents/Naveen's Automation Lab Notes.docx");
		                                                //So use .sendKeys then pass the values of file path where the data I want to upload from..
		
		//It will ONLY work if have ** type="file" ** attribute/value is available when you spy/inspect the element
		//Just spy by inspector and get the element key....

		//****IQ  100% asked: How to do you handle window's or computer's file upload popups?   
		//Ans - After I get the xpath or locator (element key) INSTEAD of using .click method.. I'll use .sendKeys() method TO up load 
		//..the file from whatever directory by using the file path. (To get the path in mac, high light the directory, right click & hold option and copy it then put it in .sendKeys() method parameter) 
				
		Thread.sleep(4000);  //Write Static wait (Thread.sleep() ) we'll get error in red and once we put mouse on it, we'll get options for throws or try/catch block to handle it
		
		driver.quit();
	}

}
