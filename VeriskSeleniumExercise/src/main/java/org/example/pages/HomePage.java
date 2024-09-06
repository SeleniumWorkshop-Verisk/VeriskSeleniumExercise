package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText = "WOMEN")
    private WebElement womenLink;

    @FindBy(linkText = "MEN")
    private WebElement menLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToWomenSection() {
        womenLink.click();
    }

    public void navigateToMenSection() {
        menLink.click();
    }
}
