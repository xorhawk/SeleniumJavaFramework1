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


public class Test1 {
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
		baseUrl = "https://www.katalon.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	public void test1() throws Exception {
		driver.get("https://horizonweb.myqaweb.co.uk/");
	    driver.findElement(By.id("ctl24_emailTextBox")).click();
	    driver.findElement(By.id("ctl24_emailTextBox")).clear();
	    driver.findElement(By.id("ctl24_emailTextBox")).sendKeys("a");
	    driver.findElement(By.xpath("//body")).click();
	    driver.findElement(By.id("ctl24_passwordTextBox")).click();
	    driver.findElement(By.id("ctl24_passwordTextBox")).clear();
	    driver.findElement(By.id("ctl24_passwordTextBox")).sendKeys("a");
	    driver.findElement(By.id("ctl24_loginImageButton")).click();
	    driver.findElement(By.id("ctl12_keywordTextBox")).click();
	    driver.findElement(By.id("ctl12_keywordTextBox")).clear();
	    driver.findElement(By.id("ctl12_keywordTextBox")).sendKeys("00215x");
	    driver.findElement(By.id("ctl12_keywordgoImageButton")).click();
	    driver.findElement(By.id("ctl61_buyImageButton")).click();
	    driver.findElement(By.id("ctl14_linesLabel")).click();
	    driver.findElement(By.linkText("Got it!")).click();
	    driver.findElement(By.id("ctl54_CartGridView_ctl02_DeptDropDownList")).click();
	    new Select(driver.findElement(By.id("ctl54_CartGridView_ctl02_DeptDropDownList"))).selectByVisibleText("qa1");
	    driver.findElement(By.id("ctl54_CartGridView_ctl02_DeptDropDownList")).click();
	    driver.findElement(By.xpath("//body")).click();
	    driver.findElement(By.id("ctl54_CheckoutButton")).click();
	    driver.findElement(By.id("ctl54_orderRefTextBox_I")).click();
	    driver.findElement(By.id("ctl54_orderRefTextBox_I")).clear();
	    driver.findElement(By.id("ctl54_orderRefTextBox_I")).sendKeys("check auto");
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='You will be redirected to the Sage Pay website when you place your order.'])[1]/following::div[3]")).click();
	    driver.findElement(By.id("ctl54_termsCheckBox")).click();
	    driver.findElement(By.id("ctl54_completeImageButton")).click();
	    //driver.findElement(By.id("ctl54_printImageButton")).click();
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_1 | ]]
	    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | win_ser_local | ]]
	    driver.findElement(By.id("ctl24_loginImageButton")).click();
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
