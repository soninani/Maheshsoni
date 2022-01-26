package Driverfactory;


import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Commonfunctionliabrieares.Function2library;
import Commonfunctionliabrieares.hydbridfunctionlibrary;
import Utilities.Excelfileutilities;

public class runtestapp2 extends hydbridfunctionlibrary{

	String outputpath="C:\\Selenium live project practice\\Final practice project\\Test output\\outputpath.xlsx";
	ExtentReports extents;
	ExtentTest test;
	@Test
	public void logintest() throws Throwable{

		Excelfileutilities 	xl= new Excelfileutilities("C:\\Selenium live project practice\\Final practice project\\Test Input\\Hybridtest.xlsx");
		int row=xl.rowcount("MasterTestCases");


		for (int i = 1; i <row; i++) {
			String res="";
			String mastersheet=xl.getCellData("MasterTestCases", i, 1);
			String ma=xl.getCellData("MasterTestCases", i, 2);
			if (ma.equals("Y")) {

				extents = new ExtentReports("./Extentreports/"+ma);


				for (int j = 1; j < xl.rowcount(mastersheet); j++) {

					test=extents.startTest(ma);
					String Descreption =xl.getCellData(mastersheet, j, 0);
					test.log(LogStatus.INFO, Descreption);
					String Function_Name=xl.getCellData(mastersheet, j, 1);
					test.log(LogStatus.INFO, Descreption);
					String Locater_type =xl.getCellData(mastersheet, j, 2);
					test.log(LogStatus.INFO, Descreption);
					String Locater_value =xl.getCellData(mastersheet, j, 3);
					test.log(LogStatus.INFO, Descreption);
					String Test_Data =xl.getCellData(mastersheet, j, 4);
					test.log(LogStatus.INFO, Descreption);

					try {

						if (Function_Name.equals("startBrowser")) {
							hydbridfunctionlibrary.startBrowser();

						}else if (Function_Name.equals("launchurl")) {
							hydbridfunctionlibrary.launchurl();
						}else if (Function_Name.equals("waitforElement")) {
							hydbridfunctionlibrary.waitforElement(driver, Locater_type, Locater_value, Test_Data);
						}else if (Function_Name.equals("typeaction")) {
							hydbridfunctionlibrary.typeaction(driver, Locater_type, Locater_value, Test_Data);
						}else if (Function_Name.equals("clickAction")) {
							hydbridfunctionlibrary.clickAction(driver, Locater_type, Locater_value);

						}else if (Function_Name.equalsIgnoreCase("closeBrowser")) {
							hydbridfunctionlibrary.closeBrowser();
						}else if (Function_Name.equalsIgnoreCase("capturenum")) {
							Function2library.capturenum(driver, Locater_type, Locater_value);
						}else if (Function_Name.equalsIgnoreCase("tablevalidation")) {
							Function2library.tablevalidation(driver);

						}


						xl.setCellData(mastersheet, j,5 , "pass", outputpath);
						test.log(LogStatus.PASS, Descreption);
						res="true";
					} catch (Exception e) {
						xl.setCellData(mastersheet, j, 5, "fail", outputpath);
						test.log(LogStatus.FAIL, Descreption);
						res="false";
					}
					if (res.equals("true")) {
						xl.setCellData(mastersheet, i, 3, "pass", outputpath);

					}else if (res.equals("false")) {
						xl.setCellData(mastersheet, i, 3, "fail", outputpath);
					}


				}


				extents.endTest(test);
				extents.flush();

			}else if (ma.equals("N")) {
				xl.setCellData(mastersheet, i, 3, "blocked", outputpath);
			}



		}

	}



}
