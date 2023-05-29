package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelper;

public class SearchCustomerPage {
	
   public WebDriver ldriver; 

  public WaitHelper waitHelper;

   public SearchCustomerPage(WebDriver rdriver)
   {
	   ldriver=rdriver;
	   PageFactory.initElements(rdriver, this);
	   waitHelper=new WaitHelper(ldriver);
   }
   
   @FindBy(how=How.ID,using="SearchEmail")
   WebElement txtEmail;

   @FindBy(how=How.ID,using="SearchFirstName")
   WebElement txtFirstName;
   
   @FindBy(how=How.ID,using="SearchLastName")
   WebElement txtLastName;
   
   @FindBy(how=How.ID,using="SearchMonthOfBirth")
   WebElement dobMonth;
   
   @FindBy(how=How.ID,using="SearchDayOfBirth")
   WebElement dobDate;
   
   @FindBy(how=How.ID,using="SearchCompany")
   WebElement companyName;
   
   @FindBy(how=How.XPATH,using="/html/body/div[3]/div[1]/form[1]/section/div/div/div/div[1]/div/div[2]/div[1]/div[2]/div[5]/div[2]/div/div")
   WebElement customerRoles;
   
   @FindBy(how=How.XPATH,using="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]")
   WebElement listItemAdministrators;
   
   @FindBy(how=How.XPATH,using="//*[@id=\"30a2d20c-7139-4910-8e84-99d700d81a1e\"]")
   WebElement listItemRegistered;
   
   @FindBy(how=How.XPATH,using="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]")
   WebElement listItemGuests;
   
   @FindBy(how=How.XPATH,using="//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]")
   WebElement listItemVendors;
   
   @FindBy(how=How.ID,using="search-customers")
   WebElement btnSearch;
   
   @FindBy(how=How.XPATH,using="//*[@id=\"customers-grid\"]")
   WebElement tableSearchResults;
   
   @FindBy(how=How.ID,using="//*[@id=\"customers-grid_wrapper\"]")
   WebElement table;
   
   @FindBy(how=How.ID,using="//*[@id=\"customers-grid_wrapper\"]/div[1]/div/div/div[1]/div/table/thead/tr")
   List<WebElement> tableRows;
   
   @FindBy(how=How.ID,using="//*[@id=\"customers-grid\"]/tbody/tr/td")
   List<WebElement> tableColumns;

   public void setEmail(String mail)
   {
	   
	   txtEmail.clear();
	   txtEmail.sendKeys(mail);
   }
   public void setFirstName(String fName)
   {
	   txtFirstName.clear();
	   txtFirstName.sendKeys(fName);
   }
   public void setLastName(String lName)
   {
	   txtLastName.clear();
	   txtLastName.sendKeys(lName);
   }
   public void clickSearch()
   {
	   btnSearch.click();
   }
   public int getNoRows()
   {
	   return (tableRows.size());
   }
   public int getNoColumns()
   {
	   return (tableColumns.size());
   }
   
   public boolean searchCustomerByEmailId(String email)
   {
	   boolean flag=false;
	   for(int i=1;i<=getNoRows();i++)
	   {
		   String emailId=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
		   System.out.println(emailId);
		   
		   if(emailId.equals(email))
		   {
			   flag=true;
		   }
	   }
	   return flag;
   }

   public boolean searchCustomerByName(String Name)
   {
	   boolean flag=false;
	   for(int i=1;i<=getNoRows();i++)
	   {
		   String name=table.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[3]")).getText();
		   System.out.println(name);
		   String names[]=name.split(" ");
		   if(names[0].equals("Victoria") && names[i].equals("Terces"))
		   {
			   flag=true;
		   }
	   }
	   return flag;
   }
}
