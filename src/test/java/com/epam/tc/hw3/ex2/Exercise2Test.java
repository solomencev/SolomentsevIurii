package com.epam.tc.hw3.ex2;

import static com.epam.pages.MainPage.HOME_PAGE;

import com.epam.tc.hw3.AbstractChromeTest;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;

public class Exercise2Test extends AbstractChromeTest {
    public SoftAssertions softly = new SoftAssertions();
    private static final List<String> LOGS = List
            .of("Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true",
                    "Water: condition changed to true");

    @Test(groups = {"HW3"})
    public void exercise2()  {
        //2. Assert Browser title "Home Page"
        softly.assertThat(driver.getTitle()).as("Browser title is incorrect").isEqualTo(HOME_PAGE);
        /* Perform login. */
        mainPage.login(user, password);
        /* Assert Username is loggined.*/
        softly.assertThat(mainPage.getUserName()).as("Roman Iovlev is not logged").isEqualTo(userFullName);
        /* Open through the header menu Service -> Different Elements Page. */
        mainPage.getHeaderMenu()
                .clickServiceMenu()
                .clickDifferentElements();
        /* Select checkboxes. */
        differentElementsPage.getCheckBoxWater().click();
        differentElementsPage.getCheckBoxWind().click();
        /* Select radio. */
        differentElementsPage.getRadioButtonSelen().click();
        /* Select in dropdown. */
        differentElementsPage.getDropdownYellow().click();
        /* Assert that: for each checkbox there is an individual log row and value is corresponded to the status of
         * checkbox; for radio button there is a log row and value is corresponded to the status of radio button; for
         * dropdown there is a log row and value is corresponded to the selected value. */
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
        softly.assertAll();
    }
}
