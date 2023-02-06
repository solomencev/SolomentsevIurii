package com.epam.tc.hw7;

import static com.epam.tc.hw4.utils.Config.getUserFullNameFromProperties;
import static com.epam.tc.hw4.utils.Config.getUserNameFromProperties;
import static com.epam.tc.hw4.utils.Config.getUserPasswordFromProperties;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public abstract class AbstractTest {

    public static final jdi.entities.User ROMAN_IOVLEV = new jdi.entities.User(
        Config.getUserNameFromProperties(),
        Config.getUserPasswordFromProperties(),
        Config.getUserFullNameFromProperties());

    public String user = getUserNameFromProperties();
    public String password = getUserPasswordFromProperties();
    public String userFullName = getUserFullNameFromProperties();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
        JdiSite.openHomePage();
        JdiSite.login(ROMAN_IOVLEV);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }
}
