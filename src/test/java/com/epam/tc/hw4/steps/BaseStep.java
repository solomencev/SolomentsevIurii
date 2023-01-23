package com.epam.tc.hw4.steps;

import com.epam.pages.DifferentElementsPage;
import com.epam.pages.MainPage;
import com.epam.tc.hw4.AbstractChromeTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public abstract class BaseStep extends AbstractChromeTest {

    SoftAssertions softAssert = new SoftAssertions();
    public static MainPage mainPage;
    public static DifferentElementsPage differentElementsPage;



    protected BaseStep(WebDriver webDriver) {
        mainPage = new MainPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
    }

}
