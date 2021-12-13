package demo;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MyAbstractClass {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	WebDriver driver=null;
	//public WebDriver driver;

	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("Cancel_Empty_Cart.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);	
	}
	
	
	
	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies(); 
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); //timeout for 30seconds, the driver will pause/wait for x seconds until page is loaded
		// Implicit wait timeout for 30seconds, the driver will pause/wait for x seconds until web element is found
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	
	@AfterMethod // What happens after each test case
	// This will take a screenshot if there is a test failure
	public void afterMethod(ITestResult result) throws Exception{
		 //System.out.println("Msg written after each test, just to verify that afterMethod is working as it should");
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot tc=(TakesScreenshot)driver; // Converted driver to a takesScreenShot type
			File src=tc.getScreenshotAs(OutputType.FILE);  // It will take ScreenShot but will store into Java's buffer memory
			FileHandler.copy(src, new File(result.getName()+".png")); // Copy from Java Memory and write to file
		}
	}
	

	  @AfterTest
		public void tearDownTest() {
			
			//close browser
					driver.close();
					driver.quit();
					System.out.println("Tests Completed Successfully");
			
		}
		@AfterSuite
		public void tearDown() {
			 extent.flush();
		}
	}