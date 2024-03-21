package com.example.pigeon_wings.BDD;

import com.example.pigeon_wings.CucumberRunner;
import com.example.pigeon_wings.factory.annotation.LazyAutowired;
import com.example.pigeon_wings.page.step_source.NopRegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@CucumberContextConfiguration
@SpringBootTest
public class RegistrationSteps {
    @LazyAutowired
    private NopRegistrationPage regPage;
    @Given("User go to the NopCommerce Home page")
    public void userGoToTheNopCommerceHomePage() {
        this.regPage.goTo();
    }
    @Given("User navigate to the Registration page")
    public void navigateToRegPage() {
        this.regPage.goToReg();
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
        String datePattern2 = "\\d{1}/\\d{2}/\\d{4}";
        String datePattern3 = "\\d{2}/\\d{2}/\\d{4}";

        if(dob.matches(datePattern3)) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.regPage.setBirthDate(LocalDate.parse(dob, dtf));
        }
        else if(dob.matches(datePattern2)) {
            DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("d/MM/yyyy");
            this.regPage.setBirthDate(LocalDate.parse(dob, dtf1));
        }
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
