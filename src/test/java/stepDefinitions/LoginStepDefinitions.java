package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.WebDriverManager;

public class LoginStepDefinitions {
    WebDriver driver = WebDriverManager.getDriver();
    LoginPage loginPage = new LoginPage (driver);

    @Given ("I am on the Sauce Demo login page")
    public void i_am_on_the_sauce_demo_login_page() {
        driver.get ("https://www.saucedemo.com/");
    }

    @When("I enter valid username {string}")
    public void i_enter_valid_username(String string) {
        loginPage.enterUsername (string);
    }

    @When("I enter valid password {string}")
    public void i_enter_valid_password(String string) {
        loginPage.enterPassword (string);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
       loginPage.clickLoginButton();
    }

    @Then("I should see the products page")
    public void i_should_see_the_products_page() {
        Assert.assertTrue (loginPage.isProductsPageDisplayed ());
    }

    @When ("I enter invalid username {string}")
    public void i_enter_invalid_username(String string) {
        loginPage.enterUsername (string);
    }

    @Then ("I should see an error message {string}")
    public void i_should_see_an_error_message(String string) {
        Assert.assertEquals (loginPage.getErrorMessage (),string);
    }

}
