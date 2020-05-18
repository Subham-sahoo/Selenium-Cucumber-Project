package com.nopCommerce.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.nopCommerce.Utility.WaitHelper;


public class SearchCustomerNamePage {
public WebDriver ldriver;
public WaitHelper waithelper;
public SearchCustomerNamePage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper=new WaitHelper(ldriver);
	}
	
	@FindBy(how=How.ID,using="SearchEmail")
	@CacheLookup
	WebElement txtemail;
	
	@FindBy(how=How.ID,using="SearchFirstName")
	@CacheLookup
	WebElement txtfname;
	
	@FindBy(how=How.ID,using="SearchLastName")
	@CacheLookup
	WebElement txtlname;
	
	@FindBy(how=How.ID,using="SearchMonthOfBirth")
	@CacheLookup
	WebElement mob ;
	
	@FindBy(how=How.ID,using="SearchDayOfBirth")
	@CacheLookup
	WebElement dob  ;
	
	@FindBy(how=How.ID,using="SearchCompany")
	@CacheLookup
	WebElement  txtcompany ;
	
	@FindBy(how=How.ID,using="SearchIpAddress")
	@CacheLookup
	WebElement txtipadd;
	
	@FindBy(how=How.XPATH,using="//div[@class='k-multiselect-wrap k-floatwrap']")
	@CacheLookup
	WebElement txtrole;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Administrators')]")
	@CacheLookup
	WebElement  admin;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Forum Moderators')]")
	@CacheLookup
	WebElement Moderators ;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Guests')]")
	@CacheLookup
	WebElement  Guests;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Registered')]")
	@CacheLookup
	WebElement Registered ;
	
	@FindBy(how=How.XPATH,using="//li[contains(text(),'Vendors')]")
	@CacheLookup
	WebElement Vendors ;
	
	
	@FindBy(how=How.ID,using="search-customers")
	@CacheLookup
	WebElement  btnsearch;
	
	@FindBy(how=How.XPATH,using="//table[@role='grid']")
	@CacheLookup
	WebElement btnSearchResult; 
	
	@FindBy(how=How.XPATH,using="//table[@id='customers-grid']")
	@CacheLookup
	WebElement table; 
	
	@FindBy(how=How.ID,using="//table[@id='customers-grid']//tbody/td")
	@CacheLookup
	List<WebElement> rows; 
	
	@FindBy(how=How.ID,using="//table[@id='customers-grid']//tbody/td/tr")
	@CacheLookup
	List<WebElement> colomns; 
	
public void setEmail(String emaill) {
		waithelper.WaitforElement(txtemail,30);
		txtemail.clear();
		txtemail.sendKeys(emaill);
	}
public void setFirstName(String fnme) {
	waithelper.WaitforElement(txtfname,30);
	txtfname.clear();
	txtfname.sendKeys(fnme);
		
	}
public void setlastname(String lnme) {
	waithelper.WaitforElement(txtlname,30);
	txtlname.clear();
	txtlname.sendKeys(lnme);
		
}
public void btnsearch() {
	btnSearchResult.click();
	waithelper.WaitforElement(btnSearchResult,30);
}
public int noofrows() {
	return rows.size();
	
}
public int noofcoloums() {
	return colomns.size();
	
}

public boolean SearchCustomerEmail(String email)
{
	boolean flag= false;
	
	for(int i=0;i<noofrows();i++) {
		String emailid=table.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+i+"]/td[2]")).getText();
		
		System.out.println(emailid);
		if(emailid.equals(email)) {
			flag=true;
		}
		
	}
	return flag;
	
}

	
	
	}
