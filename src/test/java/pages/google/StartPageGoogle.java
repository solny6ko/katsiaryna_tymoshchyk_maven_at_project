package pages.google;

import driver.DriverInit;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;

public class StartPageGoogle {
    WebDriver driver = DriverInit.getWebDriver();

    public void navigateToGoogleHomePage() {
        driver.get("https://google.com");
    }

    public void acceptCookiesGoogleHomePage() {
        try {
            driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));

        }
    }

    public void inputSearchQueryUsingKeyboard() {
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
    }
}
