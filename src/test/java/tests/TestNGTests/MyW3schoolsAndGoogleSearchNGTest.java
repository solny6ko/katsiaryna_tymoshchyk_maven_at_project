package tests.TestNGTests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.google.GoogleSearchResultPage;
import pages.google.GoogleStartPage;
import pages.w3cschool.W3CSchoolJavaTutorialPage;
import tests.BaseStepsTestNG;

public class MyW3schoolsAndGoogleSearchNGTest extends BaseStepsTestNG {
    private W3CSchoolJavaTutorialPage javaTutorialW3CSchoolPage = new W3CSchoolJavaTutorialPage();
    private GoogleStartPage googleStartPage = new GoogleStartPage();
    private GoogleSearchResultPage googleSearchResultsPage = new GoogleSearchResultPage();

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