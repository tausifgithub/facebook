package pack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessengerPom {


	@FindBy (xpath="//a[text()='Rooms']")
    private WebElement rooms;
	

	@FindBy (xpath="(//a[@class='_4vo5'])[2]")
    private WebElement features;
	
	
	
	
	
   public MessengerPom(WebDriver driver)
   {
	   PageFactory.initElements(driver,this);
   }
	
   
   public void fetureClick() {
	   features.click();
	}
  
	   public void roomsClick() {
	   rooms.click();
	}

	
	
	
	
	
	
}
