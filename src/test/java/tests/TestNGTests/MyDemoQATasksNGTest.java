package tests.TestNGTests;


import org.testng.Assert;
import org.testng.annotations.*;
import pages.demoqa.DemoQASelectPage;
import tests.BaseStepsTestNG;

public class MyDemoQATasksNGTest extends BaseStepsTestNG {
    private DemoQASelectPage demoQASelectPage = new DemoQASelectPage();

    @Test
    public void demoQATasksSelectValue() {
        demoQASelectPage.navigateToDemoQAPage();
        demoQASelectPage.selectSelectValue();
        demoQASelectPage.waitForSelectValue();
        demoQASelectPage.selectSelectValue();
        Assert.assertTrue(demoQASelectPage.checkSelectedValueForSelectValue(),
                "'Group 1, option 2' value is not selected");
    }

    @Test
    public void demoQATasksSelectOne() {
        demoQASelectPage.navigateToDemoQAPage();
        demoQASelectPage.scrollToSelectOne();
        demoQASelectPage.openSelectOneDropDown();
        demoQASelectPage.waitForSelectOneIsOpened();
        demoQASelectPage.selectOptionForSelectOne();
        Assert.assertTrue(demoQASelectPage.checkIfOptionForSelectOneIsDisplayed(),
                "'Mrs.' value is not selected");
    }

    @Test
    public void demoQATasksOldStyleSelectMenu() {
        demoQASelectPage.navigateToDemoQAPage();
        demoQASelectPage.scrollToOldStyleMenu();
        demoQASelectPage.selectOptionForOldStyleMenu();
        Assert.assertTrue(demoQASelectPage.checkIfOptionForOldStyleMenuIsSelected(),
                "Yellow value is not selected");
    }

    @Test
    public void demoQATasksStandardMultiSelect() {
        demoQASelectPage.navigateToDemoQAPage();
        demoQASelectPage.scrollToStandardMultiSelect();
        demoQASelectPage.selectTwoOptionsInStandardMultiSelect();
        Assert.assertTrue(demoQASelectPage.check1OptionInTwoOptionsInStandardMultiSelectIsSelected() &&
                        demoQASelectPage.check2OptionInTwoOptionsInStandardMultiSelectIsSelected(),
                "Saab And Audi cars are not selected simultaniously");
    }

    @Test
    public void demoQATasksMultiselectDropDown() {
        demoQASelectPage.navigateToDemoQAPage();
        demoQASelectPage.scrollToMultiselectDropDown();
        demoQASelectPage.openMultiselectDropdown();
        demoQASelectPage.waitForMultiselectDropDownIsOpened();
        demoQASelectPage.selectValueInMultiselectDropdown();
        demoQASelectPage.closeMultiselectDropDown();
        Assert.assertTrue(demoQASelectPage.checkSelectedValueOfMultiselectDropDown(),
                "Green colour is not selected");
    }
}