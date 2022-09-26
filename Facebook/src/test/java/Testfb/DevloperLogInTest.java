package Testfb;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pack.DevloperLogIn;
import pack.LogInPagePom;

public class DevloperLogInTest {
	
	public static void main(String[] args) {
		
	System.setProperty("webdriver.chrome.driver","C:\\selenium project\\chromedriver_win32 (1)\\chromedriver.exe");
    WebDriver driver=new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("https://www.facebook.com");

    LogInPagePom logInPage=new LogInPagePom(driver);
    
    //logInPage.sendUserName();
    //logInPage.enterPassword();
    
    DevloperLogIn devloperLogIn=new DevloperLogIn(driver);
   
    devloperLogIn.clickOnDevLogIn();
}
}