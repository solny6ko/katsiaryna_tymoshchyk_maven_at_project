package pages.booking;

import driver.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ExplicitElementWait;


public class HotelPageBookingXPath {
    public static final String PROPERTY_RATING_STARS_XPATH = "//span[@data-testid='rating-stars']/span[1]";

    WebDriver driver = DriverInit.getWebDriver();

    public String calculateRatingStars() {
        int starsCount = 0;
        for (int i = 1; i < 6; i++) {
            String pathToStar = "//span[@data-testid='rating-stars']/span[" + i + "]";
            if (driver.findElement(By.xpath(pathToStar)).isDisplayed()) {
                starsCount++;
            }
        }
        return String.valueOf(starsCount);
    }

    //WAITERS
    public void waitForPropertyRatingStarsXpath() {
        ExplicitElementWait.waitForElementXPath(driver, PROPERTY_RATING_STARS_XPATH);
    }

}
