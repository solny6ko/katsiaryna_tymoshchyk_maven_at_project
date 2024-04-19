package pages.google;

import driver.DriverInit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPageGoogle {

    WebDriver driver = DriverInit.getWebDriver();

    public boolean isAllSearchResultsContainProperWord() {
        List<WebElement> searchResultsList = driver.findElements(By.xpath("//div/h1[text()='Wyniki wyszukiwania']/../div/div"));
        String wordToFind = "tutorial";

        boolean isResultsContainWord = true;
        for (WebElement result : searchResultsList) {
            String resultText = result.getText().toLowerCase();
            if (!resultText.contains(wordToFind)) {
                isResultsContainWord = false;
                break;
            }
        }
        return isResultsContainWord;
    }
}
