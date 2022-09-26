package Testfb;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import Setup.Base;
import pack.MessengerPom;
import pack.Roomspom;
import pack.SignUpPagePom;
public class TestNGClass extends Base{
	
	private WebDriver driver;
	private SignUpPagePom signUpPagePom;
	private Roomspom roomspom;
	private MessengerPom messengerPom;
	private SoftAssert soft;
	
	 
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
	   System.out.println("Before Method 1");
	   driver.get("https://www.facebook.com");
	   String messengerRoomsPageUrl= driver.getCurrentUrl();
	   String messengerPageUrl= driver.getCurrentUrl();
		  
	   soft.assertEquals(messengerPageUrl, "https://www.messenger.com/");
	   soft.assertAll();
	   messengerPom.roomsClick();
	   Thread.sleep(3000);
	    System.out.println(messengerRoomsPageUrl);
	   soft.assertEquals(messengerRoomsPageUrl, "https://www.messenger.com/rooms");
	   soft.assertAll();
	   Thread.sleep(3000);
	   signUpPagePom.clickMessenger();
	   Thread.sleep(3000);
	   System.out.println(messengerPageUrl);
	   soft.assertEquals(messengerPageUrl, "https://www.messenger.com/");
	   soft.assertAll();
	   messengerPom.roomsClick();
	   Thread.sleep(3000);
	   System.out.println(messengerRoomsPageUrl);
	   soft.assertEquals(messengerRoomsPageUrl, "https://www.messenger.com/rooms");
	   soft.assertAll();
	
	}
	
	@Test
	public void verifyGoBackToMessenger()
	{
		System.out.println("Test1");
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
		System.out.println("Test 11");
		roomspom.clickCenter();
		String url=	driver.getCurrentUrl();
		String title=driver.getTitle();
		soft.assertEquals(url, "https://www.messenger.com/help");
		soft.assertEquals(title, "https://www.messenger.com/help");
		soft.assertAll();
	
	}
	
	@AfterMethod
	public void logOutApplication()
	{
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
