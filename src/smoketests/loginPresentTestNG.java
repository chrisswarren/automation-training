package smoketests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class loginPresentTestNG {
	
	WebDriver driver;
	
	
	@Test
	public void loginElementPresentTest() {
		
		System.out.println("Running the test");
				
		boolean loginEmailBox = driver.findElement(By.name("j_username")).isDisplayed();
		boolean passwordBox = driver.findElement(By.name("j_password")).isDisplayed();
		
		Assert.assertTrue(loginEmailBox, "Login Email text box is present");
		Assert.assertTrue(passwordBox, " Password textbox not present");		
	}
	
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Initialising the driver");
		driver = Utilities.DriverFactory.open("chrome");
		String webURL = "https://sf.ut1.axle.evans-dev01.aws.eclipsegroup.co.uk/login";
		driver.get(webURL);			
	}
	
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing our web browser");
		driver.close();
	}

}
