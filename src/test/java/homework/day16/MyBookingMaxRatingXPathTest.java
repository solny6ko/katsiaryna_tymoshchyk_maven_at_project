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

public class MyBookingMaxRatingXPathTest {

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
            driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='onetrust-accept-btn-handler']"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.xpath("//input[@name='ss']")).sendKeys("Prague");
        driver.findElement(By.xpath("//div[text()='Czech Republic']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try {
            driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Property rating']"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//div[@data-filters-item='class:class=5']//label//span[2]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='5 stars']"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]")).click();

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
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-testid='rating-stars']/span[1]"))
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
        driver.close();
    }
}