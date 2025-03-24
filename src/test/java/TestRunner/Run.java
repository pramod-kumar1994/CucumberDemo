package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    features = "C:\\Users\\kumar\\eclipse-workspace\\Cucumber_Demo\\Features\\Registration.feature", // Use relative path
    glue = {"stepDefination"}, // Ensure the package name is correct
    dryRun = false,
    monochrome = true,
    plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Run extends AbstractTestNGCucumberTests {
}
