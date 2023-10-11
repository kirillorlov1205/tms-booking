package tests;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

public class BookingTest {
    @CucumberOptions(
            features = {"classpath:features"},
            glue = "steps",
            plugin = { "pretty", "html:target/cucumber.html",
                    "json:target/cucumber.json"}
    )
    public static class BookingSearchTest extends AbstractTestNGCucumberTests {
    }
}
