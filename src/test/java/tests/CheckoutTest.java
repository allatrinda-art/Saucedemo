package tests;

import io.qameta.allure.Issue;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Issue("#321")
    @Test
    public void emptyUserInformation() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        cartPage.openCart();
        cartPage.proceedToCheckout();
        checkoutPage.proceedToConfirmationPage("", "",null);
        assertEquals(checkoutPage.getErrorMessageOnCheckout(), "Error: First Name is required", "no errors");
    }

    @Test
    public void cancelOrder() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bike Light");
        productsPage.addProductToCart("Sauce Labs Onesie");
        cartPage.openCart();
        cartPage.proceedToCheckout();
        checkoutPage.proceedToConfirmationPage("Alex", "York", 123456);
        checkoutPage.cancelOrder();
        assertEquals(productsPage.findButtonByButtonName("Sauce Labs Bike Light"),"ADD TO CART", "REMOVE");
        assertEquals(productsPage.findButtonByButtonName("Sauce Labs Onesie"),"Add to cart", "REMOVE");

    }
}
