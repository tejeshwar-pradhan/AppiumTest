import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppTest {
    private AndroidDriver<MobileElement> driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "pixel8");
 //       caps.setCapability(MobileCapabilityType.APP, "/Users/tejeshwarpradhan/AndroidStudioProjects/test/AndroidMavenTest/src/AndroidCalculator.apk");
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
 //       caps.setCapability("appPackage", "");
//        caps.setCapability("appActivity","");

        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), caps);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void sampleTest() {
        // Example: Find an element and perform action
        driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Predicted app: Calculator\"]").click();
        driver.findElementById("com.darkempire78.opencalculator:id/input").sendKeys("123456");
        String text= driver.findElementById("com.darkempire78.opencalculator:id/resultDisplay").getText();
        Assert.assertEquals(text,"123456");
       // driver.findElementById("com.darkempire78.opencalculator:id/addButton").click();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
