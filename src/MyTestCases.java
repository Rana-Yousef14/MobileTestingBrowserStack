import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class MyTestCases {
	@BeforeMethod
	public void beforeEachTest() throws MalformedURLException {
		String USERNAME = "ranayousef_FsRYj8";
		String ACCESS_KEY = "HdsBJBpJHtnY2gLEpakB";
		String browserstackURL = "https://" + USERNAME + ":" + ACCESS_KEY + "@hub-cloud.browserstack.com/wd/hub";
		driver = new AndroidDriver(new URL(browserstackURL), capabilities);

	}

	DesiredCapabilities capabilities = new DesiredCapabilities();

	AndroidDriver driver;

	@BeforeTest
	public void setup() throws MalformedURLException {

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Google Pixel 6"); // Use an available device
		capabilities.setCapability("appiumVersion", "1.22.0");
		capabilities.setCapability("app", "bs://1539bf032a325b3101503120b84a69d552e744b7");

	}

	@Test(priority = 1, enabled = true)
	public void addTwoNumbers() throws MalformedURLException {

		// Wait until the element is visible before clicking
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();

		String actual = driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
		String expected = "14";

		System.out.println(actual + " is the actual value from the app");
		System.out.println(expected + " is the expected value");

		Assert.assertEquals(actual, expected);
	}
}
