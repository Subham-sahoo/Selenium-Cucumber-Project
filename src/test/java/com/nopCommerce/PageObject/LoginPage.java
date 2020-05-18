package com.nopCommerce.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "Email")
	@CacheLookup
	private WebElement UserNameEdit;

	public WebElement getUserNameEdit() {
		return UserNameEdit;
	}

    @FindBy(id = "Password")
	@CacheLookup
	private WebElement passwdEdit;

	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	private WebElement loginEdit;
	public WebElement getLoginEdit() {
		return loginEdit;
	}

	@FindBy(linkText= "Logout" )
	@CacheLookup
	private WebElement logoutEdit;
	public WebElement getLogoutEdit() {
		return logoutEdit;
	}

	public void setUserNameEdit( ) {
		UserNameEdit.clear();
		UserNameEdit.sendKeys("admin@yourstore.com");

	}

	public void setPasswdEdit() {
		passwdEdit.clear();
		passwdEdit.sendKeys("admin");
	}

	public void Loginapp() {
		
		loginEdit.click();
	}

	public void Logoutapp() {
		logoutEdit.click();
	}

}
