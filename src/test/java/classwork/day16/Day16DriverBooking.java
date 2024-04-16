package classwork.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class Day16DriverBooking {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.findElement(By.xpath("//input[@name='ss']")).sendKeys("Paris");
        driver.findElement(By.xpath("//div[text()='Ile de France, France']")).click();
        int checkInDay = LocalDate.now().plusDays(3).getDayOfMonth();
        int checkOutDay = LocalDate.now().plusDays(10).getDayOfMonth();
        String pathToDay = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
        driver.findElement(By.xpath(String.format(pathToDay, checkInDay))).click();
        driver.findElement(By.xpath(String.format(pathToDay, checkOutDay))).click();
        driver.findElement(By.xpath("//span[@data-testid='occupancy-config-icon']")).click();
        WebElement adults = driver.findElement(By.xpath("//label[@for='group_adults']/../following-sibling::div/button[2]"));
        adults.click();
        adults.click();
        WebElement rooms = driver.findElement(By.xpath("//label[@for='no_rooms']/../following-sibling::div/button[2]"));
        rooms.click();
        try {
            driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        try {
            driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Your Budget (per night)']"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//div[@data-filters-item='review_score:review_score=60']//span[2]")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Pleasant: 6+']"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//button[@data-id='class_asc']")).click();
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
        driver.close();


    }
}
