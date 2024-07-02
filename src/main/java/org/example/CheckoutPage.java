package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends LoginPage {
    AndroidDriver driver;

    public CheckoutPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AndroidFindBy(accessibility = "test-First Name")
    WebElement firstName;

    @AndroidFindBy(accessibility = "test-Last Name")
    WebElement lastName;

    @AndroidFindBy(accessibility = "test-Zip/Postal Code")
    WebElement postalCode;

    @AndroidFindBy(accessibility = "test-CONTINUE")
    WebElement continueButton;

    @AndroidFindBy(accessibility = "test-FINISH")
    WebElement finishButton;

    By confirmationMessage = AppiumBy.xpath("//android.widget.TextView[@text='THANK YOU FOR YOU ORDER']");
    By errorMessage = AppiumBy.accessibilityId("test-Error message");
    public void inputFirstName(String firstName) {
        this.firstName.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        this.lastName.sendKeys(lastName);
    }

    public void inputPostalCode(String postalCode) {
        this.postalCode.sendKeys(postalCode);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickFinish() {
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"FINISH\"))")).click();
        finishButton.click();
    }

    public void isConfirmationMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(confirmationMessage)).isDisplayed();
    }

    public void isErrorMessageDisplayed(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).isDisplayed();
    }
    public void addToCart() {
        for (int i = 1; i <= 2; i++) {
            driver.findElement(By.xpath("(//android.view.ViewGroup[@content-desc='test-ADD TO CART'])[1]")).click();
        }
        driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().textContains(\"CHECKOUT\"))")).click();
    }
}
