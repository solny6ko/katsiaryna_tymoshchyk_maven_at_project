package tests;

import driver.DriverInit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

public class BaseStepsJUnit extends DriverInit{

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
