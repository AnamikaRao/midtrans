package TestCases;

import CommonMethod.BaseMethods;
import CommonMethod.Setup;
import Pages.CardDetails;
import Pages.CardSummaryPage;
import Pages.HomePage;
import Pages.UserDetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Testcases {
    public WebDriver driver;
    HomePage homePage;
    UserDetails userDetails;
    CardDetails cardDetails;
    BaseMethods baseMethods;
    CardSummaryPage cardSummaryPage;

    @BeforeTest(groups={"alwaysrun"})
    public void tearup() throws IOException {
        driver = Setup.initiateDriver();
        homePage = new HomePage(driver);
        userDetails = new UserDetails(driver);
        cardDetails = new CardDetails(driver);
        baseMethods = new BaseMethods(driver);
        cardSummaryPage = new CardSummaryPage(driver);
    }

    @BeforeMethod(groups={"alwaysrun"})
    public void getUrl() {
        driver.get(Setup.properties.getProperty("url"));
        driver.manage().window().maximize();
        baseMethods.implictwait();
    }
@AfterTest(groups={"alwaysrun"})
public void tearDown()
{
    driver.close();
}

    //Verify the title
    @Test(groups={"regression"})
    public void verifyTitle() {
        String urlstore = driver.getCurrentUrl();
        Assert.assertEquals(urlstore, "https://demo.midtrans.com/");
    }

    //verify buy now button redirect to checkout popup reg and smoke
    @Test(groups={"regression","smoke"})
    public void buynowbutton() {
        homePage.clickbunnowbutton();
        baseMethods.waitforCheckoutbutton();
        Assert.assertTrue(homePage.checkoutbutton().isDisplayed());

    }

    //verify the total amount reg
    @Test(groups={"regression"})
    public void verifyTotal() {
        buynowbutton();
        Assert.assertEquals(homePage.verifytotalamount().getText(), "20,000");
    }

    //Verify Name and all on Checkoutpage Reg
    @Test(groups={"regression"})
    public void verifylabel() {
        buynowbutton();
        List<WebElement> label = driver.findElements(By.xpath("//td[@class='input-label']"));
        List Expctedlist = new ArrayList();
        for (WebElement l1 : label) {
            Expctedlist.add(l1.getText());
        }
        Assert.assertEquals(Expctedlist.toString(), "[Name, Email, Phone no, City, Address, Postal Code]");
    }


    //Verify user data can be added Reg
    @Test(groups={"regression"})
    public void addData() {
        buynowbutton();
        userDetails.namedetails(Setup.properties.getProperty("name"));
        userDetails.addressdetails(Setup.properties.getProperty("Address"));
        userDetails.citydetails(Setup.properties.getProperty("City"));
        userDetails.phonedetails(Setup.properties.getProperty("Phone"));
        userDetails.emaildetails(Setup.properties.getProperty("email"));
        userDetails.postalcodedetails(Setup.properties.getProperty("Postalcode"));
    }
//Verify clicking on checkout redirect to order summary reg and smoke

    @Test(groups={"regression","Smoke"})
    public void poup() {
        addData();
        homePage.checkoutbutton().click();
        driver.switchTo().frame(0);
        Assert.assertEquals(homePage.summarytitle().getText(), "Order Summary");
    }

    //Verify name and amount is visible Reg
    @Test(groups={"regression"})
    public void verifyData() throws InterruptedException {
        poup();
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='text-amount-amount']")).getText(), "20,000");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='item-name']")).getText(), "Midtrans Pillow");
    }

    //verify click on continue button select payment page open Reg and smoke
    @Test(groups={"regression","smoke"})
    public void redirecttopayment() {
        poup();
        homePage.continuebutton();
        Assert.assertEquals(homePage.Selectpaymenttitle().getText(), "Select Payment");
    }

    //Verify All payment Methods display reg
    @Test(groups={"regression"})
    public void paymentMethod() throws InterruptedException {

        redirecttopayment();
        baseMethods.holdExcution(5);
        List<WebElement> paymentname = driver.findElements(By.xpath("//div[@class='list-title text-actionable-bold']"));
        ArrayList metholist = new ArrayList();
        for (WebElement pay : paymentname) {
            metholist.add(pay.getText());

        }
        Assert.assertEquals(metholist.toString(), "[Credit/Debit Card, ATM/Bank Transfer, GoPay/other e-Wallets, ShopeePay/other e-Wallets, KlikBCA, BCA KlikPay, OCTO Clicks, Danamon Online Banking, e-Pay BRI, LINE Pay e-cash | mandiri e-cash, Telkomsel Cash, Indomaret, Alfa Group, Akulaku]");

    }

    //verify clicking on debitcard it redirect to card details page Reg and smoke

    @Test(groups={"regression","smoke"})
    public void debitCardDetails() {
        redirecttopayment();
        cardDetails.ClickOnDebitCrad();
        Assert.assertEquals(cardDetails.DebitCradTitle().getText(), "Credit/Debit Card");
    }

    //verify amount changes when user apply promo code Reg
    @Test(groups={"regression"})
    public void promoCode() throws InterruptedException {
        debitCardDetails();

        if (!cardDetails.DebitCradTitle().isEnabled()) {
            cardDetails.DebitCradTitle().click();
        }
        Assert.assertEquals(cardDetails.Prmoamount().getText(), "18,000");

        baseMethods.implictwait();
        cardDetails.RupiahPromocode2().click();
        Assert.assertEquals(cardDetails.Prmoamount().getText(), "19,990");
        baseMethods.implictwait();
        cardDetails.MasterCradpromocode3().click();
        baseMethods.implictwait();
        Assert.assertEquals(cardDetails.Prmoamount().getText(), "19,000");
  }


    //verify carddetails and submit Reg and smoke
    @Test(groups={"regression","smoke"})
    public void cardinput() throws InterruptedException {

        debitCardDetails();
        cardDetails.credicarddetails(Setup.properties.getProperty("card"));
        cardDetails.expDatedetails(Setup.properties.getProperty("expDate"));
        cardDetails.cvvdetails(Setup.properties.getProperty("cvv"));
        baseMethods.implictwait();
        cardDetails.paymentsubmit().click();
    }

    //Verify gateaydetails reg
    @Test(groups={"regression"})
    public void transcationConfirmation() throws InterruptedException {
        cardinput();
        baseMethods.holdExcution(2);
        driver.switchTo().frame(0);
        baseMethods.holdExcution(3);
        Assert.assertEquals(cardSummaryPage.merchantName().getText(), "Rubicon Store");
        Assert.assertEquals(cardSummaryPage.payblAmount().getText(), "18000.00");
        baseMethods.holdExcution(3);
        Assert.assertEquals(cardSummaryPage.carnumberdetail().getText(), "481111-1114");
    }

    //verify click on Ok with correct pin Reg and smoke

    @Test(groups={"regression","smoke"})
    public void verifycorrectpin() throws InterruptedException {
        cardinput();
        baseMethods.holdExcution(5);
        driver.switchTo().frame(0);
        cardSummaryPage.cardPindetail(Setup.properties.getProperty("correctpin"));
        cardSummaryPage.cardOkbuttondetails().click();
        baseMethods.holdExcution(2);
        Assert.assertEquals(cardSummaryPage.PurchaseConfirmation().getText(),"Thank you for your purchase.");
    }

    // verify click ok button with imcorrectpin Reg
    @Test(groups={"regression"})
    public void verifyincorrectpin() throws InterruptedException {
        cardinput();
        baseMethods.holdExcution(5);
        driver.switchTo().frame(0);
        cardSummaryPage.cardPindetail(Setup.properties.getProperty("incorrectpin"));
        cardSummaryPage.cardOkbuttondetails().click();
        baseMethods.holdExcution(5);
        driver.switchTo().frame(0);
        Assert.assertEquals(cardSummaryPage.PurchaseRejected().getText(),"Your card got declined by the bank");
    }

    @Test(groups={"regression"})
    public void veriyCancelbutton() throws InterruptedException {

        cardinput();
        baseMethods.holdExcution(5);
        driver.switchTo().frame(0);
        baseMethods.holdExcution(5);
        cardSummaryPage.cardCancelbutton().click();
        baseMethods.holdExcution(5);
       driver.switchTo().frame(0);
       baseMethods.holdExcution(5);
        Assert.assertEquals(cardSummaryPage.Purchasecancelled().getText(),"Transaction failed");

    }

}