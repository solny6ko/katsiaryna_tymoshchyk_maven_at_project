package tests;

import driver.DriverInit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void initDriver() {
        driver = DriverInit.getWebDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}
