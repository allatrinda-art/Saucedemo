package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage extends BasePage{
    public static final By COMPLETE_MESSAGE = By.cssSelector(".complete-header");


    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public String completeMessageAppears() {
        return driver.findElement(COMPLETE_MESSAGE).getText();
    }
}
