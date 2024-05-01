package steps;
import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import pages.booking.BookingHomePageXPath;
import pages.booking.BookingHotelPageXPath;
import pages.booking.BookingSearchResultsPageXPath;
import tests.BaseStepsJUnit;

import static org.junit.Assert.assertEquals;

public class BookingBddSteps extends BaseStepsJUnit {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(BookingBddSteps.class);
    private BookingHomePageXPath bookingHomePage = new BookingHomePageXPath();
    private BookingSearchResultsPageXPath bookingSearchResultPage = new BookingSearchResultsPageXPath();
    private BookingHotelPageXPath bookingHotelPage = new BookingHotelPageXPath();

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

    @And("I type {string} into city input field")
    public void typeCity(String cityName){
        bookingHomePage.typeCity(cityName);
        LOGGER.info("I typed %s into the input field", cityName);
    }

    @And("I clear input city field")
    public void clearInputDataFromInputCityField(){
        bookingHomePage.clearInputDataFromInputCityField();
    }

    @And("I submit search query")
    public void submitSearchQuery(){
        bookingHomePage.submitSearchQuery();
        LOGGER.info("Submitting Search query");
    }

    @And("I click on calendar to close it")
    public void clickOnCalendar(){
        bookingSearchResultPage.clickOnCalendar();
        LOGGER.info("Click on calendar in order to close it");
    }

    @And("I change background and font color of the hotel card")
    public void changeBackgroundOfHotelCard(){
        bookingSearchResultPage.changeBackgroundOfHotelCard();
        LOGGER.info("Background of hotel card is changed");
    }

    @And("I choose Autocomplete City")
    public void chooseAutocompleteCity(){
        bookingHomePage.chooseAutocompleteCity();
        LOGGER.info("City from autocomplete is chosen");
    }

    @And("I choose 5 stars rating")
    public void choose5StartsRating(){
        bookingSearchResultPage.waitForPropertyRatingHeaderXpath();
        bookingSearchResultPage.choose5StarsRating();
        LOGGER.info("5 Starts rating filter is applied");
    }

    @And("I click on voices rating label")
    public void clickOnRatingLabel(){
        bookingSearchResultPage.waitForHeaderOfImplementedFilter5Xpath();
        bookingSearchResultPage.clickOnRating();
        LOGGER.info("I have clicked on rating");
    }

    @And("I fill in {int} days from now checkin and {int} days from now checkout")
    public void fillInDaysForStay(int daysToAddToCHeckIn, int daysToAddToCHeckOut){
        bookingHomePage.fillInDaysForStay(daysToAddToCHeckIn, daysToAddToCHeckOut);
    }

    @And("I open stay parameters")
    public void openStayParameters(){
        bookingHomePage.openStayParameters();
    }
    @And("I add {int} adults")
    public void addAdult(int adultsQuantity){
        bookingHomePage.addAdult(adultsQuantity);
    }

    @And("I add {int} rooms")
    public void addRoom(int roomsQuantity){
        bookingHomePage.addRoom(roomsQuantity);
    }

    @And("I choose 6+ rating in rating filter")
    public void choose6PlRating(){
        bookingSearchResultPage.waitForBudgetHeaderXpath();
        bookingSearchResultPage.choose6plusRating();
    }

    @And("I open sort results dropdown")
    public void openSortingDropdown(){
        bookingSearchResultPage.waitForPropertyReviewScore6PlusBTN();
        bookingSearchResultPage.openSortResultsDropDown();
    }

    @When("I scroll to the tenth hotel in search results")
    public void scrollToTenthHotel(){
        bookingSearchResultPage.scrollToTenthHotel();
        LOGGER.info("Scrolling to the 10th hotel");
    }
    @When("I hover mouse on currency button")
    public void hoverMouseOnCurrencyBtn(){
        bookingHomePage.hoverMouseOnCurrencyBtn();
        LOGGER.info("I hovered over Currency Button");
    }

    @When("I hover mouse on language button")
    public void hoverMouseOnLanguageBtn(){
        bookingHomePage.hoverMouseOnLanguageBtn();
        LOGGER.info("I hovered over Language Button");
    }

    @When("I choose Rating Low To High sorting option")
    public void chooseRatingLowToHighResultsSorting(){
        bookingSearchResultPage.chooseRatingLowToHighResultsSorting();
    }

    @Then("I see language tooltip message {string} of language button")
    public void checkCheckAltTextLanguage(String AltTextLanguageValue){
        bookingHomePage.checkCheckAltTextLanguage("Select your language");
        LOGGER.info("Tooltip is 'Select your language'");

    }

    @Then("I see currency tooltip message {string} of currency button")
    public void checkCheckAltTextCurrency(String AltTextCurrencyValue){
        bookingHomePage.checkCheckAltTextCurrency("Select your currency");
        LOGGER.info("Tooltip is 'Select your currency'");

    }

    @Then("I can make a screenshot of hotel card")
    public void makeScreenshotOfHotelCard(){
        bookingSearchResultPage.makeScreenshotOfHotelCard();
        LOGGER.info("Screenshot is created");
    }

    @Then("I see 5 stars on opened property")
    public void checkRatingIsCorrect(){
        Driver.switchToNewOpenedWindow();
        bookingHotelPage.waitForPropertyRatingStarsXpath();
        assertEquals("Rating is wrong, ",
                "5",
                bookingHotelPage.calculateRatingStars());
    }

    @Then("I see first hotel with 6 rating")
    public void checkFirstElementRatingValueIsRight(){
        assertEquals("Score of the first sorted hotel is wrong", "6",
                bookingSearchResultPage.checkFirstElementRatingValue());

    }

}
