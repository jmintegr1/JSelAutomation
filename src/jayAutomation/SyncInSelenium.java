package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SyncInSelenium {

	public static void main(String[] args) {
		
		WebDriver driver;

//		System.setProperty("webdriver.chrome.driver", "	WebDriver driver = new SafariDriver();\n");
//		driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");
		driver = new FirefoxDriver();
		
		//driver = new SafariDriver();
		
		driver.get("https://app.hubspot.com/login");

		//only for browser page loading
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//for all the elements -- global wait -- implicit wait
		
		
		//explicit wait:
		//used for the specific element
		WebElement username = driver.findElement(By.id("username"));sendKeys(driver, username, 5, "jmintegr1@gmail.com");
		
		WebElement pwd = driver.findElement(By.id("password"));sendKeys(driver, pwd, 5, "1Zengogo");
		
		WebElement signUp = driver.findElement(By.id("loginBtn"));clickOn(driver, signUp, 3);
		
	}
	
	public static void clickOn(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
	
	public static void sendKeys(WebDriver driver, WebElement element, int timeout, String value) {
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}
	
	public static String getElementText(WebDriver driver, WebElement element, int timeout) {
		new WebDriverWait(driver, timeout).
		until(ExpectedConditions.visibilityOf(element));
		return element.getText();
		
		
	}

}