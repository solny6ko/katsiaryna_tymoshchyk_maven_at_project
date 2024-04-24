package tests;

import driver.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseStepsJUnit extends Driver {

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
