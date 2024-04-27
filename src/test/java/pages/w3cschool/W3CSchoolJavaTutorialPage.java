package pages.w3cschool;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;

public class W3CSchoolJavaTutorialPage {

    public void navigateToJavaTutorialW3CSchoolPage() {
        Driver.getWebDriver().get("https://www.w3schools.com/java/");
    }

    public void acceptCookiesJavaTutorialW3CSchoolPage(){
        try {
            Driver.getWebDriver().findElement(By.xpath("//div[@id='accept-choices']")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void copyTitleWithDoubleClickAndKeyboard(){
        WebElement nameHeader =
                Driver.getWebDriver().findElement(By.xpath("//span[@class='color_h1']"));
        Actions copyNameHeader = new Actions(Driver.getWebDriver());
        copyNameHeader
                .doubleClick(nameHeader)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build().perform();
    }
}
