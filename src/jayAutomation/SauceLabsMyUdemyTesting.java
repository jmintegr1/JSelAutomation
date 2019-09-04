package jayAutomation;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SauceLabsMyUdemyTesting {
	
	  public static final String USERNAME = "jmintegr1";
	  public static final String ACCESS_KEY = "2fdf7bc5-e186-468c-8fb0-c287232fb839";
	  public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";
	 
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities caps = DesiredCapabilities.chrome();
		caps.setCapability("platform", "macOS 10.14");
		caps.setCapability("version", "69.0");

		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new RemoteWebDriver(new URL(URL), caps); //We use remoteWebDriver because we are using Saucelabs and want to remote remotely
		
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		
		
		
	}

}
  