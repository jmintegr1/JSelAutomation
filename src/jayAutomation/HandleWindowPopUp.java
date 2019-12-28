package jayAutomation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		
		//1. Alerts -- or JavaScript Pop UP -- Use: Alert API (accept, dismiss)
		//2. File upload pop up -- Browse Button (type="file" , sendKeys(the pass the path of it inside the parameter)
		//3. Browser Window Popup -- or Advertisement pop up (windowHandler API -getWindowHandles() ) method

		WebDriver driver;

		//System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver")
		//driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
		//WebDriver driver = new FirefoxDriver(); //To instantiate & initialize in one shot  
		
		//driver = new SafariDriver();
		
		
		driver.manage().window().maximize();   
		driver.manage().deleteAllCookies();
	
		//Dynamic wait aka GLOBAL wait. Dynamic because it only waits for relevant loading time, and move onto action after. Where is STATIC WAIT like Thread.sleep(); hard coded and does not save time when page fully loaded
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//Wait for page to load fully, even if few elements are not loaded yet, that's when implicit wait comes in
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Wait 30 seconds to load ALL ELEMENTS then perform actions based on the script of that certain element. Some elements may not be loaded within 40 seconds explicit wait
        //Because it is GLOBAL wait, it will wait for all WebElements thereafter, it will wait in Dynamic fashion for the this WebElement to wait and if there were more, it will wait for those as well

		
		driver.get("http://www.popuptest.com/");
			
				
		driver.findElement(By.xpath("//a[contains(text(),'Modeless Window')]")).click();
		
		Thread.sleep(2000);
		
		        //Windows ID available in handler
		Set<String> handler = driver.getWindowHandles();		

		//In Set object the values are NOT stored on index basis, so for loop will NOT work to get the values. Then how will you get the values?
		
		Iterator<String> it = handler.iterator();   //Ans: We use Iterator Interface implementing String class 
		
		String parentWindowId = it.next();
		System.out.println("parent window id:" + parentWindowId); //It will shift focus point on object in memory from above the object to the object as it points to the FIRST value of the SET (which is NOT organized on index basis)
		
		String childWindowId = it.next();   //Now it will shift from first location in memory to location below in memory to access value
		System.out.println("Child window id:"+childWindowId);
		
		driver.switchTo().window(childWindowId); //To get "Id" we have to use switchTo() 
		
		Thread.sleep(2000);  //Write Static wait (Thread.sleep() ) we'll get error in red and once we put mouse on it, we'll get options for throws or try/catch block to handle it
		
		System.out.println("child window pop up title" + driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		
		Thread.sleep(2000);
		
		System.out.println("parent window title" + driver.getTitle()); 
		
		
		driver.close();
		
		
		Thread.sleep(4000);
		
		driver.quit();

	}

}
