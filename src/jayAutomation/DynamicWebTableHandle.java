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
		
		driver.get("https://www.freecrm.com/index.html"); 
		
		driver.findElement(By.name("username")).sendKeys("jmintegr1");
		Thread.sleep(1000);  //SEEMS LIKE IT NEEDS THREAD.SLEEP TIME FOR LOGIN BUTTON TO CLICK & WORK
		
		
		driver.findElement(By.name("password")).sendKeys("1zengogo");
		Thread.sleep(2000); 
		
		driver.findElement(By.xpath("//input[@type='submit']")).click(); 
		Thread.sleep(2000);

		
		// 3 different xpaths: //input[@value='Login']   |   input[@type='submit'] Xpath Naveen used   |   //input[@class= 'btn btn-small']
		
		driver.switchTo().frame("mainpanel"); //IQ*** WHAT IS THE FRAME METHOD & HOW MANY VALUES IT CAN ACCEPT & WHAT ARE THEY?
		Thread.sleep(2000);  //If there are dual frame then you have to distinctly focus on the frame where the button is.
		                    //Frame method is an overloaded method, method name is the same with different arguments.  
		
		// *IQ How will you handle frame?   Ans: Driver dot switch To dot frame
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	
		
		                           //OnlyTR = Row, it changes.. everything else stays constant   | TD = Column 
		//form[@id='vContactsForm']//tbody//tr[4]//td[2]
		//form[@id='vContactsForm']//tbody//tr[5]//td[2]
		//form[@id='vContactsForm']//tbody//tr[6]//td[2]
		//form[@id='vContactsForm']//tbody//tr[7]//td[2]
		
		String before_xpath = "//form[@id='vContactsForm']//tbody//tr[";
		String after_xpath = "]//td[2]";
		
	
		//Method #1: 
	/*	for(int i=4; i<=7; i++) {
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if(name.contains("Nav Smith")) { // i =6
				                                                                //ROW#1 for xapth from check box 
				driver.findElement(By.xpath("//form[@id='vContactsForm']//tbody//tr["+i +"]//td[1]")).click();
				*/
				
		/*		
		for(int i=4; i<=7; i++) {   //IF I WANTED TO CHECK BOX NEXT TO TEST RUN 
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if(name.contains("Test Run")) { // i =6  | SINCE THE XPATH ARE SIMILAR EXCEPT ROW #, SO WE JUST HAVE TO PUT THE "NAME" OF THE CONTACT IN CONTAINS 
						                                                              
				driver.findElement(By.xpath("//form[@id='vContactsForm']//tbody//tr["+i +"]//td[1]")).click();
							
		
			}
		} 	*/
		
		
		//Method #2: We are using preceding / parental or sibling xpath, going backward from current  |  Forwarding sibling is for younger(next) 
		
	
		driver.findElement(By.xpath("//a[contains(text(),'Nav Smith')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		
		//Next day I want to check box next to Test Run so just get it from there or type it the name as is.. 
		driver.findElement(By.xpath("//a[contains(text(),'Test Run')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();
		
		
		//Beauty of Method #2 is that it is super efficient as it goes right to the source and perform the action. It does have to iterate from 1st row to say.. row # 500.
		//So if you had lot of rows then the "for loop" (method 1) will take more time as it has to go row by row, especially if you had lot of lines of code/rows to
		//perform the action. It is also writing less line of code.
		
		
		Thread.sleep(5000);

		driver.quit();
				
	}
}