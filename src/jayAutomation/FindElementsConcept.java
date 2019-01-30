package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.tools.javac.util.List;

public class FindElementsConcept {

		
		
		public static void main(String[] args) throws InterruptedException {

			System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
			
			WebDriver driver = new ChromeDriver();
			
			
			driver.manage().window().maximize();   
			driver.manage().deleteAllCookies();
		
			
			//Both waits are Dynamic wait aka GLOBAL wait. Dynamic because it only waits for relevant loading time, and move onto action after. Where is STATIC WAIT like Thread.sleep(); hard coded and does not save time when page fully loaded
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Wait 40 seconds for page to load fully then perform some actions, if page loaded faster rest of the time is ignored
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Wait 30 seconds to load all elements then perform actions based on the script of that certain element. Some elements may not be loaded within 40 seconds explicit wait
			
			driver.get("https://www.facebook.com/"); 
			
			
			//1. **IQ: How to get the total count of all the links on the page?
			//2. **IQ: How to get the text of each link on the page?
			
			//All the links are represented by <a> html tag: 
			
			
			//Naveen had this
			//import up top but this import only works here next to List
			java.util.List<WebElement> linkList = driver.findElements(By.tagName("a"));  
			                        //Object name linkList or it can be anything 
			
			java.util.List<WebElement> linkList2 = driver.findElements(By.tagName("input"));  //****How to use By.tagName & why?
			
			java.util.List<WebElement> anyName = driver.findElements(By.tagName("button"));  

			
			//***IQ: How many buttons are there, or how many a or input?
			
			
			//Size of linkList:
			System.out.println(linkList.size());
			
			System.out.println(linkList2.size());
			
			System.out.println(anyName.size());
			
			//To print all text we use for loop
			for(int i=0; i<linkList.size(); i++) {
					String linkText = linkList.get(i).getText();
					System.out.println(linkText);
			}
			
			
			for(int i=0; i<linkList2.size(); i++) {
				String anyObject = linkList2.get(i).getText();
				System.out.println(anyObject);
			}
			
				
			Thread.sleep(4000);
			
			driver.quit();
	
	}

}
