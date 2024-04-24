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
    WebDriver driver = Driver.getWebDriver();

    public void navigateToDemoQAPage() {
        driver.get("https://demoqa.com/select-menu");
    }

    public void selectSelectValue(){
        driver.findElement(By.xpath("//div[@class='mt-2 row'][1]/div/div")).click();
    }

    public boolean checkSelectedValueForSelectValue(){
        return driver.findElement(By.xpath("//div[text()='Group 1, option 2']")).isDisplayed();
    }

    public void selectOptionInSelectValue(){
        driver.findElement(By.xpath("//div[text()='Group 1, option 2']")).click();
    }

    public void scrollToSelectOne(){
        WebElement headerSelectOne = driver.findElement(By.xpath("//div[text()='Select One']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", headerSelectOne);
    }

    public void openSelectOneDropDown(){
        driver.findElement(By.xpath("//div[@class='mt-2 row'][2]/div/div")).click();
    }

    public void selectOptionForSelectOne(){
        driver.findElement(By.xpath("//div[text()='Mrs.']")).click();
    }

    public boolean checkIfOptionForSelectOneIsDisplayed(){
       return driver.findElement(By.xpath("//div[text()='Mrs.']")).isDisplayed();
    }

    public void scrollToOldStyleMenu(){
        WebElement headerOldStyleSelectMenu = driver.findElement(By.xpath("//div[text()='Old Style Select Menu']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", headerOldStyleSelectMenu);
    }

    public void selectOptionForOldStyleMenu(){
        WebElement oldStyleSelectMenu = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(oldStyleSelectMenu);
        select.selectByValue("3");
    }

    public boolean checkIfOptionForOldStyleMenuIsSelected(){
        return driver.findElement(By.xpath("//option[text()='Yellow']")).isSelected();
    }

    public void scrollToStandardMultiSelect(){
        WebElement headerStandardMultiSelect = driver.findElement(By.xpath("//b[text()='Standard multi select']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", headerStandardMultiSelect);
    }

    public void selectTwoOptionsInStandardMultiSelect(){
        WebElement standardMultiSelect = driver.findElement(By.id("cars"));
        Select selectStandardMulti = new Select(standardMultiSelect);
        selectStandardMulti.isMultiple();
        selectStandardMulti.selectByValue("saab");
        selectStandardMulti.selectByValue("audi");
    }

    public boolean check1OptionInTwoOptionsInStandardMultiSelectIsSelected(){
        return driver.findElement(By.xpath("//option[text()='Saab']")).isSelected();
    }

    public boolean check2OptionInTwoOptionsInStandardMultiSelectIsSelected(){
        return driver.findElement(By.xpath("//option[text()='Audi']")).isSelected();
    }

    public void scrollToMultiselectDropDown(){
        WebElement headerMultiselectDropDown = driver.findElement(By.xpath("//b[text()='Multiselect drop down']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", headerMultiselectDropDown);
    }

    public void openMultiselectDropdown(){
        driver.findElement(By.xpath("//div[@class='row'][2]/div/div/div")).click();
    }

    public void selectValueInMultiselectDropdown(){
        driver.findElement(By.xpath("//div[text()='Green']")).click();
    }

    public void closeMultiselectDropDown(){
        driver.findElement(By.xpath("//div[@class='row'][2]/div/div/div")).click();
    }

    public boolean checkSelectedValueOfMultiselectDropDown(){
       return driver.findElement(By.xpath("//div[text()='Green']")).isDisplayed();
    }


    //WAITERS
    public void waitForSelectOneIsOpened(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Mrs.']"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void waitForSelectValue() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Group 1, option 2']"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void waitForMultiselectDropDownIsOpened(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Blue']"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}
