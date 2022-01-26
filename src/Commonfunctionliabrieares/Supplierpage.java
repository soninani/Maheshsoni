package Commonfunctionliabrieares;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import Utilities.Excelfileutilities;

public class Supplierpage {
	
	WebDriver driver;
	WebDriverWait wait;
	
	
	
	
	
	
	public Supplierpage(WebDriver driver){
		this.driver=driver;
	}
	

	


	
	@FindBy(id="mi_a_suppliers")
	WebElement ClickSupplierlink;
	@FindBy(xpath="//body/div[2]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/a[1]/span[1]")
	WebElement Clickaddicon;

	@FindBy(xpath="//input[@id='x_Supplier_Number']")
	WebElement snumber ;

	@FindBy(xpath="//input[@id='x_Supplier_Name']")
	WebElement entersname;
	@FindBy(xpath="//textarea[@id='x_Address']")
	WebElement enteraddress;
	@FindBy(xpath="//input[@id='x_City']")
	WebElement entercity;
	@FindBy(xpath="//input[@id='x_Country']")
	WebElement entercountry;
	@FindBy(xpath="//input[@id='x_Contact_Person']")
	WebElement entercontactperson;
	@FindBy(xpath="//input[@id='x_Phone_Number']")
	WebElement enterphonenumber;
	@FindBy(xpath="//input[@id='x__Email']")
	WebElement enteremail;
	@FindBy(xpath="//input[@id='x_Mobile_Number']")
	WebElement entermobnumber;
	@FindBy(xpath="//textarea[@id='x_Notes']")
	WebElement enternotes;

	@FindBy(xpath="//button[@id='btnAction']")
	WebElement clickadd;
	@FindBy(xpath="//button[contains(text(),'OK!')]")
	WebElement Clickok;

	@FindBy(xpath="//body/div[17]/div[2]/div[1]/div[4]/div[2]/button[1]")
	WebElement Clickokalert;


	@FindBy(xpath="//body/div[2]/div[3]/div[1]/div[1]/div[2]/div[2]/div[1]/button[1]")
	WebElement Clicksearch;
	@FindBy(xpath="//input[@id='psearch']")
	WebElement textbox;
	@FindBy(xpath="//button[@id='btnsubmit']")
	WebElement Clicksearchsymbol;
	
	
	public String suppliercreation(String sname, String add, String city, String country, 
			String person, String phonum, String email, String mobil, String notes) throws Throwable{
		
		wait=new WebDriverWait(driver, 30);
		//String res=null;
		ClickSupplierlink.click();
		Clickaddicon.click();
		
		String res4=null;
		String expectednum=snumber.getAttribute("value");
		System.out.println(expectednum);
	

			entersname.sendKeys(sname);
			enteraddress.sendKeys(add);
			entercity.sendKeys(city);
			entercountry.sendKeys(country);
			entercontactperson.sendKeys(person);
			enterphonenumber.sendKeys(phonum);
			enteremail.sendKeys(email);
			entermobnumber.sendKeys(mobil);
			enternotes.sendKeys(notes);
			
			clickadd.click();
			Clickok.click();
			wait.until(ExpectedConditions.elementToBeClickable(Clickokalert));
			Clickokalert.click();
			
			
			
			if (!textbox.isDisplayed()) 
				Clicksearch.click();
				textbox.clear();
				textbox.sendKeys(expectednum);
				
				//wait.until(ExpectedConditions.elementToBeClickable(Clicksearchsymbol));
				
				Clicksearchsymbol.click();
				WebElement actualvalue=driver.findElement(By.xpath("//table[@id='tbl_a_supplierslist']/tbody/tr/td[6]"));
				String act=actualvalue.getText();
				System.out.println(act);
				if (expectednum.equals(act)) {
					
					Reporter.log("testpass", true);
					res4="pass";
					
				}else {
					Reporter.log("testfail", true);
					res4="fail";
				}
				return res4;
			
		}
		
	
		
		
		
	}
	

