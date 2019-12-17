import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		//WebDriverManager.firefoxdriver().setup();
		//WebDriverManager.operadriver().setup();
		//WebDriverManager.phantomjs().setup();
		//WebDriverManager.edgedriver().setup();
		//WebDriverManager.iedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://google.com/");
		//WebElement textBox = driver.findElementById("ctl12_keywordTextBox");
		
		//Find element by name and type text in input field
		//WebElement textBox = driver.findElementByName("q");
		//textBox.sendKeys("This is a test");
		
		//Using xpath
		//driver.findElement(By.xpath("//input[@name='q']")).sendKeys("This is a test");
		
		//Single line by name
		driver.findElement(By.name("q")).sendKeys("This is a test");
			
		//WebElement textBox = driver.findElement(By.name("q"));
		//textBox.sendKeys("This is a test");
		
		//Identify all input elements on page and print the number to the console
		List<WebElement> listOfInputElements = driver.findElements(By.xpath("//input"));
		int count = listOfInputElements.size();
		System.out.println("Count of Input Elements : "+count);
		
		//driver.close();
		//driver.quit();
	}
	

	
	
}
