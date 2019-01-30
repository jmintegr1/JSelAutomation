package jayAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFileUploadPopUp {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://html.com/input-type-file/");

		driver.findElement(By.xpath("//input[@id='fileupload']")).sendKeys("/Users/jewellmehedi/Documents/Naveen's Automation Lab Notes.docx");
		
		//Do not click on choose file, then you are stuck cuz that will take away from browser to your computer and selenium is web based, not desktop based  
		//Just spy by inspector and get the element key....

		//IQ  100% asked: How to do you handle file upload popups?   Ans - After we get the xpath or element key, instead of using .click method, I'll use .sendkeys to up load 
		//the file from the what ever directory by using the file path. To get the path in mac, right click then option and copy then put it in .sendKeys method paramater 
		
		
	}

}
