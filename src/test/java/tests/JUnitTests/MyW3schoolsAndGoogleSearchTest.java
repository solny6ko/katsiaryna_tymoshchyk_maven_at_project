package tests.JUnitTests;

import org.junit.Assert;
import org.junit.Test;
import pages.google.SearchResultPageGoogle;
import pages.google.StartPageGoogle;
import pages.w3cschool.JavaTutorialPageW3CSchool;
import tests.BaseStepsJUnit;

public class MyW3schoolsAndGoogleSearchTest extends BaseStepsJUnit {
    private JavaTutorialPageW3CSchool javaTutorialW3CSchoolPage = new JavaTutorialPageW3CSchool();
    private StartPageGoogle googleStartPage = new StartPageGoogle();
    private SearchResultPageGoogle googleSearchResultsPage = new SearchResultPageGoogle();

    @Test
    public void myW3schoolsAndGoogleSearch() {

        javaTutorialW3CSchoolPage.navigateToJavaTutorialW3CSchoolPage();
        javaTutorialW3CSchoolPage.acceptCookiesJavaTutorialW3CSchoolPage();
        javaTutorialW3CSchoolPage.copyTitleWithDoubleClickAndKeyboard();

        googleStartPage.navigateToGoogleHomePage();
        googleStartPage.acceptCookiesGoogleHomePage();
        googleStartPage.inputSearchQueryUsingKeyboard();

        Assert.assertTrue("Not every search result contains needed word ",
                googleSearchResultsPage.isAllSearchResultsContainProperWord());
    }
}