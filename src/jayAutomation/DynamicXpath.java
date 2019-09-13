package jayAutomation;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DynamicXpath {

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

		
		driver  .get("https://classic.crmpro.com/index.html"); 
		
		driver.findElement(By.name("username")).sendKeys("jmintegr1");
		Thread.sleep(1000);  //SEEMS LIKE IT NEEDS THREAD.SLEEP TIME FOR LOGIN BUTTON TO CLICK & WORK
		
		driver.findElement(By.name("password")).sendKeys("1zengogo");
		Thread.sleep(2000); 
		
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		Thread.sleep(2000);

		
		// 3 different xpaths: //input[@value='Login']   |   input[@type='submit'] Xpath Naveen used   |   //input[@class= 'btn btn-small']
		
		// *IQ How will you handle frame?  
		
		//Ans: I will use driver.switchTo().frame() method and pass in the frame I want in the parameter
		
		
		driver.switchTo().frame("mainpanel"); //IQ*** WHAT IS THE FRAME METHOD & HOW MANY VALUES CAN IT ACCEPT & WHAT ARE THEY?
		Thread.sleep(2000);  //If there are dual frames then we have to specifically focus on the frame where the button is to click for function execution..
		 //Frame method is an overloaded method, method name is the same with different arguments.  
	
		
		//Easy way.. xpath from cropath, from WebTable same as DynamicWebTableHandle
		//driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();  //Will take it to Contact tab 
		
		//driver.findElement(By.xpath("//input[@value='52600633']")).click(); //To check box next to Nav Smith
		
		//Long way but great for learning like Naveen
		
		//driver.findElement(By.xpath("//a[text()='Nav Smith']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		
		//driver.findElement(By.xpath("//a[text()='Test Run']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
		//Let's say tomorrow I want to check the next box so just use the above link and just change Nav Smith to Test Run for the following contact box 
		
		
		//For Web Tables this type of customized preceding-sibling or forward-sibling Xpath Saves time from having to write 2 for loops and long line of codes
		
		
/*		Video How to be Genius in Xpath Time 27:00 explains Parent Sibling Method

		Step 1: Spy on Nav Smith, which is a link

		//a[text()='Nav Smith']   (Child’s)

		//parent::td[@class='datalistrow']    (Parent’s)

		//preceding-sibling::td[@class='datalistrow']   (Parent’s brother’s (Sibling’s) td)

		//input[@name='contact_id']     (cousin’s)   

 		****Exact xpath of Nav Smith’s check box!! */

		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
