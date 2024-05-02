package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import pages.demoqa.DemoQASelectPage;
import tests.BaseStepsJUnit;
import driver.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DemoQABddSteps extends BaseStepsJUnit {
    private static final Logger LOGGER = (Logger) LogManager.getLogger(BookingBddSteps.class);
    private DemoQASelectPage demoQASelectPage = new DemoQASelectPage();

    @Given("I open DemoQA homepage")
    public void openDemoQA() {
        demoQASelectPage.navigateToDemoQAPage();
        LOGGER.info("Open DEmoQA Home Page");
    }

    @And("I select {string} selector")
    public void selectSelectValue(String selectorName) {
        switch (selectorName) {
            case "Select Value":
                demoQASelectPage.selectSelectValue();
                LOGGER.info("I click to open Select Value selector");
                break;
            case "Select One":
                demoQASelectPage.scrollToSelectOne();
                demoQASelectPage.openSelectOneDropDown();
                LOGGER.info("I click to open Select One selector");
                break;
            case "Old Style Select Menu":
                demoQASelectPage.scrollToOldStyleMenu();
                LOGGER.info("I scroll to Old Style Menu selector");
                break;
            case "Standard Multi Select":
                demoQASelectPage.scrollToStandardMultiSelect();
                LOGGER.info("I scroll to Standard Multi Select");
                break;
            case "Multiselect Drop Down":
                demoQASelectPage.scrollToMultiselectDropDown();
                demoQASelectPage.openMultiselectDropdown();
                LOGGER.info("I click to open Multiselect Drop Down");
                break;
        }
    }

    @When("I choose an option {string} in selector")
    public void chooseOptionSelectValue(String optionToSelect) {
        switch (optionToSelect) {
            case "Group 1, option 2":
                demoQASelectPage.waitForSelectValue();
                demoQASelectPage.selectOptionInSelectValue();
                LOGGER.info("I choose 'Group 1, option 2' option in Select Value selector");
                break;
            case "Mrs.":
                demoQASelectPage.waitForSelectOneIsOpened();
                demoQASelectPage.selectOptionForSelectOne();
                LOGGER.info("I choose 'Mrs.' value Select One selector");
                break;
            case "Yellow":
                demoQASelectPage.selectOptionForOldStyleMenu();
                LOGGER.info("I choose 'Yellow' option in Old Style Menu selector");
                break;
            case "Saab And Audi cars":
                demoQASelectPage.selectTwoOptionsInStandardMultiSelect();
                LOGGER.info("I choose Saab And Audi cars in Standard Multi Select");
                break;
            case "Green":
                demoQASelectPage.waitForMultiselectDropDownIsOpened();
                demoQASelectPage.selectValueInMultiselectDropdown();
                demoQASelectPage.closeMultiselectDropDown();
                LOGGER.info("I Green option in Multiselect Drop Down");
                break;
        }
    }

    @Then("I should see the option {string} is selected")
    public void checkSelectedValue(String optionSelected) {
        switch (optionSelected) {
            case "Group 1, option 2":
                Assert.assertTrue("'Group 1, option 2' value is not selected",
                        demoQASelectPage.checkSelectedValueForSelectValue());
                LOGGER.info("'Group 1, option 2' value is selected");
                break;
            case "Mrs.":
                Assert.assertTrue("'Mrs.' value is not selected",
                        demoQASelectPage.checkIfOptionForSelectOneIsDisplayed());
                LOGGER.info("'Mrs.' value is selected");
                break;
            case "Yellow":
                Assert.assertTrue("Yellow value is not selected",
                        demoQASelectPage.checkIfOptionForOldStyleMenuIsSelected());
                LOGGER.info("Yellow value is selected");
                break;
            case "Saab And Audi cars":
                Assert.assertTrue("Saab And Audi cars are not selected simultaniously",
                        demoQASelectPage.check1OptionInTwoOptionsInStandardMultiSelectIsSelected() &&
                                demoQASelectPage.check2OptionInTwoOptionsInStandardMultiSelectIsSelected());
                LOGGER.info("Saab And Audi cars are selected simultaniously");
                break;
            case "Green":
                Assert.assertTrue("Green colour is not selected",
                        demoQASelectPage.checkSelectedValueOfMultiselectDropDown());
                LOGGER.info("Green colour is selected");
                break;
        }
    }
}