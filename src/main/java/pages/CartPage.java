package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.PageUtils;

import java.util.ArrayList;
import java.util.List;

public class CartPage {

    private static final Logger logger = LogManager.getLogger ( CartPage.class );

    private static final String CONTINUE_SHOPPING_BUTTON_SELECTOR = "#continue-shopping";
    private static final String CHECKOUT_BUTTON_SELECTOR = "#checkout";
    private static final String REMOVE_BUTTON_SELECTOR = "button[id*='remove']']";
    private static final String CART_ITEM_NAMES_SELECTOR = "div[class='inventory_item_name']";

    private WebDriver driver;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements (driver,this);
    }


    @FindBy(css = CONTINUE_SHOPPING_BUTTON_SELECTOR)
    private static WebElement continueShoppingButton;

    @FindBy(css = CHECKOUT_BUTTON_SELECTOR)
    private static WebElement checkoutButton;

    @FindBy(css = REMOVE_BUTTON_SELECTOR)
    private static WebElement removeButton;

    @FindBy(css = CART_ITEM_NAMES_SELECTOR)
    private List <WebElement> cartItemsName;


    public void clickContinueShoppingButton(){
        if(continueShoppingButton.isDisplayed ()){
            continueShoppingButton.click ();
            logger.debug ("Clicked Continue Shopping Button!");
        }else {
            logger.warn("Continue Shopping Button is not displayed!");
            throw new RuntimeException("Continue Shopping Button is not displayed!");
            }
    }

    public void clickCheckoutButton(){
        if(checkoutButton.isDisplayed ()){
            checkoutButton.click ();
            logger.debug ("Clicked Checkout Button!");
        }else {
            logger.warn("Checkout Button is not displayed!");
            throw new RuntimeException("Checkout Button is not displayed!");
        }
    }

    public void clickRemoveButton(){
        if(removeButton.isDisplayed ()){
            removeButton.click ();
            logger.debug ("Clicked Remove Button!");
        }else {
            logger.warn("Remove Button is not displayed!");
            throw new RuntimeException("Remove Button is not displayed!");
        }
    }

    public List< String> getCartItemsDetails(){
        List<String> itemNamesList = new ArrayList <> ();
        for (WebElement itemName:cartItemsName){
            itemNamesList.add (itemName.getText ());
        }
        return itemNamesList;
    }
}
