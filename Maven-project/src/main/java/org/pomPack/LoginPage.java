package org.pomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	@FindBy (xpath = "//span[text()='Login/Register']")
	private WebElement LoginRegister;
	@FindBy (id="login_email1")
	private WebElement Email;
	@FindBy (xpath="((//div[@class='absolute-center btn51ParentDimension'])[2])")
	private WebElement continuee;
	@FindBy (id="login_password1")
	private WebElement Password;
	@FindBy (xpath="(//div[@class='absolute-center btn51ParentDimension'])[2]")
	private WebElement Submit;
	@FindBy (id="close")
	private WebElement signInWithGoogle;
	@FindBy (xpath="(//input[@type='number'])[1]")
	private WebElement GrowwPIN1;
	@FindBy (xpath="(//input[@type='number'])[2]")
	private WebElement GrowwPIN2;
	@FindBy (xpath="(//input[@type='number'])[3]")
	private WebElement GrowwPIN3;
	@FindBy (xpath="//div[contains(@class,'col l7 hdQuickLinks')]//a[2]")
	private WebElement investment;
	private WebDriver driver;
	
	public LoginPage( WebDriver driver)
	{   	
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void LoginRegister()
	{  WebDriverWait explicit=new WebDriverWait(driver,5);
		explicit.until(ExpectedConditions.visibilityOf(LoginRegister));
		//signInWithGoogle.click();
       LoginRegister.click();
    }
	public void email()//String Emailid)
	{
		  Email.sendKeys("kalyanevasudha@gmail.com");//Emailid
	       continuee.click();
	}
	public void password()
	{
		 Password.sendKeys("zxcvbnm12@");
	}
	public void submit()
	{
		 Submit.click();
	}
	
	public void checkPINselected()
	{
		//WebDriverWait explicit=new WebDriverWait(driver,2);
	    //explicit.until(ExpectedConditions.elementToBeClickable(By.xpath("GrowwPIN")));
		GrowwPIN1.click();
		boolean a=GrowwPIN1.isSelected();
	    System.out.println(a);
	}
  public void enterPIN()
  {
	    Actions act=new Actions(driver);
		act.click(GrowwPIN1).sendKeys("4569").build().perform();
  }
  public Boolean verifyInvestmentPresent()
  {
	Boolean a=  investment.isDisplayed();
	  return a;
  }
	
	
	
	}
	

