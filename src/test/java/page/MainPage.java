package page;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private static final String MAIN_PAGE_URL = "https://www.booking.com/";
    private static final By SEARCH_FIELD = By.xpath("//input[@name='ss']");
    private static final By SUBMIT_SEARCH_BUTTON = By.xpath("//button[@type='submit']");
    private static final By SEARCH_POPUP_CLOSE_BUTTON = By.xpath("//button[contains(@aria-label," +
            "'Dismiss')]");
    private static final String CITY_OPTION = "//div[@class='a3332d346a' and text()='%s']";

    public MainPage openMainPage() {
        open(MAIN_PAGE_URL);
        return this;
    }

    public MainPage fillSearchField(String city) {
        $(SEARCH_FIELD).shouldBe(Condition.visible, Duration.ofSeconds(10)).sendKeys(city);
        return this;
    }

    public MainPage selectCityOptionByText(String optionName) {
        $(By.xpath(String.format(CITY_OPTION, optionName))).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }

    public HotelsListPage submitSearch() {
        $(SUBMIT_SEARCH_BUTTON).click();
        return new HotelsListPage();
    }

    public MainPage closeSearchingPopUp() {
        $(SEARCH_POPUP_CLOSE_BUTTON).shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
        return this;
    }
}
