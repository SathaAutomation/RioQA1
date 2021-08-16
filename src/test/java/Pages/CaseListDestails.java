package Pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utils.Base;
import Utils.PropertyGet;

public class CaseListDestails extends Base{
	 WebDriver driver;

	
public CaseListDestails(WebDriver driver) 
{
		
	PageFactory.initElements(driver, this);
	this.driver=driver;
	
}

@FindBy(how=How.ID,using="Username") WebElement UN;
@FindBy(how=How.ID,using="Password") WebElement PW;
@FindBy(how=How.ID,using="button-submit") WebElement Sb;



public  void errorpage()
{
	String errorurl=driver.getCurrentUrl();
	if(errorurl.contains("Error"))
	{
		driver.navigate().to(errorurl.replaceAll("/Error?aspxerrorpath=/signin-ocsd",""));
	}	
	else
	{
	System.out.println("Naviagted to caselsiting");	
	}
	
	
}
public void login(String User,String Pass)
{
	UN.sendKeys(User);
	PW.sendKeys(Pass);
	Sb.click();
}

public void login1(String User,String Pass)
{
	UN.sendKeys(User);
	PW.sendKeys(Pass);
	Sb.click();
}

public String[] caselistHeader() 
{
	List<WebElement> headerName= driver.findElements(By.xpath("//th[@class='k-header k-with-icon']//following-sibling::a"));
	
	for(WebElement e:headerName)
	{
		 String[] s;
		 System.out.println(e.getText());
	}
	return null;
	
	
	
}


}
