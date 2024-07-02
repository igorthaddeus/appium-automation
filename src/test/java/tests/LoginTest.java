package tests;

import org.example.LoginPage;
import org.testng.annotations.Test;
import testComponent.BaseTest;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void successLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        loginPage.textProductIsDisplayed();
    }

    @Test(priority = 2)
    public void failedLoginInvalidUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        loginPage.errorMessageIsDisplayed();
    }

    @Test(priority = 3)
    public void failedLoginInvalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("123");
        loginPage.clickLoginButton();

        loginPage.errorMessageIsDisplayed();
    }
}
