
package Driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Commonfunctionliabrieares.Loginpage;
import Commonfunctionliabrieares.Supplierpage;
import Utilities.Excelfileutilities;

public class Apputils {

	String inputfile="C:\\Selenium live project practice\\"
			+ "Final practice project\\Test Input\\TestData.xlsx";
	String outputfile="C:\\Selenium live project practice\\Final practice project\\Test output\\output.xlsx";




	WebDriver driver;

	@BeforeMethod
	public void launchurl(){


		System.setProperty("webdriver.chrome.driver", "C:\\Selenium live project "
				+ "practice\\Final practice project\\Common drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://projects.qedgetech.com/webapp/login.php");
		driver.manage().deleteAllCookies();
	}

	@Test
	public void loginfun() throws Throwable{

		Loginpage login=PageFactory.initElements(driver, Loginpage.class);
		String resi=login.verifylogin("admin", "master");
		Reporter.log(resi);


		Excelfileutilities excel= new Excelfileutilities(inputfile);
		int row=excel.rowcount("Supplier");

		Supplierpage supplier= PageFactory.initElements(driver, Supplierpage.class);

		for (int i = 1; i <= row; i++) {

			String sname1= excel.getCellData("Supplier", i, 0);
			String add1=excel.getCellData("Supplier", i, 1);
			String cuty=excel.getCellData("Supplier", i, 2);
			String country1=excel.getCellData("Supplier", i, 3);
			String person1=excel.getCellData("Supplier", i, 4);
			String phonum1=excel.getCellData("Supplier", i, 5);
			String email1=excel.getCellData("Supplier", i, 6);
			String mobilenum1=excel.getCellData("Supplier", i, 7);
			String notes1=excel.getCellData("Supplier", i, 8);
			String re=supplier.suppliercreation(sname1, 
					add1, cuty, country1, person1, phonum1, 
					email1, mobilenum1, notes1);
			excel.setCellData("Supplier", i, 9, re, outputfile);
			
		}



	}

	@AfterMethod
	public void closebrowser(){

		driver.close();

	}
}

