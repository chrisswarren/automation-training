package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
	
	WebDriver driver;
		
	
	@Test(dataProvider = "getData")
	public void loginTest(String email, String password) {
		System.out.println("NEW RECORD: " + email + " " + password);
		
		// Enter details
		driver.findElement(By.name("j_username")).sendKeys(email);				
		driver.findElement(By.name("j_password")).sendKeys(password);				
		driver.findElement(By.className("customer__submit-btn")).click();
		
		String message = driver.findElement(By.className("header-menu__logged-icon-container")).getText();
		System.out.println("CONFIRMTION: " + message);
		
		String pageTitle = driver.getTitle();
		System.out.println("PAGE TITLE: " + pageTitle);
		
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Initializing the WebDriver and opening the browser");
		driver = Utilities.DriverFactory.open("firefox");
		driver.get("https://sf.ut1.axle.evans-dev01.aws.eclipsegroup.co.uk/login");	
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing down the browser");
		driver.quit();
	}
	
	@DataProvider
	public String[][] getData() {
		return Utilities.Escel.get("C:\\Software\\EvansUserLogin.xls");
		
	}

}
