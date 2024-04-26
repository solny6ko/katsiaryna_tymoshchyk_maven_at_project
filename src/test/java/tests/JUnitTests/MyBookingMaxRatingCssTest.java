package tests.JUnitTests;

import driver.Driver;
import org.junit.Test;
import pages.booking.*;
import tests.BaseStepsJUnit;

import static org.testng.AssertJUnit.assertEquals;

public class MyBookingMaxRatingCssTest extends BaseStepsJUnit {
    private BookingHomePageCss bookingHomePageCss = new BookingHomePageCss();
    private BookingSearchResultsPageCss bookingSearchResultPageCss = new BookingSearchResultsPageCss();
    private BookingHotelPageCss bookingHotelPageCss = new BookingHotelPageCss();

    @Test
    public void checkBookingMaxRatingCss() {

        bookingHomePageCss.navigateToBookingPage();
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
        Driver.switchToNewOpenedWindow();
        bookingHotelPageCss.waitForPropertyRatingStarsXpath();
        assertEquals("Rating is wrong, ",
                "5",
                bookingHotelPageCss.calculateRatingStars());
    }
}