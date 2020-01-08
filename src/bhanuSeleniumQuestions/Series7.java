package bhanuSeleniumQuestions;

import java.io.File;
import java.io.FileInputStream;           //Exception import
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Series7 {  
	
	public static void main(String[] args) throws IOException {  //So if file is not present from line 22.. you'll get FileNotFoundException then I added IOEception (InputOutPut Exception) for line 24 

//		How to work with properties file?    ALSO WATCH: PROPERTIES FILE IN SELENIUM 
		
		
		Properties OR = new Properties();  //Properties object.. here the reference variable OR assist in reading properties below
				
		                                           //.dir points to the location of your project
		File file = new File(System.getProperty("user.dir")+"/src/bhanuSeleniumQuestions/or.properties");  //Get path by right click on OR.propertiles file  below then copy from /src to the end...
		                     
		                         //To handle exception put mouse on FileInputStream here and will give option to add throws or try/catch
		FileInputStream input = new FileInputStream(file); //FileInputStream helps load all the data from properties file in ONE SHOT
		
		OR.load(input);  //Need to load by using load() method in your input stream. And throws, that's why we have 2 throws in import under package above
		
		System.out.println(OR.getProperty("userName"));
		
		System.out.println(OR.getProperty("passWord"));
		
		System.out.println(OR.getProperty("Transmutation"));
		
		//What are the java script function for selenium object location?  Or what the functions you use for locator writing?

		
		//Following-sibling
		//Preceding-sibling
		//Starts-with()
		//Ends-with()
		//Following
		//Preceding
		//Contains                //Functions we use when writing Xpath
		
		
		//nth-child(1) Supply the child # inside the parameter
		// $ (starts-with)  
		// ^ (ends-with)  
		
	}

}
