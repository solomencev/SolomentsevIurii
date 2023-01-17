package com.epam.tc.hw4.steps;

import static org.apache.commons.lang3.SystemUtils.getUserName;

import com.epam.pages.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class AssertStep extends AbstractStep {

    public AssertStep(WebDriver driver) {
        super(driver);
    }

    @Step("Assert Browser title Home Page")
    public void assertBrowserTitle(String title) {
        softAssert.assertThat(driver.getTitle()).isEqualTo(title);
    }

    @Step("I assert Username is logged")
    public void assertUserIsLogged(String userFullName) {
        softAssert.assertThat(mainPage.getUserName()).isEqualTo(userFullName);
        softAssert.assertAll();
    }

}
