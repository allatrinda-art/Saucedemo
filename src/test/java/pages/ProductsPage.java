package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART = "//*[contains(text(), '%s')]/ancestor::*[@class='inventory_item']//button";
    public static final String ITEM_LINK = "//*[contains(text(), '%s')]/ancestor::a[@id='item_4_title_link']";
    public static final By PRODUCT_PAGE_ADD_TO_CART_BUTTON = By.cssSelector(".btn_primary");
    public static final By PRODUCT_LABEL = By.cssSelector(".product_label");
    //Array list for sorting.кол-во айтемов, брать названия айтемов,

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART, productName))).click();
        return this;
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

    public void isPageOpened() { //минус: использует implicitywait,
        try {
            driver.findElement(PRODUCT_LABEL);//NoSuchElementExсeption
        } catch (NoSuchElementException ex) {
            Assert.fail("Product page was not loaded");
        }
    }

    public void isPageOpened3() {//самый лучший

        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(PRODUCT_LABEL));//в течение 10 сек будет дожидаться что элекмент будет найден и веден
        } catch (TimeoutException ex) {
            Assert.fail("Страница продуктовне была загружена");
        }
    }
}
