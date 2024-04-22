package tests.JUnitTests;

import org.junit.Assert;
import org.junit.Test;
import pages.booking.HomePageBookingXPath;
import pages.booking.SearchResultsPageBookingXPath;
import tests.BaseStepsJUnit;

public class MyBookingLondonScreenshotsTest extends BaseStepsJUnit {

    private HomePageBookingXPath bookingHomePage = new HomePageBookingXPath();
    private SearchResultsPageBookingXPath bookingSearchResultPage = new SearchResultsPageBookingXPath();

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