package com.epam.tc.hw5.steps;

import static com.epam.tc.hw5.MainPage.HOME_PAGE;
import static com.epam.tc.hw5.UserTablePage.USER_TABLE_TAB;

import com.epam.tc.hw5.DifferentElementsPage;
import com.epam.tc.hw5.DriverSetup;
import com.epam.tc.hw5.MainPage;
import com.epam.tc.hw5.UserTablePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;

public class AssertStep extends DriverSetup {

    SoftAssertions softAssert = new SoftAssertions();
    MainPage mainPage = new MainPage(driver);
    DifferentElementsPage differentElementsPage = new DifferentElementsPage(driver);
    UserTablePage userTablePage = new UserTablePage(driver);

    @Then("Browser title equals 'Home Page'")
    public void assertBrowserTitleHomePage() {
        softAssert.assertThat(userTablePage.getBrowserTitleName()).as("Incorrect title").isEqualTo(HOME_PAGE);
        softAssert.assertAll();
    }

    @Then("{string} page should be opened")
    public void assertBrowserTitleUserTable(String title) {
        softAssert.assertThat(mainPage.getBrowserTitleName()).as("Incorrect title").isEqualTo(USER_TABLE_TAB);
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

    @Then("Checkbox Water is logged")
    public void checkboxWaterLogged() {
        softAssert.assertThat(logsContainsItem(differentElementsPage
            .getLogs(), "Water: condition changed to true")).as("Not logged").isTrue();
        softAssert.assertAll();
    }

    @And("Checkbox Wind is logged")
    public void checkboxWindLogged() {
        softAssert.assertThat(logsContainsItem(differentElementsPage
            .getLogs(), "Wind: condition changed to true")).as("Not logged").isTrue();
        softAssert.assertAll();
    }

    @And("Radiobutton Selen is logged")
    public void radioButtonSelenLogged() {
        softAssert.assertThat(logsContainsItem(differentElementsPage
            .getLogs(), "metal: value changed to Selen")).as("Not logged").isTrue();
        softAssert.assertAll();
    }

    @And("Dropdown Yellow is logged")
    public void dropdownYellowLogged() {
        softAssert.assertThat(logsContainsItem(differentElementsPage
            .getLogs(), "Colors: value changed to Yellow")).as("Not logged").isTrue();
        softAssert.assertAll();
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void numberTypeDropdownsShouldDisplayedOnUsersTableOnUserTablePage(int numberOfDropDowns) {
        softAssert.assertThat(userTablePage.getNumberTypeDropdowns().size()).isEqualTo(numberOfDropDowns);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernamesShouldBeDisplayedUsersTableOnUserTablePage(int numberOfUsers) {
        softAssert.assertThat(userTablePage.getUsers().size()).isEqualTo(numberOfUsers);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void descriptionTextsUnderImagesShouldBeDisplayedUsersTableOnUserTablePage(int numberOfDescriptions) {
        softAssert.assertThat(userTablePage.getDescriptions().size()).isEqualTo(numberOfDescriptions);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxesShouldBeDisplayedUsersTableOnUserTablePage(int numberOfCheckboxes) {
        softAssert.assertThat(userTablePage.getCheckboxes().size()).isEqualTo(numberOfCheckboxes);
    }

    @Then("User table should contain following values:")
    public void userTableContainValues(DataTable dataTable) {
        List<List<String>> userTable = dataTable.rows(1).cells();
        List<String> number = new ArrayList<>();
        List<String> user = new ArrayList<>();
        List<String> description = new ArrayList<>();
        for (List<String> element : userTable) {
            number.add(element.get(0));
            user.add(element.get(1));
            description.add(element.get(2));
        }
        softAssert.assertThat(userTablePage.getNumberFromTable())
              .as("Incorrect numbers")
              .isEqualTo(number);
        softAssert.assertThat(userTablePage.getUserFromTable())
              .as("Incorrect users")
              .isEqualTo(user);
        softAssert.assertThat(userTablePage.getDescriptionFromTable())
              .as("Incorrect description")
              .isEqualTo(description);
        softAssert.assertAll();
    }

    @Then("droplist should contain values in column Type for user {string}")
    public void droplistContainValuesInColumn(String userName, io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> valuesTable = dataTable.rows(1).cells();
        List<String> values = new ArrayList<>();
        for (List<String> element : valuesTable) {
            values.add(element.get(0));
        }
        softAssert.assertThat(userTablePage.getDroplistValues(userName))
              .as("Incorrect values in dropdown")
              .isEqualTo(values);
        softAssert.assertAll();
    }

    @Then("1 log row has {string} text in log section")
    public void logRowHasTextInLogSection(String log) {
        softAssert.assertThat(userTablePage.logsAfterSelectingVipCheckbox(log)).as("Fail").isTrue();
    }


    private static boolean logsContainsItem(Collection<WebElement> logs, String expectedEntry) {
        for (var logElement : logs) {
            if (logElement.getText().contains(expectedEntry)) {
                return true;
            }
        }
        return false;
    }
}
