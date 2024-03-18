package com.example.pigeon_wings.BDD;

import com.example.pigeon_wings.factory.annotation.LazyAutowired;
import com.example.pigeon_wings.page.registration.NopRegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDate;

@CucumberContextConfiguration
@SpringBootTest
public class RegistrationSteps {
    @LazyAutowired
    private NopRegistrationPage regPage;
    @Given("User go to the NopCommerce Home page")
    public void launchHomePage() {
        this.regPage.goTo();
    }

    @Given("User navigate to the Registration page")
    public void navigateToRegPage() {
        regPage.goToReg();
    }

    @When("User select the {string} as gender")
    public void selectGender(String type) {
        this.regPage.setGender(type);
    }

    @When("User set first name and last name")
    public void inputName() {
        this.regPage.setNames();
    }

    @When("User set {string} as date of birth")
    public void selectDob(String dob) {
        this.regPage.setBirthDate(LocalDate.parse(dob));
    }

    @When("User set {string} as email")
    public void setEmail(String email) {
        this.regPage.setContactDetails(email);
    }

    @When("User set {string} as company details")
    public void setCompanyName(String companyName) {
        this.regPage.setCompanyDetails(companyName);
    }

    @When("User set Newsletter option as {string}")
    public void setNewsletterSubscription(String checkbox) {
        this.regPage.setNewsletterStatus(checkbox);
    }

    @When("User set {string} as password and confirm password again")
    public void setPwd(String pwd) {
        this.regPage.setPassword(pwd);
    }

    @When("User click on the Register button")
    public void submitRegistrationForm() {
        this.regPage.submit();
    }

    @Then("Verify that the new account registration message {string} is displayed")
    public void confirmationPage(String msg) {
        this.regPage.getConfirmationText(msg);

    }


}
