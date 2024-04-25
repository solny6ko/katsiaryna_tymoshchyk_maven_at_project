package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.booking.BookingHomePageXPath;
import pages.booking.BookingSearchResultsPageXPath;
import tests.BaseStepsTestNG;


public class MyBookingParisCheckRatingXPathNGTest extends BaseStepsTestNG {
    private BookingHomePageXPath bookingHomePage = new BookingHomePageXPath();
    private BookingSearchResultsPageXPath bookingSearchResultPage = new BookingSearchResultsPageXPath();

    @Test
    public void myBookingParisCheckRatingXPath() {

        bookingHomePage.navigateToBookingPage();
        bookingHomePage.dismissSignIn();
        bookingHomePage.acceptCookies();
        bookingHomePage.typeCity("Paris");
        bookingHomePage.chooseAutocompleteCity();
        bookingHomePage.fillInDaysForStay(3, 10);
        bookingHomePage.addAdult(4);
        bookingHomePage.addRoom(2);
        bookingHomePage.dismissSignIn();
        bookingHomePage.submitSearchQuery();
        bookingHomePage.dismissSignIn();
        bookingSearchResultPage.waitForBudgetHeaderXpath();
        bookingSearchResultPage.choose6plusRating();
        bookingSearchResultPage.waitForPropertyReviewScore6PlusBTN();
        bookingSearchResultPage.openSortResultsDropDown();
        bookingSearchResultPage.chooseRatingLowToHighResultsSorting();
        Assert.assertEquals(bookingSearchResultPage.checkFirstElementRatingValue(),
                "6",
                "Score of the first sorted hotel is wrong");
    }
}
