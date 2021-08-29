package TestCases;

import CommonMethod.Setup;
import Pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.io.IOException;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Testcases {
    public WebDriver driver;
    HomePage homePage;

    @BeforeTest
    public void tearup() throws IOException {
        driver = Setup.initiateDriver();
        homePage = new HomePage(driver);
    }

    @BeforeMethod
    public void getUrl() {
        driver.get(Setup.properties.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }



    //@Test
    public void verifyTitle() {
        String urlstore = driver.getCurrentUrl();
        Assert.assertEquals(urlstore, "https://demo.midtrans.com/");
    }

    @Test(priority = 1)
    public void buynowbutton() throws InterruptedException {
        homePage.clickbunnowbutton();
        Thread.sleep(4000);
        //homePage.titleShoppingcart();
        boolean title = homePage.titleShoppingcart().isDisplayed();
        String s = homePage.titleShoppingcart().getText();
        System.out.println(s);
        Assert.assertTrue(title);
        Thread.sleep(4000);

    }

    @Test(priority = 2)
    public void verifyTotal() throws InterruptedException {
//        homePage.clickbunnowbutton();
        Thread.sleep(4000);
        String totaltext = homePage.verifytotalamount().getText();
//        System.out.println(totaltext);
        Assert.assertEquals(totaltext, "20,000");
    }

    @Test(priority = 3)
    public void veriycheckoutbuttondisplay() throws InterruptedException {
        Thread.sleep(9000);
        homePage.clickbunnowbutton();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(homePage.checkoutbutton()));
        //boolean checkoutbtn=homePage.checkoutbutton().isDisplayed();
        Assert.assertTrue(homePage.checkoutbutton().isDisplayed());

    }

    @Test(priority = 4)
    public void verifylabel() throws InterruptedException {
        Thread.sleep(9000);
        homePage.clickbunnowbutton();
        Thread.sleep(9000);
        List<WebElement> label = driver.findElements(By.xpath("//td[@class='input-label']"));
        Thread.sleep(9000);
        List Expctedlist = new ArrayList();
        for (WebElement l1 : label) {
            Expctedlist.add(l1.getText());
        }
        System.out.print(Expctedlist);
        Assert.assertEquals(Expctedlist.toString(), "[Name, Email, Phone no, City, Address, Postal Code]");

    }

    @Test
    public void addData() throws InterruptedException {
        Thread.sleep(9000);
        homePage.clickbunnowbutton();
        Thread.sleep(9000);
        homePage.namedetails(Setup.properties.getProperty("name"));
        homePage.addressdetails(Setup.properties.getProperty("Address"));
        homePage.citydetails(Setup.properties.getProperty("City"));
        homePage.phonedetails(Setup.properties.getProperty("Phone"));
        homePage.emaildetails(Setup.properties.getProperty("email"));
        homePage.postalcodedetails(Setup.properties.getProperty("Postalcode"));


    }

    @Test()
    public void checkout() throws InterruptedException {
        Thread.sleep(9000);
        homePage.clickbunnowbutton();
        Thread.sleep(9000);
        homePage.checkoutbutton().click();
    }

    @Test
    public void poup() throws InterruptedException {
        Thread.sleep(9000);
        homePage.clickbunnowbutton();
        Thread.sleep(9000);
        homePage.checkoutbutton().click();
        driver.switchTo().frame(0);
        String pagetitle = driver.findElement(By.xpath("//p[@class='text-page-title-content']")).getText();
        System.out.println(pagetitle);
    }

    //Verify name and amount is visible
    @Test
    public void verifyData() throws InterruptedException {
        Thread.sleep(9000);
        homePage.clickbunnowbutton();
        Thread.sleep(9000);
        homePage.checkoutbutton().click();
        driver.switchTo().frame(0);
//        String amount =driver.findElement(By.xpath("//span[@class='text-amount-amount']")).getText();
//        System.out.println(amount);
//        String name=driver.findElement(By.xpath("//span[@class='item-name']")).getText();
//         System.out.println(name);
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='text-amount-amount']")).getText(), "20,000");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='item-name']")).getText(), "Midtrans Pillow");
    }

    //verify click on continue button select payment page open
    @Test
    public void redirecttopayment() throws InterruptedException {
        homePage.clickbunnowbutton();
        Thread.sleep(9000);
        homePage.checkoutbutton().click();
        Thread.sleep(9000);
        driver.switchTo().frame(0);
        Thread.sleep(9000);
        driver.findElement(By.xpath("//a[@class='button-main-content']")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//p[@class='text-page-title-content']")).getText(), "Select Payment");
    }

    //Verify All payment Methods
    @Test
    public void paymentMethod() throws InterruptedException {
        homePage.clickbunnowbutton();
        Thread.sleep(9000);
        homePage.checkoutbutton().click();
        Thread.sleep(9000);
        driver.switchTo().frame(0);
        Thread.sleep(9000);
        driver.findElement(By.xpath("//a[@class='button-main-content']")).click();
        Thread.sleep(9000);
        List<WebElement> paymentname = driver.findElements(By.xpath("//div[@class='list-title text-actionable-bold']"));
        ArrayList metholist = new ArrayList();
        for (WebElement pay : paymentname) {
            metholist.add(pay.getText());
        //    System.out.println(metholist);
        }
       Assert.assertEquals(metholist.toString(),"[Credit/Debit Card, ATM/Bank Transfer, GoPay/other e-Wallets, ShopeePay/other e-Wallets, KlikBCA, BCA KlikPay, OCTO Clicks, Danamon Online Banking, e-Pay BRI, LINE Pay e-cash | mandiri e-cash, Telkomsel Cash, Indomaret, Alfa Group, Akulaku]");

    }
    //verify clicking on debitcard it redirect to card details page

    @Test
    public void debitCardDetails() throws InterruptedException {
        homePage.clickbunnowbutton();
        Thread.sleep(9000);
        homePage.checkoutbutton().click();
        Thread.sleep(9000);
        driver.switchTo().frame(0);
        Thread.sleep(9000);
        driver.findElement(By.xpath("//a[@class='button-main-content']")).click();
        Thread.sleep(9000);
        driver.findElement(By.xpath("//a[@class='list with-promo']//div[@class='list-content']//div[1]")).click();
    }

    //verify amount changes when user apply promo code
    @Test
    public void promoCode() throws InterruptedException {
        homePage.clickbunnowbutton();
        Thread.sleep(9000);
        homePage.checkoutbutton().click();
        Thread.sleep(9000);
        driver.switchTo().frame(0);
        Thread.sleep(9000);
        driver.findElement(By.xpath("//a[@class='button-main-content']")).click();
        Thread.sleep(9000);
        driver.findElement(By.xpath("//a[@class='list with-promo']//div[@class='list-content']//div[1]")).click();
        Thread.sleep(9000);

        driver.findElement(By.xpath("//div[@class='input-row']//div[2]//div[1]//label[1]")).isEnabled();
        String pp = driver.findElement(By.xpath("//span[@class='text-amount-amount']")).getText();
        System.out.println(pp);
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='text-amount-amount']")).getText(), "18,000");
        System.out.println("I am first checkbox is selcted");
        Thread.sleep(3000);

        System.out.println("I am checking first the checkbox");
        driver.findElement(By.xpath("//div[@class='input-row']//div[1]//div[1]//label[1]")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='text-amount-amount']")).getText(), "19,990");

        System.out.println("I am checking third  checkbox");
        driver.findElement(By.xpath("//div[@class='input-row']//div[3]//div[1]//label[1]")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='text-amount-amount']")).getText(), "19,000");
    }

    //verify carddetails and submit
    @Test
    public void cardinput() throws InterruptedException {

        homePage.clickbunnowbutton();
        Thread.sleep(9000);
        homePage.checkoutbutton().click();
        Thread.sleep(9000);
        driver.switchTo().frame(0);
        Thread.sleep(9000);
        driver.findElement(By.xpath("//a[@class='button-main-content']")).click();
        Thread.sleep(9000);
        driver.findElement(By.xpath("//a[@class='list with-promo']//div[@class='list-content']//div[1]")).click();
        Thread.sleep(9000);
        homePage.credicarddetails(Setup.properties.getProperty("card"));
        homePage.expDatedetails(Setup.properties.getProperty("expDate"));
        homePage.cvvdetails(Setup.properties.getProperty("cvv"));
        homePage.paymentsubmit().click();
    }

    //Verify gateaydetails
    @Test
    public void transcationConfirmation() throws InterruptedException {
        homePage.clickbunnowbutton();
        Thread.sleep(9000);
        homePage.checkoutbutton().click();
        Thread.sleep(9000);
        driver.switchTo().frame(0);
        Thread.sleep(9000);
        driver.findElement(By.xpath("//a[@class='button-main-content']")).click();
        Thread.sleep(9000);
        driver.findElement(By.xpath("//a[@class='list with-promo']//div[@class='list-content']//div[1]")).click();
        Thread.sleep(9000);
        homePage.credicarddetails(Setup.properties.getProperty("card"));
        homePage.expDatedetails(Setup.properties.getProperty("expDate"));
        homePage.cvvdetails(Setup.properties.getProperty("cvv"));
        homePage.paymentsubmit().click();

        Thread.sleep(9000);

        driver.switchTo().frame(0);

        Assert.assertEquals(homePage.merchantName().getText(), "Rubicon Store");
        Assert.assertEquals(homePage.payblAmount().getText(), "18000.00");
        Assert.assertEquals(homePage.carnumberdetail().getText(), "481111-1114");
    }


    //Your card got declined by the bank

    @Test
    public void verifycorrectpin() throws InterruptedException {
        homePage.clickbunnowbutton();
        Thread.sleep(2000);
        homePage.checkoutbutton().click();
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='button-main-content']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='list with-promo']//div[@class='list-content']//div[1]")).click();
        Thread.sleep(2000);
        homePage.credicarddetails(Setup.properties.getProperty("card"));
        homePage.expDatedetails(Setup.properties.getProperty("expDate"));
        homePage.cvvdetails(Setup.properties.getProperty("cvv"));
        homePage.paymentsubmit().click();

        Thread.sleep(9000);

        driver.switchTo().frame(0);

        homePage.cardPindetail(Setup.properties.getProperty("correctpin"));
        Thread.sleep(2000);
        homePage.cardOkbuttondetails().click();
        Thread.sleep(2000);

        driver.switchTo().frame(0);
   //  String succesmsg = driver.findElement(By.xpath("//div[@class='final-panel success']")).getText();
   //     String succesmsg = driver.findElement(By.xpath("//div[@text()='Transaction successful]"));
        //   System.out.println(succesmsg);


    }

    //imcorrectpin
    @Test
    public void verifyincorrectpin() throws InterruptedException {

        homePage.clickbunnowbutton();
        Thread.sleep(2000);
        homePage.checkoutbutton().click();
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='button-main-content']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='list with-promo']//div[@class='list-content']//div[1]")).click();
        Thread.sleep(2000);
        homePage.credicarddetails(Setup.properties.getProperty("card"));
        homePage.expDatedetails(Setup.properties.getProperty("expDate"));
        homePage.cvvdetails(Setup.properties.getProperty("cvv"));
        homePage.paymentsubmit().click();

        Thread.sleep(9000);

        driver.switchTo().frame(0);

        homePage.cardPindetail(Setup.properties.getProperty("incorrectpin"));
        Thread.sleep(2000);
        homePage.cardOkbuttondetails().click();
        Thread.sleep(2000);

        driver.switchTo().frame(0);
        String failsmsg = driver.findElement(By.xpath("//span[normalize-space()='Your card got declined by the bank']")).getText();
               System.out.println(failsmsg);
    }

    @Test
    public void veriyCancelbutton() throws InterruptedException {

        homePage.clickbunnowbutton();
        Thread.sleep(8000);
        homePage.checkoutbutton().click();
        Thread.sleep(9000);
        driver.switchTo().frame(0);
        Thread.sleep(9000);
        driver.findElement(By.xpath("//a[@class='button-main-content']")).click();
        Thread.sleep(9000);
        driver.findElement(By.xpath("//a[@class='list with-promo']//div[@class='list-content']//div[1]")).click();
        Thread.sleep(9000);
        homePage.credicarddetails(Setup.properties.getProperty("card"));
        homePage.expDatedetails(Setup.properties.getProperty("expDate"));
        homePage.cvvdetails(Setup.properties.getProperty("cvv"));
        homePage.paymentsubmit().click();

        Thread.sleep(2000);

        driver.switchTo().frame(0);
        Thread.sleep(2000);
        homePage.cardCancelbutton().click();
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        String failsmsg = driver.findElement(By.xpath("//span[normalize-space()='Transaction failed']")).getText();
        System.out.println(failsmsg);
        Assert.assertEquals(driver.findElement(By.xpath("//span[normalize-space()='Transaction failed']")).getText(),"Transaction failed");

    }

}