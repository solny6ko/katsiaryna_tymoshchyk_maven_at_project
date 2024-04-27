package pages.booking;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ExplicitElementWait;

import java.time.LocalDate;
import java.util.Arrays;

public class BookingHomePageCss {


    public static final String DISMISS_SIGN_IN_INFO_CSS = "button[aria-label='Dismiss sign-in info.'] > span > span";
    public static final String ACCEPT_COOKIES_BTN_CSS = "#onetrust-accept-btn-handler";
    public static final String CITY_INPUT_FIELD_CSS = "input[name='ss']";
    public static final String AUTOCOMPLETE_CITY_PRAGUE_CSS = "#autocomplete-result-0 > div > div > div > :first-of-type";
    public static final String AUTOCOMPLETE_CITY_PARIS_CSS = "#autocomplete-result-0 > div > div > div > :first-of-type";
    public static final String SUBMIT_SEARCH_REQUEST_CSS = "button[type='submit']";

    public void navigateToBookingPage() {
        Driver.getWebDriver().get("https://booking.com");
    }

    public void acceptCookies() {
        ExplicitElementWait.waitForElementXCss(Driver.getWebDriver(), ACCEPT_COOKIES_BTN_CSS);
        Driver.getWebDriver().findElement(By.cssSelector(ACCEPT_COOKIES_BTN_CSS)).click();
    }

    public void dismissSignIn() {
        try {
            Driver.getWebDriver().findElement(By.cssSelector(DISMISS_SIGN_IN_INFO_CSS)).click();
        } catch (
                NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void typeCity(String cityName) {
        Driver.getWebDriver().findElement(By.cssSelector(CITY_INPUT_FIELD_CSS)).sendKeys(cityName);
    }

    public void choosePragueAutocomplete() {
        Driver.getWebDriver().findElement(By.cssSelector(AUTOCOMPLETE_CITY_PRAGUE_CSS)).click();
    }

    public void chooseParisAutocomplete() {
        Driver.getWebDriver().findElement(By.cssSelector(AUTOCOMPLETE_CITY_PARIS_CSS)).click();
    }

    public void fillInDaysForStay(int daysToAddToCHeckIn, int daysToAddToCHeckOut) {
        int checkInDay = LocalDate.now().plusDays(daysToAddToCHeckIn).getDayOfMonth();
        int checkOutDay = LocalDate.now().plusDays(daysToAddToCHeckIn).getDayOfMonth();
        String pathToDay = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
        Driver.getWebDriver().findElement(By.xpath(String.format(pathToDay, checkInDay))).click();
        Driver.getWebDriver().findElement(By.xpath(String.format(pathToDay, checkOutDay))).click();
    }


    public void openStayParameters() {
        Driver.getWebDriver().findElement(By.cssSelector("button[data-testid='occupancy-config']")).click();
    }
    public void addAdult(int adultsQuantity) {
        if (adultsQuantity == 1){
            WebElement adultsMinus = Driver.getWebDriver().findElement(By.cssSelector("div[data-testid='occupancy-popup'] > div > div > div > button > span"));
            adultsMinus.click();;
        } else {
            WebElement adultsPlus = Driver.getWebDriver().findElement(By.cssSelector("div[data-testid='occupancy-popup'] > div > div:first-child > div > button~button > span"));
            for (int i=1; i<=(adultsQuantity-2); i++){
                adultsPlus.click();
            }
        }
    }
    public void addRoom(int roomsQuantity){
        WebElement rooms = Driver.getWebDriver().findElement(By.cssSelector("div[data-testid='occupancy-popup'] > div > div:nth-of-type(3) > div > button~button > span"));
        for (int i=1; i<=(roomsQuantity-1); i++){
            rooms.click();
            i++;
        }
    }

    public void submitSearchQuery() {
        Driver.getWebDriver().findElement(By.cssSelector(SUBMIT_SEARCH_REQUEST_CSS)).click();
    }
}
