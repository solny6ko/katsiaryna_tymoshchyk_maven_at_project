package pages.booking;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ExplicitElementWait;


public class BookingHotelPageXPath {
    public static final String PROPERTY_RATING_STARS_XPATH = "//span[@data-testid='rating-stars']/span[1]";

    public String calculateRatingStars() {
        int starsCount = 0;
        for (int i = 1; i < 6; i++) {
            String pathToStar = "//span[@data-testid='rating-stars']/span[" + i + "]";
            if (Driver.getWebDriver().findElement(By.xpath(pathToStar)).isDisplayed()) {
                starsCount++;
            }
        }
        return String.valueOf(starsCount);
    }

    //WAITERS
    public void waitForPropertyRatingStarsXpath() {
        ExplicitElementWait.waitForElementXPath(Driver.getWebDriver(), PROPERTY_RATING_STARS_XPATH);
    }

}
