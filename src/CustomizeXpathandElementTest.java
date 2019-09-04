import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomizeXpathandElementTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
//		driver.get("https://www.crmpro.com/index.html");
//		
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("jmintegr1");
//		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1zengogo");
//		
//		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		driver.get("https://www.amazon.com/");
		

		Thread.sleep(3000);
		
		driver.quit();
		
	}

}
