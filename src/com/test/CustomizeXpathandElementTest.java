package com.test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class CustomizeXpathandElementTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;
//		
//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		
//		driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");   //FireFox Driver added
		driver = new FirefoxDriver();
		
		//WebDriver driver = new SafariDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("https://www.crmpro.com/index.html");
				
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("jmintegr1");
		//Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("1zengogo");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(4000);
		
		driver.quit();
		
		
	}

}
