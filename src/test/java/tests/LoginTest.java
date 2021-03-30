package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//СКРИНШОТ,ЕСЛИ УПАЛ
//связка с TEST MANAGEMENT SYSTEM

public class LoginTest extends BaseTest{

    @DataProvider(name = "Input for login")
    public Object[][] inputForLogin() { //всегда возвращается двумерный массив данных
        return new Object[][]{
                {"standart_user", "123", "Epic sadface: Username and password do not match any user in this service"},//может быть сколько угодно параметров. от 2х
                {"", "123321", "Epic sadface: Username is required"}
        };
    }

    @Test(dataProvider = "Input for login")
    public void login(String user, String password, String errorMessage) {
        loginPage.open();//новые
        loginPage.login(user, password);
        Assert.assertEquals(loginPage.getErrorMessage(),
                errorMessage,
                "no messages/errors");
    }

    @Test
    public void wrongPassword() {
        loginPage.open();//новые
        loginPage.login("standard_user", "123");
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "no messages/errors");

        //boolean homeText = driver.findElement(By.cssSelector(".product_label")).isDisplayed();//cssSelector("product_label").getText();но boolean
        //Assert.assertTrue(homeText, "Products");
    }

    @Test
    public void emptyUserName() {
        loginPage.open();//новые
        loginPage.login("", "123321");
        productsPage.isPageOpened3();
        Assert.assertEquals(loginPage.getErrorMessage(),
                "Epic sadface: Username is required",
                "no messages/errors");

        //boolean homeText = driver.findElement(By.cssSelector(".product_label")).isDisplayed();//cssSelector("product_label").getText();но boolean
        //Assert.assertTrue(homeText, "Products");
    }
}
