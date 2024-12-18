package pages;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class ProductPage {
    private static final String INVENTORY_ITEM_NAME_SELECTOR="a div[class='inventory_item_name ']";
    private static final String INVENTORY_ITEM_PRICE_SELECTOR="div[class='inventory_item_price']";
    private static final String ADD_TO_CART_BUTTON_SELECTOR ="button[class*='btn_inventory']";
    private static final String CART_BUTTON_SELECTOR =".shopping_cart_link";

    @FindBy(css = INVENTORY_ITEM_NAME_SELECTOR)
    List< WebElement> inventoryItemsName;

    @FindBy(css = INVENTORY_ITEM_PRICE_SELECTOR)
     List< WebElement> inventoryItemsPrice;

    @FindBy(css = ADD_TO_CART_BUTTON_SELECTOR)
     List<WebElement> inventoryItemsAddToCart;
    @FindBy(css = CART_BUTTON_SELECTOR)
    WebElement cartButton;

    private static final Logger logger = LogManager.getLogger ( ProductPage.class );
    WebDriver driver;

    public ProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements (driver,this);
    }

    public List <String> getInventoryItemsName(){
        logger.info("Collecting Item names:{}",driver.getCurrentUrl ());
        return getElementTextList ( inventoryItemsName, "Item name" );
    }
    public List< String> getInventoryItemsPrice(){
        logger.info("Collecting Item prices:");

        return getElementTextList ( inventoryItemsPrice, "Item price" );
    }

    private List<String> getElementTextList(List<WebElement> elementList, String logMessagePrefix){
        List<String> elementTextList = new ArrayList <> ();
        for (WebElement element:elementList){
            String text = element.getText ();
            elementTextList.add (text);
            logger.info("{}: {}", logMessagePrefix, text);
        }
        return elementTextList;
    }

    private int findItemIndexByName(String itemName){
        for(int i=0;i<inventoryItemsName.size ();i++){
            if(inventoryItemsName.get ( i ).getText ().equals(itemName)){
                return i;
            }
        }
        return -1;
    }


    public void clickAddToCartButton(String itemName){
        logger.debug("Attempting to add product '{}' to cart", itemName);
        int itemIndex = findItemIndexByName ( itemName );
        if(itemIndex==-1){
            logger.warn ("{} not present in the inventory list",itemName);
            throw new RuntimeException ("Item not in the inventory");
        }
        WebElement addToCartButton = inventoryItemsAddToCart.get ( itemIndex );
        if (addToCartButton.getText ().equalsIgnoreCase ( "Add to cart" )){
            addToCartButton.click ();
            logger.debug ("Added product {} to cart successfully",itemName);
        }else {
            logger.warn ("Product {} already added to cart!",itemName);
            throw new RuntimeException ("Product already added to cart!");
        }
    }

    public String getCartItemCount(){
        return cartButton.getText ();
    }

    public void openCart(){
        cartButton.click ();
    }
}
