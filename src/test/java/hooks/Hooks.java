package hooks;

import config.ConfigLoader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.TestContext;
import utils.WebDriverManager;

public class Hooks {


    private final TestContext testContext;
    public Hooks(TestContext testContext){
        this.testContext=testContext;
    }


    @Before
    public void setup(){
        this.testContext.driver.get ( ConfigLoader.getProperty ( "baseURI" ));

    }

    @After
    public void tearDown(){
        this.testContext.webDriverManager.quitDriver ();
    }

}
