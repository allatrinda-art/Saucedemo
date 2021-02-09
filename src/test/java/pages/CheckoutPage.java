package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public static final By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");
    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By ZIP_CODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.cssSelector(".cart_button");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void proceedToCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void proceedToConfirmationPage(String firstName, String lastName, int zip) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(String.valueOf(zip));
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
