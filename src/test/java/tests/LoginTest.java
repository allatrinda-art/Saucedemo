package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void wrongPassword() {
        loginPage.open();//новые
        loginPage.login("standard_user", "123");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "message");

        //boolean homeText = driver.findElement(By.cssSelector(".product_label")).isDisplayed();//cssSelector("product_label").getText();но boolean
        //Assert.assertTrue(homeText, "Products");
    }

    @Test
    public void emptyUserName() {
        loginPage.open();//новые
        loginPage.login("", "123");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "message");

        //boolean homeText = driver.findElement(By.cssSelector(".product_label")).isDisplayed();//cssSelector("product_label").getText();но boolean
        //Assert.assertTrue(homeText, "Products");
    }

}
