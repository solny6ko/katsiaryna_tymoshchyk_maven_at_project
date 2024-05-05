package tests.JUnitTests;

import org.junit.Test;
import pages.booking.BookingHomePageXPath;
import pages.booking.BookingSignInPageXPath;

import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;

public class MyBookingNextTripListXPathTest {

    private BookingHomePageXPath bookingHomePage = new BookingHomePageXPath();
    private BookingSignInPageXPath bookingSignInPage = new BookingSignInPageXPath();

    @Test
    public void checkNextTripListTest() throws IOException {
        bookingHomePage.navigateToBookingPage();
        bookingHomePage.dismissSignIn();
        bookingHomePage.acceptCookies();
        bookingHomePage.navigateToSignIn();
        bookingSignInPage.bookingSignIn();
        bookingHomePage.typeCity("Madrid");
        bookingHomePage.chooseAutocompleteCity();
        bookingHomePage.fillInDaysForStayMonthsFromNow(1,5);
        bookingHomePage.submitSearchQuery();

//        assertEquals("Alt text on Select your currency button is wrong, ",
//                "Select your currency", bookingHomePage.checkCurrencyPicker());
    }
}
