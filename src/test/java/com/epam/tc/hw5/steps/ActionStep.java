package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.DifferentElementsPage;
import com.epam.tc.hw5.DriverSetup;
import com.epam.tc.hw5.MainPage;
import com.epam.tc.hw5.UserTablePage;
import com.epam.tc.hw5.fragments.HeaderMenu;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class ActionStep extends DriverSetup {

    MainPage mainPage = new MainPage(driver);
    DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
    HeaderMenu headerMenu  = new HeaderMenu(driver);
    UserTablePage userTablePage = new UserTablePage(driver);

    @Given("User opens website")
    public void openWebSite() {
        mainPage.openMainPage();
    }

    @Given("I open JDI GitHub site")
    public void openJdiGitHubWebsite() {
        mainPage.openMainPage();
    }

    @When("Perform login as {string} and password {string}")
    public void performLogin(String user, String password) {
        mainPage.login(user, password);
    }

    @When("Switch to the frame")
    public void switchToIframe(String iframe) {
        mainPage.switchToFrame(iframe);
    }

    @When("Switch to original window back")
    public void switchToParentWindow() {
        mainPage.switchToHomePage();
    }

    @When("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        headerMenu.clickServiceMenuAndThenDifferentElementService();
    }

    @When("I click on {string} button in Header")
    public void openServiceMenuInHeader(String string) {
        headerMenu.clickServiceMenu();
    }

    @When("I click on {string} button in Service dropdown")
    public void clickUserTableItemInServiceMenuDropDown(String string) {
        headerMenu.clickUserTablePageElement();
    }

    @When("Select checkbox Wind")
    public void selectCheckboxWind() {
        differentElementsPage.selectCheckBoxWind();
    }

    @When("Select checkbox Water")
    public void selectCheckboxWater() {
        differentElementsPage.selectCheckBoxWater();
    }

    @When("Select radio Selen")
    public void selectRadioSelen() {
        differentElementsPage.selectRadioButtonSelen();
    }

    @When("Select in dropdown Yellow")
    public void selectDropDownColorYellow() {
        differentElementsPage.selectDropDownYellow();
    }

    @When("I select vip checkbox for {string}")
    public void selectVipCheckboxForUser(String name) {
        userTablePage.selectVipCheckbox(name);
    }
}
