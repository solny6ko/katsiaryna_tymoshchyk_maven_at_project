package pages.booking;

import driver.Driver;
import org.openqa.selenium.*;
import utils.ExplicitElementWait;

public class SearchResultsPageBookingCss {

    public static final String PROPERTY_RATING_CLASS_5_CSS = "div[ data-filters-item='class:class=5'] > label";
    public static final String HEADER_OF_IMPLEMENTED_FILTER_5_CSS = "div[ data-testid='title']:first-of-type";
    public static final String PROPERTY_REVIEW_SCORE_CSS = "div[ data-testid='title']:first-of-type";
    public static final String PROPERTY_REVIEW_SCORE_6PLUS_CSS = "div[ data-filters-item='review_score:review_score=60'] > label:first-of-type";
    public static final String PROPERTY_REVIEW_SCORE_6PLUS_BUTTON_CSS = "div[ data-testid='title']:first-of-type";
    public static final String YOUR_BUDGET_HEADER_CSS = "#filter_group_price_\\:rg\\: > div:first-of-type > h3";

    WebDriver driver = Driver.getWebDriver();

    public void choose5StarsRating() {
        driver.findElement(By.cssSelector(PROPERTY_RATING_CLASS_5_CSS)).click();
    }

    public void clickOnRating() {
        driver.findElement(By.cssSelector(PROPERTY_REVIEW_SCORE_CSS)).click();
    }

    public void choose6plusRating() {
        driver.findElement(By.cssSelector(PROPERTY_REVIEW_SCORE_6PLUS_CSS)).click();
    }

    public void openSortResultsDropDown() {
        driver.findElement(By.cssSelector("button[data-testid='sorters-dropdown-trigger']")).click();
    }

    public void chooseRatingLowToHighResultsSorting() {
        driver.findElement(By.cssSelector("button[data-id='class_asc']")).click();
    }

    public String checkFirstElementRatingValue() {
        String score = driver.findElement(By.xpath("//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]/div")).getText();
        String[] arrOfStr = score.split(" ");
        String scoreString = arrOfStr[1];
        String[] arrayScoreString = scoreString.split("\\.");
        return arrayScoreString[0];
    }


    //WAITERS
    public void waitForPropertyRatingHeaderXpath() {
        ExplicitElementWait.waitForElementXCss(driver, PROPERTY_RATING_CLASS_5_CSS);
    }

    public void waitForHeaderOfImplementedFilter5Xpath() {
        ExplicitElementWait.waitForElementXCss(driver, HEADER_OF_IMPLEMENTED_FILTER_5_CSS);
    }

    public void waitForBudgetHeaderXpath() {
        ExplicitElementWait.waitForElementXCss(driver, YOUR_BUDGET_HEADER_CSS);
    }

    public void waitForPropertyReviewScore6PlusBTN() {
        ExplicitElementWait.waitForElementXCss(driver, PROPERTY_REVIEW_SCORE_6PLUS_BUTTON_CSS);
    }

}
