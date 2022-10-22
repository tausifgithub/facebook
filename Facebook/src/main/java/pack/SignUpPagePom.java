package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPagePom {
	private WebDriver driver;
	private WebDriverWait wait;
	private Select select;
       
	@FindBy (xpath="(//a[@role='button'])[2]")
    private WebElement CreateNewAccButton;

	@FindBy (xpath="//input[@name='firstname']")
    private WebElement enterfirstName;
	
	@FindBy (xpath="//input[@name='lastname']")
	private WebElement enterSurname;
	
	@FindBy (xpath="//input[@name='reg_email__']")
	private WebElement enterMobileNumber;
	
	@FindBy (xpath="//input[@data-type='password']")
	private WebElement enterPassword;
	
	@FindBy (xpath="//select[@id='day']")
	private WebElement bdayDate;
	
	@FindBy (xpath="//select[@id='month']")
	private WebElement bdayMonth;
	
	@FindBy (xpath="//select[@id='year']")
	private WebElement bdayYear;

	@FindBy (xpath="(//input[@type='radio'])[2]")
	private WebElement selectGendarMale;

    @FindBy (xpath="//div[@class='_1lch']")
    private WebElement custom;
    
    @FindBy (xpath="//select[@name='preferred_pronoun']")
    private WebElement  pronoun;
   
    @FindBy (xpath="(//button[text()='Sign Up'])[1]")
    private WebElement clickSignUpButton;
    
    @FindBy (xpath="//img[@class='_8idr img']")
    private WebElement closeButton;
    
	@FindBy (xpath="//a[text()='Messenger']")
    private WebElement messenger;
	
	@FindBy (xpath="//img[@class='_8idr img']")
    private WebElement close;
	
    
public SignUpPagePom (WebDriver driver) {
	 
	PageFactory.initElements(driver, this);
	
}


public void clickonCreatAccButton() {
	CreateNewAccButton.click();
}

public void sendUserName(String firstName) {
	enterfirstName.sendKeys(firstName);
}

public void sendsurName(String lastName) {
	enterSurname.sendKeys(lastName);
}

public void sendMobileNumber(String moNumber) {
	enterMobileNumber.sendKeys(moNumber);
}

public void sendPassword(String password) {
	enterPassword.sendKeys(password);
}

public void enterDate() {
	
	bdayDate.sendKeys("24");
}
public void enterMonth() {
	bdayMonth.sendKeys("Nov");
}
public void enterYear() {
	bdayYear.sendKeys("1994");
}

public void selectGender() {
	selectGendarMale.click();
}

public void customButton() {
	 custom.click();
}

public void pronounButton() {
	 pronoun.click();
}

public void clickOnSignUp() {
	clickSignUpButton.click();
}

public void clickOnclose() {
	closeButton.click();
}

public void clickMessenger() {
	messenger.click();
}

public void closeIcon() {
	close.click();
}




       
       
       
       
       
       
       
       
       
       
}


