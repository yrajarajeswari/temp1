package resources;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;



public class baseclass {

	
	public Properties prop;// need to declare publicly to access in other classes
	 public WebDriver driver;//we need to declare it as public to access outside the class
	 //globally initializing webdriver 
	
		public WebDriver initializedriver() throws IOException
		{
			 prop  = new Properties();//properties file is used to invoke different browsers in this project
			FileInputStream fis =new FileInputStream("D:\\Rajeswari\\RealProject\\src\\main\\java\\resources\\data.properties");//we need to link properties file to base class and all the testcases should be able to use it
		     prop.load(fis);//property method
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))// we cannot use "==" sign here as we are extracting from properties file
		{
			//execute chrome
			
			System.setProperty("webdriver.chrome.driver","C:\\Users\\Hem\\Desktop\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Hem\\Desktop\\geckodriver.exe");
			 driver =new FirefoxDriver();
		}
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.ie.driver","D:\\Rajeswari\\IEDriverServer_Win32_2.39.0\\IEDriverServer.exe");
			 driver =new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //this wait time is applied for entire script
		return driver; //here we are returning driver object so void should be changed to webdriver
		}
		
		public void getscreenshot(String result) throws IOException
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); //takes screenshot of testcases
			FileUtils.copyFile(src,new File("D:\\Rajeswari\\Personal\\test\\"+ result +"screenshot.png"));
			
			
			
			
			
			
		
			//result has the testcasename that failed
			
			//this screenshot should also be declared in testng.xml file to look for testNG listeners
			
			//we need to make the file names dynamic to store different screenshots with differnet names 
			//we need to run the script from testng.xml file to see this
		}
		
		
	}


