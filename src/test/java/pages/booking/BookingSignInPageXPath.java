package pages.booking;

import data.BookingUser;
import driver.Driver;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ObjectMapper;
import org.openqa.selenium.By;
import utils.ExplicitElementWait;

import java.io.File;
import java.io.IOException;

public class BookingSignInPageXPath {

    public static final String PASSWORD_INPUT_FIELD_XPATH = "//input[@type='password']";

    public void bookingSignIn() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        BookingUser userToLogIn = objectMapper
                    .readValue(new File("src/test/java/data/booking.json"), BookingUser.class);
        String login = userToLogIn.getUser_login();
        String password = userToLogIn.getUser_password();
        Driver.getWebDriver().findElement(By.xpath("//input[@type='email']")).sendKeys(login);
        Driver.getWebDriver().findElement(By.xpath("//button[@type='submit']")).click();
        ExplicitElementWait.waitForElementXPath(Driver.getWebDriver(), PASSWORD_INPUT_FIELD_XPATH);
//        Driver.getWebDriver().switchTo().frame(1);
        Driver.getWebDriver().findElement(By.xpath(PASSWORD_INPUT_FIELD_XPATH)).sendKeys(password);
        Driver.getWebDriver().findElement(By.xpath("//button[@type='submit']")).click();
    }
}
