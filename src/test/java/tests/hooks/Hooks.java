package tests.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import tests.context.TestContext;

public class Hooks {
    private final TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        testContext.clearScenarioContext();
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            // Take screenshot
            byte[] screenshot = testContext.getPage().screenshot();
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        testContext.tearDown();
    }
} 