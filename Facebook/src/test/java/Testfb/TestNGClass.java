package Testfb;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import Setup.Base;
import Utils.Utility;
import pack.MessengerPom;
import pack.Roomspom;
import pack.SignUpPagePom;
public class TestNGClass extends Base{
	
	private WebDriver driver;
	private SignUpPagePom signUpPagePom;
	private Roomspom roomspom;
	private MessengerPom messengerPom;
	private SoftAssert soft;
	int testCase_id;
	
	 
	@Parameters ("browser")
    @BeforeTest
	public void launchBrowser(String browserName)
	{
		System.out.println("Before test 1");
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
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	@BeforeClass
	public void createpomObjects()
	{
	  System.out.println("Before class 1");
      signUpPagePom=new SignUpPagePom(driver);
      messengerPom=new MessengerPom(driver); 
      roomspom=new Roomspom(driver) ;
	}
	
	
	@BeforeMethod
	public void openRoomsPage() throws InterruptedException
	{
	   soft=new SoftAssert();
	   System.out.println("Before Method 1");
	   driver.get("https://www.facebook.com");
	   signUpPagePom.clickMessenger();
	   Assert.assertEquals(driver.getCurrentUrl(),"https://www.messenger.com/"); 
	   soft.assertEquals(driver.getTitle(), "Messenger");
	   messengerPom.roomsClick();
	}
	
	@Test
	public void verifyGoBackToMessenger()
	{
		testCase_id=100;
		System.out.println("Test100");
		roomspom.return2massengerClick();
		String url=	driver.getCurrentUrl();
		String title=driver.getTitle();
	    soft.assertEquals(url, "https://www.messenger.com/");
	    soft.assertEquals(title, "Messenger");
	    soft.assertAll();
		
//************************Hard Assert**************************************************
   
		/*Assert.assertEquals(url, "https://www.messenger.com");
	Assert.assertEquals(title, "Messenger","Messenger title is failed");*/
			
//***************************in one line **************************************************	
		
		/*boolean result=url.equals("https://www.messenger.com/") && title.equals("Messenger");
	    
	    Assert.assertTrue(result);*/
//*************************************************************************************
	    
	}
	
	@Test
	public void verifyHelpCenterButton()
	{
		testCase_id=101;
		System.out.println("Test 200");
		roomspom.clickCenter();
		String url=	driver.getCurrentUrl();
		String title=driver.getTitle();
		soft.assertEquals(url, "https://www.messenger.com/help");
		soft.assertAll();
		
	}
	
	@AfterMethod
	public void logOutApplication(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("status failed ");
			Utility.captureScreenShot(driver, testCase_id );
		}
		System.out.println("After method 1" );
		System.out.println("Logout");
	}
	
	@AfterClass
	public void cleanPOMobject() {
		System.out.println("After class 1");
		signUpPagePom=null;
		roomspom=null;
		messengerPom=null;
	}
	
	@AfterTest
	public void closeBrowser()
	{
		System.out.println("AfterTest 1");
		driver.close();
		driver=null;
		System.gc();
	}
	
	@AfterSuite
	public void afterSuit()
	{
		System.out.println("After Suit 1");
	}

}
