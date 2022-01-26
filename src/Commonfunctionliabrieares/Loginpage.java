package Commonfunctionliabrieares;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Loginpage {


	WebDriver driver;
	WebDriverWait wait;

	public Loginpage(WebDriver driver){
		this.driver=driver;
	}
	
	
	@FindBy(name="btnreset")
	WebElement ClickReset;

	@FindBy(name="username")
	WebElement enterusername;
	
	@FindBy(name="password")
	WebElement enterpassword;
	
	@FindBy(name="btnsubmit")
	WebElement Clicklogin;
	
	
	@FindBy(xpath="//body/div[2]/div[2]/div[1]/div[1]/ul[1]/li[10]/a[1]")
	WebElement Clicklogout;


	public String verifylogin(String username, String password){
		
		
		String res="null";
		wait= new WebDriverWait(driver,30);
		
		ClickReset.click();
		enterusername.sendKeys(username);
		enterpassword.sendKeys(password);
		Clicklogin.click();
		
		wait.until(ExpectedConditions.visibilityOf(Clicklogout));
		
		if (Clicklogout.isDisplayed()) {
			
			Reporter.log("Testpass", true);
			res="pass";
		//System.out.println("pass");
		}else {
			Reporter.log("Test fail",true);
			//System.out.println("fail");
			res="fail";
		}
		return res;
	
		







	}

}
