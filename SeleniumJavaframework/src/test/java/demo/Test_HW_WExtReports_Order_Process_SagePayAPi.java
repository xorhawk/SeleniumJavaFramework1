package demo;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class Test_HW_WExtReports_Order_Process_SagePayAPi {

	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	
	WebDriver driver=null;

	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("PaymentWSagePayAPI.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);	
	}
	
	@BeforeTest
	public void setUpTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		// Implicit wait timeout for 30seconds, the driver will pause for x seconds until web element is found
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}

	@Test
	public void test1() throws Exception {
		ExtentTest test = extent.createTest("Browse to HW and login", "Description: Browse to HorizonWeb and login");
       
		driver.get("https://horizonweb.myqaweb.co.uk/");
		Thread.sleep(3000);
	    driver.findElement(By.linkText("Got it!")).click();
		test.pass("Navigated to https://horizonweb.myqaweb.co.uk/");
		//driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email / Username'])[1]/following::input[1]")).click();  
	    
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
		ExtentTest test = extent.createTest("Go to cart and complete checkout ", "Description: go to the cart and complete checkout");
		
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Shopping Cart'])[1]/following::span[1]")).click();
		test.pass("Goto Cart");
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
        
	    test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot3.png").build());
        test.addScreenCaptureFromPath("screenshot3.png");
	}
	
	@Test
	public void test4() throws Exception {
		ExtentTest test = extent.createTest("SagePay API", "Description: Complete Payment VIA SagePay API");
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@value='Pay']")).click();
		driver.findElement(By.xpath("//button[@value='VISA']//span[@class='payment-method__hint']")).click();
		driver.findElement(By.xpath("//input[@id='form-card_details.field-pan']")).sendKeys("4929000000006");
		driver.findElement(By.xpath("//input[@id='form-card_details.field-expiry_mm']")).sendKeys("2");
		driver.findElement(By.xpath("//input[@id='form-card_details.field-expiry_yy']")).sendKeys("25");
		driver.findElement(By.xpath("//input[@id='form-card_details.field-cvc']")).sendKeys("123");
		Thread.sleep(1000);
		test.pass("SagePay card details entered");
		driver.findElement(By.xpath("//button[normalize-space()='Confirm card details']")).click();
		driver.findElement(By.xpath("//button[@value=\"proceed\"]")).click();

		//driver.findElement(By.xpath("//button[normalize-space()='Pay 8.31 GBP now']")).click();
		Thread.sleep(3000);
		
	    test.pass("Payment processed VIA SagePay");
        
	    test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot4.png").build());
        test.addScreenCaptureFromPath("screenshot4.png");
	}
	
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
				System.out.println("Test Completed Successfully");
		
	}
	@AfterSuite
	public void tearDown() {
		 extent.flush();
	}
}
