package AppHooks;

import java.util.Properties;

 
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

 
 
import com.qa.factory.Driverfactory;
import com.qa.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
 
 

public class applicationhooks {

private Driverfactory driverfactory;
	
	private WebDriver driver;
	
	private ConfigReader configreader;
	
	Properties prop;
	
	@Before(order=0)
	public void getproperty()
	{
		configreader=new ConfigReader();
		
		prop=configreader.init_prop();
	}

	@Before(order=1)
	public void launchbrowser()
	{
		
		String browsername=prop.getProperty("browser");
		
		driverfactory=new Driverfactory();
		
		driver=driverfactory.init_driver(browsername);
	}
	
	
	@After(order=0)
	public void quitbrowser()
	{
		driver.quit();
	}
	
	@After(order=1)
	public void screenshot(Scenario scenario)
	{
		if(scenario.isFailed())
		{
		     String screenshotname=scenario.getName().replaceAll(" ", "_");
		
	          byte[]	sourecepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	
	          scenario.attach(sourecepath,"image/png", screenshotname);
	    }
	}
	
	
	
	
	
}
