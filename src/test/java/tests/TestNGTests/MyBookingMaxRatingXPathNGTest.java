package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.booking.HomePageBookingXPath;
import pages.booking.HotelPageBookingXPath;
import pages.booking.SearchResultsPageBookingXPath;
import tests.BaseTest;
import utils.WindowsHandleUtility;


public class MyBookingMaxRatingXPathNGTest extends BaseTest {
    private HomePageBookingXPath bookingHomePage;
    private SearchResultsPageBookingXPath bookingSearchResultPage;
    private HotelPageBookingXPath bookingHotelPage;

    @Test
    public void checkBookingMaxRatingXPath() {

        bookingHomePage.navigateToBookingPage();
        String originalWindow = driver.getWindowHandle();
        bookingHomePage.dismissSignIn();
        bookingHomePage.acceptCookies();
        bookingHomePage.typeCity("Prague");
        bookingHomePage.choosePragueAutocomplete();
        bookingHomePage.submitSearchQuery();
        bookingHomePage.dismissSignIn();
        bookingSearchResultPage.waitForPropertyRatingHeaderXpath();
        bookingSearchResultPage.choose5StarsRating();
        bookingSearchResultPage.waitForHeaderOfImplementedFilter5Xpath();
        bookingSearchResultPage.clickOnRating();
        WindowsHandleUtility.switchToNewOpenedWindow(driver, originalWindow);
        bookingHotelPage.waitForPropertyRatingStarsXpath();
        Assert.assertEquals(bookingHotelPage.calculateRatingStars(), "5",
                "Rating is wrong");
    }
}