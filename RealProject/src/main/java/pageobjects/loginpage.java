package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginpage {

	
	public WebDriver driver;
	By email=By.xpath("//input[@id='user_email']");
	By password=By.xpath("//input[@id='user_password']");
	By button=By.xpath("//input[@name='commit']");
	public loginpage(WebDriver driver)
	{   
		//constructor
		//constructor can be overloaded
		// TODO Auto-generated constructor stub
		this.driver=driver;//as local variable and gloabal variable names are same we used this
	}
	public WebElement getemail() //getlogin is called in homepage trough object
	{
		
		return driver.findElement(email);
		
		//here we are returning webelement no return type should be webelement 
		
		//email is variable that locates the element
		}
	
	public WebElement getpassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement getbutton()
	{
		return driver.findElement(button);
	}
}
///need to work this page