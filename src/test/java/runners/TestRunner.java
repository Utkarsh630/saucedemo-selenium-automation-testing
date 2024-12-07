package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features/login.feature"}, glue = {"stepDefinitions"},
plugin = {"pretty", "html:reports/cucumber-report/cucumber.html"}, monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {
}
