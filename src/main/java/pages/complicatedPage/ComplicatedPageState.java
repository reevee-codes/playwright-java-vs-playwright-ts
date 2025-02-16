package pages.complicatedPage;

import com.microsoft.playwright.Page;
import pages.BasePage;

public class ComplicatedPageState extends BasePage {
    private final ComplicatedPageComponent complicatedPageComponent;

    public ComplicatedPageState(Page page) {
        super(page);
        this.complicatedPageComponent = new ComplicatedPageComponent(page);
    }

    public boolean checkIfColorOfButtonChanged() {
        String bodyClass = page.locator("body").getAttribute("class");
        return bodyClass.contains("safari");
    }
}
