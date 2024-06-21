package org.stepdefinition;

import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.dockerjava.api.model.Driver;

public class Fbid extends BaseClass {

	public Fbid() {
		PageFactory.initElements( driver, this);
	}
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(name ="pass")
	private WebElement password;
	
	@FindBy(name = "login")
	private WebElement login;

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}
}
