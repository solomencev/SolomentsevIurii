package com.epam.tc.hw4;

import com.epam.pages.DifferentElementsPage;
import com.epam.pages.MainPage;
import com.epam.tc.hw4.steps.ActionStep;
import com.epam.tc.hw4.steps.AssertStep;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Config;

public abstract class AbstractChromeTest {

    protected WebDriver driver;
    static WebDriverWait webDriverWait;
    protected MainPage mainPage;
    protected DifferentElementsPage differentElementsPage;
    protected SoftAssertions softAssert;
    protected ActionStep actionStep;
    protected AssertStep assertStep;

    protected String user = Config.getUserNameFromProperties();
    protected String password = Config.getUserPasswordFromProperties();
    protected String userFullName = Config.getUserFullNameFromProperties();

    /** Open test site by URL. */
    @BeforeClass(alwaysRun = true)
    public void setup(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        softAssert = new SoftAssertions();
        assertStep = new AssertStep(driver);
        actionStep = new ActionStep(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriverWait = new WebDriverWait(driver, 10);
        context.setAttribute("driver", driver);

    }

    /** Close Browser. */
    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.quit();
    }
}
