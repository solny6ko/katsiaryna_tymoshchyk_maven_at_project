package tests;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseStepsTestNG extends Driver {

    static WebDriver driver;

    @BeforeClass
    public static void initDriver() {
        driver = Driver.getWebDriver();
    }

    @AfterClass
    public static void closeDriver() {
        Driver.destroy();
    }
}
