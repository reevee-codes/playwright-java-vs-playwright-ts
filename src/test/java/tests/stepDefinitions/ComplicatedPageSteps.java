package tests.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.complicatedPage.ComplicatedPageFunctions;
import pages.complicatedPage.ComplicatedPageState;
import tests.context.TestContext;
import static org.assertj.core.api.Assertions.assertThat;

public class ComplicatedPageSteps {
    private final ComplicatedPageFunctions complicatedPageFunctions;
    private final ComplicatedPageState complicatedPageState;

    public ComplicatedPageSteps(TestContext testContext) {
        this.complicatedPageFunctions = new ComplicatedPageFunctions(testContext.getPage());
        this.complicatedPageState = new ComplicatedPageState(testContext.getPage());
    }

    @Given("I open the Complicated Page")
    public void i_open_the_complicated_page() {
        complicatedPageFunctions.navigate();
    }

    @When("I hover over the first button")
    public void i_hover_over_the_first_button() {
        complicatedPageFunctions.hoverOverFirstButton();
    }

    @Then("I see the button change color")
    public void i_see_the_button_change_color() {
        assertThat(complicatedPageState.checkIfColorOfButtonChanged())
                .withFailMessage("Title on first top deals element is not displayed")
                .isTrue();
    }
}
