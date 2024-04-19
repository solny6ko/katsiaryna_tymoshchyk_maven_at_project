package tests.JUnitTests;


import org.junit.Assert;
import org.junit.Test;
import pages.demoqa.SelectPageDemoQA;

public class MyDemoQATasksTest {
    private SelectPageDemoQA demoQASelectPage;

    @Test
    public void demoQATasksSelectValue() {
        demoQASelectPage.navigateToDemoQAPage();
        demoQASelectPage.selectSelectValue();
        demoQASelectPage.waitForSelectValue();
        demoQASelectPage.selectSelectValue();
        Assert.assertTrue("'Group 1, option 2' value is not selected",
                demoQASelectPage.checkSelectedValueForSelectValue());
    }

    @Test
    public void demoQATasksSelectOne() {
        demoQASelectPage.navigateToDemoQAPage();
        demoQASelectPage.scrollToSelectOne();
        demoQASelectPage.openSelectOneDropDown();
        demoQASelectPage.waitForSelectOneIsOpened();
        demoQASelectPage.selectOptionForSelectOne();
        Assert.assertTrue("'Mrs.' value is not selected",
                demoQASelectPage.checkIfOptionForSelectOneIsDisplayed());
    }

    @Test
    public void demoQATasksOldStyleSelectMenu() {
        demoQASelectPage.navigateToDemoQAPage();
        demoQASelectPage.scrollToOldStyleMenu();
        demoQASelectPage.selectOptionForOldStyleMenu();
        Assert.assertTrue("Yellow value is not selected",
                demoQASelectPage.checkIfOptionForOldStyleMenuIsSelected());
    }

    @Test
    public void demoQATasksStandardMultiSelect() {
        demoQASelectPage.navigateToDemoQAPage();
        demoQASelectPage.scrollToStandardMultiSelect();
        demoQASelectPage.selectTwoOptionsInStandardMultiSelect();
        Assert.assertTrue("Saab And Audi cars are not selected simultaniously",
                demoQASelectPage.check1OptionInTwoOptionsInStandardMultiSelectIsSelected() &&
                        demoQASelectPage.check2OptionInTwoOptionsInStandardMultiSelectIsSelected());
    }

    @Test
    public void demoQATasksMultiselectDropDown() {
        demoQASelectPage.navigateToDemoQAPage();
        demoQASelectPage.scrollToMultiselectDropDown();
        demoQASelectPage.openMultiselectDropdown();
        demoQASelectPage.waitForMultiselectDropDownIsOpened();
        demoQASelectPage.selectValueInMultiselectDropdown();
        demoQASelectPage.closeMultiselectDropDown();
        Assert.assertTrue("Green colour is not selected",
                demoQASelectPage.checkSelectedValueOfMultiselectDropDown());
    }
}