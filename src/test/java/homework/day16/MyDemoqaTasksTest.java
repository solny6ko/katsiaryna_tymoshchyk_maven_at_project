package homework.day16;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertThat;

public class MyDemoqaTasksTest {
    private WebDriver driver;

    @Before
    public void before() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void demoqaTasksSelectValue() {
        driver.get("https://demoqa.com/select-menu");
        driver.findElement(By.xpath("//div[@class='mt-2 row'][1]/div/div")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Group 1, option 2']"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//div[text()='Group 1, option 2']")).click();
        Assert.assertTrue("'Group 1, option 2' value is not selected", driver.findElement(By.xpath("//div[text()='Group 1, option 2']")).isDisplayed());
    }

    @Test
    public void demoqaTasksSelectOne() {
        driver.get("https://demoqa.com/select-menu");

        WebElement headerSelectOne = driver.findElement(By.xpath("//div[text()='Select One']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", headerSelectOne);

        driver.findElement(By.xpath("//div[@class='mt-2 row'][2]/div/div")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Mrs.']"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//div[text()='Mrs.']")).click();
        Assert.assertTrue("'Mrs.' value is not selected", driver.findElement(By.xpath("//div[text()='Mrs.']")).isDisplayed());
    }

    @Test
    public void demoqaTasksOldStyleSelectMenu() {
        driver.get("https://demoqa.com/select-menu");

        WebElement headerOldStyleSelectMenu = driver.findElement(By.xpath("//div[text()='Old Style Select Menu']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", headerOldStyleSelectMenu);

        WebElement oldStyleSelectMenu = driver.findElement(By.id("oldSelectMenu"));
        Select select = new Select(oldStyleSelectMenu);
        select.selectByValue("3");
        Assert.assertTrue("Yellow value is not selected", driver.findElement(By.xpath("//option[text()='Yellow']")).isSelected());
    }

    @Test
    public void demoqaTasksStandardMultiSelect() {
        driver.get("https://demoqa.com/select-menu");

        WebElement headerStandardMultiSelect = driver.findElement(By.xpath("//b[text()='Standard multi select']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", headerStandardMultiSelect);

        WebElement standardMultiSelect = driver.findElement(By.id("cars"));
        Select selectStandardMulti = new Select(standardMultiSelect);
        selectStandardMulti.isMultiple();
        selectStandardMulti.selectByValue("saab");
        selectStandardMulti.selectByValue("audi");

        Assert.assertTrue("Saab And Audi cars are not selected simultaniously",
                driver.findElement(By.xpath("//option[text()='Saab']")).isSelected() &&
                        driver.findElement(By.xpath("//option[text()='Audi']")).isSelected());
    }

    @Test
    public void demoqaTasksMultiselectDropDown() {
        driver.get("https://demoqa.com/select-menu");

        WebElement headerMultiselectDropDown = driver.findElement(By.xpath("//b[text()='Multiselect drop down']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", headerMultiselectDropDown);

        driver.findElement(By.xpath("//div[@class='row'][2]/div/div/div")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Blue']"))
        );
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.findElement(By.xpath("//div[text()='Black']")).click();
        driver.findElement(By.xpath("//div[@class='row'][2]/div/div/div")).click();
        Assert.assertTrue("Green colour is not selected",
                driver.findElement(By.xpath("//div[text()='Green']")).isDisplayed());

    }

    @After
    public void cLoseBrowser() {
           driver.close();
    }
}