package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.CheckoutPage;
import org.example.LoginPage;
import testComponent.BaseTest;

import java.net.MalformedURLException;

public class CheckoutProduct extends BaseTest {
    LoginPage loginPage;
    CheckoutPage checkoutPage;

    @Given("User is on the login page")
    public void the_user_is_on_the_login_page() throws MalformedURLException {
        super.setUp();
        loginPage = new LoginPage(driver);
    }

    @When("User input username {string} and password {string}")
    public void the_user_logs_in_with_username_and_password(String username, String password) {
        loginPage.inputUsername(username);
        loginPage.inputPassword(password);
        loginPage.clickLoginButton();
    }

    @When("User adds an item to the cart")
    public void the_user_adds_an_item_to_the_cart() {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.addToCart();
    }

    @When("User input first name {string}, last name {string}, and postal code {string}")
    public void the_user_enters_their_details(String firstName, String lastName, String postalCode) {
        checkoutPage.inputFirstName(firstName);
        checkoutPage.inputLastName(lastName);
        checkoutPage.inputPostalCode(postalCode);
    }

    @When("User continues to the checkout")
    public void the_user_continues_to_the_checkout() {
        checkoutPage.clickContinue();
    }

    @When("User completes the purchase")
    public void the_user_completes_the_purchase() {
        checkoutPage.clickFinish();
    }

    @Then("User should see a confirmation message")
    public void the_user_should_see_a_confirmation_message() {
        checkoutPage.isConfirmationMessageDisplayed();
    }
}
