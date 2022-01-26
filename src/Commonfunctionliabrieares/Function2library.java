package Commonfunctionliabrieares;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.gargoylesoftware.htmlunit.javascript.host.file.FileReader;

import Utilities.propertyfileutil;

public class Function2library {

	public static WebDriver driver;

	public static void startBrowser() throws Throwable{


		if (propertyfileutil.getValueforkey("Browser").equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium live project practice\\Final practice project\\Common drivers\\chromedriver.exe");
			driver=new ChromeDriver();

		}else if (propertyfileutil.getValueforkey("Browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium live project practice\\ERP_StockAccounting\\CommonDrivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else {
			Reporter.log("Browser is not matching",true);
		}

	}

	public static void launchurl() throws Throwable{

		driver.get(propertyfileutil.getValueforkey("Url"));
		driver.manage().window().maximize();


	}


	public static void waitforElement(WebDriver driver, String Locatertype, String Loctaervalue, String data ){
		WebDriverWait wait= new WebDriverWait(driver, Integer.parseInt(data));

		if (Locatertype.equals("id")) {
			WebElement id=driver.findElement(By.id(Loctaervalue));
			wait.until(ExpectedConditions.visibilityOf(id));

		}else if (Locatertype.equals("name")) {
			WebElement name=driver.findElement(By.name(Loctaervalue));
			wait.until(ExpectedConditions.visibilityOf(name));

		}else if (Locatertype.equals("xpath")) {
			WebElement xpath=driver.findElement(By.xpath(Loctaervalue));
			wait.until(ExpectedConditions.visibilityOf(xpath));
		}else {
			Reporter.log("Unble to wait for element", true);
		}
	}

	public static void typeaction(WebDriver driver, String Locatertype, String Loctaervalue, String data){

		if (Locatertype.equalsIgnoreCase("id")) {
			WebElement id=driver.findElement(By.id(Loctaervalue));
			id.clear();
			id.sendKeys(data);

		}else if (Locatertype.equalsIgnoreCase("name")) {

			WebElement name=driver.findElement(By.name(Loctaervalue));
			name.clear();
			name.sendKeys(data);

		}else if (Locatertype.equalsIgnoreCase("xpath")) {
			WebElement xpath=driver.findElement(By.xpath(Loctaervalue));
			xpath.clear();
			xpath.sendKeys(data);
		}else {
			Reporter.log("unable to find", true);
		}


	}

	public static void clickAction(WebDriver driver, String Locatertype, String Loctaervalue){

		if (Locatertype.equals("id")) {
			driver.findElement(By.id(Loctaervalue)).click();

		}else if (Locatertype.equals("name")) {
			driver.findElement(By.name(Loctaervalue)).click();

		}else if (Locatertype.equals("xpath")) {
			driver.findElement(By.xpath(Loctaervalue)).click();

		}else {
			Reporter.log("unable to click action", true);
		}

	}

	public static void closeBrowser(){
		driver.close();
	}



	public static void capturenum(WebDriver driver, String Locatertype, String Loctaervalue) throws Throwable{
		String exp="";
		if (Locatertype.equalsIgnoreCase("id")) {
			exp=driver.findElement(By.id(Loctaervalue)).getAttribute("value");


		}else if (Locatertype.equalsIgnoreCase("xpath")) {
			exp=driver.findElement(By.xpath(Loctaervalue)).getAttribute("value");

		}else {
			Reporter.log("data not found", true);
		}
		FileWriter fw= new FileWriter("C:\\Selenium live project practice\\Final practice project\\Capture data\\snumber.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(exp);
		bw.flush();
		bw.close();
	}

	public static void tablevalidation(WebDriver driver) throws Throwable{

		java.io.FileReader fiel= new java.io.FileReader("C:\\Selenium live project practice\\Final practice project\\Capture data\\snumber.txt");
		BufferedReader buff= new BufferedReader(fiel);
		String line=buff.readLine();
		//int data=Integer.parseInt(TestData);
				
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
			
			
		}else {
			Reporter.log("Test fail the data", true);
		}


	}
















}
