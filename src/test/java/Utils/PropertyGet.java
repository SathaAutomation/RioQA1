package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyGet extends Base{
	public static void propertydata() throws IOException 
	{
		File  pross= new File("D:\\Automation Work\\RioQA\\Config\\base.properties");
		fis= new FileInputStream(pross);
		pro= new Properties();
		pro.load(fis);
		
	}
	public static String getbrowser() 
	{
		
		return pro.getProperty("Browser");
		
		
	}
	public static String geturl() 
	{
		
		return pro.getProperty("Url");
		
	}
	public static String UN() 
	{
		
		return pro.getProperty("UserName");
		
		
	}public static String PW() 
	{
		
		return pro.getProperty("Password");
		
	}
	
	
}
