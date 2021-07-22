package BasePack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public  WebDriver launchChromeBrowser()
	{System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
	 WebDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
		return driver;
	}
	public  WebDriver launchFirefoxBrowser()
	{System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\geckodriver.exe");
	 WebDriver driver=new FirefoxDriver();
	 driver.manage().window().maximize();
		return driver;
	}

}
