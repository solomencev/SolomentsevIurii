package com.epam.tc.hw5.steps;

import static com.epam.tc.hw4.MainPage.HOME_PAGE;

import com.epam.tc.hw5.AbstractChromeTest;
import io.cucumber.java.en.Then;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class ThenStep extends BaseStep {

    AssertStep assertStep = new AssertStep(webDriver);

    private static final int COUNT_OF_IMAGES_MAIN_PAGE = 4;
    private static final List<String> LOGS = List
        .of("Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true",
            "Water: condition changed to true");

    protected ThenStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Then("title equals Home Page")
    public void titleEqualsHomePage() {
        assertStep.assertBrowserTitle(HOME_PAGE);
    }

    @Then("user is logged")
    public void userIsLogged() {
        assertStep.assertUserIsLogged(userFullName);
    }

    @Then("items are displayed on the header section")
    public void itemHeader() {
        assertStep.assertItemsInHeader(LIST_ITEMS_HEADER);
    }

    @Then("there are 4 images on the Index Page and they are displayed")
    public void imagesOnIndexPage() {
        assertStep.assertImagesOnIndexPage(COUNT_OF_IMAGES_MAIN_PAGE);
    }

    @Then("there are 4 texts on the Index Page under icons and they have proper text")
    public void textUnderIcons() {
        assertStep.assertTextUnderIcons(TEXT_UNDER_IMAGES);
    }

    @Then("there is the iframe with “Frame Button” exist")
    public void iframeButtonExist() {
        assertStep.assertIframeButtonExist();
    }

    @Then("that there is 'Frame Button' in the iframe")
    public void frameButtonIsDisplayed() {
        assertStep.assertFrameButtonIsDisplayed();
    }

    @Then("5 items in the Left Section are displayed")
    public void itemsInLeftSection() {
        assertStep.assertItemsInLeftSection(leftMenuItems);
    }

    @Then("Checkbox Water is checked")
    public void elementCheckBoxWaterIsSelected() {
        assertStep.assertElementCheckBoxWaterIsSelected();
    }

    @Then("Radiobutton selen is checked")
    public void elementRadioButtonSelenIsSelected() {
        assertStep.assertElementRadioButtonSelenIsSelected();
    }

    @Then("Checkbox Wind  is checked")
    public void elementCheckBoxWindIsSelected() {
        assertStep.assertElementCheckBoxWindIsSelected();
    }

    @Then("Dropdown is selected")
    public void elementDropdownYellowIsSelected() {
        assertStep.assertElementDropdownYellowIsSelected();
    }

    @Then("logs are displayed")
    public void logsForElements() {
        assertStep.assertLogsForElements(LOGS);
    }
}
