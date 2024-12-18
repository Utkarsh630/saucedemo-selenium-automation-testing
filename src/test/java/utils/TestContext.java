package utils;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;

public class TestContext {

    public WebDriver driver;
    public PageObjectManager pageObjectManager;
    public WebDriverManager webDriverManager = new WebDriverManager ();
     public List <String> selectedProducts;
     public int numberOfProducts;


    public TestContext(){
        driver=webDriverManager.getDriver ();
        pageObjectManager = new PageObjectManager (driver);
    }

    public void verifyCurrentURI(String expectedURI,String pageName){
        Assert.assertEquals (driver.getCurrentUrl (), expectedURI,"mismatch in"+ pageName +" URI");
    }

    public void addProductToCart(DataTable dataTable){
        selectedProducts = dataTable.asList ();
        numberOfProducts = selectedProducts.size ();
        for (String product : selectedProducts) {
            pageObjectManager.getProductPage ().clickAddToCartButton ( product );
        }
    }


}

