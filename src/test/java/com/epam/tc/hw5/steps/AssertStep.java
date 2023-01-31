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

    @Then("Browser title should be 'Home Page'")
    public void assertHomePageIsOpened() {
        softAssert.assertThat(userTablePage.getBrowserTitleName()).as("Incorrect title").isEqualTo(HOME_PAGE);
        softAssert.assertAll();
    }

    @Then("{string} page should be opened")
    public void assertUserTableIsOpened(String title) {
        softAssert.assertThat(mainPage.getBrowserTitleName()).as("Incorrect title").isEqualTo(USER_TABLE_TAB);
        softAssert.assertAll();
    }

    @Then("User is logged as {string}")
    public void assertUserIsLogged(String userFullName) {
        softAssert.assertThat(mainPage.getUserName()).as("Incorrect user name").isEqualTo(userFullName);
        softAssert.assertAll();
    }

    @Then("Checkbox Water should be logged")
    public void checkboxWaterShouldBeLogged() {
        softAssert.assertThat(logsContainsItem(differentElementsPage
            .getLogs(), "Water: condition changed to true")).as("Not logged").isTrue();
        softAssert.assertAll();
    }

    @And("Checkbox Wind should be logged")
    public void checkboxWindShouldBeLogged() {
        softAssert.assertThat(logsContainsItem(differentElementsPage
            .getLogs(), "Wind: condition changed to true")).as("Not logged").isTrue();
        softAssert.assertAll();
    }

    @And("Radiobutton Selen should be logged")
    public void radioButtonSelenShouldBeLogged() {
        softAssert.assertThat(logsContainsItem(differentElementsPage
            .getLogs(), "metal: value changed to Selen")).as("Not logged").isTrue();
        softAssert.assertAll();
    }

    @And("Dropdown Yellow should be logged")
    public void dropdownYellowShouldBeLogged() {
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
    public void userTableShouldContainValues(DataTable dataTable) {
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
    public void droplistShouldContainValuesInColumn(String userName, io.cucumber.datatable.DataTable dataTable) {
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
