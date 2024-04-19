package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Day16Driver {

    public static void main(String[] args) throws MalformedURLException {
//        Запускает Вебдрайвер локально
//        WebDriver driver = new ChromeDriver();
//        Запускает Вебдрайвер на удаленном компьютере (конструктор, который принимает на вход два объекта)
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:9515"), new ChromeOptions());
        driver.get("https://selenium.dev");
//        (ChromeDriver)driver.findElement(); - при явном приведении типов будет больше методов
//        у ChromeDriver, чем у driver
    }
}
