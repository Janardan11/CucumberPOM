package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {

	

	
	private WebDriver driver;
	
	//1.By locators
	
	private By emailid=By.id("email");
	private By password=By.id("passwd");
	private By signInbutton=By.id("SubmitLogin");
	
	private By forgotpfd=By.linkText("Forgot your password?");
	
	//2.constructor of the page class
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	
	//3.page actions :feature of the page the form of method
	//assertion not write here ,implement in stepdefination
	
	public String getloginpagetitle()
	{
		return driver.getTitle();
	}
	
	public boolean isforgotpwdlinkExist()
	{
		return driver.findElement(forgotpfd).isDisplayed();
	}
	
	
	public void enterusername(String username)
	{
		driver.findElement(emailid).sendKeys(username);
	}
	
	public void enterpassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickonloginbutton()
	{
		driver.findElement(signInbutton).click();
	}
	
	
	public Accountpage dologin(String un,String pw)
	{
		driver.findElement(emailid).sendKeys(un);
		driver.findElement(password).sendKeys(pw);
		
		driver .findElement(signInbutton).click();
		
		return new Accountpage(driver);
	}
	
}
