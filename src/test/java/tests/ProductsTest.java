package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ProductsTest extends BaseTest{

    @Test(retryAnalyzer = Retry.class) //если упадет, то запустится еще один раз
    public void productsShouldBeAvailableInCart() {
        loginPage
                .open()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack")
                .addProductToCart("Sauce Labs Bike Light")
                .openCart();

        assertEquals(cartPage.getNumberProducts(), 2, "не все товары в корзине");
    }

    @Test
    public void orderPlaced() {
        loginPage.open()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack")
                .addProductToCart("Sauce Labs Bike Light")
                .addProductToCart("Sauce Labs Onesie")
                .openCart()
                .proceedToCheckout()
                .proceedToConfirmationPage("Alex", "York", 123456);
        assertEquals(checkoutPage.paidItems(), 3, "не все товары оплачены");
        checkoutPage.finishOrder();
        assertEquals(confirmationPage.completeMessageAppears(), "THANK YOU FOR YOUR ORDER", "order failed");
    }

    @Test
    public void deleteItemFromCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.addProductToCart("Sauce Labs Bike Light");
        cartPage.openCart();
        cartPage.removeItemfromCart("Sauce Labs Backpack");
        assertEquals(cartPage.getNumberProducts(), 1, "item wasn't removed");
        assertEquals(cartPage.findProductName(), "Sauce Labs Bike Light", "incorrect item was removed");
    }

    @Test
    public void addItemFromProductPage() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.openProductLink("Sauce Labs Backpack");
        productsPage.addProductToCartFromProductPage();
        cartPage.openCart();
        assertEquals(cartPage.getNumberProducts(), 1, "no items were added");
        assertEquals(cartPage.findProductName(), "Sauce Labs Backpack", "no such item in the cart");
    }
}
