package mukeshDebug;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Helper {

	public static void typeIntoInputBox(WebDriver driver, String id, String text) {

		
		
		System.out.print("Trying to enter for element whose id is " + id);
		
		driver.findElement(By.id(id)).sendKeys(text);
		
		System.out.print("Text elemented for element whichh has id " + id);
			
		
	}

}
