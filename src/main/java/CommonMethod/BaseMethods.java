package CommonMethod;

import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseMethods extends HomePage{

    public BaseMethods(WebDriver driver1) {
        super(driver1);
    }

    public void waitforCheckoutbutton()
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class='cart-checkout']"))));
    }
    public void implictwait()
    {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    public static void holdExcution(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
