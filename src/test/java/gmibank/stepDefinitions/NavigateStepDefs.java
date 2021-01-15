package gmibank.stepDefinitions;


import gmibank.pages.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class NavigateStepDefs {
    BasePage basePage = new BasePage();
    @When("user navigates to {string} page under account menu icon")
    public void user_navigates_to_page_under_account_menu_icon(String pageName) throws Exception {

        basePage.clickAndSelectDropDownItemUnderAccountMenuIcon(pageName);
        //BrowserUtils.waitFor(1);
    }


    @When("user navigates to {string} page under My Operations menu")
    public void user_navigates_to_page_under_My_Operations_menu(String pageName) throws Exception {
        basePage.clickAndSelectDropDownItemUnderMyOperationsNavItem(pageName);
    }

    @Given("user navigates to {string} page under {string} menu")
    public void user_navigates_to_page_under_menu(String dropDownItem, String navItem) {
        BasePage basePage = new BasePage();
        basePage.clickGivenNavItemAndSelectGivenDropDownItem(navItem, dropDownItem);
    }

}
