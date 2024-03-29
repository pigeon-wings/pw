package com.example.pigeon_wings.page.step_source;


import com.example.pigeon_wings.entity.BillInfo;
import com.example.pigeon_wings.factory.annotation.LazyAutowired;
import com.example.pigeon_wings.factory.annotation.Page;
import com.example.pigeon_wings.page.step_source.sub_source.BillFormFilling;
import com.example.pigeon_wings.repository.BillInfoRepository;
import com.github.javafaker.Faker;
import org.apache.commons.io.input.BOMInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestPropertySource;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.sql.Date;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


@Page
public class PlaceOrderRegPage extends BillFormFilling {

    @FindBy(xpath="//ul[@class='top-menu notmobile']//a[normalize-space()='Electronics']")
    private WebElement Electronics;
    @FindBy(xpath="(//a[normalize-space()='Cell phones'])[3]")
    private WebElement cell_phone;
    @FindBy(xpath="//a[normalize-space()='Nokia Lumia 1020']")//Nokia Lumia 1020
    private WebElement nokia_lumia;
    @FindBy(id="product_enteredQuantity_20")
    private WebElement setQuantity;
    @FindBy(id="add-to-cart-button-20")
    private WebElement btnCart;
    @FindBy(xpath="//span[@class='cart-label']")
    private WebElement shopping_cart;
    @FindBy(id="termsofservice")
    private WebElement terms_conditions;
    @FindBy(id="checkout")
    private WebElement checkout_btn;
    @FindBy(xpath="//button[normalize-space()='Checkout as Guest']")
    private WebElement check_guest_btn;
    @FindBy(xpath="//h2[normalize-space()='Billing address']")
    private WebElement billingPortionClick;
    @FindBy(name="save")
    private WebElement billingContinueBtn;
    @FindBy(id="shippingoption_1")
    private WebElement shippingNextDayAir;
    @FindBy(xpath="//button[@class='button-1 shipping-method-next-step-button']")
    private WebElement shippingContinueBtn;
    @FindBy(xpath="//input[@id='paymentmethod_1']")
    private WebElement paymentCredit;
    @FindBy(xpath="//button[@class='button-1 payment-method-next-step-button']")
    private WebElement paymentContinueBtn;
    @FindBy(xpath="//button[@class='button-1 payment-info-next-step-button']")
    private WebElement paymentInfoContinueBtn;
    @FindBy(xpath="//strong[normalize-space()='Your order has been successfully processed!']")
    private WebElement purchaseConfirmMessage;
    @FindBy(xpath="//button[normalize-space()='Confirm']")
    private WebElement purchaseConfirmBtn;
    @FindBy(xpath="//button[normalize-space()='Continue']")
    private WebElement purchaseEndingContinueBtn;

    @LazyAutowired
    private Faker faker;
    @Autowired
    private BillFormFilling placePage;
    @Autowired
    private BillInfoRepository repository;

    public void clickOnCellPhone(String category, String content) throws InterruptedException {

//       Actions // actions= new Actions(this.driver);
//        actions.moveToElement(Electronics).click(cell_phone).build().perform();
        this.Electronics.click();
        this.cell_phone.click();

    }
    public void clickOnProduct(String product){
this.nokia_lumia.click();
    }
    public void setQuantity(int quantity){
this.setQuantity.sendKeys("2");
    }
    public void addToCart(String cartButton){
this.btnCart.click();

    }
    public void goToShippingPage(){

this.shopping_cart.click();

    }
    public void performCheckout(){
        this.terms_conditions.click();
this.checkout_btn.click();

    }

    public void clickCheckoutAsGuest(){
this.check_guest_btn.click();

    }

    public void inputRequiredDetails() throws InterruptedException {
        String fstName=faker.name().firstName();
        String lstName=faker.name().lastName();

        this.placePage.setNames(fstName, lstName);
        String bill_email= "pigeon.wings.elubilu+"+faker.name().firstName()+"@gmail.com";
        this.placePage.setBillingEmail(bill_email);
        this.placePage.setCompanyName(faker.name().nameWithMiddle());
        this.placePage.setLocation("United States", "Florida", "dhaka", "4/24, mmirpur-12");
        this.placePage.setContact("12345", "0144452221", "11123343");
        this.billingPortionClick.click();
        this.billingContinueBtn.click();
//        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@src, 'https://ogs.google.com/widget/callout')]")));
//        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='No thanks']"))).click();
//        driver.switchTo().defaultContent();
//        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.name("q"))).sendKeys("Diksha Rewatkar");

    }

    public void chooseShippingMethod(String shipMethod) throws InterruptedException {
        Thread.sleep(3000);
this.shippingNextDayAir.click();
        this.shippingContinueBtn.click();
    }
    public void choosePaymentMethod(String payMethod) throws InterruptedException {
        Thread.sleep(3000);
        this.paymentCredit.click();
        this.paymentContinueBtn.click();
    }

   @FindBy(xpath="//select[@id='CreditCardType']")
   private WebElement cardType;

    @FindBy(xpath="//input[@id='CardholderName']")
    private WebElement cHolderName;

    @FindBy(xpath="//input[@id='CardNumber']")
    private WebElement cardNumber;
    @FindBy(xpath="//select[@id='ExpireMonth']")
    private WebElement expire_month;
    @FindBy(xpath="//select[@id='ExpireYear']")
    private WebElement expire_year;
    @FindBy(xpath="//input[@id='CardCode']")
    private WebElement card_code;

    public void chooseCardMethod(String cardType) throws InterruptedException {
        Thread.sleep(3000);
        new Select(this.cardType).selectByVisibleText("Visa");
        this.cHolderName.sendKeys(faker.name().fullName());
        this.cardNumber.sendKeys("4242424242424242424242");
        new Select(this.expire_month).selectByVisibleText("12");
        new Select(this.expire_year).selectByVisibleText("2025");
        this.card_code.sendKeys("123");

        this.paymentInfoContinueBtn.click();
    }
    public void confirmPurchase() throws InterruptedException {
        Thread.sleep(3000);
this.purchaseConfirmBtn.click();

    }

    public void getConfirmationMsg(String txt){

        this.wait.until((d)->this.purchaseConfirmMessage.isDisplayed());
        assert this.purchaseConfirmMessage.getText().equals(txt);
        this.purchaseEndingContinueBtn.click();

    }
    @Override
    public boolean isAt() {
        return this.wait.until((d)->this.purchaseConfirmMessage.isDisplayed());
    }
}
