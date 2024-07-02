package test;

import org.example.LoginPage;
import org.example.SortProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import testComponent.BaseTest;

public class SortProductTest extends BaseTest {
    @Test
    public void successSortProduct(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        SortProductPage sp = new SortProductPage(driver);

        Assert.assertEquals(sp.sortDescedingProduct(), sp.priceProductValidateDescending());
    }
}
