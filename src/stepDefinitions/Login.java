package stepDefinitions;


import org.testng.Assert;

import com.aventstack.extentreports.Status;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import genericFunction.Property;

public class Login extends BasePage{ 
	
	public Property loginmap = new Property(System.getProperty("user.dir")+"\\src\\ObjectMapping\\login.properties");
	
	@Given("^test data is read from excel \"([^\"]*)\" under \"([^\"]*)\"$")
	public void test_data_is_read_from_excel_under(String scenarioName, String sheetName) throws Throwable { 

		System.out.println(scenarioName);
		System.out.println(sheetName);
		readexceldata(scenarioName, sheetName);
		Thread.sleep(3000);
		setReport(BasePage.scenarioName, BasePage.description);
	}
	
	@When("^User opens browser$")
	public void user_opens_browser() throws Throwable { 
		try {
			openBrowser();
			test.log(Status.PASS, "Browser opened sucessfully");
		}
		catch(Exception e) {
			e.getMessage();
			test.log(Status.FAIL, "Unable to open the browser");
		}
		try {
			navigateToUrl();
			test.log(Status.PASS, "Navigated to URL sucessfully");
		}
		catch(Exception e) {
			e.getMessage();
			test.log(Status.FAIL, "Not bale to navigate to the URL");
		}
	}

	@And("^user enters the username$")
	public void user_enters_the_username() throws Throwable { 
		sendKeys("username", loginmap, testdataMap.get("Username"));
	}

	@And("^user enters the password$")
	public void user_enters_the_password() throws Throwable { 
		sendKeys("password", loginmap, testdataMap.get("Password"));
	}
	
	/*@And("^user enters the username as \"([^\"]*)\"$")
	public void user_enters_the_username_as(String name) throws Throwable {
		driver.findElement(By.name("userName")).sendKeys(name);
		Thread.sleep(3000);
	}

	@And("^user enters the password as \"([^\"]*)\"$")
	public void user_enters_the_password_as(String pwd) throws Throwable {
		driver.findElement(By.name("password")).sendKeys(pwd);
		Thread.sleep(3000);
	}
	
	@Given("^user enters the username and password$")
	public void user_enters_the_username_and_password(DataTable usercredentials) throws Throwable {
		List<List<String>> data = usercredentials.raw();
		driver.findElement(By.name("userName")).sendKeys(data.get(0).get(0));
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
		
	}*/

	@Then("^user clicks on Login$")
	public void user_clicks_on_Login() throws Throwable { 
		clickElement("signin", loginmap);
	}

	@And("^the verify the title$")
	public void the_verify_the_title() throws Throwable { 
		String expected = "Find a Flight: Mercury Tours:";
		Assert.assertEquals(driver.getTitle(), expected);
		
	}
	
	@Then("^user quits the browser$")
	public void user_quits_the_browser() throws Throwable { 
		closeBrowser();
	}

}
