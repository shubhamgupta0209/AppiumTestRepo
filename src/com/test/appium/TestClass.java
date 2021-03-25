package com.test.appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ISuiteListener;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestClass {
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		/*
		 * File f = new File("src"); File fs = new File(f, "ApiDemos-debug.apk");
		 * 
		 * DesiredCapabilities cap = new DesiredCapabilities();
		 * cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		 * cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
		 * 
		 * driver = new AndroidDriver<AndroidElement>(new
		 * URL("http://127.0.0.1:4723/wd/hub"), cap);
		 */

		String kobitonServerUrl = "https://meettoshubh2005:03006b64-5789-4b7b-bd7d-a8476b275df1@api.kobiton.com/wd/hub";

		DesiredCapabilities capabilities = new DesiredCapabilities();
// The generated session will be visible to you only. In case you want this session available for other users, please assign this device to specific group. 
		capabilities.setCapability("sessionName", "Automation test session");
		capabilities.setCapability("sessionDescription", "");
		capabilities.setCapability("deviceOrientation", "portrait");
		capabilities.setCapability("captureScreenshots", true);
// The maximum size of application is 500MB
// By default, HTTP requests from testing library are expired
// in 2 minutes while the app copying and installation may
// take up-to 30 minutes. Therefore, you need to extend the HTTP
// request timeout duration in your testing library so that
// it doesn't interrupt while the device is being initialized.
		capabilities.setCapability("app", "kobiton-store:175199");

		capabilities.setCapability("deviceGroup", "KOBITON");
// For deviceName, platformVersion Kobiton supports wildcard
// character *, with 3 formats: *text, text* and *text*
// If there is no *, Kobiton will match the exact text provided
		capabilities.setCapability("deviceName", "Xperia XA Ultra");
		capabilities.setCapability("platformVersion", "7.0");
		capabilities.setCapability("platformName", "Android");

		driver = new AndroidDriver<AndroidElement>(new URL(kobitonServerUrl), capabilities);

	}

	@Test
	public void testCal() throws Exception {

		driver.findElements(By.id("android:id/text1")).get(4).click();

		driver.findElements(By.id("android:id/text1")).get(3).click();

		driver.findElements(By.id("android:id/text1")).get(0).click();

		int size = driver.findElements(By.className("android.widget.Button")).size();

		// System.out.println(size);
		/*
		 * String text = driver.findElement(By.xpath("//*[@text='Media']")).getText();
		 * Assert.assertEquals(text, "Media");
		 */
		Assert.assertEquals(4, size);

	}

	@AfterClass
	public void teardown() {
		// close the app
		driver.quit();
	}
}