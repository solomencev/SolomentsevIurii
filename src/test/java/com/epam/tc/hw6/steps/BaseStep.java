package com.epam.tc.hw6.steps;

import com.epam.tc.hw6.AbstractChromeTest;
import com.epam.tc.hw6.DifferentElementsPage;
import com.epam.tc.hw6.MainPage;
import com.epam.tc.hw6.fragments.HeaderMenu;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public abstract class BaseStep extends AbstractChromeTest {

    SoftAssertions softAssert = new SoftAssertions();
    public static MainPage mainPage;
    public static DifferentElementsPage differentElementsPage;
    public static HeaderMenu headerMenu;

    protected BaseStep(WebDriver webDriver) {
        mainPage = new MainPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        headerMenu = new HeaderMenu(webDriver);
    }
}
