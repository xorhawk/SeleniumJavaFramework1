package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestNGListenerDemo {
	
	@Test
	public void test1()	{
		System.out.println("I am inside test1");
	}
	
	@Test
	public void test2()	{
		System.out.println("I am inside test2");
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
				
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com/");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@name='abc']")).sendKeys("abcd");
		
		driver.close();
	}
	
	@Test
	public void test3()	{
		System.out.println("I am inside test3");
		throw new SkipException("This test is skipped");
	}
}
