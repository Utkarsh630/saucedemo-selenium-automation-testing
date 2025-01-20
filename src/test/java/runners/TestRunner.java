package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(tags = "@regression", features = {"src/test/resources/features/"}, glue = {"stepDefinitions","hooks"},
plugin = {"pretty", "html:reports/cucumber-report/cucumber.html","json:reports/cucumber-report/cucumber.json"
,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {
//    Parallel run of tests

//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios(){
//        return super.scenarios ();
//    }
}
