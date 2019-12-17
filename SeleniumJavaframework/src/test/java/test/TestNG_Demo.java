package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;
import demo.Log4jDemo;

public class TestNG_Demo {

	WebDriver driver = null;
	public static String browserName=null;
	
	private static Logger logger = LogManager.getLogger(Log4jDemo.class);
	
	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		PropertiesFile.getProperties();
		
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("Chrome Browser started");
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"/Drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
			logger.info("Firefox Browser started");
		}
		
		
		logger.info("Browser started");
		
	}
	
	@Test
	public void googleSearch() {
				
		//Goto Google.com
		driver.get("https://google.com/");
		
		//Enter text in search text box
		driver.findElement(By.name("q")).sendKeys("This is a test");
		
		//Click text box and press enter key on Keyboard
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
	}
	
	@AfterTest
	public void tearDownTest() {
	
		//close Browser
		driver.close();
		//driver.quit();
		
		System.out.println("Test Completed Successfully");
		PropertiesFile.setProperties();
	}
}
