package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG_Demo2 {

	WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test
	public void googleSearch2() {
				
		//Goto Google.com
		driver.get("https://google.com/");
		
		//Enter text in search text box
		driver.findElement(By.name("q")).sendKeys("This is a test");
		
		//Click text box and press enter key on Keyboard
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
	}
	
	@Test
	public void googleSearch3() {
				
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
		driver.quit();
		
		System.out.println("Test Completed Successfully");
	}
}
