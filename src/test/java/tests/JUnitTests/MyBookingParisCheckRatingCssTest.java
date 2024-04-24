package tests.JUnitTests;

import org.junit.Test;
import pages.booking.BookingHomePageCss;
import pages.booking.BookingSearchResultsPageCss;
import tests.BaseStepsJUnit;

import static org.testng.AssertJUnit.assertEquals;


public class MyBookingParisCheckRatingCssTest extends BaseStepsJUnit {
    private BookingHomePageCss bookingHomePageCss = new BookingHomePageCss();
    private BookingSearchResultsPageCss bookingSearchResultPageCss = new BookingSearchResultsPageCss();

    @Test
    public void myBookingParisCheckRatingCss() {

        bookingHomePageCss.navigateToBookingPage();
        bookingHomePageCss.dismissSignIn();
        bookingHomePageCss.acceptCookies();
        bookingHomePageCss.typeCity("Paris");
        bookingHomePageCss.chooseParisAutocomplete();
        bookingHomePageCss.fillInDaysForStay(3, 10);
        bookingHomePageCss.openStayParameters();
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
