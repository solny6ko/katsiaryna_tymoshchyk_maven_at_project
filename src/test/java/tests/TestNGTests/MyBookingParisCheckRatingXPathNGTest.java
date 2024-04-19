package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.booking.HomePageBookingXPath;
import pages.booking.SearchResultsPageBookingXPath;
import tests.BaseTest;


public class MyBookingParisCheckRatingXPathNGTest extends BaseTest {
    private HomePageBookingXPath bookingHomePage;
    private SearchResultsPageBookingXPath bookingSearchResultPage;

    @Test
    public void myBookingParisCheckRatingXPath() {

        bookingHomePage.navigateToBookingPage();
        bookingHomePage.dismissSignIn();
        bookingHomePage.acceptCookies();
        bookingHomePage.typeCity("Paris");
        bookingHomePage.chooseParisAutocomplete();
        bookingHomePage.fillInDaysForStay(3, 10);
        bookingHomePage.addAdult();
        bookingHomePage.addAdult();
        bookingHomePage.addRoom();
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