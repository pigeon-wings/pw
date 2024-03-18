package com.example.pigeon_wings.BDD;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceOrderSteps {
    @When("User click {string} option from {string} category")
    public void userClickOptionFromCategory(String arg0, String arg1) {
    }

    @And("User click on the {string} for product details")
    public void userClickOnTheForProductDetails(String arg0) {
    }

    @And("User set the quantity number {int} in the quantity field")
    public void userSetTheQuantityNumberInTheQuantityField(int arg0) {
    }

    @And("User click on the {string} button")
    public void userClickOnTheButton(String arg0) {
    }

    @And("User go to the shipping cart page")
    public void userGoToTheShippingCartPage() {
    }

    @And("User accept terms conditions and click checkout button")
    public void userAcceptTermsConditionsAndClickCheckoutButton() {
    }

    @And("User click checkout as guest button")
    public void userClickCheckoutAsGuestButton() {
    }

    @And("User input all the billing details and click continue")
    public void userInputAllTheBillingDetailsAndClickContinue() {
    }

    @And("User select shipping method {string} and click continue")
    public void userSelectShippingMethodAndClickContinue(String arg0) {
    }

    @And("User select payment method {string} and click continue")
    public void userSelectPaymentMethodAndClickContinue(String arg0) {
    }

    @And("User select {string} card and input card information")
    public void userSelectCardAndInputCardInformation(String arg0) {
    }

    @And("User click confirm button to place the order")
    public void userClickConfirmButtonToPlaceTheOrder() {
    }

    @Then("Verify that the order place message {string} is displayed")
    public void verifyThatTheOrderPlaceMessageIsDisplayed(String arg0) {
    }
}
