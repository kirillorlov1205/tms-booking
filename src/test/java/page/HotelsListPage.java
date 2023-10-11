package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.ArrayList;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class HotelsListPage {

    private static final By HOTELS_LIST = By.xpath("//div[@data-testid='title']");
    private static final String HOTEL_RATING = "//div[contains(text(),'%s')]//ancestor::div[contains(@class," +
            "'c2931f4182')]//div[contains(@class,'d86cee9b25')]";

    public boolean isHotelDisplayed(String hotelName) {
        ArrayList<String> hotelsList = new ArrayList<>();
        for (SelenideElement item : $$(HOTELS_LIST)) {
            hotelsList.add(item.getText());
        }
        return hotelsList.contains(hotelName);
    }

    public String getHotelRating(String hotelName) {
        return $(By.xpath(String.format(HOTEL_RATING, hotelName))).shouldBe(Condition.visible, Duration.ofSeconds(10))
                .getText();
    }
}
