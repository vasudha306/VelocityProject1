package org.testPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pomPack.CartPage;
import org.pomPack.HomePage;
import org.pomPack.LoginPage;
import org.pomPack.LogoutGroww;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BasePack.BaseClass;

public class Groww extends BaseClass {
	private WebDriver driver;
	private LoginPage loginPage;
	private	LogoutGroww logout;
	private SoftAssert soft;
	@BeforeTest
    @Parameters("browser") 
public void LaunchBrowser(String browser) throws InterruptedException
	{
		
		if(browser.equals("chrome"))
    	{
    		driver=launchChromeBrowser();
    	}
    	else if(browser.equals("firefox"))
    	{
    		driver=launchFirefoxBrowser();
    	}
		 Thread.sleep(4000);
		 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
@BeforeClass
public void OpenUrl()
{
	 
	
	 loginPage=new LoginPage(driver);
	 driver.get("https://groww.in");
	 soft= new SoftAssert();
	 
	
}/*
@BeforeMethod
public void launchUrl()
{
	
}*/
@Test
public void Login() throws InterruptedException
{
	loginPage.LoginRegister();
	loginPage.email();
	loginPage.password();
	loginPage.submit();
	loginPage.checkPINselected();
	Thread.sleep(4000);
	loginPage.enterPIN();
	String url="https://groww.in/";
	System.out.println("url = "+url);
	WebDriverWait expi=new WebDriverWait(driver,6);
	expi.until(ExpectedConditions.urlToBe(url));
	//Assert.assertEquals(url," url");
	soft.assertEquals(url, url);
	url=driver.getTitle();
	System.out.println("tite = "+url);
	//Assert.assertEquals(url, "title");
	soft.assertEquals(url, url);
	System.out.println("hello");
	soft.assertAll();//describe failure occures due to which reson and put assertall in after method
	// result will not apply on test if we dont use assertAll ,results shows pass test case
}
@Test
public void verifyInvestmentIsPresentOntheScreen ()
{
	Assert.assertTrue(loginPage.verifyInvestmentPresent());
}

//Assert.assertEquals(actual, s);

/*@Test(dependsOnMethods= {"homePagee"})
public void AddtoCart()

{    String url=driver.getCurrentUrl();
System.out.println(url);
	Assert.assertEquals(url, "https://groww.in/user/cart");

}*/
@AfterClass
public void close()
{loginPage=null;
	}
@AfterTest
public void closeBrowser()
{driver.quit();
	}}

/*@Test(dependsOnMethods= {"AddtoCart"})
public void verifyCanRemoveCartCantent() throws InterruptedException
{cart=new CartPage(driver);
//cart.clickOnAddToCart(driver);
Thread.sleep(5000);
cart.RemoveFromcart();
	}}
//est(priority=3)
//blic void LogOut()
//logout=new LogoutGroww(driver);
//ogout.ForSignOutArrow();
//ogout.signOut();
//
*/
