package calvin_klein_test.test;

import calvin_klein_test.page.CalvinKleinWishlistPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CalvinKleinWishlistPageTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    void getDriver() {
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");

        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        firefoxBinary.addCommandLineOptions("--no-sandbox");

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);

        driver = new FirefoxDriver(firefoxOptions);
    }

    @Test(description = "Test empty wishlist")
    void testWishlist() {
        boolean isEmptyViewDisplayed = new CalvinKleinWishlistPage(driver)
                .openPage()
                .acceptCookies()
                .signIn()
                .reload()
                .checkIsEmptyViewDisplayed();

        Assert.assertTrue(isEmptyViewDisplayed);
    }

    @AfterMethod(alwaysRun = true)
    void resetDriver() {
        driver.quit();
        driver = null;
    }
}
