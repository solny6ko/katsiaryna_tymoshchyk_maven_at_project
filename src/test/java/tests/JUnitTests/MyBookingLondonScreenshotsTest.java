package tests.JUnitTests;

import org.junit.Assert;
import org.junit.Test;
import pages.booking.HomePageBookingXPath;
import pages.booking.SearchResultsPageBookingXPath;
import tests.BaseTest;

public class MyBookingLondonScreenshotsTest extends BaseTest {
    private HomePageBookingXPath bookingHomePage;
    private SearchResultsPageBookingXPath bookingSearchResultPage;

    @Test
    public void checkMyBookingLondonScreenshots() {
        bookingHomePage.navigateToBookingPage();
        bookingHomePage.dismissSignIn();
        bookingHomePage.acceptCookies();
        bookingHomePage.typeCity("London");
        bookingHomePage.submitSearchQuery();
        bookingHomePage.dismissSignIn();
        Assert.assertFalse("There are no screenshot created",
                bookingSearchResultPage.checkThatScreenshotExists());
        //But I am not able to check the content of the created screenshot
    }
}