package org.stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Fblog extends BaseClass{
	Fbid f;
	
	@Given("To launch the browser and maximize the window")
	public void to_launch_the_browser_and_maximize_the_window() {
	   
		launchBrowser();
		windowMaximize();
	}

	@When("User has to pass the url of facebook appilcation")
	public void user_has_to_pass_the_url_of_facebook_appilcation() {
	  
		url("https://www.facebook.com/");
	}

	@When("User should pass the data in {string} email field")
	public void user_should_pass_the_data_in_email_field(String em) {
	    
		f = new Fbid();
		passText(em, f.getEmail());
	}

	@When("User should pass the data in {string}  password field")
	public void user_should_pass_the_data_in_password_field(String ps) {
	    
		f = new Fbid();
		passText(ps, f.getPassword());
	}

	@When("User must click the login in button for the proper process")
	public void user_must_click_the_login_in_button_for_the_proper_process() {
	   
		f = new Fbid();
		click(f.getLogin());
	}

	@Then("User should close the browser")
	public void user_should_close_the_browser() {
	  closeEntireBrowser();
	}
}
