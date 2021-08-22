package Utils;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Base {
	static WebDriver driver;
	static XSSFWorkbook xss;
	static XSSFSheet xsheet;
	static XSSFRow xrow;
	static XSSFCell xcol;
	static FileInputStream fis;
	static String XcellPath;
	static Select dropdown;
	static Properties pro;
	
	
	public static void ScreenShot(WebDriver idriver,String dis) throws IOException 
	{
		TakesScreenshot ts;
		File src=((TakesScreenshot)idriver).getScreenshotAs(OutputType.FILE);
		File distination= new File(dis);
		FileHandler.copy(src, distination);	
	}
	public static void dragandDrop(WebElement drop,WebElement drag)  
	{
		Actions act =act=new Actions(driver);
		act.dragAndDrop(drop, drag).build().perform();
	}
	
	public static void doubleClick(WebElement element)  
	{
		Actions act =act=new Actions(driver);
		act.doubleClick(element);
	}
	public static void dropdown(WebElement element,String value)  
	{
	dropdown= new Select(element);
	dropdown.selectByValue(value);
	}
	
		
	
	public static void alertAccept()
	{
		driver.switchTo().alert().accept();
	}
	public static void aleerDismiss()
	{
		driver.switchTo().alert().dismiss();
	}
	
	public static void windowhandlesAlert(WebElement element)
	{
		element.click();
		String mainWindow=driver.getWindowHandle();
		
		Set<String> window= driver.getWindowHandles();
		Iterator<String> it=window.iterator();
		while(it.hasNext())
		{
			String childWindow=it.next();
			
			if(!mainWindow.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(childWindow);
			}
			else
			{
				driver.switchTo().window(mainWindow);
			}
		}
	}
	
	}
