package com.nopCommerce.StepDefination;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import com.nopCommerce.PageObject.AddCustomerPage;
import com.nopCommerce.PageObject.LoginPage;
import com.nopCommerce.PageObject.SearchCustomerNamePage;

public class BaseClass 
{
	public WebDriver driver;
	public LoginPage lgn;
	public AddCustomerPage adcust;
	public SearchCustomerNamePage searchcust;
	//Create for generating Unique email id
	
	public static String randomstring() 
	{
	String Generateemail=RandomStringUtils.randomAlphabetic(5);
	return Generateemail;
	}
}
