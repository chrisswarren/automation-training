package tests;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


@RunWith(value = Parameterized.class)
public class NewAccountDDT {
	String title, firstName, lastName, email, password, confirmPassword;
	//boolean termsAndConditions;
	WebElement titleElement, firstNameElement, lastNameElement, addPasswordElement, confirmPasswordElement, termsAndConditions;
	WebDriver driver;
	
	// This is our test method
	@Test
	public void newAccountTest() {
		System.out.println("NEW RECORD: " + title + " " + firstName + " " + lastName + " " + email + " " + password + " " + confirmPassword + " " + termsAndConditions);
		

		driver.findElement(By.className("guest__container")).click();
		
		WebElement emailElement = driver.findElement(By.cssSelector("#angular-app > div.my-5 > app-root > app-login > div > div > div > lib-guest-login > div > form > label > input"));
		emailElement.sendKeys(email);
		driver.findElement(By.className("guest__submit-btn")).click();
		
		// Define Web elements
		defineWebElements();
		
		
		// Fill out form
		new Select (titleElement).selectByVisibleText(title);
		firstNameElement.sendKeys(firstName);
		lastNameElement.sendKeys(lastName);
		addPasswordElement.sendKeys(password);
		confirmPasswordElement.sendKeys(confirmPassword);
		
		
		driver.findElement(By.className("register-area__submit-button")).click();		
		
		
		
	}
	
	@Before
	public void setUp() {
		System.out.println("Initializing the WebDriver and opening the browser");
		driver = Utilities.DriverFactory.open("firefox");
		driver.get("https://sf.ut1.axle.evans-dev01.aws.eclipsegroup.co.uk/login");
		
	}
	
	@After
	public void tearDown() {
		System.out.println("Closing down teh browser");
		driver.quit();
		
	}
	
	public void defineWebElements() {
		// Define Web elements
		titleElement =  driver.findElement(By.id("title"));
		firstNameElement = driver.findElement(By.id("firstName"));
		lastNameElement	= driver.findElement(By.id("lastName"));
		addPasswordElement = driver.findElement(By.id("password"));
		confirmPasswordElement = driver.findElement(By.id("checkPassword"));
		termsAndConditions = driver.findElement(By.id("termsAndConditions"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", termsAndConditions);
		
	}
	
	// This annotation method is designed to pass parameters into the class via the constructor
	@Parameters
	public static List<String[]> getData() {
		return Utilities.CSV.get("C:\\Software\\EvansUserAccount.csv");
		
	}
	
	// Constructor that passes parameters to the test method
	public NewAccountDDT(String title, String firstName, String lastName, String email, String password, String confirmPassword, String termsAndConditions) {
	
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
				
		//if (termsAndConditions.equals("TRUE")) {this.termsAndConditions = true;}
		//else {this.termsAndConditions = false;}
		
		
		
	}

}
