package com.example.pigeon_wings.page.step_source.sub_source;


import com.example.pigeon_wings.Base;
import com.example.pigeon_wings.factory.annotation.PageFragment;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


@PageFragment
public class BillFormFilling extends Base {
    @FindBy(id="BillingNewAddress_FirstName")
    private WebElement fName;
    @FindBy(id="BillingNewAddress_LastName")
    private WebElement lName;
    @FindBy(id="BillingNewAddress_Email")
    private WebElement billingEmail;
    @FindBy(id="BillingNewAddress_Company")
    private WebElement companyName;
    @FindBy(id="BillingNewAddress_CountryId")
    private WebElement selectCountry;
    @FindBy(id="BillingNewAddress_StateProvinceId")
    private WebElement selectState;
    @FindBy(id="BillingNewAddress_City")
    private WebElement inputCity;
    @FindBy(id="BillingNewAddress_Address1")
    private WebElement inputAddress1;
    //inputAddress2 intentionally left blanked
    @FindBy(id="BillingNewAddress_ZipPostalCode")
    private WebElement zipCode;
    @FindBy(id="BillingNewAddress_PhoneNumber")
    private WebElement billingPhone;
    @FindBy(id="BillingNewAddress_FaxNumber")
    private WebElement billingFax;


    public void setNames(String firstName, String lastName) {
        this.fName.sendKeys(firstName);
        this.lName.sendKeys(lastName);
    }
    public void setBillingEmail(String billingEmail) {
        this.billingEmail.sendKeys(billingEmail);
    }
    public void setCompanyName(String companyName) {
        this.companyName.sendKeys(companyName);
    }

    public void setLocation(String countryName, String stateName, String cityName, String address) throws InterruptedException {
        new Select(this.selectCountry).selectByVisibleText(countryName);

        Thread.sleep(3000);
        WebElement submenu= wait.until(ExpectedConditions.visibilityOf(this.selectState));
        new Select(submenu).selectByVisibleText(stateName);
        this.inputCity.sendKeys(cityName);
        this.inputAddress1.sendKeys(address);

    }
    public void setContact(String zipcode, String phone, String fax) {
        this.zipCode.sendKeys(zipcode);
        this.billingPhone.sendKeys(phone);
        this.billingFax.sendKeys(fax);
    }
    @Override
    public boolean isAt() {
       return false;
    }
}
