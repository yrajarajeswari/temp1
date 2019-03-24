package Academy;
import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.landingpage;
import pageobjects.loginpage;
import resources.baseclass;

public class validatingpage extends baseclass{
	
//*********comparing the text from login page in equal to the actual value***********
		
	@BeforeMethod
	public void setup() throws IOException   //prerequisite before test
	{
		driver=initializedriver();
	
		driver.get(prop.getProperty("url"));
	
	}
	
	
	
		@Test
		public void basepagenavigation() throws IOException
		{
		
			//i need to call the base class method in this test case
			//through inheritance concept we can do that 
			
			//intitializedriver returns driver object 
			 //we should not pass the url here as it is global for entire scenario
			
			//we invoke landing page method here
			//we can use methods of a class trough inheritance or by objects we can 
			
			landingpage l=new landingpage(driver);
			//created object for landingpage()
			 //gets the text from loginpage (FEATURED COURSES)
			Assert.assertEquals(l.gettext().getText(),"FEATURED COURSES");
			//using assertions we compare actual value with expected value
			Assert.assertTrue(l.getnavigatebar().isDisplayed());
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		}
		@AfterTest
		public void teardown()   
		{
			//post conditions after test
			driver.close();
			
		}
      }

