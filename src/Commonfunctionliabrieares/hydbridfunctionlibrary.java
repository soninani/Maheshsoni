package Commonfunctionliabrieares;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Driver;import org.apache.xerces.impl.xpath.XPath;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.internal.PropertiesFile;

import Utilities.propertyfileutil;



public class hydbridfunctionlibrary {

	public static WebDriver driver;



	public static void startBrowser() throws Throwable{

		if (propertyfileutil.getValueforkey("Browser").equalsIgnoreCase("Chrome")) {

			System.setProperty("webdriver.chrome.driver", "C:\\Selenium live project practice\\Final practice project\\Common drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if (propertyfileutil.getValueforkey("Browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium live project practice\\ERP_StockAccounting\\CommonDrivers\\chromedriver.exe");
			driver=new FirefoxDriver();
		}else {
			Reporter.log("Brow",true);
		}
	}

	public static void launchurl() throws Throwable{
		
			driver.get(propertyfileutil.getValueforkey("Url"));
			driver.manage().window().maximize();
		

	}
	public static void waitforElement(WebDriver driver, String loctertype, String locatervalue, String testdata){
		WebDriverWait wait= new WebDriverWait(driver, Integer.parseInt(testdata));

		if (loctertype.equalsIgnoreCase("id")) {
			WebElement id=driver.findElement(By.id(locatervalue));
			wait.until(ExpectedConditions.visibilityOf(id));
		}else if (locatervalue.equalsIgnoreCase("name")) {
			WebElement name=driver.findElement(By.name(locatervalue));
			wait.until(ExpectedConditions.visibilityOf(name));
		}else if (locatervalue.equalsIgnoreCase("xpath")) {
			WebElement xpath=driver.findElement(By.xpath(locatervalue));
			wait.until(ExpectedConditions.visibilityOf(xpath));
		}else {
			Reporter.log("unable to wait", true);
					
		}
	}


	public static void typeaction(WebDriver driver, String loctertype, String locatervalue,String testdata){
		if (loctertype.equals("id")) {

			WebElement l=driver.findElement(By.id(locatervalue));
			l.clear();
			l.sendKeys(testdata);

		}else if (loctertype.equals("name")) {
			WebElement l=driver.findElement(By.name(locatervalue));
			l.clear();
			l.sendKeys(testdata);
		}else if (loctertype.equals("xpath")) {
			WebElement l=driver.findElement(By.xpath(locatervalue));
			l.clear();
			l.sendKeys(testdata);
		}else {
			Reporter.log("unable to type", true);
		}




	}
	public static void clickAction(WebDriver driver, String loctertype, String locatervalue){
		if (loctertype.equals("id")) {

			WebElement l=driver.findElement(By.id(locatervalue));
			l.click();

		}else if (loctertype.equals("name")) {
			WebElement l=driver.findElement(By.name(locatervalue));
			l.click();
		}else if (loctertype.equals("xpath")) {
			WebElement l=driver.findElement(By.xpath(locatervalue));
			l.click();
		}else {
			Reporter.log("unable to click", true);
		}
	}

	public static void closeBrowser(){

		driver.close();

	}
	
	
	public static void capturenum(WebDriver driver, String loctertype, String locatervalue) throws Throwable{
		String exp="";
		if (loctertype.equals("id")) {

			WebElement l=driver.findElement(By.id(locatervalue));
		l.getAttribute("value");

		}else if (loctertype.equals("name")) {
			WebElement l=driver.findElement(By.name(locatervalue));
			l.getAttribute("value");
		}else if (loctertype.equals("xpath")) {
			WebElement l=driver.findElement(By.xpath(locatervalue));
			l.getAttribute("value");
		}else {
			Reporter.log("unable to click", true);
		}
		
		FileWriter fw= new FileWriter("C:\\Selenium live project practice\\Final practice project\\Capture data\\snumber.txt");
		BufferedWriter bw= new BufferedWriter(fw);
		bw.write(exp);
		bw.flush();
		bw.close();
	}
	
	
	public static void tablevalidation(WebDriver driver) throws Throwable{
		FileReader fi= new FileReader("C:\\Selenium live project practice\\Final practice project\\Capture data\\snumber.txt");
		BufferedReader bh= new BufferedReader(fi);
		String line=bh.readLine();
		if (!driver.findElement(By.xpath(propertyfileutil.getValueforkey("searchtextbox"))).isDisplayed()) {
			driver.findElement(By.xpath(propertyfileutil.getValueforkey("searchsymbol"))).click();
			driver.findElement(By.xpath(propertyfileutil.getValueforkey("searchtextbox"))).clear();
			
			driver.findElement(By.xpath(propertyfileutil.getValueforkey("searchtextbox"))).sendKeys(line);
			driver.findElement(By.xpath(propertyfileutil.getValueforkey("searchbutton"))).click();
			
			WebElement expjie=driver.findElement(By.xpath(propertyfileutil.getValueforkey("suppliernum")));
			String expe=expjie.getText();
			if (expe.equals(line)) {
				
				Reporter.log("Test pass equal", true);
				
			}else {
				Reporter.log("Test fail not equal", true);
			}
			
			
		}
	}

}


