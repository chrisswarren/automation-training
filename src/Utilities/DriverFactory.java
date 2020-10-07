package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	// This method return a WebDriver object
	
	public static WebDriver open(String browsertype) {
		if (browsertype.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Software\\Selenium Standalone Server\\chromedriver.exe");
			return new ChromeDriver();			
		}
		else if (browsertype.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Software\\Selenium Standalone Server\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}
			
		else {
			System.setProperty("webdriver.gecko.driver", "C:\\Software\\Selenium Standalone Server\\geckodriver.exe");
			return new FirefoxDriver();
		}
		
	}

}
