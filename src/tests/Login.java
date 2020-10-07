package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import pages.ContactDetails;
import pages.LoginPage;

public class Login {
	
	
	@Test
	public void loginTestPOM() {
		
				
		// 1. Initialise driver
		
		WebDriver driver = Utilities.DriverFactory.open("chrome");
		driver.get("https://sf.ut1.axle.evans-dev01.aws.eclipsegroup.co.uk/login");
		
		// 2. (Enter login information (Login page)
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmailAddress("christopher.warren@evanscycles.com");
		loginPage.setPassword("Password55!");
		loginPage.clickSignIn();
		
		// 3. Get confirmation (dashboard)
		ContactDetails contactDetails = new ContactDetails(driver);
		String conf = contactDetails.contactDetailsTitle();
		Assert.assertTrue(conf.contains("Contact Details"));
		
		
		// 4. Close browser
		driver.quit();
		
	}

}
