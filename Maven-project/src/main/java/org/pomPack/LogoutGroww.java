package org.pomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutGroww {
	WebDriver driver;
	
	@FindBy (xpath="/html/body/div/div/div/div/div[1]/div/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div")
	private WebElement dropDownArrowLogOut;
	@FindBy (xpath="(//div[@class='settingItem valign-wrapper'])[4]")
	private WebElement LogOutOtion;
	public LogoutGroww(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void ForSignOutArrow()
	{
		dropDownArrowLogOut.click();
	}
	public void signOut()
	{Actions act=new Actions( driver);
		act.moveToElement(LogOutOtion).click().build().perform();
	}
}
