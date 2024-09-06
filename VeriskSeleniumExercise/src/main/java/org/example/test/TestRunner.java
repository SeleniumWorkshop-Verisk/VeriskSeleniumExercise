package org.example.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.pages.CartPage;
import org.example.pages.CheckoutPage;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.utilities.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.example.utilities.WaitUtils.waitForElementToBeVisible;
import static org.junit.Assert.assertTrue;

public class TestRunner {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverFactory.createDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test
    public void testEcommerceFlow() throws InterruptedException {
        loginPage.openLoginPage("https://ecommerce.tealiumdemo.com");
        loginPage.clickAccountLink();
        loginPage.clickLoginButton();
        loginPage.enterCredentials("testerveritest@test.com", "veritest");
        loginPage.clickSubmitButton();
        Thread.sleep(5000);
        assertTrue("Login failed", loginPage.isLoginSuccessful());

        checkoutPage.setDefaultBillingAddress();
        assertTrue("Failed to add billing address", checkoutPage.isBillingAddressAdded());

        homePage.navigateToWomenSection();
        cartPage.addItemToCart();
        assertTrue("Failed to add item to cart", cartPage.isItemAddedToCart());

        homePage.navigateToMenSection();
        cartPage.addItemToCart();
        assertTrue("Failed to add item to cart", cartPage.isItemAddedToCart());



        checkoutPage.proceedToCheckout();
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

