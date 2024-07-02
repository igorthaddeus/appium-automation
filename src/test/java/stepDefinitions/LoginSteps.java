package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.LoginPage;
import testComponent.BaseTest;

import java.net.MalformedURLException;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;

    @Given("User is on Login page")
    public void user_is_on_login_page() throws MalformedURLException {
        super.setUp();
        loginPage = new LoginPage(driver);
    }

    @And("User input username {string}")
    public void user_input_username(String username) {
        loginPage.inputUsername(username);
    }

    @And("User input password {string}")
    public void user_input_password(String password) {
        loginPage.inputPassword(password);
    }

    @And("User click on login button")
    public void user_click_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("User in on home page")
    public void user_in_home_page() {
        loginPage.textProductIsDisplayed();
//        super.closeSession();
    }
}
