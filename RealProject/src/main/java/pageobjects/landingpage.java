package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingpage {

	
	public WebDriver driver;
	By navigatebar=By.xpath("//div/div[@class='container']/nav/ul");
	By text=By.xpath("//div[@class='text-center']/h2");
	By login=By.cssSelector("a[href*='sign_in']");//for login button clicking"
	By popup=By.xpath("//button[contains(text(),'NO THANKS')]");
	public landingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;//as local variable and gloabal variable names are same we used this
	}
	public WebElement getlogin() //getlogin is called in homepage trough object
	{
		
		return driver.findElement(login);
		
		//here we are returning webelement no return type should be webelement 
		
		//login is variable that locates the element
		}
	
	public WebElement getpopup()
	{
		return driver.findElement(popup);
	}
	public WebElement gettext()
	{
		return driver.findElement(text);
	}
	public WebElement getnavigatebar()
	{
		return driver.findElement(navigatebar);
	}
	
}
