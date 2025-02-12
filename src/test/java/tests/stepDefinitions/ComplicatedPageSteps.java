package tests.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.complicatedPage.ComplicatedPageFunctions;
import tests.BaseTest;

public class ComplicatedPageSteps extends BaseTest {
    private ComplicatedPageFunctions complicatedPageFunctions;

    @Given("I open the Complicated Page")
    public void i_open_the_complicated_page() {
        if (page == null) {
            setup();
        }
        complicatedPageFunctions = new ComplicatedPageFunctions(page);
        complicatedPageFunctions.navigate();
    }

    @When("I click on the first button")
    public void i_click_on_the_first_button() {
        complicatedPageFunctions.clickOnFirstButton();
    }

    @Then("I see the button change color")
    public void i_should_see_the_button_change_color() {
      //todo
    }
}
