package demo;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.appender.rolling.action.DeleteAction;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import utils.ExcelUtils; // My tiny Excel data reader utility

import org.testng.Assert;

public class Test_HW_WExtReports_Add2Cart_EmptyCart_DataDriven_using_abstract extends MyAbstractClass{
	

	@Test(description="This TC will load the app and login")
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
	    //driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Remember Me'])[1]/following::input[1]")).click();
	    driver.findElement(By.className("cssloginImageButton")).click(); //Same button click but using classname to locate element
	    test.pass("Logged in");
	    
		test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        //test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot1.png").build());
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot1.png").build());
        test.addScreenCaptureFromPath("screenshot1.png");
	}
	
	@Test(description="This TC adds products to cart product codes are in xlsx spreadsheet", dataProvider="productdata")
	public void test2(String productCode) throws Exception {
		ExtentTest test = extent.createTest("Search 4 a product and add it to cart ", "Description: Search for a product and add the product to the cart");
		
		driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search:'])[1]/following::input[1]")).click();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search:'])[1]/following::input[1]")).clear();
	    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search:'])[1]/following::input[1]")).sendKeys(productCode);
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
	    
		driver.findElement(By.xpath("//input[@value='Empty Cart']")).click();
		test.pass("Empty Cart button clicked");
		
		Alert a = driver.switchTo().alert(); // Switch driver focus to the Alert box
		Thread.sleep(1000);
		a.accept();   // Pressing OK button to confirm to empty cart
		//a.dismiss();   // Pressing Cancel button
		driver.switchTo().defaultContent(); // Switch driver focus back from Alert box to Main page
		test.pass("Empty cart alert message accepted");
		Thread.sleep(2000);
		
	    test.log(Status.INFO, "This step shows usage of log(status, details)");
        test.info("This step shows usage of info(details)");
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot3.png").build());
        test.addScreenCaptureFromPath("screenshot3.png");
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
	
	@DataProvider(name = "productdata")
	public Object getData( ) {
		String excelPath = "C:/Users/Sveinn Ari/Selenium Maven Test/Excel/productdata.xlsx";

		Object data[][] = testData(excelPath, "Sheet1");
		return data;
	}

	public Object[][] testData(String excelPath, String sheetName)	{

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object data[][] = new Object[rowCount-1][colCount];

		for(int i=1; i<rowCount; i++)	{
			for(int j=0; j<colCount; j++)	{

				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData+" | ");
				data[i-1][j] = cellData;

			}
			//System.out.println();
		}
		return data;

	}
	
	
}
