package Stepdefinations;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;

import com.pages.Accountpage;
import com.pages.Loginpage;
import com.qa.factory.Driverfactory;
import com.qa.util.ConfigReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Accountpagestep {

	private Loginpage loginpa=new Loginpage(Driverfactory.getDriver());
	
	private Accountpage accountpage;
	
 private 	ConfigReader configreader;
	
	Properties prop;
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application( ) {
		
	
	
	configreader=new ConfigReader();
	prop=configreader.init_prop();
		
	String uname=	prop.getProperty("username");
	String password=	prop.getProperty("password");
	
	System.out.println(uname+"   "+password);
		
		Driverfactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
		accountpage= loginpa.dologin(uname, password);
	}
	 
	
	/*
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		
		
	 List<Map<String,String>>	credlist=dataTable.asMaps();
	 
	String username= credlist.get(0).get("username");
	String password= credlist.get(0).get("password");
	     
	Driverfactory.getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	accountpage=loginpa.dologin(username, password);
	}
*/
	@Given("user is on account page")
	public void user_is_on_account_page() {
		
	String title=	accountpage.accountpagetitle();
	System.out.println("accountpagetitle"+title );
	     
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable sectiontable) {
		
		List<String> expectedaccountsectionlist=sectiontable.asList();
		
		System.out.println("Expected account section list="+expectedaccountsectionlist);
	List<String> actualaccountsectionlist=	accountpage.getaccountsectionlist();
	
	System.out.println("Actual account section list="+actualaccountsectionlist);
	
	Assert.assertTrue(expectedaccountsectionlist.containsAll(actualaccountsectionlist));
		
	    
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer int1) {
		
		Assert.assertTrue(accountpage.getaccountsectioncount()==int1);
		
	   
	}

}
