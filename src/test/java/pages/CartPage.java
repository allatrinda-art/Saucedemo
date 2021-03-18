package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public static final By NUMBER_OF_BUTTONS = By.cssSelector(".inventory_item_price");
    public static final String REMOVE_BUTTON = "//*[contains(text(), '%s')]/ancestor::*[@class='cart_item']//button";
    public static final By AVAILABLE_ITEMS_IN_CART = By.cssSelector(".inventory_item_name");
    public static final By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");
    //*[contains(text(), '%s')]/ancestor::*[@class='cart_item']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    //@Override
    public BasePage open() {
        driver.get("https://www.saucedemo.com/cart.html");
        return this;
    }

    public int getNumberProducts() {
        return driver.findElements(NUMBER_OF_BUTTONS).size();
    }

    public void removeItemfromCart(String item) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, item))).click();
    }

    public String findProductName() {
        return driver.findElement(AVAILABLE_ITEMS_IN_CART).getText();
    }

    public CheckoutPage proceedToCheckout() {
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES); //драйвер, стань интерфейсом takescrenshot
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutPage(driver);
    }
}
