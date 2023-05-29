package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	
	WebDriver ldriver;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	By linkCustomers_menu=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a/i");
	By linkCustomers_menuItem=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	By addCustomer=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a/i");
	By email=By.xpath("//*[@id=\"Email\"]");
	By password=By.xpath("//*[@id=\"Password\"]");
	By firstName=By.xpath("//*[@id=\"FirstName\"]");
	By lastName=By.xpath("//*[@id=\"LastName\"]");
	By maleGender=By.xpath("//*[@id=\"Gender_Male\"]");
	By fGender=By.xpath("//*[@id=\"Gender_Female\"]");
	By dob=By.xpath("//*[@id=\"DateOfBirth\"]");
	By companyName=By.xpath("//*[@id=\"Company\"]");
	By customerRoles=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
	By store=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div/input");
	By listItemAdminstrators=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]");
	By listItemRegistered=By.xpath("//*[@id=\"660ec48a-756d-4f47-9e4e-019b93560959\"]");
	By listItemGuests=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");
	By listItemVendors=By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]");
	By drpmgrOfVendor=By.xpath("//*[@id=\"VendorId\"]");
	By adminContent=By.xpath("//*[@id=\"AdminComment\"]");
	By saveBtn=By.xpath("/html/body/div[3]/div[1]/form/div[1]/div/button[1]");
	

	public String getPageTitle()
	{
		return ldriver.getTitle();
	}
	public void clickOnCustomerMenu()
	{
		ldriver.findElement(linkCustomers_menu).click();;
	}
	
	public void linkCustomersMenuItem()
	{
		ldriver.findElement(linkCustomers_menuItem).click();;
	}
	
	public void addCustomer()
	{
		ldriver.findElement(addCustomer).click();;
	}
	
	public void setEmail(String mail)
	{
		ldriver.findElement(email).sendKeys(mail);
	}
	
	public void setPassword(String pwd)
	{
		ldriver.findElement(password).sendKeys(pwd);
	}
	
	public void setCutomerRoles(String role) throws InterruptedException
	{
		if(!role.equals("Vendors"));
		{
			ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]"));
		}
		
		ldriver.findElement(customerRoles).click();
		Thread.sleep(3000);
		
		WebElement listItem=null;
		if(role.equals("Administrators"))
		{
			listItem=ldriver.findElement(listItemAdminstrators);
		}
		else if(role.equals("Guests"))
		{
			listItem=ldriver.findElement(listItemGuests);
		}
		else if(role.equals("Registered"))
		{
			listItem=ldriver.findElement(listItemRegistered);
		}
		else if(role.equals("Vendors"))
		{
			listItem=ldriver.findElement(listItemVendors);
		}
		
		//listItem.click();
		
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click;", listItem);
	}
	
	public void setManagerOfVendor(String value)
	{
		Select drp=new Select(ldriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
	}
	
	public void setgender(String gender)
	{
		if(gender.equals("Male"))
		{
			ldriver.findElement(maleGender).click();
		}
		else if(gender.equals("Female"))
		{
			ldriver.findElement(fGender).click();
		}
		else
		{
			ldriver.findElement(maleGender).click(); 
		}
	}
	
	public void setFirstName(String fname)
	{
		ldriver.findElement(firstName).sendKeys(fname);
	}
	public void setLastName(String lname)
	{
		ldriver.findElement(lastName).sendKeys(lname);
	}
	public void setDob(String birth)
	{
		ldriver.findElement(dob).sendKeys(birth);
	}
	public void setCompanyName(String company)
	{
		ldriver.findElement(companyName).sendKeys(company);
	}
	public void setAdminContent(String content)
	{
		ldriver.findElement(adminContent).sendKeys(content);
		
	}
	public void clickOnSave()
	{
		ldriver.findElement(saveBtn).click();
	}
}
