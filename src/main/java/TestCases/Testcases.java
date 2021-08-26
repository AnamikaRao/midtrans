package TestCases;

import CommonMethod.Setup;
import Pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Testcases {
    public WebDriver driver;
    HomePage homePage;

    @Test
    public void tearup() throws IOException {
        driver = Setup.initiateDriver();
        homePage = new HomePage(driver);
        driver.get(Setup.properties.getProperty("url"));
        driver.manage().window().maximize();
    }
}