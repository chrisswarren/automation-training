package tests;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import pages.ContactDetailsPageFactory;
import pages.LoginPageFactory;



public class LoginFactory {
	
	String emailAddress = "christopher.warren@evanscycles.com";
	String password = "Password55!";
	
	
	public void loginTestPageFactory() {
		
		
		// 1. Initialize driver
		WebDriver driver = Utilities.DriverFactory.open("chrome");
		driver.get("https://sf.ut1.axle.evans-dev01.aws.eclipsegroup.co.uk/login");
		
		// 2. Enter Login
		LoginPageFactory loginPage = new LoginPageFactory(driver);
		loginPage.login(emailAddress, password);
		loginPage.clickSignIn();
		
		// 3. Confirmation
		
		ContactDetailsPageFactory contactDetails = new ContactDetailsPageFactory(driver);
		contactDetails.contactDetailsTitle();
		String conf = contactDetails.contactDetailsTitle();
		Assert.assertTrue(conf.contains("Contact Details"));
		
		contactDetails.clickEditContactDetails();
			
				
		// 4. Close WebDriver
		driver.quit();
		
	}

}
