package MyTestrunner;



import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;

import io.cucumber.junit.Cucumber;
 


 //use maven arch 1.4
 

@RunWith(Cucumber.class)
@CucumberOptions( 
		features="D:\\eclipse-workspace\\CucumberPOM\\src\\test\\java\\Features\\Accountpage.feature",
 

glue= {"Stepdefinations","AppHooks"},

plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
       
		monochrome = true 
 
//tags= {"@SmokeTest"}
		            
 	)




public class mytestrunner {

}
