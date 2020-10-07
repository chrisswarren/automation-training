package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class NewAccount {

	public static void main(String[] args) {
		
		String browsertype = "firefox";
		String signIn = "Guest";
		String email = "automation161@test.com";
		String title;
		String firstname = "Joe";
		String lastname = "Bloggs";
		String password = "Password55!";
		String confirmpassword = "Password55!";
		String selectterms;
		String selectmarketing;
		// Define WebDriver
		WebDriver driver;
		
		
		// Define our webdriver
		driver = Utilities.DriverFactory.open(browsertype);
				
				
				// Open browser and navigate to the sign in page	
				driver.get("https://sf.ut1.axle.evans-dev01.aws.eclipsegroup.co.uk/login");
				
				// Define Web Elements
				
				// WebElement signInElement = driver.findElement(By.className("customer__email-container"));
				// WebElement guestElement = driver.findElement(By.className("guest__container"));
							
				
				// Select create account radio button
				driver.findElement(By.className("guest__container")).click();
				
				// Gender radio button algorithm
				//if (signIn.equalsIgnoreCase("Guest")) {guestElement.click();				
				//}
				//else {
				//	guestElement.click();
				//}
			
				
				// Enter Email address
				WebElement emailAddressElement = driver.findElement(By.cssSelector(".guest__input"));
				emailAddressElement.sendKeys(email);
				
				// Select continue
				driver.findElement(By.className("guest__submit-btn")).click();
				
				WebElement firstNameElement = driver.findElement(By.id("firstName"));
				WebElement lastNameElement	= driver.findElement(By.id("lastName"));
				WebElement addPasswordElement = driver.findElement(By.id("password"));
				WebElement confirmPasswordElement = driver.findElement(By.id("checkPassword"));				
				
				// Fill out form
				new Select(driver.findElement(By.id("title"))).selectByVisibleText("Mr");
				firstNameElement.sendKeys(firstname);
				lastNameElement.sendKeys(lastname);
				addPasswordElement.sendKeys(password);
				confirmPasswordElement.sendKeys(confirmpassword);
				
				// Click T&Cs checkbox
				WebElement element = driver.findElement(By.id("termsAndConditions"));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
				
				
				// Select Create account
				driver.findElement(By.className("register-area__submit-button")).click();
				
				// Get confirmation
				// String message = driver.findElement(By.className("contact-details")).getText();
				// System.out.println("CONFIRMATION: " + message);
				
				String pageTitle = driver.getTitle();
				System.out.println(pageTitle);
				
				// Conditional testing results
				
				//if (pageTitle == ("Register an Account | Bike Shop | Evans Cycles | Evans Cycles")) {
				//	System.out.println("Confirmation: Test successful: " + pageTitle);
				//}
				//else {
				//	System.out.println("TEST FAILED");
				//}
				
				// Close browser
				driver.close();

	}

}
