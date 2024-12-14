package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(tags = "", features = {"src/test/resources/features/"}, glue = {"stepDefinitions","hooks"},
plugin = {"pretty", "html:reports/cucumber-report/cucumber.html"}, monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {
//    Parallel run of tests

//    @Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios(){
//        return super.scenarios ();
//    }
}
