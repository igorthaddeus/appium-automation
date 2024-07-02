package test;

import org.example.CheckoutPage;
import org.example.LoginPage;
import org.testng.annotations.Test;
import testComponent.BaseTest;

public class CheckoutTest extends BaseTest {
    @Test(priority = 1)
    public void successCheckout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        CheckoutPage cp = new CheckoutPage(driver);
        cp.addToCart();
        cp.inputFirstName("test");
        cp.inputLastName("test");
        cp.inputPostalCode("123");
        cp.clickContinue();
        cp.clickFinish();
        cp.isConfirmationMessageDisplayed();
    }

    @Test(priority = 2)
    public void testNullFirstName() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        CheckoutPage cp = new CheckoutPage(driver);
        cp.addToCart();
        cp.inputFirstName("");
        cp.inputLastName("test");
        cp.inputPostalCode("123");
        cp.clickContinue();
        cp.isErrorMessageDisplayed();
    }

    @Test(priority = 3)
    public void testNullLastName() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        CheckoutPage cp = new CheckoutPage(driver);
        cp.addToCart();
        cp.inputFirstName("test");
        cp.inputLastName("");
        cp.inputPostalCode("123");
        cp.clickContinue();
        cp.isErrorMessageDisplayed();
    }

    @Test(priority = 3)
    public void testNullZip() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        CheckoutPage cp = new CheckoutPage(driver);
        cp.addToCart();
        cp.inputFirstName("test");
        cp.inputLastName("test");
        cp.inputPostalCode("");
        cp.clickContinue();
        cp.isErrorMessageDisplayed();
    }



}
