package utils;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestContext {

    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public WebDriverManager webDriverManager = new WebDriverManager ();


    public TestContext(){
        driver=webDriverManager.getDriver ();
        pageObjectManager = new PageObjectManager (driver);
    }

    public void verifyCurrentURI(String expectedURI,String pageName){
        Assert.assertEquals (driver.getCurrentUrl (), expectedURI,"mismatch in"+ pageName +" URI");
    }

}

