package steps;
import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import pages.booking.BookingHomePageXPath;

public class BookingBddSteps {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(BookingBddSteps.class);
    private BookingHomePageXPath bookingHomePage = new BookingHomePageXPath();

    @Given("I open booking homepage")
    public void openSite(){
        bookingHomePage.navigateToBookingPage();
        LOGGER.info("Open Booking Home Page");
    }

    @And("I dismiss sign in")
    public void dismissSignIn(){
        bookingHomePage.dismissSignIn();
        LOGGER.info("Sign in is dismissed");
    }

    @And("I accept cookies")
    public void acceptCookies(){
        bookingHomePage.acceptCookies();
        LOGGER.info("Cookies are accepted");
    }

    @When("I hover mouse on currency button")
    public void hoverMouseOnCurrencyBtn(){
        bookingHomePage.hoverMouseOnCurrencyBtn();
        LOGGER.info("I hovered over Currency Button");
    }

    @Then("I see currency tooltip message {string} of currency button")
    public void checkCheckAltTextCurrency(String AltTextCurrencyValue){
        bookingHomePage.checkCheckAltTextCurrency("Select your currency");
        LOGGER.info("Tooltip is 'Select your currency'");

    }


}
