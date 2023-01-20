package com.epam.tc.hw4;

import static com.epam.pages.utils.Config.getUserFullNameFromProperties;
import static com.epam.pages.utils.Config.getUserNameFromProperties;
import static com.epam.pages.utils.Config.getUserPasswordFromProperties;

import com.epam.pages.DifferentElementsPage;
import com.epam.pages.MainPage;
import com.epam.tc.hw4.steps.ActionStep;
import com.epam.tc.hw4.steps.AssertStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public abstract class AbstractChromeTest {

    public static MainPage mainPage;
    public static AssertStep assertStep;
    public static ActionStep actionStep;
    public SoftAssertions softAssert = new SoftAssertions();

    private static WebDriver webDriver;
    public static DifferentElementsPage differentElementsPage;
    static WebDriverWait webDriverWait;
    public static List<String> leftMenuItems =  List
        .of("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
    public static List<String> LIST_ITEMS_HEADER = List
        .of("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

    public static final List<String> TEXT_UNDER_IMAGES = List
        .of("To include good practices\nand ideas from successful\nEPAM project",
            "To be flexible and\ncustomizable",
            "To be multiplatform",
            "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    public String user = getUserNameFromProperties();
    public String password = getUserPasswordFromProperties();
    public String userFullName = getUserFullNameFromProperties();

    @BeforeClass(alwaysRun = true)
    public void setup(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        softAssert = new SoftAssertions();
        webDriver = new ChromeDriver();
        mainPage = new MainPage(webDriver);
        assertStep = new AssertStep(webDriver);
        actionStep = new ActionStep(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(webDriver, 10);
        context.setAttribute("driver", webDriver);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        webDriver.quit();
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

}
