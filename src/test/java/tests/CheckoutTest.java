package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void emptyUserInformation() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        cartPage.open();
        checkoutPage.proceedToCheckout();
        checkoutPage.proceedToConfirmationPage("", "",0);
        assertEquals(checkoutPage.getErrorMessageOnCheckout(), "Error: First Name is required", "no errors");
    }
}
