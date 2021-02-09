package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AuthorizationTest {

    @Test
    public void login() {
        WebDriver browser = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");//хром хранится в папке resources
        browser.manage().window().maximize();//полный экран. использовать всегда
        browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//TODO изучить waits
        browser.get("https://www.saucedemo.com/");//открывает браузер/урл
    }
}
