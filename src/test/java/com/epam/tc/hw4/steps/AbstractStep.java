package com.epam.tc.hw4.steps;

import com.epam.pages.DifferentElementsPage;
import com.epam.pages.MainPage;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;

public class AbstractStep {

    public static WebDriver webDriver;
    SoftAssertions softAssert = new SoftAssertions();
    public MainPage mainPage;
    public static DifferentElementsPage difElPage;


    protected AbstractStep(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
