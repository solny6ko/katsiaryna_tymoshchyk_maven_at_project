package tests.JUnitTests;

import org.junit.Test;
import pages.booking.*;
import tests.BaseStepsJUnit;
import utils.WindowsHandleUtility;

import static org.testng.AssertJUnit.assertEquals;

public class MyBookingMaxRatingCssTest extends BaseStepsJUnit {
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
        assertEquals("Rating is wrong, ",
                "5",
                bookingHotelPageCss.calculateRatingStars());
    }
}