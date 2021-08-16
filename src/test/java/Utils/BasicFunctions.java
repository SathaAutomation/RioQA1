package Utils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class BasicFunctions {
	
	
	static WebDriver driver;

	@Test
	
	public static void screeShot() throws IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "D:\\cloudbackup\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.navigate().to("https://auto.mahindra.com/suv/xuv300");
		
		driver.manage().window().maximize();
		try
		{
	    driver.findElement(By.xpath("//div[@class='submit']")).click();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    WebElement drop=driver.findElement(By.xpath("//div[@class='dropdown']//button[@class = 'btn btn-primary dropdown-toggle']"));
	    JavascriptExecutor executor = (JavascriptExecutor)driver;
	    executor.executeScript("arguments[0].click();", drop);
	    executor.executeScript("arguments[0].value ='';", drop);
	    
	    List<WebElement> dropvalue=driver.findElements(By.xpath("//div[@class='dropdown open']//following-sibling::a"));
	    for(WebElement dup:dropvalue)
	    {
	    	System.out.println(dup.getText());
	    }
	    //drop.click();
	    //Actions act= new Actions(driver);
	    //act.moveToElement(drop).click();
	    //driver.findElement(By.xpath("//button[@class='btn btn-primary dropdown-toggle']")).sendKeys(Keys.ENTER);
	    WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[contains(text(),'Gallery')]"))));
		driver.findElement(By.xpath("//a[contains(text(),'Gallery')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//body[@class='header_mnm xuv300_brand_body brand-page default-device bodyclass']"))));
		TakesScreenshot Tks=  ((TakesScreenshot)driver);
		File src= Tks.getScreenshotAs(OutputType.FILE);
		File Dis= new File("D:\\Automation Work\\ScreenShot\\test.png");
		FileHandler.copy(src, Dis);
		
			
	}
	

}
