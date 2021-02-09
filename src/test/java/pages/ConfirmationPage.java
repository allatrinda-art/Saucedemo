package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePage{
    public static final By PAID_ITEM = By.cssSelector(".inventory_item_name");
    public static final By FINISH_BUTTON = By.cssSelector(".cart_button");
    public static final By COMPLETE_MESSAGE = By.cssSelector(".complete-header");


    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public int paidItems() {
        return driver.findElements(PAID_ITEM).size();
    }

    public void finishTheOrder() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public String completeMessageAppears() {
        return driver.findElement(COMPLETE_MESSAGE).getText();
    }
}
