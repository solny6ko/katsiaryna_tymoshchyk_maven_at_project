package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.booking.BookingHomePageCss;
import pages.booking.BookingSearchResultsPageCss;
import tests.BaseStepsTestNG;

public class MyBookingParisCheckRatingCssNGTest extends BaseStepsTestNG {
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
        bookingHomePageCss.addAdult(4);
        bookingHomePageCss.addRoom(2);
        bookingHomePageCss.dismissSignIn();
        bookingHomePageCss.submitSearchQuery();
        bookingHomePageCss.dismissSignIn();
        bookingSearchResultPageCss.waitForBudgetHeaderXpath();
        bookingSearchResultPageCss.choose6plusRating();
        bookingSearchResultPageCss.waitForPropertyReviewScore6PlusBTN();
        bookingSearchResultPageCss.openSortResultsDropDown();
        bookingSearchResultPageCss.chooseRatingLowToHighResultsSorting();
        Assert.assertEquals(bookingSearchResultPageCss.checkFirstElementRatingValue(),
                "6",
                "Score of the first sorted hotel is wrong");
    }
}
