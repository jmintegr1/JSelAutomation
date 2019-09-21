package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;   //Alert class (alert api) imported from selenium 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class AlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver;

		
//		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
//		driver = new ChromeDriver();
		
		System.setProperty("webdriver.gecko.driver", "/Users/jewellmehedi/Downloads/geckodriver");   //FireFox Driver added
		driver = new FirefoxDriver();
				
		//driver = new SafariDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		
		driver.findElement(By.name("proceed")).click(); //Clicking on GO button
		
		Thread.sleep(5000);
		
		          //driver.switchTo().alert() will give us an alert class object by storing it in the Alert class reference variable on the other side of = 
		Alert alt = driver.switchTo().alert();  //Alert API is in selenium so we need to import it from selenium  //This shift the focus to the pop up box 
		
		//IQ 100% asked: How will you handle web alerts, or web based popups, or JavaScript popups?  //They can ask the method name, write the code of the switch method

		
		//Ans: I will use ALERT API to handle alerts so we need to switch to the alert window & then we can call the ALERT API.
		               
		//So I have to switch from popups, to where the CONTROL should be by using:  Alert alt = driver.switchTo().alert() methods 
		
		
		//(Maybe this sentence is needed: then use .getText() method, validate using  if/else statement and finally accept
		
		System.out.println(alt.getText());  //So use getText() method to get that "text message" of that particular alert so put it in print line statement's parameter 
		
	      
		//We use alert to make sure the popup message is as it is expected and nothing different hence = TC is passed 
		
		String text = alt.getText(); //Now bring the alert.getText() method from print line statement and create a reference variable that stores the text with this method & use its instance variable 
		                              //in if / else condition to validate
		
		if(text.equals("Please enter a valid user name")){  //This if/else statement helps with the validation point 
			System.out.println("correct alert message Dudeee");
		}
		else {
			System.out.println("in-coreect alert message");
		}
		
		alt.accept();//This will Click on the OK button of the message on Alert, since there is no element then just the method will do 
		
		Thread.sleep(3000);
				
		driver.quit();
		
		//alert.dismiss(); //To click on cancel button if there is a button for dismissal, then use this method but here we don't have it so keep it commented out 
		
	}

}
