package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount {

	public static void main(String[] args) {
		
		// Define our webdriver
		System.setProperty("webdriver.gecko.driver", "C:\\Software\\Selenium Standalone Server\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		// Open browser and navigate to the sign in page	
		driver.get("https://sf.ut1.axle.evans-dev01.aws.eclipsegroup.co.uk/login");
		
		// Select create account radio button
		driver.findElement(By.className("guest__container")).click();
		
		// Enter Email address
		driver.findElement(By.cssSelector(".guest__input")).sendKeys("automation7@test.com");
		
		// Select continue
		driver.findElement(By.className("guest__submit-btn")).click();
		
		// Fill out form
		new Select(driver.findElement(By.id("title"))).selectByVisibleText("Mr");
		driver.findElement(By.id("firstName")).sendKeys("Joe");
		driver.findElement(By.id("lastName")).sendKeys("Bloggs");
		driver.findElement(By.id("password")).sendKeys("Password55!");
		driver.findElement(By.id("checkPassword")).sendKeys("Password55!");
		
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
		System.out.println("pageTitle: " + pageTitle);
		
		
		// Close browser
		driver.close();
		
	

	}

}
