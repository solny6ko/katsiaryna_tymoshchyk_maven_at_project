package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

public class WindowsHandleUtility {

    public static void switchToNewOpenedWindow(WebDriver driver, String originalWindow) {
        Set<String> openedWindows = driver.getWindowHandles();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                numberOfWindowsToBe(2)
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        for (String windowHandle : openedWindows) {
            if (!windowHandle.contentEquals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }
}

