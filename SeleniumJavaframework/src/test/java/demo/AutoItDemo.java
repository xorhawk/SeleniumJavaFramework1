package demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class AutoItDemo {

	public static void main(String[] args) throws Exception {
		
		test();
	}
		public static void test() throws Exception {
			
		String projectPath = System.getProperty("user.dir");
		//System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", projectPath+"/Drivers/geckodriver/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		
		driver.get("http://www.tinyupload.com/");
		//Thread.sleep(4000);
		//driver.findElement(By.name("uploaded_file")).click();
		driver.findElement(By.name("uploaded_file")).sendKeys(Keys.RETURN);
		//driver.findElement(By.xpath("//input[@name='uploaded_file']")).sendKeys(Keys.RETURN);
		//Thread.sleep(4000);
		driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
		
		//driver.findElement(By.xpath("//input[@name='uploaded_file']")).click();
		//driver.findElements(By.id("browse button inspection")).click();
		//driver.findElements(By.id("browse button inspection")).sendKeys("C:\\tmp\\file2.txt");

		Runtime.getRuntime().exec("C:\\tmp\\FileUploadScript.exe");

		//Process p=Runtime.getRuntime().exec("C\\tmp\\FileUploadScript.exe");
		 // p.waitFor();
		
		Thread.sleep(3000);
		//driver.close();
	}

}
