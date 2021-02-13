package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/java/features/S20_31_DeleteTask.feature", glue = "stepDefinition")
public class RunTestCase extends AbstractTestNGCucumberTests {
	
}
