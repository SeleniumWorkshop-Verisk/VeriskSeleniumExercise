package org.example.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    public static void waitForElementToBeVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        new WebDriverWait(driver, timeoutInSeconds).until(ExpectedConditions.visibilityOf(element));
    }
}

