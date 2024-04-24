package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplicitElementWait {

    public static void waitForElementXPath(WebDriver driver, String elementToWaitForXPath) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath(elementToWaitForXPath))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void waitForElementXCss(WebDriver driver, String elementToWaitForCss) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementToWaitForCss))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
}
