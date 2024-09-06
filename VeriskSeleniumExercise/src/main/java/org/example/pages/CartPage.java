package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.example.utilities.WaitUtils.waitForElementToBeVisible;

public class CartPage extends BasePage {

    @FindBy(linkText = "VIEW DETAILS")
    private WebElement viewDetailsLink;

    @FindBy(xpath = "//ul[@id = \"configurable_swatch_color\"]/li[1]/a")
    private WebElement colorOption;

    @FindBy(xpath = "//ul[@id = \"configurable_swatch_size\"]/li[1]/a")
    private WebElement sizeOption;

    @FindBy(xpath = "//*[@id=\"product_addtocart_form\"]/div[3]/div[6]/div[2]/div[2]/button")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@class = \"success-msg\"]/ul/li/span")
    private WebElement successMessage;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void addItemToCart() {
        waitForElementToBeVisible(driver, viewDetailsLink, 20);
        js.executeScript("window.scrollBy(0, 500);");
        viewDetailsLink.click();
        waitForElementToBeVisible(driver, colorOption, 10);
        colorOption.click();
        waitForElementToBeVisible(driver, sizeOption, 10);
        sizeOption.click();
        js.executeScript("window.scrollBy(0, 200);");
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public boolean isItemAddedToCart() {
        return successMessage.getText().contains("added to your shopping cart");
    }
}
