package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements (driver,this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement userName_field;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password_field;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement login_button;

    @FindBy(xpath = "//div[@class='error-message-container error']/h3")
    private WebElement error_message;

    public void enterUsername(String message){
        userName_field.sendKeys (message);
    }
    public void enterPassword(String message ){
        password_field.sendKeys (message);
    }
    public void clickLoginButton(){
        login_button.click ();
    }

    public boolean isProductsPageDisplayed(){
        return driver.getCurrentUrl ().contains("inventory");
    }

    public String getErrorMessage(){
        return error_message.getText ();
    }
}
