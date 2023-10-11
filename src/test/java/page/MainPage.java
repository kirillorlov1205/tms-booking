package page;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private static final String MAIN_PAGE_URL = "https://www.booking.com/";
    private static final By SEARCH_FIELD_LOCATOR = By.xpath("//input[@name='ss']");
    private static final By SUBMIT_SEARCH_BUTTON_LOCATOR = By.xpath("//button[@type='submit']");
    private static final By SEARCH_POPUP_CLOSE_BUTTON = By.xpath("//button[contains(@aria-label," +
            "'Dismiss')]");

    public MainPage openMainPage() {
        open(MAIN_PAGE_URL);
        return this;
    }

    public MainPage fillSearchField(String city) {
        $(SEARCH_FIELD_LOCATOR).shouldBe(Condition.visible, Duration.ofSeconds(10)).sendKeys(city);
        return this;
    }

    public HotelsListPage submitSearch() {
        $(SUBMIT_SEARCH_BUTTON_LOCATOR).click();
        return new HotelsListPage();
    }

    public MainPage closeSearchingPopUp() {
        $(SEARCH_POPUP_CLOSE_BUTTON).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }
}
