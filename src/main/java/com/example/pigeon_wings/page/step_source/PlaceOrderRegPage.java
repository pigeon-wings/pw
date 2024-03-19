package com.example.pigeon_wings.page.step_source;

import com.example.pigeon_wings.Base;
import com.example.pigeon_wings.factory.annotation.LazyAutowired;
import com.example.pigeon_wings.factory.annotation.Page;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.Objects;
@Page
public class PlaceOrderRegPage extends Base {
    @FindBy(xpath="//a[normalize-space()='Electronics']")
    private WebElement electronics;
    @FindBy(xpath="//a[normalize-space()='Cell phones']")
    private WebElement cell_phone;
    @FindBy(id="gender-male")//Nokia Lumia 1020
    private WebElement nokia_lumia;
    @FindBy(id="gender-female")
    private WebElement femaleGender;
    @FindBy(id="FirstName")
    private WebElement firstName;
    @FindBy(id="LastName")
    private WebElement lastName;
    @FindBy(name="DateOfBirthDay")
    private WebElement day;
    @FindBy(name="DateOfBirthMonth")
    private WebElement month;
    @FindBy(name="DateOfBirthYear")
    private WebElement year;
    @FindBy(id="Email")
    private WebElement email;
    @FindBy(id="Company")
    private WebElement companyName;
    @FindBy(id="Newsletter")
    private WebElement newsletterStatus;
    @FindBy(id="Password")
    private WebElement password;
    @FindBy(id="ConfirmPassword")
    private WebElement retypePassword;
    @FindBy(id="register-button")
    private WebElement submit;
    @FindBy(xpath="//div[@class='result']")
    private WebElement confirmation;

    @LazyAutowired
    private Faker faker;


    public void goTo(){
        this.driver.get("https://demo.nopcommerce.com/");
    }
    public void clickOnCellPhone(String category, String content) throws InterruptedException {
//        Actions //actions = new Actions(this.driver);
//        actions.moveToElement(electronics)
//                .moveToElement(cell_phone)
//                .click().build().perform();
//        Actions actions = new Actions(this.driver);
//        Thread.sleep(1000);
//        actions.moveToElement(electronics).perform();
//        actions.moveToElement(cell_phone).perform();
//        actions.click().build().perform();
    }
    public void clickOnProduct(String product){

    }
    public void setQuantity(int quantity){

    }
    public void addToCart(String cartButton){


    }
    public void goToShippingPage(){


    }
    public void performCheckout(){


    }

    public void clickCheckoutAsGuest(){


    }
    public void inputRequiredDetails(){


    }
    public void chooseShippingMethod(String payMethod){


    }
    public void choosePaymentMethod(){


    }
    public void chooseCardMethod(String cardType){


    }
    public void confirmPurchase(){
        this.submit.click();

    }

    public String getConfirmationMsg(String txt){
        this.wait.until((d)->this.confirmation.isDisplayed());
        return this.confirmation.getText();
    }
    @Override
    public boolean isAt() {
        return this.wait.until((d)->this.firstName.isDisplayed());
    }
}
