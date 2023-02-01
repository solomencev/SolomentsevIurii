package com.epam.tc.hw6.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitActions {

    private WebDriverWait webDriverWait;

    public WaitActions(WebDriver webDriver) {
        webDriverWait = new WebDriverWait(webDriver, 10);
    }
}
