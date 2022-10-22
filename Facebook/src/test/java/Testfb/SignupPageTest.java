package Testfb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pack.LogInPagePom;
import pack.SignUpPagePom;

public class SignupPageTest {
	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver","C:\\selenium project\\chromedriver_win32 (1)\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com");
       // Thread.sleep(3000);
		


SignUpPagePom signUpPagePom=new SignUpPagePom(driver);
         String logInPageUrl= driver.getCurrentUrl();
           
    if(logInPageUrl.equals("https://www.facebook.com/"))
    {
    	System.out.println(logInPageUrl+"url is verified");
    }
    else
    {
    	System.out.println("url is wrong");
    }
        	     	 
        	 
signUpPagePom.clickonCreatAccButton();
   
      

//signUpPagePom.sendUserName();
//signUpPagePom.sendsurName();
//signUpPagePom.sendMobileNumber();
//signUpPagePom.sendPassword();
signUpPagePom.enterDate();
signUpPagePom.enterMonth();
signUpPagePom.enterYear();
signUpPagePom.selectGender();
//signUpPagePom.customButton();
//signUpPagePom.pronounButton();

Thread.sleep(3000);
signUpPagePom.clickOnSignUp();
Thread.sleep(10000);
signUpPagePom.clickOnclose();
Thread.sleep(3000);
 
signUpPagePom.clickMessenger();
		
		
		
		
		
}		
	

}


