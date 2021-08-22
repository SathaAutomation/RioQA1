package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.CaseListDestails;
import Pages.TearmsandCondition;


public class LoginPage {
	WebDriver driver;
	
	
	@Test
	public  void login() throws IOException

	{
		 
		System.setProperty("webdriver.chrome.driver", "D:\\cloudbackup\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.navigate().to("https://3mocc-sl1-qa.azurewebsites.net/");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		CaseListDestails cld= new CaseListDestails(driver);
		cld.login();
		String url= driver.getCurrentUrl();
		if(url.contains("/core/eula"))
		{
		TearmsandCondition TC= new TearmsandCondition(driver);
		TearmsandCondition.pagescroll();
		TC.confirmpage();
		
		}
		
	}

}
