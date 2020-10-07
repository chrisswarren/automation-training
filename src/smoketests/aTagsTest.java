package smoketests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class aTagsTest {
WebDriver driver;
	
	
	@Test
	public void loginElementPresentTest() {		
		System.out.println("Running the test");	
		boolean forgotYourPassword = false;
		
		// We want to test the presence of A  tags >> Hyperlinks
		List <WebElement> aElements = driver.findElements(By.tagName("a"));
		int numberOfAElements = aElements.size();
		System.out.println("There are " + numberOfAElements + " a tags on the page");
		
		for (WebElement aElement : aElements) {
			System.out.println(aElement.getText());
			if (aElement.getText().equals("Forgot your password?")) {
				forgotYourPassword = true;
				break;
		}
				
	}
	
	// Assertions
	Assert.assertTrue(forgotYourPassword);
	
	}

	@BeforeMethod
	public void setUp() {
		System.out.println("Initialising the driver");
		driver = Utilities.DriverFactory.open("chrome");
		String webURL = "https://sf.ut1.axle.evans-dev01.aws.eclipsegroup.co.uk/login";
		driver.get(webURL);			
	}
	
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing our web browser");
		driver.close();
	}
}
