package steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import page.HotelsListPage;
import page.MainPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BookingSteps {

    private MainPage mainPage;
    private HotelsListPage hotelsListPage;

    @Before
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.timeout = 5000;
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        chromeOptions.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(chromeOptions);
        WebDriverRunner.setWebDriver(driver);
        getWebDriver().manage().window().maximize();
    }

    @After
    public void close() {
        getWebDriver().quit();
    }

    @Given("User Opens Booking main page")
    public void userOpensBookingMainPage() {
        mainPage = new MainPage();
        mainPage.openMainPage();
    }

    @When("User does search in {string} city")
    public void userDoesSearch(String city) {
        mainPage = new MainPage();
        mainPage.fillSearchField(city)
                .closeSearchingPopUp()
                .submitSearch();
    }

    @Then("Hotel {string} should be on the first page")
    public void hotelShouldBeOnTheFirstPage(String hotelName) {
        hotelsListPage = new HotelsListPage();
        Assert.assertTrue(hotelsListPage.isHotelDisplayed(hotelName), "Hotel is not displayed");
    }

    @And("Hotel rating is {string}")
    public void hotelRatingIs(String expectedRating) {
        hotelsListPage = new HotelsListPage();
        String hotelName = "Hawkwood Apartments";
        String actualHotelRating = hotelsListPage.getHotelRating(hotelName);
        Assert.assertEquals(actualHotelRating, expectedRating, "Hotel rating doesn't match expected");
    }
}
