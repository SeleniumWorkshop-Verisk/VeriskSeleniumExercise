package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.example.utilities.WaitUtils.waitForElementToBeVisible;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@data-target-element = \"#header-account\"]")
    private WebElement accountLink;

    @FindBy(xpath = "//*[@title = \"Log In\"]")
    private WebElement loginButton;

    @FindBy(id = "email")
    private WebElement emailTextBox;

    @FindBy(id = "pass")
    private WebElement passwordTextBox;

    @FindBy(id = "send2")
    private WebElement submitButton;

    @FindBy(className = "welcome-msg")
    private WebElement welcomeMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }

    public void clickAccountLink() {
        waitForElementToBeVisible(driver, accountLink, 10);
        accountLink.click();
    }

    public void clickLoginButton() {
        waitForElementToBeVisible(driver, loginButton, 10);
        loginButton.click();
    }

    public void enterCredentials(String username, String password) {
        waitForElementToBeVisible(driver, emailTextBox, 10);
        emailTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
    }

    public void clickSubmitButton() {
        waitForElementToBeVisible(driver, submitButton, 10);
        js.executeScript("arguments[0].scrollIntoView();", submitButton);
        submitButton.click();
    }

    public boolean isLoginSuccessful() {
        waitForElementToBeVisible(driver, welcomeMessage, 10);
        return welcomeMessage.getText().equalsIgnoreCase("Welcome, veritest tester!");
    }

}
