package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactDetails {
	
	WebDriver driver;
	
	public String contactDetailsTitle() {
		return driver.findElement(By.className("contact-details")).getText();
		
	}
	
	public void editContactDetails() {
		driver.findElement(By.id("my-account__group-contact-details-edit-btn")).click();
	}
	
	public ContactDetails(WebDriver driver) {
		this.driver = driver;
		
	}

}
