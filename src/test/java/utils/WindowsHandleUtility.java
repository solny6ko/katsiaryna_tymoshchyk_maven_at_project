package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import driver.DriverInit;

public class WindowsHandleUtility {
    static WebDriver driver = DriverInit.getWebDriver();
    public static void switchToNewOpenedWindow() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }
}

