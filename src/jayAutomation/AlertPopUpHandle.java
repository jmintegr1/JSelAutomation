package jayAutomation;

import org.openqa.selenium.Alert;   //Alert class imported from selenium 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertPopUpHandle {

	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		
		driver.findElement(By.name("proceed")).click(); //Clicking on GO button
		
		Thread.sleep(5000);
		
		//IQ 100% asked: How will you handle alerts and popup?  //They can ask the method name, write the code of the switch method
		
		//Ans: the four lines below is how you answer the IQ. We have to use alert API to handle alerts. Then 
		//we have to switch to driver.switchTo.alert. then getText method and finally alert.accept method to click OK
		
		
		Alert alert = driver.switchTo().alert();  //Alert is a class so it will need to import it from selenium  //This shift the focus to the pop up box 
		
		System.out.println(alert.getText());  //So use getText method to get that "message" and put it in print line statement's parameter 
		
		String text = alert.getText();
		
		if(text.equals("Please enter a valid user name")){
			System.out.println("correct alert message");
		}
		else {
			System.out.println("in-coreect alert message");
		}
		
		alert.accept();//Click on OK button
		
		Thread.sleep(4000);
				
		driver.quit();
		
		//alert.dismiss(); //To click on cancel button if there is a button dismissal, then use this method

	}

}
