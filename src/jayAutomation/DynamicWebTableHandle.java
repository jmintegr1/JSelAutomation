package jayAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/Users/jewellmehedi/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); //delete all cookies
		
		//Dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://classic.crmpro.com/index.html"); 
		
		driver.findElement(By.name("username")).sendKeys("jmintegr1");
		Thread.sleep(1000);  //SEEMS LIKE IT NEEDS THREAD.SLEEP TIME FOR LOGIN BUTTON TO CLICK & WORK
		
		
		driver.findElement(By.name("password")).sendKeys("1zengogo");
		Thread.sleep(2000); 
		
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		Thread.sleep(2000);

			
		driver.switchTo().frame("mainpanel"); //IQ*** WHAT IS THE FRAME METHOD & HOW MANY VALUES IT CAN ACCEPT & WHAT ARE THEY?
		Thread.sleep(2000);  //If there are dual frame then you have to distinctly focus on the frame where the button is.
		                    //Frame method is an overloaded method, method name is the same with different arguments.  
		
		// *IQ How will you handle frame?   Ans: Driver dot switch To dot frame() and then call the Alert API
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	
		//Actual values start from row number [4] and ends @ row [7]
		//form[@id='vContactsForm']//tbody//tr[4]//td[2]   TR = in HTML means Row and only row changes.. everything else stays constant   
		//form[@id='vContactsForm']//tbody//tr[5]//td[2]
		//form[@id='vContactsForm']//tbody//tr[6]//td[2]  TD = Column is constant
		//form[@id='vContactsForm']//tbody//tr[7]//td[2]
		
		
		//Method #1:
		
//		String before_xpath = "form[@id='vContactsForm']//tbody//tr[ ";//form[@id='vContactsForm']//tbody//tr[     (6)To make it dynamic we don't include row# 6 and let the code fill in for appropriate row     ]//td[2] 
//    
//		String after_xpath = "]//td[2]"; 
//		
//		for(int i=4; i<=7; i++) {
//			//After getting the text with .getText() then store it inside String name =
//			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();  
//			System.out.println(name); //Up to this code it will print all the names
//			if(name.contains("Nav Smith")) { //i =6, means row 6 now, this can change if more names added so this code makes it dynamic and will pick the right row to print after update
//				                                                                //ROW#1 for xapth from check box 
//				driver.findElement(By.xpath("//form[@id='vContactsForm']//tbody//tr["+i + "]//td[2]")).click();
//		}	                                  
				
			
//		for(int j=4; i<=7; i++) {   //IF TOMORROW I WANTED TO CHECK BOX NEXT TO TEST RUN, below Nav Smith
//			String name2 = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
//			System.out.println(name2);
//			if(name.contains("Test Run")) { // i =6  | SINCE THE XPATH ARE SIMILAR EXCEPT ROW #, SO WE JUST HAVE TO CHANGE THE "NAME" OF THE CONTACT IN CONTAINS() 
//						                                                              
//				driver.findElement(By.xpath("//form[@id='vContactsForm']//tbody//tr["+i +"]//td[1]")).click();
//							
//			}
//		} 	
//		
		
			
			
		//METHOD #2 MY FAVORITE & recommended: We are using preceding / parental or sibling xpath, going backward from current  |  Forwarding sibling is for younger(next) 
		//Cuz if we have 50 tc and then we have to use the loop system which means 4 or 5 lines of code again and again 
	
		driver.findElement(By.xpath("//a[contains(text(),'Nav Smith')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		
//		driver.findElement(By.xpath("//input[@type='checkbox' and @name='contact_id' and @value='52600633' ]")).click(); //I DID THIS MYSELF, WHICH WAS LOT EASIER AS I WENT RIGHT FOR CHECK 
		//BOX AND JUST ADDED MORE ATTRIBUTES TILL IT IS 1 OF 1
		
		//Next day I want to check box next to Test Run so just get it from the following check and REPLACE  'Nav Smith' with 'Test Run'.. 
		driver.findElement(By.xpath("//a[contains(text(),'Test Run')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		
//		driver.findElement(By.xpath("//input[@type='checkbox' and @name='contact_id' and @value='52600634' ]")).click();  //MUCH EASIER AS I TOOK MY ABOVE CUSTOMIZED XPATH AND 
		//JUST CHANGED THE LAST DIGIT FROM 3 TO 4 
		
		//Beauty of Method #2 is that it is super efficient as it goes right to the source and perform the action. It does not have to iterate from 1st row to say.. row # 500.
		//So if you had lot of rows then the "for loop" (method 1) will take more time as it has to go row by row, especially if you had lot of lines of code/rows to
		//perform the action. It is also writing less line of code.
		
		
		Thread.sleep(5000);

		//driver.quit();
		
		}		
	}
	
