package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="Email")
	WebElement userName;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement loginBtn;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	public void setUserName(String uname)
	{
		userName.clear();
		userName.sendKeys(uname);
		
	}
	public void setPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	public void clickLogin()
	{
		loginBtn.click();
	}
	public void clickLogout()
	{
		logout.click();
	}

}
