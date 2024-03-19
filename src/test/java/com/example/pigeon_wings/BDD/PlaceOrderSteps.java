package com.example.pigeon_wings.BDD;

import com.example.pigeon_wings.factory.annotation.LazyAutowired;
import com.example.pigeon_wings.page.step_source.NopRegistrationPage;
import com.example.pigeon_wings.page.step_source.PlaceOrderRegPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest
public class PlaceOrderSteps {

    @LazyAutowired
private PlaceOrderRegPage placeOrderRegPage;

    @When("User click {string} option from {string} category")
    public void chooseCategory(String category, String content) throws InterruptedException {
        this.placeOrderRegPage.clickOnCellPhone(category, content);
    }

    @And("User click on the {string} for product details")
    public void clickOnProduct(String product) {
        this.placeOrderRegPage.clickOnProduct(product);
    }

    @And("User set the quantity number {int} in the quantity field")
    public void setTheQuantity(int quantity) {
        quantity=2;
        this.placeOrderRegPage.setQuantity(quantity);
    }

    @And("User click on the {string} button")
    public void addToCart(String cartButton) {
        cartButton="ADD TO CART";
        this.placeOrderRegPage.addToCart(cartButton);
    }

    @And("User go to the shipping cart page")
    public void purchaseProcess() {
        this.placeOrderRegPage.goToShippingPage();
    }

    @And("User accept terms conditions and click checkout button")
    public void clickCheckout() {
        this.placeOrderRegPage.performCheckout();
    }

    @And("User click checkout as guest button")
    public void clickCheckoutAsGuest() {
        this.placeOrderRegPage.clickCheckoutAsGuest();
    }

    @And("User input all the billing details and click continue")
    public void inputRequiredDetails() {
        this.placeOrderRegPage.inputRequiredDetails();
    }

    @And("User select shipping method {string} and click continue")
    public void chooseShippingMethod(String method) {
        method="Next Day Air";
        this.placeOrderRegPage.chooseShippingMethod(method);
    }

    @And("User select payment method {string} and click continue")
    public void choosePaymentMethod(String payMethod) {
        payMethod="Credit Card";
        this.placeOrderRegPage.chooseCardMethod();
    }

    @And("User select {string} card and input card information")
    public void selectInputDetails(String cardInfo) {
        cardInfo="Visa";
        this.placeOrderRegPage.chooseCardMethod(cardInfo);
    }

    @And("User click confirm button to place the order")
    public void clickConfirmButton() {
        this.placeOrderRegPage.confirmPurchase();
    }

    @Then("Verify that the order place message {string} is displayed")
    public void getConfirmMsg(String msg) {
        msg="Your order has been successfully processed!";
        this.placeOrderRegPage.getConfirmationMsg(msg);
    }
}
