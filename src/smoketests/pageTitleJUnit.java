package smoketests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class pageTitleJUnit {
	
	WebDriver driver;
	String webURL = "https://sf.ut1.axle.evans-dev01.aws.eclipsegroup.co.uk/login";
	
	@Test
	public void pageTitleTest() {
		System.out.println("Running the Test");
				
		driver = Utilities.DriverFactory.open("chrome");
		driver.get(webURL);
		String actualTitle = driver.getTitle();
		String expectedTitle = "| Sign In | UK Online Bike Shop | Evans Cycles";
		Assert.assertEquals(expectedTitle, actualTitle);
		// Assert.fail("We intentionally failed this test");		
	}
	
	@Before
	public void setUp() {		
		System.out.println("Initializing the Driver");
		driver = Utilities.DriverFactory.open("chrome");
	}
	
	@After
	public void tearDown() {		
		System.out.println("Closing the Driver");
		driver.close();
	}

}
