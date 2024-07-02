package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.LoginPage;
import org.example.SortProductPage;
import org.testng.Assert;
import testComponent.BaseTest;

import java.net.MalformedURLException;

public class SortProductSteps extends BaseTest {
    LoginPage loginPage;
    SortProductPage sortProductPage;

    @Given("User on the login page")
    public void user_on_the_login_page() throws MalformedURLException {
        super.setUp();
        loginPage = new LoginPage(driver);
    }

    @When("User login with username {string} and password {string}")
    public void user_login_with_username_password(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
    }

    @When("User sort products")
    public void user_sort_Products() {
        sortProductPage = new SortProductPage(driver);
    }

    @Then("the products should be sorted in ascending order of price")
    public void the_products_should_be_sorted() {
        Assert.assertEquals(sortProductPage.sortDescedingProduct(), sortProductPage.priceProductValidateDescending());
    }
}
