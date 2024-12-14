package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUtils {

    WebDriver driver;

    public PageUtils(WebDriver driver){
        this.driver=driver;
    }


    public void scrollToElement(WebElement targetElement){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", targetElement);
    }


}
