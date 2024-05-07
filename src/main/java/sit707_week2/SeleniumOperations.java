package sit707_week2;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

/**
 * This class demonstrates Selenium locator APIs to identify HTML elements.
 * 
 * Details in Selenium documentation https://www.selenium.dev/documentation/webdriver/elements/locators/
 * 
 * @author Ahsan Habib
 */
public class SeleniumOperations {
	
	static WebDriver driver;
	
	public static void sleep(int sec) {
		try {
			Thread.sleep(sec*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public SeleniumOperations() {
        // Initialize WebDriver instance when object is created
        System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver-win64/chromedriver.exe");
        System.out.println("Fire up chrome browser.");
        driver = new ChromeDriver();
    }
	
	
	public static String bunnings_login_page(String myemail,String mypasswd) {

		System.out.println("Driver info: " + driver);
		
		sleep(2);
	
		// Load a webpage in chromium browser.
		String url = "https://www.bunnings.com.au/login";
		driver.get(url);

		
        // Locate and fill email field
        WebElement emailField = driver.findElement(By.id("okta-signin-username"));
        emailField.sendKeys(myemail);
        
        // Locate and fill password field
        WebElement passwordField = driver.findElement(By.id("okta-signin-password"));
        passwordField.sendKeys(mypasswd);
		
        // Locate Login button and click to submit using Selenium API.
        WebElement loginButton = driver.findElement(By.id("okta-signin-submit"));
        loginButton.click();

        // Sleep a while
        sleep(3);
        
        //String currentUrl = driver.getCurrentUrl();
        
        // Determine if login was successful or not based on current URL
        if (driver.getCurrentUrl().contains(url)) {
        	return "Login fails";
        }else {
        	saveScreenshotOfficeworks(driver);
            return "Login succeed";
        }
	}
	
    public void quitDriver() {
        // Quit WebDriver instance after all tests are done
        if (driver != null) {
            driver.quit();
        }
    }
    
 static void saveScreenshotOfficeworks(WebDriver driver) {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("C:/Users/User/Documents/SIT 707 - Software Quality And Testing/Task 4.2C/success.png"));
			System.out.println("Screenshot from Officework's registration page saved successfully");
		}catch(IOException e) {
			System.out.println("Failed to save screenshot from Officework's registration page");
			e.printStackTrace();
		}
	}
	
	

	
}
