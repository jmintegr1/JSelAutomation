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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrokenLinkTest {

	public static void main(String[] args) throws InterruptedException, MalformedURLException, IOException {
		
		WebDriver driver;
		
//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
		//driver = new SafariDriver();
		
		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS); //Dynamic wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html"); 
		
		//driver.get("https://makemysushi.com/404?"); I think this page was designed to give Not Found status code
		
		driver.findElement(By.name("username")).sendKeys("naveenautomation");
		Thread.sleep(1000);  //SEEMS LIKE IT NEEDS THREAD.SLEEP TIME FOR LOGIN BUTTON TO CLICK & WORK
		
		driver.findElement(By.name("password")).sendKeys("test@123");
		Thread.sleep(2000); 
		
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		Thread.sleep(2000);

		driver.switchTo().frame("mainpanel");  //How will you check that Links are not broken?
		Thread.sleep(2000);
		
		//Links: are available in the form of <a Tag followed by href = <a heref | I want to go to this url: http://www.google.com     //To check broken links for both: 1st We collect all the links then we go one by one and check the 
		//Images: are associated with <img tag |  href <http://www.test.com>     //;correct links with img & href or not, so we have to check for links and images. To do this manually it is extremely time consuming, so we automate this. 
		
		//1. Get list of all the links & images, by WebElement extending List interface: say it has 500 total links
		
		//IQ*** How will you check the total number of links that are available by .tagName()?
		List<WebElement> linkList = driver.findElements(By.tagName("a"));  //Will get the total <a tags (links) in the list object
		linkList.addAll(driver.findElements(By.tagName("img")));          //Will get the total img (images)  
		
		System.out.println("Size of full lninks & images--->"+ linkList.size());

		
		List<WebElement> activeLinks = new ArrayList<WebElement>();  //Now say 450 cuz, this object filters out 50 links that does not have href properties
		
		//2. Iterate reference variable (linkList): to exclude all the links/images that doesn't have any href attributes 
		for(int i=0; i<linkList.size(); i++) {
			System.out.println(linkList.get(i).getAttribute("href"));
			if(linkList.get(i).getAttribute("href") != null && (! linkList.get(i).getAttribute("href").contains("javascript"))){ //This line of code and ! means NOT so it if it contains Javascript, even with href then exclude it
				activeLinks.add(activeLinks.get(i));
			}
		}
		
		//Get the size of active links list: 
		System.out.println("Size of active lninks & images--->"+ activeLinks.size());  //Only getting full links & images, NOT active links & images, no href  
		                                         
		//3. Check the href url, with http connection api:
		
		for(int j=0; j<activeLinks.size(); j++) {
			
		HttpURLConnection connection = (HttpURLConnection) new URL(activeLinks.get(j).getAttribute("href")).openConnection();
		
		connection.connect();
		String response = connection.getResponseMessage(); //Ok  or return error
		connection.disconnect();
		System.out.println(activeLinks.get(j).getAttribute("href") + "--->" + response );
		
		//Response codes will indicate which links are broken or or ok:  
		//200 --OK
		//404 -- Not Found
		//500 -- Internal Server Error
		//400 -- Bad request		
		//Then in the console once we get a complete list of all links and find broken links, the broken links are the ones we report as bugs
		
		Thread.sleep(3000); //Write Static wait (Thread.sleep() ) we'll get error in red and once we put mouse on it, we'll get options for throws or try/catch block to handle it
		
		driver.quit();
			
		}
		
	}

}
