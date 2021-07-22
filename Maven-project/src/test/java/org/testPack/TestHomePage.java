package org.testPack;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.pomPack.HomePage;
import org.pomPack.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BasePack.BaseClass;
//call all webdriver methods in testclass and webelement methodes in pom class
public class TestHomePage extends BaseClass {
	private	WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	@BeforeSuite
	public void requrementBeforeBrowserLaunch()
	{
		System.out.println("any requrement before browser launch put in before suitlike cache or cookies clear  code,chrome notification disable");
	   //their is no need to write after suit
	}
    @BeforeTest
    @Parameters("browser") 
    public void launchBrowser(String browser) throws InterruptedException 
    {
    	if(browser.equals("chrome"))
    	{
    		driver=launchChromeBrowser();
    	}
    	else if(browser.equals("firefox"))
    	{
    		driver=launchFirefoxBrowser();
    	}
    	
    	 driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS );
    	 ArrayList<String> arrayList =new  ArrayList<String>(driver.getWindowHandles());//to handle child browser popup code
         System.out.println( "Address of main window ="+arrayList.get(0));
            //maintain all code releted to driver here like child popup
         
    }
    
	@BeforeClass
    public void openURl() throws InterruptedException
    {
    	 driver.get("https://groww.in");
    	 loginPage=new LoginPage(driver);//create object of all pom classes in before class
    //this login code should be in before method
 	 	loginPage.LoginRegister();
 	 	loginPage.email();
 	 	loginPage.password();
 	 	loginPage.submit();
 	 	loginPage.checkPINselected();
 	 	Thread.sleep(5000);
 	 	loginPage.enterPIN();
}
     @Test()
    public void homePagee() throws InterruptedException
    {
    	homePage=new HomePage(driver);
    homePage.sendDatasearchBox();
    homePage.moveTodropdown();
    homePage.enterSIPamount();
    Thread.sleep(5000);
    homePage.clickOnAddToCart();
   
    Thread.sleep(5000);

    }
    @Test
    public void verifyProceedToPayButton()
    {
   
    	Assert.assertTrue( homePage.verifyProceedToPayEnabled());
    }
    @AfterClass
    public void closeURL()
    {
    	 homePage=null;
        loginPage=null;
       // gc();
        //close url
     }
    @AfterTest
    public void closeBrowser()
    {
    	driver.quit();
    }
}
/*
*/
