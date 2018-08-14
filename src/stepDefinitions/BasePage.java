package stepDefinitions;

import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import genericFunction.Property;
import genericFunction.GenericFunction;

public class BasePage {
	public static WebDriver driver;
	public static LinkedHashMap<String, String> testdataMap;
	public static String scenarioName;
	public static String description;
	public static int rownum=1;
	
	ExtentHtmlReporter htmlReport;
	ExtentReports extent;
	ExtentTest test;
	
	GenericFunction gf = new GenericFunction();
	
	
	public void openBrowser() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void navigateToUrl() throws Exception {
		driver.get("http://newtours.demoaut.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void clickElement(String element, Property locator) throws Exception {
		Thread.sleep(3000);
		
		try {
			driver.findElement(locator.getLocator(element)).click();
			test.log(Status.PASS, "Element clicked successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			test.log(Status.FAIL, "Element not clicked successfully");
		}
	}
	
	public void sendKeys(String element, Property locator, String value) throws Exception {
		Thread.sleep(3000);
		
		try {
			driver.findElement(locator.getLocator(element)).sendKeys(value);
			test.log(Status.PASS, "Value " +value+ " entered successfully");
		} catch (Exception e) {
			e.printStackTrace();
			test.log(Status.FAIL, "Value " +value+ " not entered successfully");
		}
	}
	
	public void selectByText(String element, Property locator, String value) throws Exception {
		Thread.sleep(3000);
		
		Select select = new Select(driver.findElement(locator.getLocator(element)));
		try {
			select.selectByVisibleText(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectByValue(String element, Property locator, String value) throws Exception {
		Thread.sleep(3000);
		
		Select select = new Select(driver.findElement(locator.getLocator(element)));
		try {
			select.selectByValue(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void selectByIndex(String element, Property locator, int value) throws Exception {
		Thread.sleep(3000);
		
		Select select = new Select(driver.findElement(locator.getLocator(element)));
		try {
			select.selectByIndex(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void acceptAlert() throws Exception {
		Thread.sleep(2000);
		
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert() throws Exception {
		Thread.sleep(2000);
		
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToFrame(String frameID) throws Exception {
		Thread.sleep(2000);
		
		try {
			driver.switchTo().frame(frameID);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dragAndDrop(String source, String destination, Property locator) throws Exception{
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		WebElement sourceValue = driver.findElement(locator.getLocator(source));
		WebElement target = driver.findElement(locator.getLocator(destination));
		try {
			action.dragAndDrop(sourceValue, target).build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void mouseHover(String element, Property locator) throws Exception {
		Thread.sleep(3000);
		
		Actions action = new Actions(driver);
		try {
			action.moveToElement(driver.findElement(locator.getLocator(element))).build().perform();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void uploadFile(String location) throws Exception {
		Thread.sleep(3000);
		
		try {
			Runtime.getRuntime().exec(location);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public String getText(String element, Property locator) throws Exception {
		Thread.sleep(3000);
		
		String text = null;
		try {
			text = driver.findElement(locator.getLocator(element)).getText();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return text;
	}
	
	public void readexceldata(String ScenarioName, String SheetName) throws Exception {
		testdataMap = gf.getTestDataListByScenario(System.getProperty("user.dir")+"\\src\\supporting_files", "TestData_V2", SheetName, ScenarioName).get(rownum-1);
		System.out.println(testdataMap);
		System.out.println(testdataMap.get("Username"));
		System.out.println(testdataMap.get("Scenario"));
		scenarioName = testdataMap.get("Scenario");
		description = testdataMap.get("Description");
	}
	
	public void setReport(String Scenario, String Description) {
		htmlReport = new ExtentHtmlReporter("ExtentReport.html"); 
		extent = new ExtentReports();
		extent.attachReporter(htmlReport);
		test = extent.createTest(Scenario, Description);
	}
	
	public void closeBrowser() {
		driver.quit();
		test.log(Status.PASS, "Browser closed successfully");
		extent.flush();
	}

}
