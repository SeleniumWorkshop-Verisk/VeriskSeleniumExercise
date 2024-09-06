package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.example.utilities.WaitUtils.waitForElementToBeVisible;

public class CheckoutPage extends BasePage {

    @FindBy(linkText = "EDIT ADDRESS")
    private WebElement editAddressLink;

    @FindBy(id = "telephone")
    private WebElement telephoneField;

    @FindBy(id = "street_1")
    private WebElement streetField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "region_id")
    private WebElement regionDropdown;

    @FindBy(id = "zip")
    private WebElement zipField;

    @FindBy(xpath = "//*[@id=\"form-validate\"]/div[3]/button/span/span")
    private WebElement saveAddressButton;

    @FindBy(xpath = "//*[@class = \"success-msg\"]/ul/li/span")
    private WebElement addressSuccessMessage;

    @FindBy(xpath = "//button[@title = \"Proceed to Checkout\"]")
    private WebElement proceedToCheckoutButton;

    @FindBy(id = "billing:use_for_shipping_yes")
    private WebElement billingAddressCheckbox;

    @FindBy(xpath = "//button[@title = \"Continue\"]")
    private WebElement billingAddressContinueButton;

    @FindBy(id = "s_method_flatrate_flatrate")
    private WebElement flatRateOption;

    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/button")
    private WebElement shippingMethodButton;

    @FindBy(xpath = "//*[@id=\"payment-buttons-container\"]/button/span/span")
    private WebElement paymentButton;

    @FindBy(xpath = "//button[@title = \"Place Order\"]")
    private WebElement placeOrderButton;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void setDefaultBillingAddress() {
        waitForElementToBeVisible(driver, editAddressLink, 10);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight);");
        editAddressLink.click();
        waitForElementToBeVisible(driver, telephoneField, 10);
        js.executeScript("window.scrollBy(0, 500);");
        telephoneField.sendKeys("7777777");
        waitForElementToBeVisible(driver, streetField, 10);
        js.executeScript("window.scrollBy(0, 900);");
        streetField.sendKeys("street1");
        cityField.sendKeys("Toledo");
        new Select(regionDropdown).selectByVisibleText("Ohio");
        zipField.sendKeys("55555");
        waitForElementToBeVisible(driver, saveAddressButton, 10);
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        saveAddressButton.click();
    }

    public boolean isBillingAddressAdded() {
        waitForElementToBeVisible(driver, addressSuccessMessage, 10);
        return addressSuccessMessage.getText().equalsIgnoreCase("The address has been saved.");
    }

    public void proceedToCheckout() {
        proceedToCheckoutButton.click();
        waitForElementToBeVisible(driver, billingAddressCheckbox, 10);
        billingAddressCheckbox.click();
        billingAddressContinueButton.click();
        waitForElementToBeVisible(driver, flatRateOption, 10);
        js.executeScript("window.scrollBy(0, 200);");
        flatRateOption.click();
        waitForElementToBeVisible(driver, shippingMethodButton, 10);
        shippingMethodButton.click();
        waitForElementToBeVisible(driver, paymentButton, 10);
        paymentButton.click();
        waitForElementToBeVisible(driver, placeOrderButton, 10);
        placeOrderButton.click();
    }
}
