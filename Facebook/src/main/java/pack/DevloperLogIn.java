package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DevloperLogIn {
	
	
	@FindBy (xpath  ="//h3[text()='Facebook Login']")
    private WebElement logInClick;
	
	
	public DevloperLogIn(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
			
	}
	
	
	
	public void clickOnDevLogIn()
	{
		logInClick.click();
	}
	
	
}
