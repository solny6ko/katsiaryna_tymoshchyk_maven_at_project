package tests;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseStepsTestNG {

    static WebDriver driver;

    @BeforeClass
    public static void initDriver() {
        driver = Driver.getWebDriver();
    }

    public static void getConfig() {
        System.out.println(System.getProperty("CONFIG"));
    }


    @AfterClass
    public static void closeDriver() {
        Driver.destroy();
    }
}
