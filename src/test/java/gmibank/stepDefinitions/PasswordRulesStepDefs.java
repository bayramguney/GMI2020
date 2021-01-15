package gmibank.stepDefinitions;

import gmibank.pages.RegistrationPage;
import gmibank.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class PasswordRulesStepDefs {

    RegistrationPage registrationPage = new RegistrationPage();

    @When("user types a {string} {string} and press TAB")
    public void user_types_a_and_press_TAB(String textBox, String value) {
        registrationPage.typeValueInsideASpecifiedTextBox(textBox, value);
    }


    @Then("verify that a message is displayed such as {string}")
    public void verify_that_a_message_is_displayed_such_as(String expectedMessage) {
        String actualErrorMessage = registrationPage.getMessage(registrationPage.newPasswordErrorMessage);
        Assert.assertEquals(expectedMessage, actualErrorMessage);
    }

    @Then("verify that no message is displayed")
    public void verify_that_no_message_is_displayed() {
        Assert.assertFalse(registrationPage.isThereAnyError());
    }


    @Then("verify that {int} led is lighting")
    public void verify_that_led_is_lighting(int expectedNumber) {
        int actualNumber = registrationPage.getNumberOfLightingLedsForPasswordStrength();
        Assert.assertEquals(expectedNumber, actualNumber);
    }


    @When("Type all valid information into following textboxes with values in the registration page")
    public void type_all_valid_information_into_following_textboxes_with_values_in_the_registration_page(Map<String, String> dataMap) {
        for (String textBoxName : dataMap.keySet()) {
            registrationPage.typeValueInsideASpecifiedTextBox(textBoxName, dataMap.get(textBoxName));
        }

    }

    @When("click to register in the registration page")
    public void click_to_register_in_the_registration_page() {
        registrationPage.clickRegisterButton();
        BrowserUtils.waitFor(3);
    }

    @Then("verify that new user is not registered")
    public void verify_that_new_user_is_not_registered() throws Exception {
        String resultMessage = registrationPage.getTextOfRegistrationResult();
        //System.out.println("resultMessage = " + resultMessage);
        Assert.assertNotEquals("Registration saved!", resultMessage);
    }

}
