package pages.complicatedPage;

import com.microsoft.playwright.Page;

public class ComplicatedPageFunctions {
    private final Page page;
    private final ComplicatedPageComponent complicatedPageComponent;

    public ComplicatedPageFunctions(Page page) {
        this.page = page;
        this.complicatedPageComponent = new ComplicatedPageComponent(page);
    }

    public void navigate() {
        page.navigate("https://ultimateqa.com/complicated-page");
    }

    public void clickOnFirstButton() {
        complicatedPageComponent.firstButton.click();
    }
}
