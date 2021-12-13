package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

import com.google.common.base.Function;

public class FluentWaitDemo {

	public static void main(String[] args) throws Exception {
		test();
	}

	public static void test() throws Exception {

		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Abcd - NIHM");
		//driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);

		//driver.findElement(By.linkText("ABCD - NIMH Data Archive - NIMH")).click();

		// Waiting 30 seconds for an element to be present on the page, checking
		// for its presence once every 5 seconds.
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(2))
				.ignoring(NoSuchElementException.class);

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {

				WebElement linkElement= driver.findElement(By.xpath("//cite[contains(text(),'https://nda.nih.gov')]"));
				// WebElement linkElement= driver.findElement(By.xpath(projectPath//span[contains(text(),'ABCD - NIMH Data Archive - NIH')])
				//WebElement linkElement= driver.findElement(By.xpath("//*[normalize-space(text()) and normalize-space(.)='Web result with site links'])[1]/following::span[1]"));

				if(linkElement.isEnabled()) {
					System.out.println("Success : Element Found (Link found in Search results according to the xpath ");

				}
				return linkElement;
			}
		});

		//Click the link once found
		element.click();

		Thread.sleep(3000);

		driver.close();
		driver.quit();

	}

}
