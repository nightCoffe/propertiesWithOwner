package tests;

import configurations.SelectWebDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HabrTest {

    private WebDriver driver = new SelectWebDriver().get();

    @Test
    public void MainHabrTest() {
        assertEquals("All posts in a row / Habr", driver.getTitle());
        driver.quit();
    }
}
