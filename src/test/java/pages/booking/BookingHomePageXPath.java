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
    public static final String YOUR_CURRENCY_BTN_TOOLTIP_XPATH = "//div[text()='Select your currency']";

    public void navigateToBookingPage() {
        Driver.getWebDriver().get("https://booking.com");
    }

    public void acceptCookies() {
        ExplicitElementWait.waitForElementXPath(Driver.getWebDriver(), ACCEPT_COOKIES_BTN_XPATH);
        Driver.getWebDriver().findElement(By.xpath(ACCEPT_COOKIES_BTN_XPATH)).click();
    }

    public void dismissSignIn() {
        try {
            Driver.getWebDriver().findElement(By.xpath(DISMISS_SIGN_IN_INFO_XPATH)).click();
        } catch (
                NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void typeCity(String cityName) {
        Driver.getWebDriver().findElement(By.xpath(CITY_INPUT_FIELD_XPATH)).click();
        Driver.getWebDriver().findElement(By.xpath(CITY_INPUT_FIELD_XPATH)).sendKeys(cityName);
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    public void chooseAutocompleteCity() {
        Driver.getWebDriver().findElement(By.xpath(AUTOCOMPLETE_CITY_XPATH)).click();
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void fillInDaysForStay(int daysToAddToCHeckIn, int daysToAddToCHeckOut) {
        int checkInDay = LocalDate.now().plusDays(daysToAddToCHeckIn).getDayOfMonth();
        int checkOutDay = LocalDate.now().plusDays(daysToAddToCHeckOut).getDayOfMonth();
        String pathToDay = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
        Driver.getWebDriver().findElement(By.xpath(String.format(pathToDay, checkInDay))).click();
        Driver.getWebDriver().findElement(By.xpath(String.format(pathToDay, checkOutDay))).click();
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void openStayParameters() {
        Driver.getWebDriver().findElement(By.xpath("//span[@data-testid='occupancy-config-icon']")).click();
    }

    public void addAdult(int adultsQuantity) {
        if (adultsQuantity == 1) {
            WebElement adultsMinus = Driver.getWebDriver().findElement(By.xpath("//label[@for='group_adults']/../following-sibling::div/button[1]"));
            adultsMinus.click();
            ;
        } else {
            WebElement adultsPlus = Driver.getWebDriver().findElement(By.xpath("//label[@for='group_adults']/../following-sibling::div/button[2]"));
            for (int i = 1; i <= (adultsQuantity - 2); i++) {
                adultsPlus.click();
            }
        }
    }

    public void addRoom(int roomsQuantity) {
        WebElement rooms = Driver.getWebDriver().findElement(By.xpath("//label[@for='no_rooms']/../following-sibling::div/button[2]"));
        for (int i = 1; i <= (roomsQuantity - 1); i++) {
            rooms.click();
            i++;
        }
    }

    public void submitSearchQuery() {
        Driver.getWebDriver().findElement(By.xpath(SUBMIT_SEARCH_REQUEST_XPATH)).click();
    }

    public String checkCurrencyPicker() {
        WebElement currencyBtn = Driver.getWebDriver().findElement(By.xpath("//button[@data-testid='header-currency-picker-trigger']/span"));
        Actions checkAltTextCurrency = new Actions(Driver.getWebDriver());
        checkAltTextCurrency.moveToElement(currencyBtn);
        checkAltTextCurrency.perform();
        return currencyBtn.findElement(By.xpath(YOUR_CURRENCY_BTN_TOOLTIP_XPATH)).getText();
    }
    public void hoverMouseOnCurrencyBtn(){
        WebElement currencyBtn = Driver.getWebDriver().findElement(By.xpath("//button[@data-testid='header-currency-picker-trigger']/span"));
        Actions checkAltTextCurrency = new Actions(Driver.getWebDriver());
        checkAltTextCurrency.moveToElement(currencyBtn);
        checkAltTextCurrency.perform();
    }

    public boolean checkCheckAltTextCurrency(String AltTextCurrencyValue){
        return Driver.getWebDriver().findElement(By.xpath(YOUR_CURRENCY_BTN_TOOLTIP_XPATH)).getText().equals(AltTextCurrencyValue);
    }

    public String checkLanguagePicker() {
        WebElement languageBtn = Driver.getWebDriver().findElement(By.xpath("//button[@data-testid='header-language-picker-trigger']/span"));
        Actions checkAltTextLanguage = new Actions(Driver.getWebDriver());
        checkAltTextLanguage.moveToElement(languageBtn);
        checkAltTextLanguage.perform();
        return languageBtn.findElement(By.xpath("//div[text()='Select your language']")).getText();
    }

}
