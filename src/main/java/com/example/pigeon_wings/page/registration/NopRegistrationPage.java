package com.example.pigeon_wings.page.registration;

import com.example.pigeon_wings.Base;
import com.example.pigeon_wings.factory.annotation.LazyAutowired;
import com.example.pigeon_wings.factory.annotation.Page;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.util.Assert;

import java.time.LocalDate;

@Page
public class NopRegistrationPage extends Base {
    @FindBy(xpath="//a[normalize-space()='Register']")
    private WebElement regPageNavi;
    @FindBy(id="gender-male")
    private WebElement maleGender;
    @FindBy(id="gender-female")
    private WebElement femaleGender;
    @FindBy(id="FirstName")
    private WebElement firstName;
    @FindBy(id="LastName")
    private WebElement lastName;
    @FindBy(name="DateOfBirthDay")
    private WebElement day;
    @FindBy(id="DateOfBirthMonth")
    private WebElement month;
    @FindBy(id="DateOfBirthYear")
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
    @FindBy(id="submitBtn")
    private WebElement submit;
    @FindBy(xpath="//div[@class='result']")
    private WebElement confirmation;

    @LazyAutowired
    private Faker faker;


    public void goTo(){
        this.driver.get("https://demo.nopcommerce.com/");
    }
    public void goToReg(){
        regPageNavi.click();
    }
    public void setGender(String genderType) {
if(genderType.equals("Male"))
        this.maleGender.click();
else
    this.femaleGender.click();
    }

    public void setNames() {
        this.firstName.sendKeys(faker.name().firstName());
        this.lastName.sendKeys(faker.name().lastName());
    }

    public void setBirthDate(LocalDate localDate){
        new Select(this.year).selectByVisibleText(String.valueOf(localDate.getYear()));
        new Select(this.day).selectByVisibleText(String.valueOf(localDate.getDayOfMonth()));
        new Select(this.month).selectByValue(localDate.getMonth().toString());
    }
    public void setContactDetails(String email){
        this.email.sendKeys(email);

    }
    public void setCompanyDetails(String companyName){
        this.companyName.sendKeys(companyName);
    }

    public void setNewsletterStatus(String not_subs){
        if(not_subs.equals("unchecked")) {
            this.newsletterStatus.click();
        }

    }

    public void setPassword(String password){
        this.password.sendKeys(password);
        this.retypePassword.sendKeys(password);
    }

    public void submit(){
        this.submit.click();
    }
    public void getConfirmationText(String txt){
        this.wait.until((d)->this.confirmation.isDisplayed());
        Assert.isTrue(this.confirmation.isDisplayed(),txt);
    }
    @Override
    public boolean isAt() {
        return this.wait.until((d)->this.firstName.isDisplayed());
    }

}
