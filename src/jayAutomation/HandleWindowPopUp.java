package jayAutomation;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindowPopUp {

	public static void main(String[] args) throws InterruptedException {
		
		//1. Alerts -- or JavaScript Pop UP -- Use: Alert API (accept, dismiss)
		//2. File upload pop up -- Browse Button (type="file" , sendKeys(path)
		//3. Browser Window Popup -- or Advertisement pop up (windowHandler API -getWindowHandles() ) method


		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();   
		driver.manage().deleteAllCookies();
	
		
		//Dynamic wait aka GLOBAL wait. Dynamic because it only waits for relevant loading time, and move onto action after. Where is STATIC WAIT like Thread.sleep(); hard coded and does not save time when page fully loaded
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);//Wait for page to load fully, even if few elements are not loaded yet, that's why implicit wait comes in
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Wait 30 seconds to load ALL ELEMENTS then perform actions based on the script of that certain element. Some elements may not be loaded within 40 seconds explicit wait
		
		
		driver.get("http://www.popuptest.com/");
		
		driver.findElement(By.xpath("//a[contains(text(),'Modeless Window')]")).click();
		
		Thread.sleep(2000);
		
		        //Windows ID available in handler
		Set<String> handler = driver.getWindowHandles();
		//In Set object the values are NOT stored on index basis, so for loop will not work to get the values. The how will you get the values?
		
		//Ans: We have to use iterator method 
		Iterator<String> it = handler.iterator();
		
		String parentWindowId = it.next();
		System.out.println("parent window id:" + parentWindowId); //It will shift focus point on object in memory from above the object to the object as it points to the FIRST value of the SET (which is NOT organized on index basis)
		
		String childWindowId = it.next();   //Now it will shift from first location in memory to location below in memory to access value
		System.out.println("Child window id:"+childWindowId);
		
		driver.switchTo().window(childWindowId); //To get "Id" we have to switch
		
		Thread.sleep(2000);
		
		System.out.println("child window pop up title"+driver.getTitle());
		
		driver.close();
		
		driver.switchTo().window(parentWindowId);
		
		Thread.sleep(2000);
		
		System.out.println("parent window title" + driver.getTitle()); 
		
		
		driver.close();
		
		
		//Thread.sleep(4000);
		
		//driver.quit();
		
		
		
		

		
	}

}
