package com.epam.tc.hw4.steps;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class ActionStep extends BaseStep {
    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Open test site by URL")
    public void openWebSite(String website) {
        webDriver.get(website);
    }

    @Step("Perform login as {username}|{password}")
    public void performLogin(String user, String password) {
        mainPage.login(user, password);
    }

    @Step("Switch to the {frame}")
    public void switchToIframe(String iframe) {
        webDriver.switchTo().frame(iframe);
    }

    @Step("Switch to original window back")
    public void switchToParentWindow() {
        webDriver.switchTo().parentFrame();
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        mainPage.getHeaderMenu().clickServiceMenu().clickDifferentElements();
    }

    @Step("Select checkboxes {element}")
    public void selectCheckboxWind() {
        differentElementsPage.selectCheckBoxWind();
    }

    @Step("Select checkboxes {element}")
    public void selectCheckboxWater() {
        differentElementsPage.selectCheckBoxWater();
    }

    @Step("Select radio {element}")
    public void selectRadioSelen() {
        differentElementsPage.selectRadioButtonSelen();
    }

    @Step("Select in dropdown {element}")
    public void selectDropDownColorYellow() {
        differentElementsPage.selectDropDownYellow();
    }
}
