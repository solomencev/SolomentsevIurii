package com.epam.tc.hw4.ex2;

import com.epam.tc.hw4.AbstractChromeTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class Exercise2Test extends AbstractChromeTest {
    public SoftAssertions softly = new SoftAssertions();
    private static final List<String> LOGS = List
            .of("Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true",
                    "Water: condition changed to true");

    @Test(groups = {"HW4"})
    @Description(value = "Test case for Exercise #2")
    @Feature("Feature One")
    @Story("Different Elements Page")
    public void exercise2()  {
        assertBrowserTitle();
        performLogin();
        assertUserLoggined();
        openDifferentElementsPage();
        clickCheckBoxesWaterAndWind();
        clickRadioButtonSelen();
        selectDropdownYellow();
        assertLogs();
        softly.assertAll();
    }

    @Step("Verify browser title")
    public SoftAssertions assertBrowserTitle() {
        softly.assertThat(driver.getTitle()).as("Browser title is incorrect").isEqualTo(mainPage.HOME_PAGE);
        return softly;
    }

    @Step("User log in")
    private void performLogin() {
        mainPage.login(user, password);
    }

    @Step("The user is logged")
    public SoftAssertions assertUserLoggined() {
        softly.assertThat(mainPage.getUserName()).as("Roman Iovlev is not logged")
                .isEqualTo(userFullName);
        return softly;
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openDifferentElementsPage() {
        mainPage.getHeaderMenu().clickServiceMenu().clickDifferentElements();
    }

    @Step("Select checkboxes")
    public void clickCheckBoxesWaterAndWind() {
        differentElementsPage.getCheckBoxWater().click();
        differentElementsPage.getCheckBoxWind().click();
    }

    @Step("Select radio")
    public void clickRadioButtonSelen() {
        differentElementsPage.getRadioButtonSelen().click();
    }

    @Step("Select in dropdown")
    public void selectDropdownYellow() {
        differentElementsPage.getDropdownYellow().click();
    }

    @Step("Assert that 1 for each checkbox there is an individual log row and value is corresponded to the status \n"
        + "of checkbox 2 for radio button there is a log row and value is corresponded to the status of radio button\n"
        + "3 for dropdown there is a log row and value")
    public SoftAssertions assertLogs() {
        softly.assertThat(differentElementsPage.getCheckBoxWater().isSelected()).as("Logs are not displayed")
                .isTrue();
        softly.assertThat(differentElementsPage.getCheckBoxWind().isSelected()).as("Logs are not displayed")
                .isTrue();
        softly.assertThat(differentElementsPage.getRadioButtonSelen().isSelected())
                .as("Logs are not displayed")
                .isTrue();
        softly.assertThat(differentElementsPage.getDropdownYellow().isSelected()).as("Logs are not displayed")
                .isTrue();
        for (int i = 0; i < LOGS.size(); i++) {
            softly.assertThat(differentElementsPage.getLogs().get(i).getText()).contains(LOGS.get(i));
        }
        return softly;
    }
}
