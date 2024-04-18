package homework.day16;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;
import static org.testng.AssertJUnit.assertEquals;

public class MyBookingMaxRatingCssTest {

    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void checkBookingMaxRatingXPath() {
//Store the ID of the original window
        String originalWindow = driver.getWindowHandle();
//Check we don't have other windows open already
        assert driver.getWindowHandles().size() == 1;
        driver.get("https://booking.com");
        try {
            driver.findElement(By.cssSelector("button[aria-label='Dismiss sign-in info.'] > span > span")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#onetrust-accept-btn-handler"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
        driver.findElement(By.cssSelector("input[name='ss']")).sendKeys("Prague");
        driver.findElement(By.cssSelector("#autocomplete-result-0 > div > div > div > :first-of-type")).click();
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        try {
            driver.findElement(By.cssSelector("button[aria-label='Dismiss sign-in info.'] > span > span")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[ data-filters-item='class:class=5'] > label"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("div[ data-filters-item='class:class=5'] > label")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[ data-testid='title']:first-of-type"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("div[ data-testid='title']:first-of-type")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                numberOfWindowsToBe(2)
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(20)).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span[data-testid='rating-stars'] > span"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        int starsCount = 0;
        for (int i = 1; i < 6; i++) {
            String pathToStar = "//span[@data-testid='rating-stars']/span[" + i + "]";
            if (driver.findElement(By.xpath(pathToStar)).isDisplayed()) {
                starsCount++;
            }
        }
        String starsCountString = String.valueOf(starsCount);

        assertEquals("Rating is wrong, ", "5", starsCountString);
    }

    @After
    public void cLoseBrowser() {
        driver.quit();
    }
}