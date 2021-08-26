package Pages;

import CommonMethod.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Setup {
    public WebDriver driver;

    public HomePage(WebDriver driver1)
    {
        this.driver = driver1;
        PageFactory.initElements(driver,this);
    }
}
