import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    @Test
    public void successfulLogin() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");//хром хранится в папке resources
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();//полный экран. использовать всегда
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//TODO изучить waits
        browser.get("https://www.saucedemo.com/");//открывает браузер/урл
        WebElement submitElement = browser.findElement(By.id("login-button"));
        browser.findElement(By.id("user-name")).sendKeys("standard_user");
        browser.findElement(By.id("password")).sendKeys("secret_sauce");
        submitElement.click();
        String homeText = browser.findElement(By.className("product_label")).getText();
        Assert.assertEquals("Products", homeText);
        browser.quit();

    }
}
