package tests;

import driver.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseStepsTestNG extends DriverInit{

    static WebDriver driver;

    @BeforeClass
    public static void initDriver() {
        driver = DriverInit.getWebDriver();
    }

    @AfterClass
    public static void closeDriver() {
       driver.quit();
    }
}
