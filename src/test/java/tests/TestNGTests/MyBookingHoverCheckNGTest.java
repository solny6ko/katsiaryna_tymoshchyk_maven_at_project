package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.booking.BookingHomePageXPath;
import pages.booking.BookingSearchResultsPageXPath;
import tests.BaseStepsTestNG;

public class MyBookingHoverCheckNGTest extends BaseStepsTestNG {

    private BookingHomePageXPath bookingHomePage = new BookingHomePageXPath();

    @Test
    public void checkCheckAltTextCurrency() {
        bookingHomePage.navigateToBookingPage();
        bookingHomePage.dismissSignIn();
        bookingHomePage.acceptCookies();
        Assert.assertEquals(bookingHomePage.checkCurrencyPicker(),
                "Select your currency",
                "Alt text on Select your currency button is wrong ");
    }

    @Test
    public void checkCheckAltTextLanguage() {
//        bookingHomePage.navigateToBookingPage();
//        bookingHomePage.dismissSignIn();
//        bookingHomePage.acceptCookies();
        Assert.assertEquals(bookingHomePage.checkLanguagePicker(),
                "Select your language",
                "Alt text on Select your language button is wrong ");
    }
}