package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

public class ApplitoolsDemo {

	public static void main(String[] args) {

		// Open a Chrome browser.
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Initialize the eyes SDK and set private API key.
		Eyes eyes = new Eyes();
		eyes.setApiKey("kWvH8naMmvv82L1119GBYAuoGPVD3109lotj93R29SMKFBY110");

		try{

			// Start the test and set the browser's viewport size to 800x600.
			eyes.open(driver, "Hello World!", "My first Applitools Selenium Java test!",
					//To get viewport size go to http://viewportsizes.mattstow.com/mine/
					new RectangleSize(1920, 937));

			// Navigate the browser to the "test" web-site.
			driver.get("https://horizonweb.myqaweb.co.uk/");
			
			// Visual checkpoint #1.
			eyes.checkWindow("before logging in!");
			
			//Perform site login steps
			driver.findElement(By.id("ctl24_emailTextBox")).click();
			driver.findElement(By.id("ctl24_emailTextBox")).clear();
			driver.findElement(By.id("ctl24_emailTextBox")).sendKeys("a");
			driver.findElement(By.xpath("//body")).click();
			driver.findElement(By.id("ctl24_passwordTextBox")).click();
			driver.findElement(By.id("ctl24_passwordTextBox")).clear();
			driver.findElement(By.id("ctl24_passwordTextBox")).sendKeys("a");
			driver.findElement(By.id("ctl24_loginImageButton")).click();



			// Click the "Click me!" button.
			//driver.findElement(By.tagName("button")).click();

			// Visual checkpoint #2. after login
			eyes.checkWindow("logged in!");

			// End the visual test.
			eyes.close();

		} finally {

			// Close the browser.
			driver.quit();

			// If the test was aborted before eyes.close was called, ends the test as aborted.
			eyes.abortIfNotClosed();
		}


	}

}
