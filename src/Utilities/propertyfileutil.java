package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class propertyfileutil {
	
	
	public static String getValueforkey(String key) throws Throwable{
		
		Properties configprop= new Properties();
		FileInputStream fi= new FileInputStream("C:\\Selenium live project practice\\Final practice project\\Property files\\property.properties");
		configprop.load(fi);
		String rs=configprop.getProperty(key);
		return rs;
	
		
	}
	
	
		
		
		
		
	

}
