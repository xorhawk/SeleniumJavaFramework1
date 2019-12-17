import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserTest {

	public static void main(String[] args) {
		
		String projectPath = System.getProperty("user.dir");
		System.out.println("projectPath : "+projectPath);
		
		//System.setProperty("webdriver.gecko.driver", projectPath+"/Drivers/geckodriver/geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver", projectPath+"/Drivers/chromedriver/chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		
		System.setProperty("webdriver.ie.driver", projectPath+"/Drivers/iedriver/IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://horizonweb.myqaweb.co.uk/");
		
		driver.close();
	}
	
}
