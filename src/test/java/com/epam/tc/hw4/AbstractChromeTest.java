package com.epam.tc.hw4;

import com.epam.pages.DifferentElementsPage;
import com.epam.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Config;

public class AbstractChromeTest {

    protected WebDriver driver;
    static WebDriverWait webDriverWait;
    protected MainPage mainPage;
    protected DifferentElementsPage differentElementsPage;

    protected String user = Config.getUserNameFromProperties();
    protected String password = Config.getUserPasswordFromProperties();
    protected String userFullName = Config.getUserFullNameFromProperties();

    /** Open test site by URL. */
    @BeforeClass(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 10);
    }

    /** Close Browser. */
    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}
