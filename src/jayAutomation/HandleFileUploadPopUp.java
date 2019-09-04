package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class HandleFileUploadPopUp {

	public static void main(String[] args) throws InterruptedException {

		
//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new SafariDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://html.com/input-type-file/");
		
		//Do not use .click on browse button or choose file, then you are stuck coz that will take you away from browser and into your computer and selenium is web based, not desktop based  
		driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("/Users/jewellmehedi/Documents/Naveen's Automation Lab Notes.docx");
		                                                //So use .sendKeys then pass the values of file path where the data I want to upload...
		
		//It will ONLY work if have ** type="file" ** attribute/value is available when you spy/inspect the element
		//Just spy by inspector and get the element key....

		//****IQ  100% asked: How to do you handle window's or computer's file upload popups?   Ans - After I get the xpath or locator (element key) INSTEAD of using .click method, I'll use .sendKEYS method TO up load 
		//..the file from whatever directory by using the file path. (To get the path in mac, high light the directory, right click & hold option and copy it then put it in .sendKeys method parameter) 
				
		Thread.sleep(4000);
		
		//driver.quit();
	}

}
