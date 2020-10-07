package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactDetailsPageFactory {
	
	WebDriver driver;
	
	// Define Web Elements
	
	@FindBy(className="contact-details")
	WebElement title;
	
	@FindBy(id="my-account__group-contact-details-edit-btn")
	WebElement editContactDetailsBtn;
	
	//  Steps
	public String contactDetailsTitle() {
		return title.getText();
	}
	
	public void clickEditContactDetails() {
		editContactDetailsBtn.click();
	}
	
	
	// Actions
	
	public void editContactDetails() {
		contactDetailsTitle();
		clickEditContactDetails();
		
		
	}
	
	//Constructor
	
	public ContactDetailsPageFactory (WebDriver driver) {
		this.driver = driver;
		
		// Initialise WebElements
		PageFactory.initElements(driver, this);
	}

}
