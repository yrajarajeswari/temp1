package Academy;

import java.io.IOException;


import java.util.concurrent.TimeUnit;
//import java.util.logging.LogManager;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.testng.log4testng.Logger;

import pageobjects.landingpage;
import pageobjects.loginpage;
import resources.baseclass;

public class homepage extends baseclass{
	
	@BeforeMethod
	public void setups() throws IOException
	{
		driver=initializedriver();
		
	}
	
	
	@Test(dataProvider="getdata") //using dataprovider data 
	public void basepagenavigation(String username,String password) throws IOException
	{
		//we need to pass parameters in arguments because it should know the return types 
		//i need to call the base class method in this test case
		//through inheritance concept we can do that 
		
		//intitializedriver returns driver object 
		driver.get(prop.getProperty("url"));
		 //we should not pass the url here as it is global for entire scenario
		
		//we invoke landing page method here
		//we can use methods of a class trough inheritance or by objects we can 
		
		landingpage l=new landingpage(driver);//created object for landingpage()
		loginpage lp=new loginpage(driver);//connecting loginpage 
		
		
		
		l.getpopup().click();
		l.getlogin().click();
		lp.getemail().sendKeys(username);
		lp.getpassword().sendKeys(password);
		
		lp.getbutton().click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
		//multiple data with testng
		@DataProvider   
		public Object[][] getdata()  //returns object array 
		{
			Object[][] data=new Object[2][2];  //created object array for different sets of data users
			data[0][0]="abc@qw.com";
			data[0][1]="123456A";
		    //first row for unrestricted user passing two values email and pwd
		    
		   data[1][0]="xyz@qw.com";
		   data[1][1]="abcde";
		 // 2nd row for restricted user
		   
		   return data;  //we need to return data to access the data provider test
			//count of parameter arguments should be equal to the data passing in each row in object array
					
		}

	
	@AfterTest
	public void teardowns()
	{
		driver.close();
		
	}

}
