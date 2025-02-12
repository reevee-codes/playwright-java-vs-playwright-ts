package pages.complicatedPage;

import com.microsoft.playwright.Page;

public class ComplicatedPageState {
    private final Page page;
    private final ComplicatedPageComponent complicatedPageComponent;

    public ComplicatedPageState(Page page) {
        this.page = page;
        this.complicatedPageComponent = new ComplicatedPageComponent(page);
    }

    public String getColorOfFirstButton() {
        return complicatedPageComponent.firstButton.getAttribute("color");
    }
}
