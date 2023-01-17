package com.epam.tc.hw4.steps;

import com.epam.pages.DifferentElementsPage;
import com.epam.pages.MainPage;
import com.epam.tc.hw4.AbstractChromeTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AbstractStep extends AbstractChromeTest {

    protected MainPage mainPage;
    protected DifferentElementsPage differentElementsPage;
    protected SoftAssertions softAssert;
    protected WebDriver driver;


    /*protected AbstractStep(WebDriver webDriver) {
        //driver = new ChromeDriver();
        mainPage = new MainPage(webDriver);
        differentElementsPage = new DifferentElementsPage(webDriver);
        //softAssertions = new SoftAssertions();

    }*/

    protected AbstractStep(WebDriver driver) {
        this.driver = driver;
    }
}
