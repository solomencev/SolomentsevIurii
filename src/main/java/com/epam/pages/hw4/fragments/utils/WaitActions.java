package com.epam.pages.hw4.fragments.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitActions {

    private WebDriverWait webDriverWait;

    public WaitActions(WebDriver webDriver) {
        webDriverWait = new WebDriverWait(webDriver, 10);
    }
}
