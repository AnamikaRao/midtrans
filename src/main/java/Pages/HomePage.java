package Pages;

import CommonMethod.Setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends Setup {
    public WebDriver driver;

    public HomePage(WebDriver driver1) {
        this.driver = driver1;
        PageFactory.initElements(driver, this);
    }

    @FindBy( css= ".btn.buy")
    WebElement buynow;

    public void clickbunnowbutton() {
        buynow.click();
    }

  @FindBy(xpath = "//div[@class='cart-inner']//span[1]")
    WebElement ShoppingCart;

    public WebElement titleShoppingcart()
    {
        return ShoppingCart;

    }

    @FindBy(xpath = "//td[@class='amount']")
    WebElement totalamount;

    public WebElement verifytotalamount()
    {
        return  totalamount;
    }

    @FindBy(xpath = "//div[@class='cart-checkout']")
    WebElement checkbtn;

    public WebElement checkoutbutton()
    {
        return checkbtn;
    }

    @FindBy(xpath="//input[@value='Budi']")
    WebElement name;
    public void namedetails(String name1)
    {
        name.clear();
        name.sendKeys(name1);

    }
    @FindBy(xpath="//input[@value='budi@utomo.com']")
    WebElement email;
    public void emaildetails(String email1)
    {
        email.clear();
        email.sendKeys(email1);
    }
    @FindBy(xpath="//input[@value='081808466410']")
    WebElement phonenumber;
    public void phonedetails(String phonenumber1)
    {
        phonenumber.clear();
        phonenumber.sendKeys(phonenumber1);
    }
    @FindBy(xpath="//input[@value='Jakarta']")
    WebElement city;
    public void citydetails(String city1)
    {
        city.clear();
        city.sendKeys(city1);
    }
    @FindBy(xpath="//textarea[normalize-space()='MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11']")
    WebElement address;
    public void addressdetails(String address1)
    {
        address.clear();
        address.sendKeys(address1);
    }
    @FindBy(xpath="//input[@value='10220']")
    WebElement postal;
    public void postalcodedetails(String postal1)

    {
        postal.clear();
        postal.sendKeys(postal1);
    }

}


