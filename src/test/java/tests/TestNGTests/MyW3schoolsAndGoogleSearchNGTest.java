package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.google.SearchResultPageGoogle;
import pages.google.StartPageGoogle;
import pages.w3cschool.JavaTutorialPageW3CSchool;
import tests.BaseStepsTestNG;

public class MyW3schoolsAndGoogleSearchNGTest extends BaseStepsTestNG {
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

        Assert.assertTrue(googleSearchResultsPage.isAllSearchResultsContainProperWord(),
                "Not every search result contains needed word ");
    }
}