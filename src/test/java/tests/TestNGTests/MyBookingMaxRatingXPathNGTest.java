package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.booking.HomePageBookingXPath;
import pages.booking.HotelPageBookingXPath;
import pages.booking.SearchResultsPageBookingXPath;
import tests.BaseStepsJUnit;
import tests.BaseStepsTestNG;
import utils.WindowsHandleUtility;


public class MyBookingMaxRatingXPathNGTest extends BaseStepsTestNG {
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
        Assert.assertEquals(bookingHotelPage.calculateRatingStars(), "5",
                "Rating is wrong");
    }
}