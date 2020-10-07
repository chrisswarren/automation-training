package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageFactory {
	WebDriver driver;
	
	// Define WebElements
	@FindBy(name="j_username")
	WebElement emailAddressBox;
	
	@FindBy(name="j_password")
	WebElement passwordBox;
	
	@FindBy(className="customer__submit")
	WebElement signInBtn;
	
		// Steps
	public void setEmailAddress(String emailAddress) {
		emailAddressBox.sendKeys(emailAddress);		
	}
	
	public void setPassword(String password) {
		passwordBox.sendKeys(password);		
	}
	
	public void clickSignIn() {
		signInBtn.click();		
	}
	
	// Actions
	public void login(String emailAddress, String password) {
	setEmailAddress(emailAddress);
	setPassword(password);
	clickSignIn();
	}
	
	// Constructor initialises the state of the driver
	public LoginPageFactory(WebDriver driver) {
		this.driver = driver;
		
		// Initialise WebElements
		PageFactory.initElements(driver, this);
		
	}
	
}


