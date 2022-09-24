package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {

	/*




        driverfactory



         */
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	
	public WebDriver init_driver(String browser)
	{
		System.out.println("browser value is ="+browser);
		
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			//System.setProperty("webdriver.chrome.driver", "D:\\selenium\\Chrome Driver\\newchromeDriver\\chromedriver.exe");
			tlDriver.set(new ChromeDriver());
			
			//driver=new ChromeDriver();
		}
		else
			if(browser.equals("firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				tlDriver.set(new ChromeDriver());
			}
			else
				if(browser.equals("IE"))
				{
					WebDriverManager.iedriver().setup();
					tlDriver.set(new ChromeDriver());
				}
				else
				{
					System.out.println("please pass the correct browser value:"+browser);
				}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		
		return getDriver();
		
	}
	
	/**
	 * this is used to get the driver with ThreadLocal
	 * @return
	 */
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}
	

}
