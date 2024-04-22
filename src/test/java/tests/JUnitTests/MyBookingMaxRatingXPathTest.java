package tests.JUnitTests;

import org.junit.Test;
import pages.booking.HomePageBookingXPath;
import pages.booking.HotelPageBookingXPath;
import pages.booking.SearchResultsPageBookingXPath;
import tests.BaseStepsJUnit;
import utils.WindowsHandleUtility;

import static org.testng.AssertJUnit.assertEquals;

public class MyBookingMaxRatingXPathTest extends BaseStepsJUnit {
    private HomePageBookingXPath bookingHomePage = new HomePageBookingXPath();
    private SearchResultsPageBookingXPath bookingSearchResultPage = new SearchResultsPageBookingXPath();
    private HotelPageBookingXPath bookingHotelPage = new HotelPageBookingXPath();

    @Test
    public void checkBookingMaxRatingXPath() {

        bookingHomePage.navigateToBookingPage();
        bookingHomePage.dismissSignIn();
        bookingHomePage.acceptCookies();
        bookingHomePage.typeCity("Prague");
        bookingHomePage.choosePragueAutocomplete();
        bookingHomePage.submitSearchQuery();
        bookingHomePage.dismissSignIn();
        bookingSearchResultPage.waitForPropertyRatingHeaderXpath();
        bookingSearchResultPage.choose5StarsRating();
        bookingSearchResultPage.waitForHeaderOfImplementedFilter5Xpath();
        bookingSearchResultPage.clickOnRating();
        WindowsHandleUtility.switchToNewOpenedWindow();
        bookingHotelPage.waitForPropertyRatingStarsXpath();
        assertEquals("Rating is wrong, ",
                "5",
                bookingHotelPage.calculateRatingStars());
    }
}