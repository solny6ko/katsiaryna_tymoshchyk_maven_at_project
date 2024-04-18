package classwork.day16;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class MyBookingParisCheckRatingCSSTest {
    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void myBookingParisCheckRatingCSS() {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("#onetrust-accept-btn-handler")).click();
        driver.findElement(By.cssSelector("input[name='ss']")).sendKeys("Paris");
        driver.findElement(By.cssSelector("#autocomplete-result-0 > div > div > div > :first-of-type")).click();
        int checkInDay = LocalDate.now().plusDays(3).getDayOfMonth();
        int checkOutDay = LocalDate.now().plusDays(10).getDayOfMonth();
        String pathToDay = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
        driver.findElement(By.xpath(String.format(pathToDay, checkInDay))).click();
        driver.findElement(By.xpath(String.format(pathToDay, checkOutDay))).click();
        driver.findElement(By.cssSelector("button[data-testid='occupancy-config']")).click();
        WebElement adults = driver.findElement(By.cssSelector("div[data-testid='occupancy-popup'] > div > div:first-child > div > button~button > span"));
        adults.click();
        adults.click();
        WebElement rooms = driver.findElement(By.cssSelector("div[data-testid='occupancy-popup'] > div > div:nth-of-type(3) > div > button~button > span"));
        rooms.click();
        try {
            driver.findElement(By.cssSelector("button[aria-label='Dismiss sign-in info.'] > span > span")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        try {
            driver.findElement(By.cssSelector("button[aria-label='Dismiss sign-in info.'] > span > span")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#filter_group_price_\\:rg\\: > div:first-of-type > h3"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.cssSelector("div[ data-filters-item='review_score:review_score=60'] > label:first-of-type")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[ data-testid='title']:first-of-type"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.cssSelector("button[data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.cssSelector("button[data-id='class_asc']")).click();
        String score = driver.findElement(By.xpath("//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]/div")).getText();
        System.out.println(score + " Div value");

        String[] arrOfStr = score.split(" ");
        System.out.println(Arrays.toString(arrOfStr) + " Array from div value");
        String scoreString = arrOfStr[1];
        System.out.println(scoreString + " Score value in string");
        String[] arrayScoreString = scoreString.split("\\.");
        System.out.println(Arrays.toString(arrayScoreString) + " Array from Score value");
        String onlyScoreValue = arrayScoreString[0];
        System.out.println(onlyScoreValue);

        assertEquals("Score of the first sorted hotel is wrong", "6", onlyScoreValue);
    }
    @After
    public void cLoseBrowser() {
        driver.close();
    }
}
