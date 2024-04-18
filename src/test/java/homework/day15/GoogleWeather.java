package homework.day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.TextStyle;
import java.util.Locale;

public class GoogleWeather {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("погода Минск");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[tesxt()='погода']/b[text()=]' минск']")).click();
        driver.findElement(By.xpath("//div[@id='wop_dp']/div[2]")).click();
        Thread.sleep(2000);

        String tomorrow = LocalDate.now(ZoneId.systemDefault()).plusDays(1)
                .getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("be"));

        WebElement el = driver.findElement(
                By.xpath(String.format("//*[name()='text' and contains(@aria-label, 'Celsius %s 12:00')][2]", tomorrow)));
        System.out.println(el.getAttribute("aria-label"));
        driver.close();
    }
}
