import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;

public class BaseTest {
    AndroidDriver driver;
    private AppiumDriverLocalService service;

    @BeforeMethod
    public void setUp() throws MalformedURLException {

        service = new AppiumServiceBuilder()
                .usingAnyFreePort()
                .build();
        service.start();

//        service = new AppiumServiceBuilder()
//                .usingPort(4724)  // Ganti dengan port yang tidak digunakan
//                .build();
//        service.start();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "13.0");
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("app", "C:/Users/Igor/Documents/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.swaglabsmobileapp");
        capabilities.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

//        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver = new AndroidDriver(capabilities);
//        driver = new AndroidDriver(new URL(service.getUrl().toString()), capabilities);
//        AndroidDriver driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), capabilities);


//        driver = new AndroidDriver(new URL(service.getUrl().toString()), capabilities);

    }

    @AfterMethod
    public void closeSession(){
        if(driver != null){
            driver.quit();
        }
    }
}
