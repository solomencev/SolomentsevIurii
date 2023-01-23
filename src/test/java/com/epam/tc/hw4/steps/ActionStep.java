package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.AbstractChromeTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionStep extends AbstractChromeTest {
    public ActionStep(WebDriver webDriver) {
        super();
    }

    @Step("Open test site by URL")
    public void openWebSite(String website) {
        getWebDriver().get(website);
    }

    @Step("Perform login as {username}|{password}")
    public void performLogin(String user, String password) {
        //mainPage = new MainPage(webDriver);
        mainPage.login(user, password);
    }

    @Step("Switch to the {frame}")
    public void switchToIframe(String iframe) {
        getWebDriver().switchTo().frame(iframe);
    }

    @Step("Switch to original window back")
    public void switchToParentWindow() {
        getWebDriver().switchTo().parentFrame();
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        mainPage.getHeaderMenu().clickServiceMenu().clickDifferentElements();
        //differentElementsPage = new DifferentElementsPage(webDriver);
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
