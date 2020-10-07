package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public void setEmailAddress(String emailAddress) {
		driver.findElement(By.name("j_username")).sendKeys(emailAddress);
		
	}
	
	public void setPassword(String password) {
		driver.findElement(By.name("j_password")).sendKeys(password);
		
		
	}
	
	public void clickSignIn() {
		driver.findElement(By.className("customer__submit-btn")).click();
		
		
	}
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		
	}

}
