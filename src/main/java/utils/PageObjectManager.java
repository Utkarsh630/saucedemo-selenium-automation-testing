package utils;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductPage;

public class PageObjectManager {

    public WebDriver driver;

    public PageObjectManager(WebDriver driver){
        this.driver=driver;
    }

    public LoginPage getLoginPage(){
        return new LoginPage (driver);
    }

    public ProductPage getProductPage(){
        return new ProductPage (driver);
    }

    public PageUtils getPageUtils(){
        return new PageUtils (driver);
    }

    public CartPage getCartPage(){
        return new CartPage (driver);
    }

}
