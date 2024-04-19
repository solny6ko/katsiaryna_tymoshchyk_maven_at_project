package runners;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.JUnitTests.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({MyBookingHoverCheckTest.class,
        MyBookingLondonScreenshotsTest.class,
        MyBookingParisCheckRatingXPathTest.class,
        MyBookingParisCheckRatingCssTest.class,
        MyBookingMaxRatingXPathTest.class,
        MyBookingMaxRatingCssTest.class})
public class BookingJUnitRunner {


}