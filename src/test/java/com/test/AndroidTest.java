package com.test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class AndroidTest {

    @Test
    public void AndroidLaunchTest() throws InterruptedException, MalformedURLException {
        AndroidDriver driver = null;
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setDeviceName("Android Emulator");
            options.setAppPackage("live.hms.app2");
            options.setAppActivity(".ui.home.HomeActivity");
            options.setAutomationName("UiAutomator2");

            // Initialize AndroidDriver with the correct Appium URL
            driver = new AndroidDriver(new URL(" http://192.168.56.1:4723/"), options);

//            System.out.println("App is launched successfully!");
//            WebElement previewButton = driver.findElement(By.id("live.hms.app2:id/edt_meeting_url"));
//            previewButton.sendKeys("https://omkar-videoconf-1512.app.100ms.live/meeting/xzc-vifr-fvk");
//            WebElement joinButton = driver.findElement(By.id("live.hms.app2:id/btn_join_now"));
//            joinButton.click();
//            Thread.sleep(2000);
//            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
//            Thread.sleep(5000);
//            driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
//            Thread.sleep(5000);
//            WebElement previewView = driver.findElement(By.id("live.hms.app2:id/preview_view"));
//            Thread.sleep(5000);
//            Assert.assertTrue(previewView.isDisplayed());
//            boolean isElementPresent = driver.findElements(By.id("live.hms.app2:id/preview_view")).size() > 0;
//            if(isElementPresent) {
//                System.out.println("Preview Video Element present");
//            }
//            else {
//                System.out.println("Preview Video Element not present");
//            }
//            WebElement roomjoin = driver.findElement(By.id("live.hms.app2:id/button_join_meeting"));
//            roomjoin.click();
            System.out.println("App is launched successfully!");

            // Using the WebDriverWait for elements to wait for them to be displayed
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement previewButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("live.hms.app2:id/edt_meeting_url")));
            previewButton.sendKeys("https://omkar-videoconf-1512.app.100ms.live/meeting/xzc-vifr-fvk");

            WebElement joinButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("live.hms.app2:id/btn_join_now")));
            joinButton.click();

            // Wait for permissions and click
            WebElement allowForegroundButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
            allowForegroundButton.click();

            allowForegroundButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")));
            allowForegroundButton.click();

            WebElement previewView = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("live.hms.app2:id/preview_view")));
            Assert.assertTrue(previewView.isDisplayed());

            boolean isElementPresent = driver.findElements(By.id("live.hms.app2:id/preview_view")).size() > 0;
            if (isElementPresent) {
                System.out.println("Preview Video Element present");
            } else {
                System.out.println("Preview Video Element not present");
            }

            WebElement roomJoin = wait.until(ExpectedConditions.elementToBeClickable(By.id("live.hms.app2:id/button_join_meeting")));
            roomJoin.click();


// Uncomment to exit room if necessary
//            WebElement exitroom = driver.findElement(By.id("live.hms.app2:id/button_end_call"));
//            exitroom.click();
//            WebElement endsession = driver.findElement(By.id("live.hms.app2:id/leave_title"));
//            endsession.click();
            Thread.sleep(8000);
            driver.quit(); //Quit the driver after the test
        } catch (WebDriverException e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit(); // Quit the driver after the test
            }
        }


    }
}
