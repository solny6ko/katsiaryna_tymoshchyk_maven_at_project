package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.booking.HomePageBookingCss;
import pages.booking.HotelPageBookingCss;
import pages.booking.SearchResultsPageBookingCss;
import tests.BaseStepsJUnit;
import tests.BaseStepsTestNG;
import utils.WindowsHandleUtility;


public class MyBookingMaxRatingCssNGTest extends BaseStepsTestNG {
    private HomePageBookingCss bookingHomePageCss = new HomePageBookingCss();
    private SearchResultsPageBookingCss bookingSearchResultPageCss = new SearchResultsPageBookingCss();
    private HotelPageBookingCss bookingHotelPageCss = new HotelPageBookingCss();

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
        WindowsHandleUtility.switchToNewOpenedWindow();
        bookingHotelPageCss.waitForPropertyRatingStarsXpath();
        Assert.assertEquals(bookingHotelPageCss.calculateRatingStars(),
                "5",
                "Rating is wrong ");
    }
}