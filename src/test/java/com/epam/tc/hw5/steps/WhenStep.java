package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.AbstractChromeTest;
import io.cucumber.java.en.When;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class WhenStep extends AbstractChromeTest {

    @When("User logins as Romain Iovlev")
    public void loginAsUserRomanIovlev() {
        actionStep.performLogin(user, password);
    }

    @When("User switches to the frame")
    public void switchToIframe(String iframe) {
        actionStep.switchToIframe(iframe);
    }

    @When("User switches back to original window")
    public void switchToParentWindow() {
        actionStep.switchToParentWindow();
    }

    @When("User goes to Different elements page")
    public void  openDifferentElementPage() {
        actionStep.openDifferentElementsPage();
    }

    @When("User selects checkbox Water")
    public void selectCheckboxesWater() {
        actionStep.selectCheckboxWater();
    }

    @When("User selects checkbox Wind")
    public void selectCheckboxesWind() {
        actionStep.selectCheckboxWind();
    }

    @When("User selects radiobutton Selen")
    public void selectRadiobuttonSelen() {
        actionStep.selectRadioSelen();
    }

    @When("User selects dropdown Yellow")
    public void selectDropdownYellow() {
        actionStep.selectDropDownColorYellow();
    }
}
