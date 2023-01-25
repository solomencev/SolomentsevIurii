package com.epam.tc.hw5.steps;

import com.epam.tc.hw5.AbstractChromeTest;
import io.cucumber.java.en.Given;
import java.io.IOException;
import org.openqa.selenium.WebDriver;

public class GivenStep extends AbstractChromeTest {

    @Given("User opens website")
    public void openWebSite() {
        actionStep.openWebSite();
    }
}
