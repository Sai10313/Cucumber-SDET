package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObjects.AddCustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	
	public WebDriver ldriver;
	public LoginPage lp;
	public AddCustomerPage acp;
	public SearchCustomerPage scp;
	
	public String randomstring()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

}
