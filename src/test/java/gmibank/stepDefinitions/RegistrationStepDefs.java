package gmibank.stepDefinitions;


import gmibank.pages.RegistrationPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RegistrationStepDefs {
    RegistrationPage registrationPage = new RegistrationPage();

    @Then("Verify that this error message {string} is displayed")
    public void verify_that_this_error_message_is_displayed(String expectedMessage) {
        Assert.assertTrue(registrationPage.doesExistSuchErrorMessageInsidePage(expectedMessage));
        Assert.assertTrue(registrationPage.isThereAnyError());
    }


    @Then("Verify that error message {string} is displayed under {string} textbox")
    public void verify_that_error_message_is_displayed_under_textbox(String expectedMessage, String textBox) {
        String actualMessage = registrationPage.getErrorMessageFromSpecifiedTextBox(textBox);
        System.out.println("actualMessage = " + actualMessage);
        registrationPage.getMessage(registrationPage.mobilePhoneErrorMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Given("user types click and leaves blank {string} textbox")
    public void user_types_click_and_leaves_blank_textbox(String textBox) {
        registrationPage.typeValueInsideASpecifiedTextBox(textBox, "");
    }


    @When("user types required information and click to register button")
    public void user_types_required_information_and_click_to_register_button() {
        registrationPage.registerNewUserWithRandomGeneratedValue();
    }

    @Then("verify that new user is registered by getting such a message {string}")
    public void verify_that_new_user_is_registered_by_getting_such_a_message(String expectedMessage) {
        String actualResultMessage = registrationPage.getTextOfRegistrationResult();
        Assert.assertTrue(actualResultMessage.contains(expectedMessage));
    }


}
