package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SortProductPage extends LoginPage {

    AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Modal Selector Button\"]/android.view.ViewGroup/android.view.ViewGroup/android.widget.ImageView")
    WebElement sortButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Price (low to high)\"]")
    WebElement sortItemButton;

    public SortProductPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    private void addProductNamesToList(List<String> nameProducts, By locator) {
        List<WebElement> elements = driver.findElements(locator);
        for (WebElement element : elements) {
            String text = element.getText();
            nameProducts.add(text);
        }
    }

    private void scrollForward() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"
        ));
    }

    private void scrollToTop() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollBackward()"
        ));
    }

    public List<String> getPriceProductList() {
        List<String> priceProducts = new ArrayList<>();
        By priceLocator = AppiumBy.xpath("//android.widget.TextView[@content-desc=\"test-Price\"]");
        addProductNamesToList(priceProducts, priceLocator);
        scrollForward();
        addProductNamesToList(priceProducts, priceLocator);

        return priceProducts;
    }

    public List<Double> sortingProducts(List<String> priceProducts, Boolean sort) {
        List<Double> priceProductList;


        if (sort) {
            priceProductList = priceProducts.stream()
                    .map(s -> Double.valueOf(s.replace("$", "")))
                    .sorted()
                    .collect(Collectors.toList());
        } else {
            priceProductList = priceProducts.stream()
                    .map(s -> Double.valueOf(s.replace("$", "")))
                    .collect(Collectors.toList());
        }
        return priceProductList;
    }

    public List<Double> sortDescedingProduct() {
        return sortingProducts(getPriceProductList(), true);
    }

    public List<Double> priceProductValidateDescending() {
        scrollToTop();

        sortButton.click();
        sortItemButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        return sortingProducts(getPriceProductList(), false);
    }
}