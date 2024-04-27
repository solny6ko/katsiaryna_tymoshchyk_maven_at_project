package pages.demoqa;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQASelectPage {

    public void navigateToDemoQAPage() {
        Driver.getWebDriver().get("https://demoqa.com/select-menu");
    }

    public void selectSelectValue(){
        Driver.getWebDriver().findElement(By.xpath("//div[@class='mt-2 row'][1]/div/div")).click();
    }

    public boolean checkSelectedValueForSelectValue(){
        return Driver.getWebDriver().findElement(By.xpath("//div[text()='Group 1, option 2']")).isDisplayed();
    }

    public void selectOptionInSelectValue(){
        Driver.getWebDriver().findElement(By.xpath("//div[text()='Group 1, option 2']")).click();
    }

    public void scrollToSelectOne(){
        WebElement headerSelectOne = Driver.getWebDriver().findElement(By.xpath("//div[text()='Select One']"));
        ((JavascriptExecutor) Driver.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", headerSelectOne);
    }

    public void openSelectOneDropDown(){
        Driver.getWebDriver().findElement(By.xpath("//div[@class='mt-2 row'][2]/div/div")).click();
    }

    public void selectOptionForSelectOne(){
        Driver.getWebDriver().findElement(By.xpath("//div[text()='Mrs.']")).click();
    }

    public boolean checkIfOptionForSelectOneIsDisplayed(){
       return Driver.getWebDriver().findElement(By.xpath("//div[text()='Mrs.']")).isDisplayed();
    }

    public void scrollToOldStyleMenu(){
        WebElement headerOldStyleSelectMenu = Driver.getWebDriver().findElement(By.xpath("//div[text()='Old Style Select Menu']"));
        ((JavascriptExecutor) Driver.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", headerOldStyleSelectMenu);
    }

    public void selectOptionForOldStyleMenu(){
        WebElement oldStyleSelectMenu = Driver.getWebDriver().findElement(By.id("oldSelectMenu"));
        Select select = new Select(oldStyleSelectMenu);
        select.selectByValue("3");
    }

    public boolean checkIfOptionForOldStyleMenuIsSelected(){
        return Driver.getWebDriver().findElement(By.xpath("//option[text()='Yellow']")).isSelected();
    }

    public void scrollToStandardMultiSelect(){
        WebElement headerStandardMultiSelect = Driver.getWebDriver().findElement(By.xpath("//b[text()='Standard multi select']"));
        ((JavascriptExecutor) Driver.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", headerStandardMultiSelect);
    }

    public void selectTwoOptionsInStandardMultiSelect(){
        WebElement standardMultiSelect = Driver.getWebDriver().findElement(By.id("cars"));
        Select selectStandardMulti = new Select(standardMultiSelect);
        selectStandardMulti.isMultiple();
        selectStandardMulti.selectByValue("saab");
        selectStandardMulti.selectByValue("audi");
    }

    public boolean check1OptionInTwoOptionsInStandardMultiSelectIsSelected(){
        return Driver.getWebDriver().findElement(By.xpath("//option[text()='Saab']")).isSelected();
    }

    public boolean check2OptionInTwoOptionsInStandardMultiSelectIsSelected(){
        return Driver.getWebDriver().findElement(By.xpath("//option[text()='Audi']")).isSelected();
    }

    public void scrollToMultiselectDropDown(){
        WebElement headerMultiselectDropDown = Driver.getWebDriver().findElement(By.xpath("//b[text()='Multiselect drop down']"));
        ((JavascriptExecutor) Driver.getWebDriver()).executeScript("arguments[0].scrollIntoView(true);", headerMultiselectDropDown);
    }

    public void openMultiselectDropdown(){
        Driver.getWebDriver().findElement(By.xpath("//div[@class='row'][2]/div/div/div")).click();
    }

    public void selectValueInMultiselectDropdown(){
        Driver.getWebDriver().findElement(By.xpath("//div[text()='Green']")).click();
    }

    public void closeMultiselectDropDown(){
        Driver.getWebDriver().findElement(By.xpath("//div[@class='row'][2]/div/div/div")).click();
    }

    public boolean checkSelectedValueOfMultiselectDropDown(){
       return Driver.getWebDriver().findElement(By.xpath("//div[text()='Green']")).isDisplayed();
    }


    //WAITERS
    public void waitForSelectOneIsOpened(){
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Mrs.']"))
        );
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void waitForSelectValue() {
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Group 1, option 2']"))
        );
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void waitForMultiselectDropDownIsOpened(){
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(Driver.getWebDriver(), Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Blue']"))
        );
        Driver.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
