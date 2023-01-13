package com.epam.tc.hw4.ex2;

import com.epam.tc.hw4.AbstractChromeTest;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
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

    /* Assert Browser title. */
    @Step
    public SoftAssertions assertBrowserTitle() {
        softly.assertThat(driver.getTitle()).as("Browser title is incorrect").isEqualTo(mainPage.HOME_PAGE);
        return softly;
    }

    /* Perform login. */
    @Step
    private void performLogin() {
        mainPage.login(user, password);
    }

    /* Assert Username is loggined.*/
    @Step
    public SoftAssertions assertUserLoggined() {
        softly.assertThat(mainPage.getUserName()).as("Roman Iovlev is not logged")
                .isEqualTo(userFullName);
        return softly;
    }

    /* Open through the header menu Service -> Different Elements Page. */
    @Step
    public void openDifferentElementsPage() {
        mainPage.getHeaderMenu().clickServiceMenu().clickDifferentElements();
    }

    /* Select checkboxes. */
    @Step
    public void clickCheckBoxesWaterAndWind() {
        differentElementsPage.getCheckBoxWater().click();
        differentElementsPage.getCheckBoxWind().click();
    }

    /* Select radio. */
    @Step
    public void clickRadioButtonSelen() {
        differentElementsPage.getRadioButtonSelen().click();
    }

    /* Select in dropdown. */
    @Step
    public void selectDropdownYellow() {
        differentElementsPage.getDropdownYellow().click();
    }

    /* Assert that: for each checkbox there is an individual log row and value is corresponded to the status of
     * checkbox; for radio button there is a log row and value is corresponded to the status of radio button; for
     * dropdown there is a log row and value is corresponded to the selected value. */
    @Step
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
