package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test
    public void CheckoutShouldWork() {

    loginPage.login("standard_user", "secret_sauce");
    productPage.addToCart("Sauce Labs Backpack");
    productPage.clickCart();
    cartPage.clickOnCheckoutButton();
    checkoutPage.fillCheckout("Ivan", "Ivanov", "24680");
    checkoutPage.clickOnFinishButton();
    assertTrue(driver.findElement(By.cssSelector(".summary_info")).isDisplayed());


    }

    @Test
    public void CheckoutWithoutFirstName() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productPage.addToCart("Sauce Labs Backpack");
        productPage.clickCart();
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillCheckout("", "Ivanov", "24680");
        assertEquals(checkoutPage.getError(), "Error: First Name is required");

    }
}