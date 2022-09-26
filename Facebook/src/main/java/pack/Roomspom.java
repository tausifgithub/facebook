package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Roomspom {

	
	@FindBy (xpath="//a[text()=' Return to messenger.com ']")
	private WebElement return2messnger;
	
	@FindBy (xpath="//a[text()=' Visit our help center ']")
    private WebElement center;
	

public Roomspom(WebDriver driver)
	  {
		   PageFactory.initElements(driver,this);
	  }
	
public void return2massengerClick()
   {
      return2messnger.click();
	}

public void clickCenter() 
    {
		center.click();
	}







	
}
