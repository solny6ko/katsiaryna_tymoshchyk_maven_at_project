package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.booking.HomePageBookingXPath;
import pages.booking.SearchResultsPageBookingXPath;
import tests.BaseTest;

public class MyBookingLondonScreenshotsNGTest extends BaseTest {
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
        Assert.assertFalse(bookingSearchResultPage.checkThatScreenshotExists(),
                "There are no screenshot created");
        //But I am not able to check the content of the created screenshot
    }
}