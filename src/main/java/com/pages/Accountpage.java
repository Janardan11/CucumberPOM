package com.pages;

 

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Accountpage {

	
	private WebDriver driver;
	
	private  By accountsection=By.cssSelector("div#center_column span");
	
	
	public Accountpage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public String accountpagetitle()
	{
		return driver.getTitle();
	}
	
	public int getaccountsectioncount()
	{
		
	return	driver.findElements(accountsection).size();
	}
	
	
	public List<String> getaccountsectionlist()

	{
		List<String> accountlist=new ArrayList<>();
		List<WebElement> accountheaderlist=driver.findElements(accountsection);
		
		for(WebElement ele:accountheaderlist)
		{
			String text=ele.getText();
			
			System.out.println(text);
			
			accountlist.add(text);
		}
		
		return accountlist;
	}
	
}
