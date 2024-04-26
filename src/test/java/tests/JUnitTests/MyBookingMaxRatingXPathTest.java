package tests.JUnitTests;

import driver.Driver;
import org.junit.Test;
import pages.booking.BookingHomePageXPath;
import pages.booking.BookingHotelPageXPath;
import pages.booking.BookingSearchResultsPageXPath;
import tests.BaseStepsJUnit;

import static org.testng.AssertJUnit.assertEquals;

public class MyBookingMaxRatingXPathTest extends BaseStepsJUnit {
    private BookingHomePageXPath bookingHomePage = new BookingHomePageXPath();
    private BookingSearchResultsPageXPath bookingSearchResultPage = new BookingSearchResultsPageXPath();
    private BookingHotelPageXPath bookingHotelPage = new BookingHotelPageXPath();

    @Test
    public void checkBookingMaxRatingXPath() {

        bookingHomePage.navigateToBookingPage();
        bookingHomePage.dismissSignIn();
        bookingHomePage.acceptCookies();
        bookingHomePage.typeCity("Prague");
        bookingHomePage.chooseAutocompleteCity();
        bookingHomePage.submitSearchQuery();
        bookingHomePage.dismissSignIn();
        bookingSearchResultPage.waitForPropertyRatingHeaderXpath();
        bookingSearchResultPage.choose5StarsRating();
        bookingSearchResultPage.waitForHeaderOfImplementedFilter5Xpath();
        bookingSearchResultPage.clickOnRating();
        Driver.switchToNewOpenedWindow();
        bookingHotelPage.waitForPropertyRatingStarsXpath();
        assertEquals("Rating is wrong, ",
                "5",
                bookingHotelPage.calculateRatingStars());
    }
}