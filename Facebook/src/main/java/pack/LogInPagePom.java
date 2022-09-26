package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPagePom {

	@FindBy (xpath  ="//input[@name='email']")
    private WebElement userName;
	
	@FindBy (xpath  ="//input[@name='pass']")
    private WebElement enterPassword;
	
	
//	@FindBy (xpath  ="//button[@name='login']")
//    private WebElement clickLoginButton;
	
	@FindBy (xpath  ="//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")
    private WebElement clickcreatAccButton;
	
	@FindBy (xpath  ="//a[text()='Developers']")
    private WebElement devloperClick;
	

	
	@FindBy (xpath  ="//a[text()='Watch']")
    private WebElement watchClick;
	
	
	//Constructor
public LogInPagePom(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);
	}
	

public void enterUsername() {
	     userName.click();
}

public void sendUserName(String name) {
	userName.sendKeys(name);
}
	
public void sendPassword(String pass) {
	enterPassword.sendKeys(pass);
}

//public void clickLoginButton() {
//	clickLoginButton.click();
//}
//

	
public void clickOnCreateButton() {
	clickcreatAccButton.click();
}

public void clickOnDevloper()
{
	devloperClick.click();
}
	

public void clickOnWatch()
{
	watchClick.click();
}	
	
	
	
	
	
	
	
	
	
	
	
}
