package homework.day16;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class MyW3schoolsAndGoogleSearchTest {
    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void myW3schoolsAndGoogleSearch() {
        driver.get("https://www.w3schools.com/java/");

        try {
            driver.findElement(By.xpath("//div[@id='accept-choices']")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }

        WebElement nameHeader =
                driver.findElement(By.xpath("//span[@class='color_h1']"));
        Actions copyNameHeader = new Actions(driver);
        copyNameHeader
                .doubleClick(nameHeader)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build().perform();

        driver.get("https://google.com");

        try {
            driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));

        }

        WebElement googleSearchField =
                driver.findElement(By.xpath("//textarea[@aria-label='Szukaj']"));

        Actions pasteNameHeader = new Actions(driver);
        pasteNameHeader
                .click(googleSearchField)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .keyDown(Keys.ENTER)
                .keyUp(Keys.ENTER)
                .build().perform();

        List<WebElement> searchResultsList = driver.findElements(By.xpath("//div/h1[text()='Wyniki wyszukiwania']/../div/div"));
        String wordToFind = "tutorial";

        boolean isResultsContainWord = true;
        for (WebElement result : searchResultsList) {
            String resultText = result.getText().toLowerCase();
            if (!resultText.contains(wordToFind)) {
                isResultsContainWord = false;
                break;
            }
        }
        Assert.assertTrue("Not every search result contains the word: " + wordToFind, isResultsContainWord);
    }

    @After
    public void cLoseBrowser() {
        driver.close();
    }
}