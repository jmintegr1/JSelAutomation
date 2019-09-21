package jayAutomation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

//import com.sun.tools.javac.util.List;

public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;

		
//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
		//driver = new SafariDriver();
		
		//driver.manage().window().maximize(); //maximize window
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); //delete all cookies
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); 	//Dynamic wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Because it is GLOBAL wait, it will wait for all WebElements thereafter, it will wait in Dynamic fashion for the this WebElement to wait and if there were more, it will wait for those as well

		
		driver.get("https:google.com"); 
		
		//driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("java");
		
		//driver.findElement(By.id("gLFyf gsfi")).sendKeys("Java");
		
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Testing");
        
		//Step #1: First write  driver.findElements By... which will give you LIST of elementS so it store it in the List<WebElement> interface on the other side of =                                                                              
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));  //Customized Dynamic Xpath 
		                                                                                 // Use of Descendant		
		
		//Step #2: Get total count of the search topic
		System.out.println("total number of suggestions in search box:::=====>+" + list.size()); //CAN'T GET THE TOTAL COUNT OF SEARCH RESULT
		
		
		//Step #3: Now print all the elements by using for loop
		for(int i=0; i<list.size(); i++) { //list.size is giving us the length of the search list
			System.out.println(list.get(i).getText()); //This GET() method with i passing in the parameter and getText() method will print one by one 
			if(list.get(i).getText().contains("testing 1 2 3")) {
				list.get(i).click();
				break; //Is a Keyword that breaks the loop/search once it finds Java tutorial from the list
			}
		}
		
		//***IQ: What does descended means and how is it used? 
				//Ans: We are putting descended on li, it means under this particular li how many descended divs are available. This will give 
				//us the complete list of divs, complete hierarchy. Then we select which child div we'll take.
		
		Thread.sleep(3000);
		
		driver.quit();
		
		}
		                                                                                                                                                                                                                                                
	}

