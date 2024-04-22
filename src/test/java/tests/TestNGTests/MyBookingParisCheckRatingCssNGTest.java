package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.booking.HomePageBookingCss;
import pages.booking.SearchResultsPageBookingCss;
import tests.BaseStepsJUnit;
import tests.BaseStepsTestNG;

public class MyBookingParisCheckRatingCssNGTest extends BaseStepsTestNG {
    private HomePageBookingCss bookingHomePageCss = new HomePageBookingCss();
    private SearchResultsPageBookingCss bookingSearchResultPageCss = new SearchResultsPageBookingCss();

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
        Assert.assertEquals(bookingSearchResultPageCss.checkFirstElementRatingValue(),
                "6",
                "Score of the first sorted hotel is wrong");
    }
}
