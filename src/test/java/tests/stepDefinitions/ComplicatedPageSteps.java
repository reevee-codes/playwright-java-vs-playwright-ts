package tests.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.complicatedPage.ComplicatedPageFunctions;
import pages.complicatedPage.ComplicatedPageState;
import tests.context.TestContext;
import org.junit.Assert;

public class ComplicatedPageSteps {
    private final ComplicatedPageFunctions complicatedPageFunctions;
    private final ComplicatedPageState complicatedPageState;
    private final TestContext testContext;

    public ComplicatedPageSteps(TestContext testContext) {
        this.testContext = testContext;
        this.complicatedPageFunctions = new ComplicatedPageFunctions(testContext.getPage());
        this.complicatedPageState = new ComplicatedPageState(testContext.getPage());
    }

    @Given("I open the Complicated Page")
    public void i_open_the_complicated_page() {
        complicatedPageFunctions.navigate();
    }

    @When("I click on the first button")
    public void i_click_on_the_first_button() {
        complicatedPageFunctions.clickOnFirstButton();
        //to do hover over button to make change of color visible
    }

    @Then("I see the button change color")
    public void i_see_the_button_change_color() {
        Assert.assertTrue("Button changed color", complicatedPageState.checkIfColorOfButtonChanged());
    }
}
