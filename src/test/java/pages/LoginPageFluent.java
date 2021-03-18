package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageFluent extends BasePage {
    public static final By LOGIN_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");
    public static final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPageFluent(WebDriver driver) {
        super(driver);
    }

    public LoginPageFluent open() {
        driver.get("https://www.saucedemo.com/");//открывает браузер/урл
        return this;//возвращает экземпляр этого же класса
    }

    public ProductsPage login(String userName, String password) {//чтобы можно было использовать разные параметры
        driver.findElement(LOGIN_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);//создали один объект, вернули
    }

    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }
}
