package tests.JUnitTests;

import org.junit.Test;
import pages.booking.HomePageBookingCss;
import pages.booking.HomePageBookingXPath;
import pages.booking.SearchResultsPageBookingCss;
import pages.booking.SearchResultsPageBookingXPath;
import tests.BaseTest;

import static org.testng.AssertJUnit.assertEquals;


public class MyBookingParisCheckRatingCssTest extends BaseTest {
    private HomePageBookingCss bookingHomePageCss;
    private SearchResultsPageBookingCss bookingSearchResultPageCss;

    @Test
    public void myBookingParisCheckRatingCss() {

        bookingHomePageCss.navigateToBookingPage();
        bookingHomePageCss.dismissSignIn();
        bookingHomePageCss.acceptCookies();
        bookingHomePageCss.typeCity("Paris");
        bookingHomePageCss.chooseParisAutocomplete();
        bookingHomePageCss.fillInDaysForStay(3, 10);
        bookingHomePageCss.addAdult();
        bookingHomePageCss.addAdult();
        bookingHomePageCss.addRoom();
        bookingHomePageCss.dismissSignIn();
        bookingHomePageCss.submitSearchQuery();
        bookingHomePageCss.dismissSignIn();
        bookingSearchResultPageCss.waitForBudgetHeaderXpath();
        bookingSearchResultPageCss.choose6plusRating();
        bookingSearchResultPageCss.waitForPropertyReviewScore6PlusBTN();
        bookingSearchResultPageCss.openSortResultsDropDown();
        bookingSearchResultPageCss.chooseRatingLowToHighResultsSorting();
        assertEquals("Score of the first sorted hotel is wrong", "6",
                bookingSearchResultPageCss.checkFirstElementRatingValue());
    }
}
