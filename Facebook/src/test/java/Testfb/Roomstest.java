package Testfb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pack.MessengerPom;
import pack.Roomspom;
import pack.SignUpPagePom;

public class Roomstest {
	
public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver","C:\\selenium project\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
        
 SignUpPagePom signUpPagePom=new SignUpPagePom(driver);
               signUpPagePom.clickMessenger();
  MessengerPom messengerPom=new MessengerPom(driver);
               messengerPom.roomsClick();
        
   Roomspom roomspom=new Roomspom(driver) ;
            
   roomspom.return2massengerClick();
   messengerPom.roomsClick();
   roomspom.clickCenter();
  
        
}
}