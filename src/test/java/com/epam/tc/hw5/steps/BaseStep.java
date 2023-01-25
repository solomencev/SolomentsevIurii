package com.epam.tc.hw5.steps;

import com.epam.tc.hw4.DifferentElementsPage;
import com.epam.tc.hw4.MainPage;
import com.epam.tc.hw4.hw4.fragments.HeaderMenu;
import com.epam.tc.hw5.AbstractChromeTest;
import com.epam.tc.hw5.Hook;
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

    protected BaseStep() {
    }
}
