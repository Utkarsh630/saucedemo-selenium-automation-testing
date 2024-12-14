package config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ConfigLoader {

    private static final Properties properties = new Properties();
    private static final String filePath=System.getProperty ("user.dir")+"/src/test/resources/configurations/config.properties";
    private static final Logger logger = LogManager.getLogger (ConfigLoader.class);

    static {
        logger.debug ("Trying to read configuration file!");
        try(FileInputStream fileInputStream = new FileInputStream (filePath)){
            properties.load (fileInputStream);
            logger.debug ("Configuration file loaded successfully!");
        }catch (IOException e){
            logger.error("Failed to load configuration file, there might be issue with file path: {}",filePath);
            throw new RuntimeException("Error to load configuration file!",e);
        }
    }

    public static String getProperty(String key){
        if(!(key.isEmpty () || key.isBlank () || key.equals (" "))){
            String value = properties.getProperty (key);
            if(value!=null){
                logger.debug ("Property loaded with key: {} and value: {}",key,value);
                return value;
            }else {
                logger.warn ("Property with key {} not found in configuration file!",key);
                throw new RuntimeException( key + ":- not specified in the Configuration.properties file.");
            }
        }else{
            logger.warn("key {} can not be empty or null!",key);
            throw new RuntimeException( key + ":- key found to be empty or null value!");
        }
    }




}
