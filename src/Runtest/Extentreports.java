package Runtest;

import java.io.IOException;
import java.sql.Date;
import java.sql.Driver;
import java.text.SimpleDateFormat;

import javax.naming.spi.DirStateFactory.Result;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.types.Description;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;
import com.mongodb.MapReduceCommand.OutputType;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



public class Extentreports  {


	public static ExtentReports reports;
	public static ExtentTest test;
	WebDriver driver;

	@BeforeTest
	public void tf(){

		//reports=new ExtentReports(System.getProperty("user.dir")+"/Reportsofthetestextent/Freecrm.html");
		//reports=new ExtentReports(System.getProperty("user.dir")+"/Reoprts/Freecrm.html");
		reports= new ExtentReports(System.getProperty("user.dir")+"/Extentsreports/Freecrm");
		
	}

	@Test
	public void test(){

		test=reports.startTest("Starttest of the system");

		int i=1;
		int j=2;

		if (i+j==3) {
			System.out.println("Testpass");
			test.log(LogStatus.INFO, "Description");
			test.log(LogStatus.PASS, "Test run sucessfullly");

		}else if (i+j==4) {
			System.out.println("Test fail");
			test.log(LogStatus.INFO, "Description");
			test.log(LogStatus.FAIL, "Test run Fail");

		}
		


	}
	
	
	@Test
	public void test2(){
		test=reports.startTest("Starttest of the system secound system");
	int l=34;
	int h=45;
	if (l==h) {
		System.out.println("Test fail");
		
	}else {
		System.out.println("Testpass");
	}
		test.log(LogStatus.INFO, "Desc");
		test.log(LogStatus.FAIL, "failedtest");
		
	}
	public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new java.util.Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
				+ ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(srcFile, destFile);
		return destination;
	}
	


	@AfterTest
	public void getResult(ITestResult result) throws Throwable{
		
//		if (result.getStatus()==ITestResult.FAILURE) {
//			test.log(LogStatus.FAIL, result.getThrowable());
//			
//		}
//		reports.endTest(test);
//		reports.flush();
//	}
	if(result.getStatus()==ITestResult.FAILURE){
		test.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
		test.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
		
		String screenshotPath = Extentreports.getScreenshot(driver, result.getName());
		test.log(LogStatus.FAIL, test.addScreenCapture(screenshotPath)); //to add screenshot in extent report
		//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
	}
	else if(result.getStatus()==ITestResult.SKIP){
		test.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
	}
	else if(result.getStatus()==ITestResult.SUCCESS){
		test.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

	}
	
	
	reports.endTest(test); //ending test and ends the current test and prepare to create html report
	driver.quit();
}







	
	
}