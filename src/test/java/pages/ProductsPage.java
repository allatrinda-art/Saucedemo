package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART = "//*[contains(text(), '%s')]/ancestor::*[@class='inventory_item']//button";
    public static final String ITEM_LINK = "//*[contains(text(), '%s')]/ancestor::a[@id='item_4_title_link']";
    public static final By PRODUCT_PAGE_ADD_TO_CART_BUTTON = By.cssSelector(".btn_primary");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART, productName))).click();
    }

    public String findButtonByButtonName(String productName) {
        return driver.findElement(By.xpath(String.format(ADD_TO_CART, productName))).getText();
    }
    public void openProductLink(String productName) {
       driver.findElement(By.xpath(String.format(ITEM_LINK, productName))).click();
    }

    public void addProductToCartFromProductPage() {
        driver.findElement(PRODUCT_PAGE_ADD_TO_CART_BUTTON).click();
    }
}
