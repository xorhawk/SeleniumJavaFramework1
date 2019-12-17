package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWaitdemo {

	public static void main(String[] args)  {
		seleniumWaits();
	}

	public static void seleniumWaits()  {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver/chromedriver.exe");
		System.out.println("projectPath : "+projectPath);
		WebDriver driver = new ChromeDriver();



		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Test by Sveinn");
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.RETURN);
				
		
		

		driver.close();
		driver.quit();
	}

}
