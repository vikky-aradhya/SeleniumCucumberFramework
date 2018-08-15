package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
		format = {"pretty","html:target/cucumber"},
		features = {"src/features"},
		glue = {"stepDefinitions/"},
		tags = {"@Login_user"}
		)
public class TestRunner extends AbstractTestNGCucumberTests{
	

}