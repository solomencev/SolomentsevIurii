package com.epam.tc.hw4.steps;

import com.epam.pages.DifferentElementsPage;
import com.epam.pages.MainPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionStep extends AbstractStep {

    public ActionStep(WebDriver driver) {
        super(driver);
    }

    @Step("Open test site by URL")
    public void openWebSite(String website) {
        webDriver.get(website);
    }

    @Step("Perform login")
    public void performLogin(String user, String password) {
        mainPage = new MainPage(webDriver);
        mainPage.login(user, password);
    }

    @Step("Switch to the iframe")
    public void switchToIframe(String frame) {
        webDriver.switchTo().frame(frame);
    }

    @Step("Switch to original window back")
    public void switchToParentWindow() {
        webDriver.switchTo().parentFrame();
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        mainPage.getHeaderMenu().clickServiceMenu().clickDifferentElements();
        differentElementsPage = new DifferentElementsPage(webDriver);
    }

    @Step("Select checkboxes")
    public void selectCheckbox(WebElement element) {
        element.click();
    }

    @Step("Select radio")
    public void selectRadioButton(WebElement element) {
        element.click();
    }

    @Step("Select in dropdown")
    public void selectDropDownColor(WebElement element) {
        element.click();
    }

}
