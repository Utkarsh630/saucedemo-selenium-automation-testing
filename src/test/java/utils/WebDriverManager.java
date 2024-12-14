package utils;

import config.ConfigLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class WebDriverManager {
    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger (WebDriverManager.class);

    public WebDriver getDriver(){
        if (driver==null){
            if(ConfigLoader.getProperty ("browser").equalsIgnoreCase ("chrome")) {
                driver = new ChromeDriver ( );
                driver.manage ().window ().maximize ();
                driver.manage ().deleteAllCookies ();
                driver.manage ().timeouts ().implicitlyWait ( Duration.ofSeconds ( 10 ));
                logger.info ( "Initialized and started ChromeDriver" );
            } else if (ConfigLoader.getProperty ("browser").equalsIgnoreCase ("firefox")) {
                driver=new FirefoxDriver ();
                logger.info ( "Initialized and started Firefox Driver" );
            } else if (ConfigLoader.getProperty ("browser").equalsIgnoreCase ("safari")) {
                driver=new SafariDriver ();
                logger.info ( "Initialized and started Safari Driver" );
            }else{
                driver=new ChromeDriver ();
                logger.info ( "No Specific browser configuration found routing to by default ChromeDriver" );
            }
        }else {
            logger.debug ("Driver already initialized {}",driver);
        }
        return driver;
    }

    public void quitDriver(){
        if (driver!=null){
            logger.debug ("Closed Driver instance!");
            driver.close ();
        }
    }
}
