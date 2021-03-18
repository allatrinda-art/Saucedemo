package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageFactory extends BasePage {
    @FindBy(id = "user-name")
    WebElement logininput;
    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(id = "login-button")
    WebElement loginButton;
    @FindBy(css = "[data-test=error]")
    WebElement errorMessage;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

//    public void open() {
//        driver.get("https://www.saucedemo.com/");//открывает браузер/урл
//        PageFactory.initElements(driver, this);
//    }

    public void login(String userName, String password) {//чтобы можно было использовать разные параметры
        logininput.sendKeys(userName);
        passwordInput.sendKeys(password);
        loginButton.click();
        //return new ProductsPage(driver);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }
}
