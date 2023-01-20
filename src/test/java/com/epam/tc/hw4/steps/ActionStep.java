package com.epam.tc.hw4.steps;

import static com.epam.tc.hw4.AbstractChromeTest.mainPage;

import com.epam.pages.DifferentElementsPage;
import com.epam.pages.MainPage;
import com.epam.tc.hw4.AbstractChromeTest;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionStep extends AbstractChromeTest {
    public ActionStep(WebDriver webDriver) {
        super();
    }

    /*public ActionStep(WebDriver driver) {
        super(driver);
    }*/

    @Step("Open test site by URL")
    public void openWebSite(String website) {
        webDriver.get(website);
    }

    //@Step("Perform login")
    @Step("Perform login as {username}|{password}")
    public void performLogin(String user, String password) {
        //mainPage = new MainPage(webDriver);
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
        //differentElementsPage = new DifferentElementsPage(webDriver);
    }

    @Step("Select checkboxes {element}")
    public void selectCheckbox(WebElement element) {
        element.click();
    }

    @Step("Select radio {element}")
    public void selectRadioButton(WebElement element) {
        element.click();
    }

    @Step("Select in dropdown {element}")
    public void selectDropDownColor(WebElement element) {
        element.click();
    }

}
