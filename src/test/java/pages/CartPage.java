package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {
    public static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    public static final By NUMBER_OF_BUTTONS = By.cssSelector(".inventory_item_price");
    public static final String REMOVE_BUTTON = "//*[contains(text(), '%s')]/ancestor::*[@class='cart_item']//button";
    public static final By AVAILABLE_ITEMS_IN_CART = By.cssSelector(".inventory_item_name");
    //*[contains(text(), '%s')]/ancestor::*[@class='cart_item']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.findElement(CART_BUTTON).click();
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
}
