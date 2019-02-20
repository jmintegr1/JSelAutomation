package jayAutomation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		

		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html"); 
		
		//driver.get("https://makemysushi.com/404?");  //Couldn't get it to run 
		
		driver.findElement(By.name("username")).sendKeys("naveenautomation");
		Thread.sleep(1000);  //SEEMS LIKE IT NEEDS THREAD.SLEEP TIME FOR LOGIN BUTTON TO CLICK & WORK
		
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(2000); 
		
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		Thread.sleep(2000);

		
		driver.switchTo().frame("mainpanel"); //IQ*** How will check the total number of links that are available bye dot tag name? How will check that Links are not broken?
		Thread.sleep(2000);
		
		//links -- //a <http://www.google.com            //To check broken links for both: 1st We collect all the links then we go one by one and check the 
		//images -- //img href <http://www.test.com>     //;correct links with img href or not.
		
		//1. Get list of all links & images:   500 total links
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		linkList.addAll(driver.findElements(By.tagName("img")));
		
		System.out.println("Size of full lninks & images--->"+ linkList.size());

		
		List<WebElement> activeLinks = new ArrayList<WebElement>();  //450 cuz This object filters out 50 links that does not have href properties
		
		//2. Iterate linkList:   exclude all the links/images - doesn't have any href attributes 
		for(int i=0; i<linkList.size(); i++) {
			System.out.println(linkList.get(i).getAttribute("href"));
			if(linkList.get(i).getAttribute("href") != null && (! linkList.get(i).getAttribute("href").contains("javascript"))){
				activeLinks.add(activeLinks.get(i));
			}
		}
		
		
		//Get the size of active links list: 
		System.out.println("Size of active lninks & images--->"+ activeLinks.size());  //Only getting full links & images, NOT active links & images 
		
		//3. Check the href url, with httpconnection api:
		
		//Response code:  200 --OK
		//404 -- Not Found
		//500 -- Internal error
		//400 -- Bad request
		
		for(int j=0; j<activeLinks.size(); j++) {
			
		HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
		
		connection.connect();
		String response = connection.getResponseMessage(); //Ok  or return error
		connection.disconnect();
		System.out.println(activeLinks.get(j).getAttribute("href") + "--->" + response );
			
		}
		
		//In the console once you get complete list of all links and find broken links, those are the ones we report as bugs
	}

}
