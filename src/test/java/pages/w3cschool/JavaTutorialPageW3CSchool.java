package pages.w3cschool;

import driver.DriverInit;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.Arrays;

public class JavaTutorialPageW3CSchool {
    WebDriver driver = DriverInit.getWebDriver();

    public void navigateToJavaTutorialW3CSchoolPage() {
        driver.get("https://www.w3schools.com/java/");
    }

    public void acceptCookiesJavaTutorialW3CSchoolPage(){
        try {
            driver.findElement(By.xpath("//div[@id='accept-choices']")).click();
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void copyTitleWithDoubleClickAndKeyboard(){
        WebElement nameHeader =
                driver.findElement(By.xpath("//span[@class='color_h1']"));
        Actions copyNameHeader = new Actions(driver);
        copyNameHeader
                .doubleClick(nameHeader)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build().perform();
    }
}
