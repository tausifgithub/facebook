package Testfb;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Setup.Base;
import Utils.Utility;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pack.DevloperLogIn;
import pack.LogInPagePom;
import pack.SignUpPagePom;

public class TestNG_2 extends Base {
	private WebDriver driver;
	private LogInPagePom logInPagePom;
	private SignUpPagePom signUpPagePom;
	private DevloperLogIn devloperLogIn;
	int testCase_id;
	
@BeforeSuite
	public void beforeSuite()
	{
		System.out.println("before suit 2");
	}


@Parameters("browser")
@BeforeTest
public void launchBrowser(String browserName)
{
	System.out.println("before test 2");
	
	if(browserName.equals("Chrome"))
	{
		driver=openChromeBrowser();
	}
	
	if(browserName.equals("Firefox"))
	{
		driver=openFirefoxBrowser();
	}
	if(browserName.equals("Opera"))
	{
		driver=openOperaBrowser();
	}
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
}


@BeforeClass
 public void createPomObjec()
 {
	System.out.println("before class 2");
	
	logInPagePom=new  LogInPagePom(driver);
	signUpPagePom=new SignUpPagePom(driver);
	devloperLogIn= new DevloperLogIn(driver);
 }
	
 @BeforeMethod
 public void openingUrl() throws EncryptedDocumentException, IOException
 {
	  System.out.println("before method 2");
	  driver.get("https://www.facebook.com/");
	  String url=driver.getCurrentUrl();
	  Assert.assertEquals(url, "https://www.facebook.com/");
	  logInPagePom.sendUserName(Utility.getTD(0, 1));
	  logInPagePom.sendPassword(Utility.getTD(1, 1));
	 	  	  
 }
	
 @Test
 public void signUpButton() throws InterruptedException, EncryptedDocumentException, IOException
 {
	 testCase_id=201;
	 logInPagePom.clickOnCreateButton();
	 signUpPagePom.sendUserName(Utility.getTD(4, 0));
	 signUpPagePom.sendsurName(Utility.getTD(4, 1));
	 signUpPagePom.sendMobileNumber(Utility.getTD(5, 0));
	 signUpPagePom.sendPassword(Utility.getTD(6, 0));
	 signUpPagePom.enterDate();
	 signUpPagePom.enterMonth();
	 signUpPagePom.enterYear();
	 signUpPagePom.selectGender();
	 signUpPagePom.clickOnSignUp();
	 signUpPagePom.closeIcon();
 }
	
 @Test
 public void devloperLogIn()
 {
	 testCase_id=202;
	 logInPagePom.clickOnDevloper();
	 String devurl=driver.getCurrentUrl();
	 String devTitle=driver.getTitle();
	 System.out.println(devTitle);
	 Assert.assertEquals(devurl, "https://developers.facebook.com/?ref=pf");
	 Assert.assertEquals(devTitle, "Meta for Developers");
     
 }
 
 
@AfterMethod
public void logOut(ITestResult result) throws IOException
{   
	if(result.getStatus()==ITestResult.FAILURE)
	{
		System.out.println("status failed ");
	Utility.captureScreenShot(driver, testCase_id);
	}

	System.out.println("LogOUt");
}
 
@AfterClass
public void cleanPOMobject()
{
	System.out.println("after class 2");
	logInPagePom=null;
	devloperLogIn=null;
	signUpPagePom=null;
	
}
@AfterTest
public void closeBrowser()
{
	System.out.println("afterTest 2");
	driver.close();
	driver=null;
	System.gc();
}

 
@AfterSuite
public void afterSuit()
{
	System.out.println("after Suit 2");
} 
}
