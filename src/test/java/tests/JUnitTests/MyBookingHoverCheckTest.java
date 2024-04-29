package tests.JUnitTests;

import org.junit.Test;
import pages.booking.BookingHomePageXPath;
import pages.booking.BookingSearchResultsPageXPath;
import tests.BaseStepsJUnit;

import static org.testng.AssertJUnit.assertEquals;

public class MyBookingHoverCheckTest extends BaseStepsJUnit {

    private BookingHomePageXPath bookingHomePage = new BookingHomePageXPath();

    @Test
    public void checkCheckAltTextCurrency() {
        bookingHomePage.navigateToBookingPage();
        bookingHomePage.dismissSignIn();
        bookingHomePage.acceptCookies();
        assertEquals("Alt text on Select your currency button is wrong, ",
                "Select your currency", bookingHomePage.checkCurrencyPicker());
    }

    @Test
    public void checkCheckAltTextLanguage() {
        bookingHomePage.navigateToBookingPage();
        bookingHomePage.dismissSignIn();
//        bookingHomePage.acceptCookies();
        assertEquals("Alt text on Select your language button is wrong, ",
                "Select your language", bookingHomePage.checkLanguagePicker());
    }
}