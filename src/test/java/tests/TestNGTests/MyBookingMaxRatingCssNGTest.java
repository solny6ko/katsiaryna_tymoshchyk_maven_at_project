package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.booking.HomePageBookingCss;
import pages.booking.HotelPageBookingCss;
import pages.booking.SearchResultsPageBookingCss;
import tests.BaseTest;
import utils.WindowsHandleUtility;


public class MyBookingMaxRatingCssNGTest extends BaseTest {
    private HomePageBookingCss bookingHomePageCss;
    private SearchResultsPageBookingCss bookingSearchResultPageCss;
    private HotelPageBookingCss bookingHotelPageCss;

    @Test
    public void checkBookingMaxRatingCss() {

        bookingHomePageCss.navigateToBookingPage();
        String originalWindow = driver.getWindowHandle();
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
        WindowsHandleUtility.switchToNewOpenedWindow(driver, originalWindow);
        bookingHotelPageCss.waitForPropertyRatingStarsXpath();
        Assert.assertEquals(bookingHotelPageCss.calculateRatingStars(),
                "5",
                "Rating is wrong ");
    }
}