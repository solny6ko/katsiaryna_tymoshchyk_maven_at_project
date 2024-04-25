package pages.booking;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import utils.ExplicitElementWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;

public class BookingHomePageXPath {

    public static final String DISMISS_SIGN_IN_INFO_XPATH = "//button[@aria-label='Dismiss sign-in info.']";
    public static final String ACCEPT_COOKIES_BTN_XPATH = "//button[@id='onetrust-accept-btn-handler']";
    public static final String CITY_INPUT_FIELD_XPATH = "//input[@name='ss']";
    public static final String AUTOCOMPLETE_CITY_XPATH = "(//span[@data-testid='autocomplete-icon-default'])[1]";
    public static final String AUTOCOMPLETE_CITY_PARIS_XPATH = "//div[text()='Ile de France, France']";
    public static final String SUBMIT_SEARCH_REQUEST_XPATH = "//button[@type='submit']";

    WebDriver driver = Driver.getWebDriver();

    public void navigateToBookingPage() {
        driver.get("https://booking.com");
    }

    public void acceptCookies() {
        ExplicitElementWait.waitForElementXPath(driver, ACCEPT_COOKIES_BTN_XPATH);
        driver.findElement(By.xpath(ACCEPT_COOKIES_BTN_XPATH)).click();
    }

    public void dismissSignIn() {
        try {
            driver.findElement(By.xpath(DISMISS_SIGN_IN_INFO_XPATH)).click();
        } catch (
                NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void typeCity(String cityName) {
        driver.findElement(By.xpath(CITY_INPUT_FIELD_XPATH)).click();
        driver.findElement(By.xpath(CITY_INPUT_FIELD_XPATH)).sendKeys(cityName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void chooseAutocompleteCity() {
        driver.findElement(By.xpath(AUTOCOMPLETE_CITY_XPATH)).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void fillInDaysForStay(int daysToAddToCHeckIn, int daysToAddToCHeckOut) {
        int checkInDay = LocalDate.now().plusDays(daysToAddToCHeckIn).getDayOfMonth();
        int checkOutDay = LocalDate.now().plusDays(daysToAddToCHeckOut).getDayOfMonth();
        String pathToDay = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
        driver.findElement(By.xpath(String.format(pathToDay, checkInDay))).click();
        driver.findElement(By.xpath(String.format(pathToDay, checkOutDay))).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void openStayParameters() {
        driver.findElement(By.xpath("//span[@data-testid='occupancy-config-icon']")).click();
    }

    public void addAdult(int adultsQuantity) {
        if (adultsQuantity == 1) {
            WebElement adultsMinus = driver.findElement(By.xpath("//label[@for='group_adults']/../following-sibling::div/button[1]"));
            adultsMinus.click();
            ;
        } else {
            WebElement adultsPlus = driver.findElement(By.xpath("//label[@for='group_adults']/../following-sibling::div/button[2]"));
            for (int i = 1; i <= (adultsQuantity - 2); i++) {
                adultsPlus.click();
            }
        }
    }

    public void addRoom(int roomsQuantity) {
        WebElement rooms = driver.findElement(By.xpath("//label[@for='no_rooms']/../following-sibling::div/button[2]"));
        for (int i = 1; i <= (roomsQuantity - 1); i++) {
            rooms.click();
            i++;
        }
    }

    public void submitSearchQuery() {
        driver.findElement(By.xpath(SUBMIT_SEARCH_REQUEST_XPATH)).click();
    }

    public String checkCurrencyPicker() {
        WebElement currencyBtn = driver.findElement(By.xpath("//button[@data-testid='header-currency-picker-trigger']/span"));
        Actions checkAltTextCurrency = new Actions(driver);
        checkAltTextCurrency.moveToElement(currencyBtn);
        checkAltTextCurrency.perform();
        return currencyBtn.findElement(By.xpath("//div[text()='Select your currency']")).getText();
    }

    public String checkLanguagePicker() {
        WebElement languageBtn = driver.findElement(By.xpath("//button[@data-testid='header-language-picker-trigger']/span"));
        Actions checkAltTextLanguage = new Actions(driver);
        checkAltTextLanguage.moveToElement(languageBtn);
        checkAltTextLanguage.perform();
        return languageBtn.findElement(By.xpath("//div[text()='Select your language']")).getText();
    }

}
