package tests.TestNGTests;

import driver.Driver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.booking.BookingHomePageCss;
import pages.booking.BookingHotelPageCss;
import pages.booking.BookingSearchResultsPageCss;
import tests.BaseStepsTestNG;

public class MyBookingMaxRatingCssNGTest extends BaseStepsTestNG {
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
        Assert.assertEquals(bookingHotelPageCss.calculateRatingStars(),
                "5",
                "Rating is wrong ");
    }
}