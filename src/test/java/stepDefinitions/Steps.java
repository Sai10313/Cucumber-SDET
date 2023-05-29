package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass{
	
	public WebDriver driver;
	public LoginPage lp;
	
	
	@Given("User Launch Chrome Browser")
	public void user_launch_chrome_browser() {
	   System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
	   driver=new ChromeDriver();
		lp=new LoginPage(driver);
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
	  driver.get(url);
	  driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    lp.setUserName(email);
	    lp.setPassword(password);
	}

	@When("click on Login")
	public void click_on_login() {
	  lp.clickLogin();
	  Thread.holdsLock(3000);
	}

	@Then("Page title Should be {string}")
	public void page_title_should_be(String expTitle) {
	   String actTitle= driver.getTitle();
	   if(driver.getPageSource().contains("Login was unsuccessful."))
	   {
		   driver.close();
		   Assert.assertTrue(false);
	   }
	   else
	   {
		   Assert.assertEquals(actTitle,expTitle);
		   System.out.println(expTitle+" "+actTitle);
	   }
	}

	@When("The user click on logout link")
	public void the_user_click_on_logout_link() throws InterruptedException {
	   lp.clickLogout();
	   Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	  
	}
	
	// Customer feature step definitions
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
	   acp=new AddCustomerPage(driver);
	   Assert.assertEquals("Dashboard / nopCommerce administration", acp.getPageTitle());
	}

	@When("User click on the customers Menu")
	public void user_click_on_the_customers_menu() throws InterruptedException {
	   Thread.sleep(3000);
	   acp.clickOnCustomerMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		 Thread.sleep(2000);
	  acp.linkCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
	    acp.addCustomer();
	    Thread.sleep(3000);
	}

	@Then("User can we Add new customer page")
	public void user_can_we_add_new_customer_page() {
		  Assert.assertEquals("Add a new customer / nopCommerce administration", acp.getPageTitle()); 
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	   String mail=randomstring()+"@gmail.com";
	   acp.setEmail(mail);
	   acp.setPassword("sai@123");
	   
	   acp.setCutomerRoles("Guests");
	   Thread.sleep(3000);
	   
	   acp.setManagerOfVendor("Vendor 2");
	   
	   acp.setgender("Mail");
	   acp.setFirstName("Sai Kumar");
	   acp.setLastName("Gorrava");
	   acp.setDob("10/13/1998");
	   acp.setCompanyName("BusyQA");
	   acp.setAdminContent("This is for testing...!");
	   
	   
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
	   acp.clickOnSave();
	   Thread.sleep(3000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
	  Assert.assertTrue(driver.findElement(By.tagName("body")).getText().
			  contains("The new customer has been added successfully."));
	  
	}
	
	// steps to execute to search a customer by emailid
	
	
	@When("Enter customer Email")
	public void enter_customer_email() throws InterruptedException {
		scp= new SearchCustomerPage(driver);
		scp.setEmail("victoria_victoria@nopCommerce.com");
		
	}

	@When("click on search button")
	public void click_on_search_button() throws InterruptedException {
	   scp.clickSearch();
	   Thread.sleep(3000);
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() throws InterruptedException {
		boolean status=scp.searchCustomerByEmailId("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
		
	}
	
	//search customer by firstname and lastname
	@When("Enter customer FirstName")
	public void enter_customer_first_name() throws InterruptedException {
		scp= new SearchCustomerPage(driver);
		scp.setFirstName("Victoria");
		Thread.sleep(3000);
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() throws InterruptedException {
	   scp.setLastName("Terces");
	   Thread.sleep(3000);
	}

	@Then("User should found name in search table")
	public void user_should_found_name_in_search_table() {
	 boolean status= scp.searchCustomerByName("Victoria Terces");
	  Assert.assertEquals(true, status);
	}

}
