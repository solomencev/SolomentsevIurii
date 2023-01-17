package com.epam.tc.hw4.steps;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Open URL")
    public void openWebSite(String website) {
        driver.get(website);
    }

    @Step("Perform login")
    public void performLogin(String user, String password) {
        mainPage.login(user, password);
    }



}
