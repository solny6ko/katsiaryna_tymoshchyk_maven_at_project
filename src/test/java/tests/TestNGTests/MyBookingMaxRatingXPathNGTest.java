package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.booking.BookingHomePageXPath;
import pages.booking.BookingHotelPageXPath;
import pages.booking.BookingSearchResultsPageXPath;
import tests.BaseStepsTestNG;
import utils.WindowsHandleUtility;


public class MyBookingMaxRatingXPathNGTest extends BaseStepsTestNG {
    private BookingHomePageXPath bookingHomePage = new BookingHomePageXPath();
    private BookingSearchResultsPageXPath bookingSearchResultPage = new BookingSearchResultsPageXPath();
    private BookingHotelPageXPath bookingHotelPage = new BookingHotelPageXPath();

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
        Assert.assertEquals(bookingHotelPage.calculateRatingStars(), "5",
                "Rating is wrong");
    }
}