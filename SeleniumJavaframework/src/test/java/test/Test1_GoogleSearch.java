package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1_GoogleSearch {

	public static void main(String[] args) {
		googleSearch();
	}
	
	public static void googleSearch() {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		
		//Goto Google.com
		driver.get("https://google.com/");
		
		//Enter text in search text box
		driver.findElement(By.name("q")).sendKeys("This is a test");
		//Click text box and press enter key on Keyboard
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		//close Browser
		driver.close();
		
		System.out.println("Test Completed Successfully");
	}
	
}
