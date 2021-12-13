package demo;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Test4_W_Extent_Reports {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeClass(alwaysRun = true)
	public void setUp() throws Exception {

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		baseUrl = "https://horizonweb.myqaweb.co.uk/";
		// Implicit wait timeout for 30seconds, the driver will pause for x seconds until web element is found
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	// Login to HW, search for product, add to cart, go through checkout, add order ref, order on account
	public void test1() throws Exception {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Test_extentReports.html");
		
		// create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
     // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("HW Ext report Test", "Simple test to validate HW functionality");
		
		driver.get("https://horizonweb.myqaweb.co.uk/");
		test1.pass("Navigated to horizonweb.myqaweb.co.uk");
		Thread.sleep(3000);
	    driver.findElement(By.linkText("Got it!")).click();
	    //Thread.sleep(3000);
	    // Using xpath instead of dynamic elements
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email / Username'])[1]/following::input[1]")).click();  
	    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email / Username'])[1]/following::input[1]")).clear();
	    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email / Username'])[1]/following::input[1]")).clear();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Email / Username'])[1]/following::input[1]")).sendKeys("a");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/preceding::input[1]")).click();
	    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::input[1]")).clear();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Password'])[1]/following::input[1]")).sendKeys("a");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Remember Me'])[1]/following::input[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search:'])[1]/following::input[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search:'])[1]/following::input[1]")).clear();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search:'])[1]/following::input[1]")).sendKeys("CQR21332");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search:'])[1]/following::input[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Add to New Line in Cart'])[1]/following::input[2]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Shopping Cart'])[1]/following::span[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Print'])[2]/following::input[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Order Reference'])[1]/following::input[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Order Reference'])[1]/following::input[1]")).clear();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Order Reference'])[1]/following::input[1]")).sendKeys("Order ref123213");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Order Reference'])[1]/following::div[5]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='I have read and agree to the'])[1]/preceding::input[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Terms and Conditions'])[1]/following::input[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Change Password'])[1]/preceding::input[1]")).click();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}
}
