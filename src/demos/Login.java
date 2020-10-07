package demos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) {
		
		
		// 1. Define the webdriver
		System.setProperty("webdriver.chrome.driver", "C:\\Software\\Selenium Standalone Server\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// 2. Open the web browser and navigate to page
		driver.get("https://www.evanscycles.com/login");
		
		// 3. Enter email address
		driver.findElement(By.name("j_username")).sendKeys("chrisswarren180@gmail.com");
		
		// 4. Enter password
		driver.findElement(By.name("j_password")).sendKeys("Bergkamp10");
		
		// 5. Click login
		driver.findElement(By.className("customer__submit-btn")).click();
		
		// 6. Define text
		String message = driver.findElement(By.className("header-menu__logged-icon-container")).getText();
		System.out.println("CONFIRMTION: " + message);
		
		String pageTitle = driver.getTitle();
		System.out.println("PAGE TITLE: " + pageTitle);
		
		// 7. Close browser
		driver.close();
	}

}
