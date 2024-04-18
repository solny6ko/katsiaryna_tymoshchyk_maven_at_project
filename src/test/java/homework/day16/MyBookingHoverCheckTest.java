package homework.day16;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;

import static org.testng.AssertJUnit.assertEquals;

public class MyBookingHoverCheckTest {

    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void checkCheckAltTextCurrency() {
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

        WebElement currencyBtn = driver.findElement(By.xpath("//button[@data-testid='header-currency-picker-trigger']/span"));
        Actions checkAltTextCurrency = new Actions(driver);
        checkAltTextCurrency.moveToElement(currencyBtn);
        checkAltTextCurrency.perform();
        String currencyBtnText = currencyBtn.findElement(By.xpath("//div[text()='Select your currency']")).getText();
        assertEquals("Alt text on Select your currency button is wrong, ", "Select your currency", currencyBtnText);
    }

    @Test
    public void checkCheckAltTextLanguage() {
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

        WebElement languageBtn = driver.findElement(By.xpath("//button[@data-testid='header-language-picker-trigger']/span"));
        Actions checkAltTextLanguage = new Actions(driver);
        checkAltTextLanguage.moveToElement(languageBtn);
        checkAltTextLanguage.perform();
        String languageBtnText = languageBtn.findElement(By.xpath("//div[text()='Select your language']")).getText();
        Assert.assertEquals("Alt text on Select your currency button is wrong, ", "Select your language", languageBtnText);
    }

    @After
    public void cLoseBrowser() {
        driver.close();
    }
}