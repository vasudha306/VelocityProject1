package org.pomPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
@FindBy (xpath="//div[text()='ADD TO CART']")
private WebElement AddToCart;
@FindBy (xpath="material-icons itc67Remove")
private WebElement RemoveFromCart;
public CartPage(WebDriver driver)
{    this.driver=driver;
	PageFactory.initElements(driver, this);
}

public void clickOnAddToCart(WebDriver driver)
{
	AddToCart.click();
}
public void RemoveFromcart()
{Actions act=new Actions(driver);
	act.moveToElement(RemoveFromCart).click().build().perform();;
}

}
