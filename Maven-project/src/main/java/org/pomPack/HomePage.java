package org.pomPack;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class HomePage {
	private WebDriver driver;
	Actions  act ;
	 
@FindBy (xpath="//input[@id='mainSearch1010']")
private WebElement searchbox;
@FindBy (id="//img[@class='se27SeSearchIcon']")
private WebElement search;
@FindBy (id="suggestionsstate-bank-of-india")
private WebElement stateBankOfIndia;
@FindBy (id="suggestionssbi-small-midcap-fund-direct-growth")
private WebElement SBInifty50ETF ;

@FindBy (xpath="//h1[text()='SBI Small Cap Fund Direct Growth'")
private WebElement mutualf;
@FindBy (id="mfoc89Amount")
private WebElement SIPamount;
@FindBy (xpath="//div[@class='mfoc945AddToCartButton center-align']")
private WebElement addToCart;
@FindBy (xpath="//*[@id=\"userCart\"]/div/div[2]/div/div[2]/div/div/div[7]/div/div/div/div")
private WebElement ProceedToPay;

public HomePage( WebDriver driver)
{   	
	this.driver=driver;
	PageFactory.initElements(driver, this);
	

}
public void sendDatasearchBox() throws InterruptedException
{ // WebDriverWait explicit=new WebDriverWait(driver,5);
//	explicit.until(ExpectedConditions.visibilityOf(searchbox));
	Thread.sleep(5000);
	searchbox.click();
	searchbox.sendKeys("sbi");
}
public void moveTodropdown()
{act=new Actions(driver);
		act.moveToElement(SBInifty50ETF).click().build().perform();
	}
public void enterSIPamount() throws InterruptedException
{
	SIPamount.sendKeys("700");
	Thread.sleep(5000);
}
public void clickOnAddToCart() throws InterruptedException
{
 addToCart.click();
	
}
public Boolean verifyProceedToPayEnabled()
{
	Boolean a=ProceedToPay.isEnabled();
	return a;
	}
public String getTextMethod()
{
	String s=driver.getTitle();
	return s;
}


}


