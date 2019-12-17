import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapabilities_Demo {

	public static void main(String[] args) {

		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("requireWindowFocus", true);

		System.setProperty("webdriver.ie.driver", projectPath+"/Drivers/iedriver/IEDriverServer.exe");
		
		WebDriver driver = new InternetExplorerDriver();

		driver.get("https://google.com/");
		//Enter text in search text box		
		driver.findElement(By.name("q")).sendKeys("This is a test");
		//Click text box and press enter key on Keyboard
		driver.findElement(By.name("q")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);

		//close Browser
		driver.close();
		driver.quit();

	}

	

}
