package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		
//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		WebDriver driver = new ChromeDriver();
		
		WebDriver driver = new SafariDriver();
		
		driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); //delete all cookies
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Because it is GLOBAL wait, it will wait for all WebElements thereafter, it will wait in Dynamic fashion for the this WebElement to wait and if there were more, it will wait for those as well

		
		driver.get("https://classic.crmpro.com/index.html"); 
		
		driver.findElement(By.name("username")).sendKeys("jmintegr1");
		Thread.sleep(1000);  //SEEMS LIKE IT NEEDS THREAD.SLEEP TIME FOR LOGIN BUTTON TO CLICK & WORK
		
		driver.findElement(By.name("password")).sendKeys("1zengogo");
		Thread.sleep(3000); 
		
		driver.findElement(By.xpath("//input[@type='submit']")).click(); //No name, no id so customize our own xpath
		Thread.sleep(3000);

		
		// 3 different xpaths: //input[@value='Login']   |   input[@type='submit'] Xpath Naveen used   |   //input[@class= 'btn btn-small']
		
		//How will you know if there is a frame? Ans: If an element is NOT taking then check if it is in different frame. So right click around the  
		//button and click on view page source and use the name of the frame that contains the element. Then use switchTo method to.... 

		// *IQ How will you handle frame?   Ans:  I will use Driver dot switchTo(). dot frame method (side info: and in the parameter I will pass in the element)
		driver.switchTo().frame("mainpanel"); //IQ*** WHAT IS THE FRAME METHOD & HOW MANY VALUES IT CAN ACCEPT & WHAT ARE THEY?
		Thread.sleep(3000);  //If there are dual frame then we have to distinctly focus on the frame where the button is. 
		                    //So frame method is an overloaded method, therefore method name is the same with different arguments.  
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		
		Thread.sleep(5000);  
		driver.quit();
				
	}
}
