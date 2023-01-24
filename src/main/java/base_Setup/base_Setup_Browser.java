package base_Setup;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class base_Setup_Browser {

    static Properties properties;
    FileInputStream myFile;
    WebDriver driver;

    public WebDriver setupBrowser() throws IOException {

        /* 	It creates an empty property list with no default values. */
        properties = new Properties();

        /* It is used for reading byte-oriented data (streams of raw bytes) such as image data, audio, video etc. You can also read character-stream data */
        myFile = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/Global_Data.properties");

        /* 	It loads data from the InputStream object */
        properties.load(myFile);

        /* ----->THIS IS THE SECTION YOU ADD WHEN YOU WANT TO USE PROFILES IN testNG, You can also specify BROWSER TYPE VIA THE TERMINAL HERE<----- You when you specify what browser to use via Terminal  mvn test -Dbrowser=firefox */
        //String browserType = System.getProperty("browser");


        /* It returns value based on the key when using the properties file to get the browserType */
        String browserType = properties.getProperty("Browser");

        if (browserType.equals("firefox")) {

            /* “System.setProperty(“propertyName”, “value”)”. It implies that it sets the system property ‘propertyName' to have the value 'value' */
            WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();
            driver = new FirefoxDriver();

        } else if (browserType.equals("chrome")) {
            WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
            driver = new ChromeDriver();
            //  driver.navigate().to(properties.getProperty("gmailURL"));

        } else if (browserType.equals("edge")) {
            WebDriverManager.getInstance(DriverManagerType.EDGE).setup();
            driver = new EdgeDriver();
            //driver.navigate().to(properties.getProperty("gmailURL"));

        } else if (browserType.equals("SAFARI")) {
            WebDriverManager.getInstance(DriverManagerType.SAFARI).setup();
            driver = new SafariDriver();
        }
        driver.navigate().to(properties.getProperty("URL"));
        return driver;
    }

    public static Properties getPropertiesObject(){
        return properties;
    }
}
