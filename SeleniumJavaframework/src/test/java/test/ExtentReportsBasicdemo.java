package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportsBasicdemo {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");

		 // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
     // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("Google Search Test One", "Simple test to validate Google search functionality");
        
        String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		
		// log(Status, details)
        test1.log(Status.INFO, "Start Test Case (status, details)");
		driver.get("https://google.com/");
		test1.pass("Navigated to Google.com");
		
		driver.findElement(By.name("q")).sendKeys("This is a test");
		test1.pass("Entered text in search boc");
		
		driver.findElement(By.name("q")).click();
		test1.pass("Search field clicked");
		
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		test1.pass("Enter Key pressed on keyboard");
		
		//close Browser
				driver.close();
				test1.pass("Browser closed");
				
				test1.info("Test Completed");
				
				extent.flush();
				
				System.out.println("Test Completed Successfully");
	}

}
