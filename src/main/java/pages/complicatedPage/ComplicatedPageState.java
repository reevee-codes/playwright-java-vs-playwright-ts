package pages.complicatedPage;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.PlaywrightException;
import exceptions.ElementNotFoundException;
import pages.BasePage;

public class ComplicatedPageState extends BasePage {
    private final ComplicatedPageComponent complicatedPageComponent;

    public ComplicatedPageState(Page page) {
        super(page);
        this.complicatedPageComponent = new ComplicatedPageComponent(page);
    }

    public boolean checkIfColorOfButtonChanged() {
        try {
            ElementHandle elementHandle = complicatedPageComponent.firstButton.elementHandle();
            String initialColor = (String) elementHandle.evaluate("element => window.getComputedStyle(element).color");
            complicatedPageComponent.firstButton.hover();
            boolean changed = (boolean) page.waitForFunction(
                    "([element, initialColor]) => {" +
                            "const currentColor = window.getComputedStyle(element).color;" +
                            "return currentColor !== initialColor;" +
                            "}",
                    new Object[]{elementHandle, initialColor}
            ).evaluate("result => result");
            return changed;
        } catch (PlaywrightException e) {
            throw new ElementNotFoundException("Failed to check button color change: " + e.getMessage());
        }
    }

    public boolean checkIfMessageAppeared(String message) {
    }
}
