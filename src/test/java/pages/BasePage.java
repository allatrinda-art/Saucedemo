package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage { //абстрактный класс
    public static final By CART_BUTTON = By.cssSelector(".shopping_cart_link");
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    //public abstract BasePage open();

    public CartPage openCart() {
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }
}
