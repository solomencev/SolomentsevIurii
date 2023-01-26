package com.epam.tc.hw5.steps;

import static com.epam.tc.hw4.MainPage.HOME_PAGE;

import com.epam.tc.hw4.DifferentElementsPage;
import com.epam.tc.hw4.MainPage;
import com.epam.tc.hw5.DriverSetup;
import io.cucumber.java.en.Then;
import java.util.List;
import org.assertj.core.api.SoftAssertions;

public class AssertStep extends DriverSetup {

    private static final List<String> LOGS = List
        .of("Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true",
            "Water: condition changed to true");
    SoftAssertions softAssert = new SoftAssertions();
    MainPage mainPage = new MainPage(driver);
    DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);

    @Then("Browser title equals 'Home Page'")
    public void assertBrowserTitle() {
        softAssert.assertThat(mainPage.getBrowserTitleName()).as("Incorrect title").isEqualTo(HOME_PAGE);
        softAssert.assertAll();
    }

    @Then("User is logged as {string}")
    public void user_is_logged_as(String userFullName) {
        softAssert.assertThat(mainPage.getUserName()).as("Incorrect user name").isEqualTo(userFullName);
        softAssert.assertAll();
    }

    @Then("Assert that there are 4 items on header section are displayed and they have proper texts")
    public void assertItemsInHeader(List<String> listItemsHeader) {
        for (int i = 0; i < listItemsHeader.size(); i++) {
            softAssert.assertThat(mainPage.getMenuList().get(i).getText()).as("Wrong text")
                      .isEqualTo(listItemsHeader.get(i));
            softAssert.assertThat(mainPage.getMenuList().get(i).isDisplayed()).as("Not displayed").isTrue();
        }
        softAssert.assertAll();
    }

    @Then("Assert that there are 4 images on the Index Page and they are displayed")
    public void  assertImagesOnIndexPage(int countOfImagesOnIndexPage) {
        softAssert.assertThat(mainPage.getListOfImages().size()).as("Incorrect number of items")
              .isEqualTo(countOfImagesOnIndexPage);
        for (int i = 0; i < countOfImagesOnIndexPage; i++) {
            softAssert.assertThat(mainPage.getListOfTextUnderImages().get(i).isDisplayed())
                      .as("Not displayed").isTrue();
        }
        softAssert.assertAll();
    }

    @Then("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void  assertTextUnderIcons(List<String> textUnderImages) {
        for (int i = 0; i < mainPage.getListOfTextUnderImages().size() - 1; i++) {
            softAssert.assertThat(mainPage.getListOfTextUnderImages().get(i).getText())
                      .as("Wrong text").isEqualTo(textUnderImages
                .get(i));
        }
        softAssert.assertAll();
    }

    @Then("Assert that there is the iframe with “Frame Button” exist")
    public void assertIframeButtonExist() {
        softAssert.assertThat(mainPage.getFrame().isDisplayed()).as("Not displayed").isTrue();
        softAssert.assertAll();
    }

    @Then("Check that there is 'Frame Button' in the iframe")
    public void assertFrameButtonIsDisplayed() {
        softAssert.assertThat(mainPage.getFrameButton().isDisplayed()).as("Not displayed").isTrue();
        softAssert.assertAll();
    }

    @Then("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void  assertItemsInLeftSection(List<String> leftMenuItems) {
        for (int i = 0; i < mainPage.getLeftMenu().size() - 1; i++) {
            softAssert.assertThat(mainPage.getLeftMenu().get(i).getText())
                      .as("Wrong text").isEqualTo(leftMenuItems.get(i));
        }
        softAssert.assertAll();
    }

    @Then("Checkbox Water is checked")
    public void assertElementCheckBoxWaterIsSelected() {
        softAssert.assertThat(differentElementsPage.isCheckBoxWaterSelected()).as("Not selected").isTrue();
        softAssert.assertAll();
    }

    @Then("Radiobutton selen is checked")
    public void assertElementRadioButtonSelenIsSelected() {
        softAssert.assertThat(differentElementsPage.isRadioButtonSelenSelected()).as("Not selected").isTrue();
        softAssert.assertAll();
    }

    @Then("Checkbox Wind is checked")
    public void assertElementCheckBoxWindIsSelected() {
        softAssert.assertThat(differentElementsPage.isCheckBoxWindSelected()).as("Not selected").isTrue();
        softAssert.assertAll();
    }

    @Then("Dropdown is selected")
    public void assertElementDropdownYellowIsSelected() {
        softAssert.assertThat(differentElementsPage.isDropdownYellowSelected()).as("Not selected").isTrue();
        softAssert.assertAll();
    }
    
    @Then("Log row and value is corresponded to the selected value.{stringList}")
    public void log_row_and_value_is_corresponded_to_the_selected_value(List<String> textForLogs) {
        for (int i = 0; i < textForLogs.size(); i++) {
            softAssert.assertThat(differentElementsPage.getLogs().get(i).getText())
                      .as("Not selected").contains(textForLogs.get(i));
        }
        softAssert.assertAll();
    }
}
