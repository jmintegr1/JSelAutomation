package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); //delete all cookies
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html"); 
		
		driver.findElement(By.name("username")).sendKeys("jmintegr1");
		Thread.sleep(1000);  //SEEMS LIKE IT NEEDS THREAD.SLEEP TIME FOR LOGIN BUTTON TO CLICK & WORK
		
		driver.findElement(By.name("password")).sendKeys("1zengogo");
		Thread.sleep(3000); 
		
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		Thread.sleep(3000);

		
		// 3 different xpaths: //input[@value='Login']   |   input[@type='submit'] Xpath Naveen used   |   //input[@class= 'btn btn-small']
		
		driver.switchTo().frame("mainpanel"); //IQ*** WHAT IS THE FRAME METHOD & HOW MANY VALUES IT CAN ACCEPT & WHAT ARE THEY?
		Thread.sleep(2000);  //If there are dual frame then you have to distinctly focus on the frame where the button is
		                    //Frame method is overloaded method, method name is the same with different arguments  
		// *IQ How will you handle frame?   Ans: Driver do switch to dot frame
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		
		Thread.sleep(5000);

		driver.quit();
				
	}
}
