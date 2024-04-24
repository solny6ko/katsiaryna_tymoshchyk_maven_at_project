package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.booking.BookingHomePageXPath;
import pages.booking.BookingSearchResultsPageXPath;
import tests.BaseStepsTestNG;

public class MyBookingLondonScreenshotsNGTest extends BaseStepsTestNG {
    private BookingHomePageXPath bookingHomePage = new BookingHomePageXPath();
    private BookingSearchResultsPageXPath bookingSearchResultPage = new BookingSearchResultsPageXPath();

    @Test
    public void checkMyBookingLondonScreenshots() {
        bookingHomePage.navigateToBookingPage();
        bookingHomePage.dismissSignIn();
        bookingHomePage.acceptCookies();
        bookingHomePage.typeCity("London");
        bookingHomePage.submitSearchQuery();
        bookingHomePage.dismissSignIn();
        Assert.assertFalse(bookingSearchResultPage.checkThatScreenshotExists(),
                "There are no screenshot created");
        //But I am not able to check the content of the created screenshot
    }
}