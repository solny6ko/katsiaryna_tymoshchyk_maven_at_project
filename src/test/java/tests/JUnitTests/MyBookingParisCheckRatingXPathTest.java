package tests.JUnitTests;

import org.junit.Test;
import pages.booking.HomePageBookingXPath;
import pages.booking.SearchResultsPageBookingXPath;
import tests.BaseTest;

import static org.testng.AssertJUnit.assertEquals;


public class MyBookingParisCheckRatingXPathTest extends BaseTest {
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
        assertEquals("Score of the first sorted hotel is wrong", "6",
                bookingSearchResultPage.checkFirstElementRatingValue());
    }
}