package Pages;

import CommonMethod.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Setup {
    public WebDriver driver;

    public HomePage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.buy")
    WebElement buynow;

    public void clickbunnowbutton() {
        buynow.click();
    }

    @FindBy(xpath = "//div[@class='cart-inner']//span[1]")
    WebElement ShoppingCart;

    public WebElement titleShoppingcart() {
        return ShoppingCart;

    }

    @FindBy(xpath = "//td[@class='amount']")
    WebElement totalamount;

    public WebElement verifytotalamount() {
        return totalamount;
    }

    @FindBy(xpath = "//div[@class='cart-checkout']")
    WebElement checkbtn;

    public WebElement checkoutbutton() {
        return checkbtn;
    }

    @FindBy(xpath = "//p[@class='text-page-title-content']")
    WebElement ordersummarytitle;

    public WebElement summarytitle() {
        return ordersummarytitle;
    }

    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement ordersummaryContinue;

    public void continuebutton() {
        ordersummaryContinue.click();
    }

    @FindBy(xpath = "//p[@class='text-page-title-content']")
    WebElement selectpaymenttitle;

    public WebElement Selectpaymenttitle() {
        return selectpaymenttitle;
    }


}


