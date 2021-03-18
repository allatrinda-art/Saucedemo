package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By ZIP_CODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.cssSelector(".cart_button");
    public static final By ERROR_MESSAGE_ON_CHECKOUT = By.cssSelector("[data-test=error]");
    public static final By CANCEL_ORDER_BUTTON = By.cssSelector(".cart_cancel_link");
    public static final By PAID_ITEM = By.cssSelector(".inventory_item_name");
    public static final By FINISH_BUTTON = By.cssSelector(".cart_button");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmationPage proceedToConfirmationPage(String firstName, String lastName, Integer zip) {
        //какую страницу указать?
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(String.valueOf(zip));
        driver.findElement(CONTINUE_BUTTON).click();
        return new ConfirmationPage(driver);//создали один объект, вернули ???
    }

    public String getErrorMessageOnCheckout() {
        return driver.findElement(ERROR_MESSAGE_ON_CHECKOUT).getText();
    }

    public void cancelOrder() {
        driver.findElement(CANCEL_ORDER_BUTTON).click();
    }
    public int paidItems() {
        return driver.findElements(PAID_ITEM).size();
    }

    public void finishOrder() {
        driver.findElement(FINISH_BUTTON).click();
    }
}
