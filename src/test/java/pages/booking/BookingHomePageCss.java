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


    WebDriver driver = Driver.getWebDriver();

    public void navigateToBookingPage() {
        driver.get("https://booking.com");
    }

    public void acceptCookies() {
        ExplicitElementWait.waitForElementXCss(driver, ACCEPT_COOKIES_BTN_CSS);
        driver.findElement(By.cssSelector(ACCEPT_COOKIES_BTN_CSS)).click();
    }

    public void dismissSignIn() {
        try {
            driver.findElement(By.cssSelector(DISMISS_SIGN_IN_INFO_CSS)).click();
        } catch (
                NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void typeCity(String cityName) {
        driver.findElement(By.cssSelector(CITY_INPUT_FIELD_CSS)).sendKeys(cityName);
    }

    public void choosePragueAutocomplete() {
        driver.findElement(By.cssSelector(AUTOCOMPLETE_CITY_PRAGUE_CSS)).click();
    }

    public void chooseParisAutocomplete() {
        driver.findElement(By.cssSelector(AUTOCOMPLETE_CITY_PARIS_CSS)).click();
    }

    public void fillInDaysForStay(int daysToAddToCHeckIn, int daysToAddToCHeckOut) {
        int checkInDay = LocalDate.now().plusDays(daysToAddToCHeckIn).getDayOfMonth();
        int checkOutDay = LocalDate.now().plusDays(daysToAddToCHeckIn).getDayOfMonth();
        String pathToDay = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
        driver.findElement(By.xpath(String.format(pathToDay, checkInDay))).click();
        driver.findElement(By.xpath(String.format(pathToDay, checkOutDay))).click();
    }


    public void openStayParameters() {
        driver.findElement(By.cssSelector("button[data-testid='occupancy-config']")).click();
    }
    public void addAdult() {
        WebElement adults = driver.findElement(By.cssSelector("div[data-testid='occupancy-popup'] > div > div:first-child > div > button~button > span"));
        adults.click();
    }

    public void addRoom() {
        WebElement rooms = driver.findElement(By.cssSelector("div[data-testid='occupancy-popup'] > div > div:nth-of-type(3) > div > button~button > span"));
        rooms.click();
    }

    public void submitSearchQuery() {
        driver.findElement(By.cssSelector(SUBMIT_SEARCH_REQUEST_CSS)).click();
    }
}
