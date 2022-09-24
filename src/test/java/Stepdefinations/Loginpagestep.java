package Stepdefinations;

import org.junit.Assert;

import com.pages.Loginpage;
import com.qa.factory.Driverfactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

 

public class Loginpagestep {

	
	private static String titlename;
	private Loginpage loginpa=new Loginpage(Driverfactory.getDriver());
	
	
	
	 

	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		Driverfactory.getDriver()
		.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		
	    
	}
	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	     
		titlename=loginpa.getloginpagetitle();
		
		System.out.println("login page title is" +titlename);
	}
	@Then("page title should be {string}")
	public void page_title_should_be(String string) {
		
		Assert.assertTrue(titlename.contains(string));
	     
	}


	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		
		Assert.assertTrue(loginpa.isforgotpwdlinkExist());
	     
	}

	@When("user enters username {string}")
	public void user_enters_username(String username) {
		
		loginpa.enterusername(username);
	     
	}

	@When("user enters password {string}")
	public void user_enters_password(String password) {
		
		loginpa.enterpassword(password);
	    
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		
		loginpa.clickonloginbutton();
	     
	}
	
	 
	 
	
}
