package utils;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class WindowsHandleUtility {
    static WebDriver driver = Driver.getWebDriver();
    public static void switchToNewOpenedWindow() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }
}

