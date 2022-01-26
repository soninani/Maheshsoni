package Driverfactory;




import org.testng.annotations.Test;

import Commonfunctionliabrieares.Function2library;
import Utilities.Excelfileutilities;

public class runapp extends Function2library{
	
			String Outputfile="C:\\Selenium live project practice\\Final practice project\\Test output\\Hybrid.xlsx";
	
	@Test
	public void runApplicationlogin() throws Throwable{
		
		Excelfileutilities 	xl= new Excelfileutilities("C:\\Selenium live project practice\\Final practice project\\Test Input\\Hybridtest.xlsx");
		int row=xl.rowcount("MasterTestCases");
		
		for (int i = 1; i <=row; i++) {
			String module="";
			String Tcmodule=xl.getCellData("MasterTestCases", i, 1);
			String Exectionmode=xl.getCellData("MasterTestCases", i, 2);
			
			if (Exectionmode.equals("Y")) {
				
				for (int j = 1; j < xl.rowcount(Tcmodule); j++) {
					
					String Descreption =xl.getCellData(Tcmodule, j, 0);
					String Function_Name=xl.getCellData(Tcmodule, j, 1);
					String Locater_type =xl.getCellData(Tcmodule, j, 2);
					String Locater_value =xl.getCellData(Tcmodule, j, 3);
					String Test_Data =xl.getCellData(Tcmodule, j, 4);
					
					try {
						
						if (Function_Name.equals("startBrowser")) {
							Function2library.startBrowser();
							
						}else if (Function_Name.equals("launchurl")) {
							Function2library.launchurl();
						}else if (Function_Name.equals("waitforElement")) {
							Function2library.waitforElement(driver, Locater_type, Locater_value, Test_Data);
						}else if (Function_Name.equals("typeaction")) {
							Function2library.typeaction(driver, Locater_type, Locater_value, Test_Data);
						}else if (Function_Name.equals("clickAction")) {
							Function2library.clickAction(driver, Locater_type, Locater_value);
							
						}else if (Function_Name.equalsIgnoreCase("closeBrowser")) {
							Function2library.closeBrowser();
							
						}else if (Function_Name.equalsIgnoreCase("capturenum")) {
							Function2library.capturenum(driver, Locater_type, Locater_value);
					}else if (Function_Name.equalsIgnoreCase("tablevalidation")) {
						Function2library.tablevalidation(driver);
						
					}
						xl.setCellData(Tcmodule, j, 5, "pass", Outputfile);
						module="true";
						
					} catch (Exception e) {
					
						
						xl.setCellData(Tcmodule, j, 5, "fail", Outputfile);
						module="false";
						
						
			
					}
					
					if (module.equals("true")) {
						xl.setCellData("MasterTestCases", i, 3, "pass", Outputfile);
						
					}else {
						xl.setCellData("MasterTestCases", i, 3, "fail", Outputfile);
						
					}
				}
				
				
				
				
				
			}else if(Exectionmode.equals("N")){
				xl.setCellData("MasterTestCases", i, 3, "Blocked", Outputfile);
			}
			
			
			
		}
		
		
		
	}
}
































	

//@Test
//public void runtestapp() throws Throwable{
//	
//	
//	Excelfileutilities xl= new Excelfileutilities("C:\\Selenium live project practice\\Final practice project\\Test Input\\Hybridtest.xlsx");
//
//	
//	for (int i = 1; i <xl.rowcount("MasterTestCases"); i++) {
//		
//		String Modulestatus="";
//		String Tcmodule=xl.getCellData("MasterTestCases", i, 1);
//		String mou= xl.getCellData("MasterTestCases", i, 2);
//		
//		if (mou.equals("y")) {
//			
//			for (int j = 1; j < xl.rowcount(Tcmodule); j++) {
//				
//		String Descreption =xl.getCellData(Tcmodule, j, 0);
//		String Function_Name=xl.getCellData(Tcmodule, j, 1);
//		String Locater_type =xl.getCellData(Tcmodule, j, 2);
//		String Locater_value =xl.getCellData(Tcmodule, j, 3);
//		String Test_Data =xl.getCellData(Tcmodule, j, 4);
//		
//		try {
//			if (Function_Name.equals("startBrowser")) {
//				Function2library.startBrowser();
//				
//			}else if (Function_Name.equals("launchurl")) {
//				Function2library.launchurl();
//			}else if (Function_Name.equals("waitforElement")) {
//				Function2library.waitforElement(driver, Locater_type, Locater_value, Test_Data);
//			}else if (Function_Name.equals("typeaction")) {
//				Function2library.typeaction(driver, Locater_type, Locater_value, Test_Data);
//			}else if (Function_Name.equals("clickAction")) {
//				Function2library.clickAction(driver, Locater_type, Locater_value);
//				
//			}else if (Function_Name.equalsIgnoreCase("closeBrowser")) {
//				Function2library.closeBrowser();
//				
//			}
//			xl.setCellData(Tcmodule, j, 5, "Pass", Outputfile);
//			Modulestatus="true";
//			
//		}catch (Exception e) {
//			xl.setCellData(Tcmodule, j, 5, "fail", Outputfile);
//			Modulestatus="False";
//		}
//		if (Modulestatus.equals("true")) {
//			
//			xl.setCellData("MasterTestCases", i, 3, "Pass", Outputfile);
//			
//		}else if (Modulestatus.equals("false")) {
//			xl.setCellData("MasterTestCases", i, 3, "fail", Outputfile);
//			
//		}
//				
//			}
//			
//			
//			
//			
//			
//				
//			
//		}else if (mou.equals("N")) {
//			xl.setCellData("MasterTestCases", i, 3, "Blocked", Outputfile);
//			
//		}
//	}
//	
//	
//	
//}
//
//
//
//}


