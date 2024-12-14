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
import java.util.List;

public class ProductStepDefinitions {

private final TestContext testContext;
private final ProductPage productPage;
private final CartPage cartPage;

private List <String> selectedProducts;
    int numberOfProducts;
    public ProductStepDefinitions(TestContext testContext){
        this.testContext=testContext;
        this.productPage=testContext.pageObjectManager.getProductPage ();
        this.cartPage=testContext.pageObjectManager.getCartPage ();
    }

    @Given ( "I am on Products page" )
    public void iAmOnProductsPage ( ) {
        this.testContext.verifyCurrentURI (ConfigLoader.getProperty ("productsPageURI"),"Product Page");
    }

    @When ("I add the selected products to the cart and add to cart button change to remove button")
    public void i_add_the_selected_products_to_the_cart (DataTable dataTable){
        selectedProducts = dataTable.asList ();
        numberOfProducts = selectedProducts.size ();
        for (String product : selectedProducts) {
            productPage.clickAddToCartButton ( product );
        }
        Assert.assertEquals (Integer.parseInt ( productPage.getCartItemCount () ), numberOfProducts);
        System.out.println (productPage.getCartItemCount () +" items in cart");
        System.out.println (numberOfProducts+" products added to cart" );
        productPage.clickCartButton ();
    }
    @Then("the cart should contain exactly those products and no others")
    public void the_cart_should_contain_exactly_those_products_and_no_others() {
        this.testContext.verifyCurrentURI (ConfigLoader.getProperty ("cartPageURI"),"Cart Page");
        Assert.assertEquals ( selectedProducts,cartPage.getCartItemsDetails ());
        cartPage.clickContinueShoppingButton ();
    }
}


