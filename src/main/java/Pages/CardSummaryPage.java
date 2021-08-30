package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CardSummaryPage extends HomePage {

    public CardSummaryPage(WebDriver driver1) {
        super(driver1);
    }


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

    @FindBy(xpath = "//span[normalize-space()='Thank you for your purchase.']")
    WebElement purchaseConfirmation;

    public WebElement PurchaseConfirmation() {
        return purchaseConfirmation;
    }

    @FindBy(xpath = "//span[normalize-space()='Your card got declined by the bank']")
    WebElement purchaseRejected;

    public WebElement PurchaseRejected() {
        return purchaseRejected;
    }

    @FindBy(xpath = "//span[normalize-space()='Transaction failed']")
    WebElement purchasecancelled;

    public WebElement Purchasecancelled() {
        return purchasecancelled;
    }


}
