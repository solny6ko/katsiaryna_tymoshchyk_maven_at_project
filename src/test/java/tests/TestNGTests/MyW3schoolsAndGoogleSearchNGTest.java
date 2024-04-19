package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.google.SearchResultPageGoogle;
import pages.google.StartPageGoogle;
import pages.w3cschool.JavaTutorialPageW3CSchool;

public class MyW3schoolsAndGoogleSearchNGTest {
    private JavaTutorialPageW3CSchool javaTutorialW3CSchoolPage;
    private StartPageGoogle googleStartPage;
    private SearchResultPageGoogle googleSearchResultsPage;

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