package demo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.testng.Assert;

public class Test_HW_WExtReports_Add2Cart_EmptyCart {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	WebDriver driver=null;

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

	

	@Test
	public void test1() throws Exception {
		ExtentTest test = extent.createTest("Browse to HW and login", "Description: Browse to HorizonWeb and login");
       
		driver.get("https://horizonweb.myqaweb.co.uk/");
		Thread.sleep(3000);
		//Assert.assertEquals(driver.getTitle(), "Home");
	    driver.findElement(By.linkText("Got it!")).click();
	    Assert.assertEquals(driver.getTitle(), "Home");
	    Thread.sleep(1000);
		test.pass("Navigated to https://horizonweb.myqaweb.co.uk/");
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email / Username'])[1]/following::input[1]")).click();  
		//boolean actualStatus = driver.findElement(By.id("remember")).isSelected();
		//boolean actualStatus = (driver.findElement(By.xpath("//*[contains(@id=\"rememberMe\")]"))).isSelected();
		//Assert.assertEquals(actualStatus, false);
		//*[contains(@id,'rememberMe')]
		
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email / Username'])[1]/following::input[1]")).sendKeys("a");
	    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/preceding::input[1]")).click();
	    test.pass("Username entered");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::input[1]")).sendKeys("a");
	    test.pass("Password entered");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Remember Me'])[1]/following::input[1]")).click();
	    test.pass("Logged in");
	    
		test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        //test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot1.png").build());
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot1.png").build());
        test.addScreenCaptureFromPath("screenshot1.png");
	}
	
	@Test
	public void test2() throws Exception {
		ExtentTest test = extent.createTest("Search 4 a product and add it to cart ", "Description: Search for a product and add the product to the cart");
		
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search:'])[1]/following::input[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search:'])[1]/following::input[1]")).clear();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search:'])[1]/following::input[1]")).sendKeys("CQR21332");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search:'])[1]/following::input[2]")).click();
	    test.pass("Search for a product");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add to New Line in Cart'])[1]/following::input[2]")).click();
	    test.pass("Product added to the cart");
        
	    test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot2.png").build());
        test.addScreenCaptureFromPath("screenshot2.png");
	}

	@Test
	public void test3() throws Exception {
		ExtentTest test = extent.createTest("Go to cart and Empty cart ", "Description: go to the cart and empty the cart");
		
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Shopping Cart'])[1]/following::span[1]")).click();
		test.pass("Goto Cart");
	    /*
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Print'])[2]/following::input[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Order Reference'])[1]/following::input[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Order Reference'])[1]/following::input[1]")).clear();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Order Reference'])[1]/following::input[1]")).sendKeys("Order ref123213");
	    test.pass("Order reference added");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Order Reference'])[1]/following::div[5]")).click();
	    driver.findElement(By.xpath("//input[@value='Pay']")).click();
	    test.pass("Online Payment method clicked");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='I have read and agree to the'])[1]/preceding::input[1]")).click();
	    test.pass("Terms and conditions accepted");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Terms and Conditions'])[1]/following::input[1]")).click();
	    test.pass("Order processed/Checked out");
        */
		driver.findElement(By.xpath("//input[@value='Empty Cart']")).click();
		test.pass("Empty Cart button clicked");
		
		Alert a = driver.switchTo().alert();
		a.accept();   // Pressing OK
		//a.dismiss();   // Pressing on Cancel 	
		driver.switchTo().defaultContent(); // Switch driver focus back from Alert box to Main page
		test.pass("Empty cart alert message accepted");
		Thread.sleep(2000);
		
	    test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot3.png").build());
        test.addScreenCaptureFromPath("screenshot3.png");
	}
	
	/*
	@Test
	public void test4() throws Exception {
		ExtentTest test = extent.createTest("SagePay Legacy", "Description: Complete Payment VIA SagePay Legacy");
		
		Thread.sleep(2000);
		driver.switchTo().frame(0);  // switch to SagePay Iframe using Iframe index, should always be the only Iframe so Zero
		test.pass("switch to SagePay Iframe");
		driver.findElement(By.name("cardnumber")).click();
	    driver.findElement(By.name("cardnumber")).clear();
	    driver.findElement(By.name("cardnumber")).sendKeys("4929 0000 0000 6");
	    driver.findElement(By.name("expirymonth")).click();
	    new Select(driver.findElement(By.name("expirymonth"))).selectByVisibleText("12");
	    driver.findElement(By.name("expiryyear")).click();
	    new Select(driver.findElement(By.name("expiryyear"))).selectByVisibleText("2030");
	    driver.findElement(By.name("securitycode")).click();
	    driver.findElement(By.name("securitycode")).clear();
	    driver.findElement(By.name("securitycode")).sendKeys("123");
	    Thread.sleep(2000);
	    driver.findElement(By.name("proceed")).click();
		test.pass("SagePay card details entered");
		Thread.sleep(3000);
		test.pass("Payment processed VIA SagePay Iframe");
		driver.switchTo().defaultContent(); // Switch driver focus back from Iframe to Main page
		test.pass("Focus switched back from Iframe to main page");
	    
        
	    test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot4.png").build());
        test.addScreenCaptureFromPath("screenshot4.png");
	}
	*/
	
	@Test
	public void test5() throws Exception {
		ExtentTest test = extent.createTest("Logout", "Description: Log out of HorizonWeb");
		
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Change Password'])[1]/preceding::input[1]")).click();
	    test.pass("Logged out of HW");
        
	    test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot5.png").build());
        test.addScreenCaptureFromPath("screenshot5.png");
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
