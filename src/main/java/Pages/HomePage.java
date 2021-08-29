package Pages;

import CommonMethod.Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

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

    //Form Data
    @FindBy(xpath = "//input[@value='Budi']")
    WebElement name;

    public void namedetails(String name1) {
        name.clear();
        name.sendKeys(name1);

    }

    @FindBy(xpath = "//input[@value='budi@utomo.com']")
    WebElement email;

    public void emaildetails(String email1) {
        email.clear();
        email.sendKeys(email1);
    }

    @FindBy(xpath = "//input[@value='081808466410']")
    WebElement phonenumber;

    public void phonedetails(String phonenumber1) {
        phonenumber.clear();
        phonenumber.sendKeys(phonenumber1);
    }

    @FindBy(xpath = "//input[@value='Jakarta']")
    WebElement city;

    public void citydetails(String city1) {
        city.clear();
        city.sendKeys(city1);
    }

    @FindBy(xpath = "//textarea[normalize-space()='MidPlaza 2, 4th Floor Jl.Jend.Sudirman Kav.10-11']")
    WebElement address;

    public void addressdetails(String address1) {
        address.clear();
        address.sendKeys(address1);
    }

    @FindBy(xpath = "//input[@value='10220']")
    WebElement postal;

    public void postalcodedetails(String postal1) {
        postal.clear();
        postal.sendKeys(postal1);
    }


    //Card Data

    @FindBy(xpath = "//input[@name = 'cardnumber']")
    WebElement debitcard;

    public void credicarddetails(String card) {
        debitcard.clear();
        debitcard.sendKeys(card);
    }

    @FindBy(xpath = "//input[@placeholder='MM / YY']")
    WebElement expDate;

    public void expDatedetails(String exp) {
        expDate.clear();
        expDate.sendKeys(exp);
    }

    @FindBy(xpath = "//input[@placeholder = '123']")
    WebElement cvvNumber;

    public void cvvdetails(String cvv) {
        cvvNumber.clear();
        cvvNumber.sendKeys(cvv);
    }

    @FindBy(xpath = "//a[@class='button-main-content']")
    WebElement submitpayment;

    public WebElement paymentsubmit() {
        return submitpayment;
    }

    //transactionData

    @FindBy(xpath = "//p[@id='merchant_name']")
    WebElement merchnatName;

    public WebElement merchantName() {
        return merchnatName;
    }

    @FindBy(xpath = "//p[@id='txn_amount']")
    WebElement totalPayblAmount;

    public WebElement payblAmount() {
        return totalPayblAmount;
    }

    @FindBy(xpath = "//p[@id='card_number']")
    WebElement Cardnumber;

    public WebElement carnumberdetail() {
        return Cardnumber;
    }

    @FindBy(xpath = "//input[@type='password']")
    WebElement cardpassword;

    public void cardPindetail(String pin) {
        cardpassword.clear();
        cardpassword.sendKeys(pin);
    }

    @FindBy(xpath = "//button[normalize-space()='OK']")
    WebElement cardOkbutton;

    public WebElement cardOkbuttondetails() {
        return cardOkbutton;
    }

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement cardCancelbutton;

    public WebElement cardCancelbutton() {
        return cardCancelbutton;
    }

}


