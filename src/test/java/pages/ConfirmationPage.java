package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePage{
    public static final By PAID_ITEM = By.cssSelector(".inventory_item_name");

    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }
    public int paidItems() {
        return driver.findElements(PAID_ITEM).size();

    }

}
