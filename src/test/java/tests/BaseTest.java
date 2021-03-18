package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class) //все тесты будут слушаться by listener
public class BaseTest {

    WebDriver chrome;
    LoginPageFluent loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    ConfirmationPage confirmationPage;

    @BeforeMethod
    public void setup(ITestResult testResult) { //
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");//хром хранится в папке resources
        chrome = new ChromeDriver(); //        chrome = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        chrome.manage().window().maximize();//полный экран. использовать всегда
        chrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//TODO изучить waits
        //testResult.getTestContext().setAttribute("driver", chrome);//!!! для testlistener
        loginPage = new LoginPageFluent(chrome);//новые
        productsPage = new ProductsPage(chrome);
        cartPage = new CartPage(chrome);
        checkoutPage = new CheckoutPage(chrome);
        confirmationPage = new ConfirmationPage(chrome);
    }

    @AfterMethod(alwaysRun = true) //всегда закрывается метод
    public void tearDown() {
        if (chrome != null) {
            chrome.quit();
        }
    }
}
