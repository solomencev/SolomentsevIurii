package com.epam.tc.hw5.steps;


import static com.epam.tc.hw4.steps.BaseStep.differentElementsPage;
import static com.epam.tc.hw4.steps.BaseStep.headerMenu;
import static com.epam.tc.hw4.steps.BaseStep.mainPage;

import com.epam.tc.hw4.DifferentElementsPage;
import com.epam.tc.hw4.MainPage;
import com.epam.tc.hw4.hw4.fragments.HeaderMenu;
import com.epam.tc.hw5.DriverSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.openqa.selenium.WebDriver;

public class ActionStep extends DriverSetup {

    MainPage mainPage = new MainPage(driver);
    DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
    HeaderMenu headerMenu  = new HeaderMenu(driver);
    @Given("User opens website")
    public void openWebSite() {
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
}
