package tests.JUnitTests;

import org.junit.Assert;
import org.junit.Test;
import pages.google.GoogleSearchResultPage;
import pages.google.GoogleStartPage;
import pages.w3cschool.W3CSchoolJavaTutorialPage;
import tests.BaseStepsJUnit;

public class MyW3schoolsAndGoogleSearchTest extends BaseStepsJUnit {
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

        Assert.assertTrue("Not every search result contains needed word ",
                googleSearchResultsPage.isAllSearchResultsContainProperWord());
    }
}