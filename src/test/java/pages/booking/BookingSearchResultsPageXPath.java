package pages.booking;

import driver.Driver;
import org.openqa.selenium.*;
import utils.ExplicitElementWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BookingSearchResultsPageXPath {
    public static final String PROPERTY_RATING_HEADER_XPATH = "//h3[text()='Property rating']";
    public static final String PROPERTY_RATING_CLASS_5_XPATH = "//div[@data-filters-item='class:class=5']//label//span[2]";
    public static final String HEADER_OF_IMPLEMENTED_FILTER_5_XPATH = "//span[text()='5 stars']";
    public static final String PROPERTY_RATING_CLASS_5_CSS = "div[ data-filters-item='class:class=5'] > label";
    public static final String PROPERTY_REVIEW_SCORE_XPATH = "//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]";
    public static final String PROPERTY_REVIEW_SCORE_6PLUS_XPATH = "//div[@data-filters-item='review_score:review_score=60']//span[2]";
    public static final String PROPERTY_REVIEW_SCORE_6PLUS_BUTTON_XPATH = "//span[text()='Pleasant: 6+']";
    public static final String YOUR_BUDGET_HEADER_XPATH = "//h3[text()='Your budget (per night)']";

    public void choose5StarsRating() {
        Driver.getWebDriver().findElement(By.xpath(PROPERTY_RATING_CLASS_5_XPATH)).click();
    }

    public void clickOnRating() {
        Driver.getWebDriver().findElement(By.xpath(PROPERTY_REVIEW_SCORE_XPATH)).click();
    }

    public void choose6plusRating() {
        Driver.getWebDriver().findElement(By.xpath(PROPERTY_REVIEW_SCORE_6PLUS_XPATH)).click();
    }

    public void openSortResultsDropDown() {
        Driver.getWebDriver().findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
    }

    public void chooseRatingLowToHighResultsSorting() {
        Driver.getWebDriver().findElement(By.xpath("//button[@data-id='class_asc']")).click();
    }

    public String checkFirstElementRatingValue() {
        String score = Driver.getWebDriver().findElement(By.xpath("//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]/div")).getText();
        String[] arrOfStr = score.split(" ");
        String scoreString = arrOfStr[1];
        String[] arrayScoreString = scoreString.split("\\.");
        return arrayScoreString[0];
    }

    public void createAndSaveHotelCardScreenshot() {
        WebElement tenthHotel = Driver.getWebDriver().findElement(By.xpath("//div[@data-testid='property-card'][10]"));
        ((JavascriptExecutor) Driver.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", tenthHotel);
        ((JavascriptExecutor) Driver.getWebDriver()).executeScript("arguments[0].style.backgroundColor = 'green'", tenthHotel);
        ((JavascriptExecutor) Driver.getWebDriver()).executeScript("arguments[0].style.color = 'red'", tenthHotel);
        byte[] asBytes = ((TakesScreenshot) Driver.getWebDriver()).getScreenshotAs(OutputType.BYTES);
        try {
            Files.write(Paths.get("C:\\Katarina\\Java\\files\\tenthHotel.png"), asBytes);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    public boolean checkThatScreenshotExists() {
        return Files.exists(Paths.get("C:\\Katarina\\Java\\files\\tenthHotel.png"));
    }

    //WAITERS
    public void waitForPropertyRatingHeaderXpath() {
        ExplicitElementWait.waitForElementXPath(Driver.getWebDriver(), PROPERTY_RATING_HEADER_XPATH);
    }

    public void waitForHeaderOfImplementedFilter5Xpath() {
        ExplicitElementWait.waitForElementXPath(Driver.getWebDriver(), HEADER_OF_IMPLEMENTED_FILTER_5_XPATH);
    }

    public void waitForBudgetHeaderXpath() {
        ExplicitElementWait.waitForElementXPath(Driver.getWebDriver(), YOUR_BUDGET_HEADER_XPATH);
    }

    public void waitForPropertyReviewScore6PlusBTN() {
        ExplicitElementWait.waitForElementXPath(Driver.getWebDriver(), PROPERTY_REVIEW_SCORE_6PLUS_BUTTON_XPATH);
    }

}
