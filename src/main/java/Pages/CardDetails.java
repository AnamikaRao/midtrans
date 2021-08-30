package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardDetails extends HomePage {

    public CardDetails(WebDriver driver1) {
        super(driver1);
    }

    @FindBy(xpath = "//a[@class='list with-promo']//div[@class='list-content']//div[1]")
    WebElement clickonDebitcard;

    public void ClickOnDebitCrad() {
        clickonDebitcard.click();
    }

    @FindBy(xpath = "//p[@class='text-page-title-content']")
    WebElement debitCradtitle;

    public WebElement DebitCradTitle() {
        return debitCradtitle;
    }

    @FindBy(xpath = "//div[@class='input-row']//div[2]//div[1]//label[1]")
    WebElement promocord1DemoPromoEngline;

    public WebElement DefaultPromoCode1() {
        return promocord1DemoPromoEngline;
    }

    @FindBy(xpath = "//div[@class='input-row']//div[1]//div[1]//label[1]")
    WebElement promocode2Rupiah;

    public WebElement RupiahPromocode2() {
        return promocode2Rupiah;
    }


    @FindBy(xpath = "//div[@class='input-row']//div[3]//div[1]//label[1]")
    WebElement masterCardPromocode3;

    public WebElement MasterCradpromocode3() {
        return masterCardPromocode3;
    }

    @FindBy(xpath = "//span[@class='text-amount-amount']")
    WebElement promoamount;

    public WebElement Prmoamount() {
        return promoamount;
    }


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
}


