package tests.JUnitTests;

import org.junit.Test;
import pages.booking.*;
import tests.BaseTest;
import utils.WindowsHandleUtility;

import static org.testng.AssertJUnit.assertEquals;

public class MyBookingMaxRatingCssTest extends BaseTest {
    private HomePageBookingCss bookingHomePageCss;
    private SearchResultsPageBookingCss bookingSearchResultPageCss;
    private HotelPageBookingCss bookingHotelPageCss;

    @Test
    public void checkBookingMaxRatingCss() {

        bookingHomePageCss.navigateToBookingPage();
        String originalWindow = driver.getWindowHandle();
        bookingHomePageCss.dismissSignIn();
        bookingHomePageCss.acceptCookies();
        bookingHomePageCss.typeCity("Prague");
        bookingHomePageCss.choosePragueAutocomplete();
        bookingHomePageCss.submitSearchQuery();
        bookingHomePageCss.dismissSignIn();
        bookingSearchResultPageCss.waitForPropertyRatingHeaderXpath();
        bookingSearchResultPageCss.choose5StarsRating();
        bookingSearchResultPageCss.waitForHeaderOfImplementedFilter5Xpath();
        bookingSearchResultPageCss.clickOnRating();
        WindowsHandleUtility.switchToNewOpenedWindow(driver, originalWindow);
        bookingHotelPageCss.waitForPropertyRatingStarsXpath();
        assertEquals("Rating is wrong, ",
                "5",
                bookingHotelPageCss.calculateRatingStars());
    }
}