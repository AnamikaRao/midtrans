package CommonMethod;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Setup {
    public static Properties properties;
    public static WebDriver driver;
    public static WebDriver initiateDriver() throws IOException
    {

        properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\data.properties");
        properties.load(fis);
        String browser = properties.getProperty("browser");

        if(browser.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
        }
        else
        {
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            driver = new FirefoxDriver();
        }
        return driver;

    }
    }

