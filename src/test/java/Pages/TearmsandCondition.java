package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utils.Base;

public class TearmsandCondition extends Base{
	static WebDriver driver;

	
	public TearmsandCondition(WebDriver idriver)
	{
		 this.driver = idriver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how=How.ID,using="tcContinue") WebElement Confirm;
	@FindBy(how=How.ID,using="tcAgree") WebElement agree;
	
	public static void pagescroll()
	{
		JavascriptExecutor executor= (JavascriptExecutor)driver;
		executor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void confirmpage() 
	{
			agree.click();
			Confirm.click();
	}

}
