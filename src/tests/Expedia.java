package tests;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Expedia {
	
	WebDriver driver;
	String browserType = "Chrome";
	String city = "Chicago";
	String checkIn = "Sep 8, 2020";
	String checkOut = "Sep 9, 2020";
	
	@Test
	public void hotelReservation() {
		
		// 1. Search
		driver.findElement(By.xpath("//*[@id=\"uitk-tabs-button-container\"]/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"location-field-destination-menu\"]/div[1]/button")).sendKeys(city);
		driver.findElement(By.xpath("//*[@id=\"location-field-destination-menu\"]/div[2]/ul/li[1]/button")).click();
		//driver.findElement(By.xpath("//*[@id=\"d1-btn\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"wizard-hotel-pwa-v2-1\"]/div[2]/div[2]/button")).click();
			
		
		
		// 2. Modify the search results page, give criteria
		driver.findElement(By.cssSelector("input[id='popularFilter-1-POOL'][value='POOL']")).click();
		
		// Print the name of the city
		String actualCity = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div[1]/main/div[2]/div/div[1]/section/form/fieldset[8]/div/div[1]/div/fieldset/div/div[1]/div/div/label")).getText();
		System.out.println("CITY: " + actualCity);	
		
		// 3. Analyze search results
		//driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div/div[1]/main/div[2]/div/div[2]/section[2]/ol/li[3]/div/div/a")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div/div[1]/main/div[2]/div/div[2]/section[2]/ol/li[3]/div/div/a")).click();
		
		//Switch the window to the popup
		ArrayList<String> windows = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(1));
		
		// Print hotel
		String hotelName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div/div[1]/section/div[1]/div/div[3]/div[1]/div/div[1]/h1")).getText();
		String rating = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div/div/div/div[1]/section/div[1]/div/div[3]/div[1]/div/div[2]/div")).getText();
		System.out.println("HOTEL " + hotelName);
		System.out.println("RATING " + rating);
		
		// 4. Book reservation
		driver.findElement(By.xpath("//*[@id=\"pricebreakdown-menu-270297549\"]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"pricebreakdown-menu-270297549\"]/div/div/div[2]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/section/div/div[2]/div/div[2]/div[2]/div/div/form/button")).click();
		
		String price = driver.findElement(By.cssSelector("span[class='amount-value']")).getText();
		System.out.println("PRICE: " + price);
		
		
		// 5. Fill out contact / billing
		
		// 6. Get confirmation
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.contains("Payment"));
		
			
		
	}
	
	@BeforeMethod
	public void setUp() {
		System.out.println("Initializing the WebDriver");
		driver = Utilities.DriverFactory.open(browserType);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.expedia.com/");
		
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("Closing the browser");
		driver.quit();
	}

}
