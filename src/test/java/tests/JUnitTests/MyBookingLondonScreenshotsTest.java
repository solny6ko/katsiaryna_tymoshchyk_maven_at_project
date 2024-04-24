package tests.JUnitTests;

import org.junit.Assert;
import org.junit.Test;
import pages.booking.BookingHomePageXPath;
import pages.booking.BookingSearchResultsPageXPath;
import tests.BaseStepsJUnit;

public class MyBookingLondonScreenshotsTest extends BaseStepsJUnit {

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
        bookingSearchResultPage.createAndSaveHotelCardScreenshot();
        Assert.assertFalse("There are no screenshot created",
                bookingSearchResultPage.checkThatScreenshotExists());
        //But I am not able to check the content of the created screenshot
    }
}