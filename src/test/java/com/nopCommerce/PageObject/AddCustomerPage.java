package com.nopCommerce.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	public WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
By Customer_Menu =By.xpath("//body[@class='skin-blue sidebar-mini']/div[@class='wrapper']/div[@class='main-sidebar']/div[@class='sidebar']/ul[@class='sidebar-menu tree']/li[4]/a[1]/span[1]");
By customer_menu_item=By.xpath(" //li[@class='treeview menu-open']//li[1]//a[1]");
By Addnewbuttom=By.xpath(" //a[@class='btn bg-blue']");
By EnterEmail=By.xpath("//input[@id='Email']");
By EnterPassword=By.xpath("//input[@id='Password']");
By FirstName=By.xpath(" //input[@id='FirstName']");
By LastName=By.xpath(" //input[@id='LastName']");
By Male=By.xpath("//input[@id='Gender_Male']");
By Female=By.xpath("//input[@id='Gender_Female']");
By dob=By.xpath("//input[@id='DateOfBirth']");
By CompanyName=By.xpath("//input[@id='Company']");
By Customer_Role=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
By Customer_Admin=By.xpath("//li[contains(text(),'Administrators')]");
By Customer_Moderate=By.xpath("//li[contains(text(),'Forum Moderators')]");
By Customer_Guest=By.xpath("//li[@class='k-item k-state-hover']");
By Customer_Register=By.xpath("//li[contains(text(),'Registered')]");
By Customer_Vendor=By.xpath("//li[@class='k-item k-state-hover']");
By Movender=By.xpath("//select[@id='VendorId']");
By Comment=By.xpath("//textarea[@id='AdminComment']");
By Save=By.xpath(" //button[@name='save']");

//Action Method

public String getPageTitle() {
	return ldriver.getTitle();
}

public void AddCustomer_Menu() {
	ldriver.findElement(Customer_Menu).click();
}
public void Customer_menu_item() {
	ldriver.findElement(customer_menu_item).click();
}
public void Addnewbuttom() {
	ldriver.findElement(Addnewbuttom).click();
}
public void EnterEmail(String email) {
	ldriver.findElement(EnterEmail).sendKeys(email);
}
public void EnterPassword(String password) {
	ldriver.findElement(EnterPassword).sendKeys(password);
}
public void FirstName(String fname) {
	ldriver.findElement(FirstName).sendKeys(fname);
}
public void LastName (String lname) {
	ldriver.findElement(LastName).sendKeys(lname);
}public void Gender(String gender) {
	if(gender.equals("Male")) {
		ldriver.findElement(Male).click();
	}else {
		if(gender.equals("Female"));
		ldriver.findElement(Female).click();
	}
}
public void dob (String DOB) {
	ldriver.findElement(dob).sendKeys(DOB);;
}
public void CompanyName(String Cname ) {
	ldriver.findElement(CompanyName).sendKeys(Cname);
}
public void Customer_Roleinfo(String role) throws InterruptedException {
	
	  if(!role.equals("Registered")) { 
		  Thread.sleep(3000);
	  ldriver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[text()='Registered']")); }
	 
	
	ldriver.findElement(Customer_Role).click();
	WebElement listItem = null ;
	Thread.sleep(3000);
	if(role.equals("Administrators")) {
		listItem=ldriver.findElement(Customer_Admin);
	}else if(role.equals("Forum Moderators")) {
		listItem=ldriver.findElement(Customer_Moderate);
	}
	else if(role.equals("Guests")) {
		listItem=ldriver.findElement(Customer_Guest);
	}
	else if(role.equals("Registered")) {
		listItem=ldriver.findElement(Customer_Register);
	}
	Thread.sleep(3000);
	listItem.click();
	Thread.sleep(3000);
	
	/*
	 * JavascriptExecutor js = (JavascriptExecutor)ldriver;
	 * js.executeScript("argument[0].click();",listItem);
	 */
	 
}
public void Manage_of_vendor(String value) {
	Select sel =new Select(ldriver.findElement(Movender));
	sel.selectByVisibleText(value);
}

public void Comment (String content) {
	ldriver.findElement(Comment).sendKeys(content);;
}
public void Save() {
	ldriver.findElement(Save).click();;
}

 
}


