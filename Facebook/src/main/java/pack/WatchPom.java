package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WatchPom {
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy (xpath  ="(//div[@data-visualcompletion='ignore'])[9]")
    private WebElement liveButton;
	
	//(//div[@data-visualcompletion='ignore'])[9]
	@FindBy (xpath  ="(//a[@role='tab'])[2]")
    private WebElement shows;
	
	

	
	public WatchPom(WebDriver driver) 
	{
	PageFactory.initElements(driver, this);
	this.driver=driver;
	wait =new WebDriverWait(driver,20);
	
	}

	

	public void enterLiveButton() {
	 
		wait.until(ExpectedConditions.elementToBeClickable(liveButton));
		liveButton.click();
		// liveButton.click();
	}
	
	 	public void enterShowButton() {
	 		shows.click();
     }


}
