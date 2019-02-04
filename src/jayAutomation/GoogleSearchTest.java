package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.sun.tools.javac.util.List;

public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); //delete all cookies
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https:google.com"); 
		
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("java");
		
		//Step #1:                                                                         //Use of Descendant
		java.util.List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));  //Customized Dynamic xpath 
		//it works with java.util.list, UNLIKE NAVEEN'S just list<WebElement>.....
		
		//Step #2:
		System.out.println("total number of suggestions in search box:::=====>+" + list.size()); //CAN'T GET THE TOTAL COUNT OF SEARCH RESULT
		
		//Step #3: 
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("java tutorial")) {
				list.get(i).click();
				break; //Keyword that breaks the loop/search once it finds Java tutorial from the list
				
				
		//***IQ: What does descended means and how is it used? 
		//Ans: We are putting descended on li, it means under this particular li how many descended divs are available. This will give 
		//us the complete list of divs, complete hierarchy. Then we choose which child we'll take.
			}
			
		}
		
	
		
		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
