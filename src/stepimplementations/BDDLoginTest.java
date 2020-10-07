package stepimplementations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class BDDLoginTest {
	
	WebDriver driver;
	
	@Given("^user is on the login screen$")
		public void user_is_on_the_login_screen() {
		System.out.println("User is on the login page");
		driver = Utilities.DriverFactory.open("Chrome");
		driver.get("https://sf.ut1.axle.evans-dev01.aws.eclipsegroup.co.uk/login");
		
	}
	
	
	 @When("^user entered correct email and password$")
		public void user_entered_correct_email_and_password() {
		 System.out.println("User enters email address and password");
		 driver.findElement(By.name("j_username")).sendKeys("christopher.warren@evanscycles.com");
		 driver.findElement(By.name("j_password")).sendKeys("Password55!");
		 driver.findElement(By.className("customer__submit-btn")).click();			
		}
	 
	 @When("^user entered email (.*)$")
	 	public void user_entered_email(String email) {
		 System.out.println("TESTING: " + email);
		 driver.findElement(By.name("j_username")).sendKeys(email);		 
	 }
	 
	 @And("^user entered password (.*)")
	 	public void user_entered_password(String password) {
		 System.out.println("TESTING: " + password);
		 driver.findElement(By.name("j_password")).sendKeys(password);
	 }
	 
	 @And("^user clicks login button$")
	 public void user_clicks_login_button() {
		 driver.findElement(By.className("customer__submit-btn")).click();
	 }
	
	
	@Then("^user gets confirmation$")
	 	public void user_gets_confirmation() {
		System.out.println("User gets confirmation");
		Assert.assertTrue(driver.findElement(By.className("contact-details")).getText().contains("Contact Details"));
	 		
	 	}
	
	@After
		public void tearDown() {
		driver.quit();
	}

}
