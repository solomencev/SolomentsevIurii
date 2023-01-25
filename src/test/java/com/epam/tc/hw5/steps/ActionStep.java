package com.epam.tc.hw5.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class ActionStep extends BaseStep {
    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Given("User opens website")
    public void openWebSite() {
        actionStep.openWebSite();
    }

    @When("Perform login as {username}|{password}")
    public void performLogin(String user, String password) {
        mainPage.login(user, password);
    }

    @When("Switch to the {frame}")
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

    @When("Select checkboxes {element}")
    public void selectCheckboxWind() {
        differentElementsPage.selectCheckBoxWind();
    }

    @When("Select checkboxes {element}")
    public void selectCheckboxWater() {
        differentElementsPage.selectCheckBoxWater();
    }

    @When("Select radio {element}")
    public void selectRadioSelen() {
        differentElementsPage.selectRadioButtonSelen();
    }

    @When("Select in dropdown {element}")
    public void selectDropDownColorYellow() {
        differentElementsPage.selectDropDownYellow();
    }
}
