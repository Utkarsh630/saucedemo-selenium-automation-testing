package stepDefinitions;

import config.ConfigLoader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.CartPage;
import pages.ProductPage;
import utils.TestContext;

public class ProductStepDefinitions {

    private static final String PRODUCT_PAGE_URI = ConfigLoader.getProperty ("productsPageURI");
    private static final String CART_PAGE_URI = ConfigLoader.getProperty ("cartPageURI");

private final TestContext testContext;
private final ProductPage productPage;
private final CartPage cartPage;



    public ProductStepDefinitions(TestContext testContext){
        this.testContext=testContext;
        this.productPage=testContext.pageObjectManager.getProductPage ();
        this.cartPage=testContext.pageObjectManager.getCartPage ();
    }

    @Given ( "I am on Products page" )
    public void iAmOnProductsPage ( ) {
        this.testContext.verifyCurrentURI (PRODUCT_PAGE_URI,"Product Page");
    }

    @When ("I add the selected products to the cart and add to cart button change to remove button")
    public void i_add_the_selected_products_to_the_cart (DataTable dataTable){
        this.testContext.addProductToCart ( dataTable );
        Assert.assertEquals (Integer.parseInt ( productPage.getCartItemCount () ), testContext.numberOfProducts);
        productPage.openCart ();
    }

    @Then("the cart should contain exactly those products and no others")
    public void the_cart_should_contain_exactly_those_products_and_no_others() {
        this.testContext.verifyCurrentURI (CART_PAGE_URI,"Cart Page");
        Assert.assertEquals ( testContext.selectedProducts,cartPage.getCartItemsDetails ());
    }
}


