package jayAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class FindElementsConcept {

		
		
		public static void main(String[] args) throws InterruptedException {
			
			WebDriver driver;

//			System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//			WebDriver driver = new ChromeDriver();
			
			System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
			driver = new FirefoxDriver();
			
			driver = new SafariDriver(); // If I want to run it on Safari, seems like now I don't need to download the safari driver as long as I activate it from preferences and Developer menu for automation  
			
			driver.manage().window().maximize();   
			driver.manage().deleteAllCookies();
		
			
			//Both waits are Dynamic wait aka GLOBAL wait. Dynamic because it only waits for relevant loading time, and move onto action after. Where is STATIC WAIT like Thread.sleep(); hard coded and does not save time when page fully loaded
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Wait 40 seconds for page to load fully then perform some actions, if page loaded faster rest of the time is ignored
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); //Wait 30 seconds to load all elements then perform actions based on the script of that certain element. Some elements may not be loaded within 40 seconds explicit wait
            //Because it is GLOBAL wait, it will wait for all WebElements thereafter, it will wait in Dynamic fashion for the this WebElement to wait and if there were more, it will wait for those as well

			driver.get("https://www.ebay.com/"); 
		
			
			//All the links are represented by < a > html TAG so use tagName(): 
//			List<WebElement> courageList = driver.findElements(By.tagName("a")); //Use "a" because <a> tag stands for All the links  
//			                                //In .findElements with By.tagName() object we don't have to use .click or .sendKeys
//			
//			//Size of LinkedList:
//			System.out.println(courageList.size()); //Just link size total 
			
//			1. ****IQ: How to get the TOTAL COUNT of all the LINKS, INPUT, or BUTTON FIELDS that are on a page?
//			
//			Ans: I will use driver.findElements(By.tagName("A") and pass "A" in the parameter since it is tag we are looking for then 
//			initialize it with List interface <WebElement> in generic and use its instance variable to call the size() in PLS.
//			
			
			
//			//How many input are there?
//			
//			List <WebElement> linkList2 = driver.findElements(By.tagName("input"));  //****How to use By.tagName & why?  
//			                         //When use .findElements to initialize than on left hand side of = use List <WebElement> to store links or the tag
//			
//			System.out.println(linkList2.size());

			
			
			
			//How many buttons are there?

//			List <WebElement> btn = driver.findElements(By.tagName("button"));  
//
//			System.out.println(btn.size());

			
			
			 
			//2. **IQ: How to get the TEXT of each LINK on the page?
			
			//Remember how to iterate Array or ArrayList? How to print all the vales of an Array ArrayList? 
			
			// Ans: To print all values & text we use for loop:
			 
			//Step A: Instantiate List Interface with tagName() method and pass in "A"
			List <WebElement> AllText = driver.findElements(By.tagName("a")); 
			             
			//Step B: Get Size
			System.out.println(AllText.size());  //.size(); Gives the count of all the links 
			 
			//Step C: for loop 
			for(int i=0; i<AllText.size(); i++) {            //.get(); method to get 1st link to start until loop is over
					String name = AllText.get(i).getText(); //Now we store the text inside an instantiated object: name
					System.out.println(name);           //.getText() method is to get the TEXT
			}
			
			
			Thread.sleep(4000);
			
			driver.quit();
			
	}

}
