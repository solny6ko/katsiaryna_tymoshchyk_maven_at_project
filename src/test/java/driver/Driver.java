package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class Driver {

    public static WebDriver driver;

    protected static Config config =
            Optional.ofNullable(System.getProperty("CONFIG")).isEmpty() ?
                    Config.CHROME : Config.valueOf(System.getProperty("CONFIG"));

    public static WebDriver getWebDriver() {
        return switch (config) {
            case FF -> getFFDriver();
            case REMOTE -> getRemoteDriver();
            default -> getChromeDriver();
        };
    }

    public static WebDriver getChromeDriver() {
        if (null == driver) {
            ChromeOptions caps = new ChromeOptions();
            caps.addArguments("start-maximized");
            caps.addArguments("disable-infobars");
            caps.setExperimentalOption("excludeSwitches",
                    Collections.singletonList("enable-automation"));
            driver = new ChromeDriver(caps);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        }
        return driver;
    }

    private static WebDriver getFFDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver getRemoteDriver() {
        return null;
    }

    public static void destroy() {
        driver.quit();
        driver = null;
    }
    public static void switchToNewOpenedWindow() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(30))
                .until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size() - 1));
    }
}
