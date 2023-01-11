package com.epam.tc.hw3;

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

import static utils.Config.*;

public class AbstractChromeTest {

    protected WebDriver driver;
    static WebDriverWait webDriverWait;
    public static List<String> leftMenuItems =  List
            .of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
    public static List<String> LIST_ITEMS_HEADER = List
            .of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    public String user = Config.getUserNameFromProperties();
    public String password = Config.getUserPasswordFromProperties();
    public String userFullName = Config.getUserFullNameFromProperties();

    /** Open test site by URL. */
    @BeforeClass(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
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
