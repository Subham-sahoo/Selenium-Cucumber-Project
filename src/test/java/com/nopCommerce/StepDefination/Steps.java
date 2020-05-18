package com.nopCommerce.StepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.nopCommerce.PageObject.AddCustomerPage;
import com.nopCommerce.PageObject.LoginPage;
import com.nopCommerce.PageObject.SearchCustomerNamePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps extends BaseClass {
	
	@Given("User Launch Chrome Browser")
	public void user_Launch_Chrome_Browser() {
		System.setProperty("webdriver.chrome.driver", ".//Driver//chromedriver.exe");
		driver=new ChromeDriver();
		lgn=new LoginPage(driver);
	}

	@When("User opens the URL {string}")
	public void user_opens_the_URL(String url) {
		driver.get(url);
	    driver.manage().window().maximize();
	}

	@When("User enter Email as {string} and password as {string}")
	public void user_enter_Email_as_and_password_as(String email ,String password) {
	   lgn.setUserNameEdit();
	   lgn.setPasswdEdit();
	}

	@When("click on login")
	public void click_on_login() throws InterruptedException {
		lgn.Loginapp();
		Thread.sleep(3000);
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String Title) {
		
		  if(driver.getPageSource().contains("Login was unsuccessful.")) {
		  driver.close();
		  Assert.assertTrue(false); 
		  }else {
			   Assert.assertEquals(Title, driver.getTitle());
		}
	    
	}

	@When("User click on as Log out link")
	public void user_click_on_as_Log_out_link() throws InterruptedException {
		
		lgn.Logoutapp();
		Thread.sleep(3000);
	  	}

	@Then("close browser")
	public void close_browser() {
	   driver.quit();
	}
	
	//Add New Customer
	
	@Then("User can view Dashboard")
	public void user_can_view_Dashboard() {
		adcust=new AddCustomerPage(driver) ;
		Assert.assertEquals("Dashboard / nopCommerce administration",adcust.getPageTitle());
	}

	@When("User click on Customer menu")
	public void user_click_on_Customer_menu() throws InterruptedException {
	   Thread.sleep(3000);
	   adcust.AddCustomer_Menu();
	}

	@When("Click on customer menu item")
	public void click_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		adcust.Customer_menu_item();
	}

	@When("click on Add new button")
	public void click_on_Add_new_button() throws InterruptedException {
		adcust.Addnewbuttom();
		Thread.sleep(4000);
	}

	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
	   Assert.assertEquals("Add a new customer / nopCommerce administration",adcust.getPageTitle() );
	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		
		
		String email=randomstring()+ "@gmail.com";
		adcust.EnterEmail(email);
		adcust.EnterPassword("test123");
		
		
		adcust.FirstName("pavan");
		adcust.LastName("kumar");
		adcust.Gender("Male");
		adcust.dob("07/11/2020");
		adcust.CompanyName("ABC");
		adcust.Customer_Roleinfo("Administrators");
		Thread.sleep(2000);
		adcust.Manage_of_vendor("Vendor 2");
				
		adcust.Comment("This is for testing..........");
		}

	

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
		adcust.Save();
		Thread.sleep(3000);
	}

	@Then("user get conformation sms {string}")
	public void user_get_conformation_sms(String string) {
	    Assert.assertFalse(driver.findElement(By.tagName("body")).getText().contains( "The new customer has been  added successful"));
	}

	
	@When("Enter Customer Email")
	public void enter_Customer_Email() {
		
		searchcust=new SearchCustomerNamePage(driver);
		searchcust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searchcust.btnsearch();
		Thread.sleep(3000);
	}

	@When("User should Found email in search table")
	public void user_should_ound_emain_in_search_table() {
		boolean Status=searchcust.SearchCustomerEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(false, Status);
	}


}
