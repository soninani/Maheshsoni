package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelfileutilities {

	
	Workbook wb;

	//Constructor to read the XL path file

	public Excelfileutilities(String excelpath)throws Throwable{
		FileInputStream fi=new FileInputStream(excelpath);
		wb=WorkbookFactory.create(fi);
	}

	//counting no.of rows in a sheet
	public int rowcount(String sheetname){
		return wb.getSheet(sheetname).getLastRowNum();

	};

	//counting no .of columns in a sheet
	public int cellcount(String sheetname){
		return wb.getSheet(sheetname).getRow(0).getLastCellNum();
	};

	//retriving the data//read the data
	public String getCellData(String Sheetname,int row, int col){
		String data=null;

		if (wb.getSheet(Sheetname).getRow(row).getCell(col).getCellType()==Cell.CELL_TYPE_NUMERIC) {
			//capture the data
			int celldata=(int)wb.getSheet(Sheetname).getRow(row).getCell(col).getNumericCellValue();
			data=String.valueOf(celldata);
		}else {
			data=wb.getSheet(Sheetname).getRow(row).getCell(col).getStringCellValue();
		}
		return data;
	}

	//set cell data
	public void setCellData(String Sheetname,int row, int col, String status, String writeExcel) throws Throwable{

		//get sheet from Wb
		Sheet ws=wb.getSheet(Sheetname);
		//get row
		Row rownum=ws.getRow(row);
		//get col
		Cell cell=rownum.createCell(col);
		//write status
		cell.setCellValue(status);
		if (status.equalsIgnoreCase("Pass")) {

			//create cell style
			CellStyle style=wb.createCellStyle();
			//create font
			Font font=wb.createFont();

			//apply colur to the font 
			font.setColor(IndexedColors.GREEN.getIndex());
			font.setBold(true);
			font.setBoldweight(font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rownum.getCell(col).setCellStyle(style);






		}else if (status.equalsIgnoreCase("Fail")) {

			//create cell style
			CellStyle style=wb.createCellStyle();
			//create font
			Font font=wb.createFont();

			//apply colur to the font 
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			font.setBoldweight(font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rownum.getCell(col).setCellStyle(style);

		}else if (status.equalsIgnoreCase("Blocked")) {

			//create cell style
			CellStyle style=wb.createCellStyle();
			//create font
			Font font=wb.createFont();

			//apply colur to the font 
			font.setColor(IndexedColors.BLUE.getIndex());
			font.setBold(true);
			font.setBoldweight(font.BOLDWEIGHT_BOLD);
			style.setFont(font);
			rownum.getCell(col).setCellStyle(style);
		}
		FileOutputStream fo=new FileOutputStream(writeExcel);
		wb.write(fo);
	}



};

