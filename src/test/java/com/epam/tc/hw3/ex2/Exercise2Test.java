package com.epam.tc.hw3.ex2;

import com.epam.tc.hw3.AbstractChromeTest;
import java.io.IOException;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Test;
import pages.DifferentElementsPage;
import pages.MainPage;

import static pages.MainPage.HOME_PAGE;
import static pages.MainPage.URL_HOME_PAGE;

public class Exercise2Test extends AbstractChromeTest {
    public SoftAssertions softly = new SoftAssertions();
    private static List<String> logs = List
            .of("Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true",
                    "Water: condition changed to true");

    public Exercise2Test() throws IOException {
    }

    @Test(groups = {"HW2"})
    public void exercise2()  {
        //1. Open test site by URL
        driver.get(URL_HOME_PAGE);
        MainPage mainPage = new MainPage(driver);
        //2. Assert Browser title "Home Page"
        softly.assertThat(driver.getTitle()).as("Browser title is incorrect").isEqualTo(HOME_PAGE);
        /* Perform login. */
        mainPage.login(user, password);
        /* Assert Username is loggined.*/
        softly.assertThat(mainPage.userLogged()).as("Roman Iovlev is not logged").isEqualTo(userFullName);
        /* Open through the header menu Service -> Different Elements Page. */
        mainPage.headerMenu()
                .clickServiceMenu()
                .clickDifferentElements();
        /* Select checkboxes. */
        DifferentElementsPage difElPage = new DifferentElementsPage(driver);
        difElPage.getCheckBoxWater().click();
        difElPage.getCheckBoxWind().click();
        /* Select radio. */
        difElPage.getRadioButtonSelen().click();
        /* Select in dropdown. */
        difElPage.getDropdownYellow().click();
        /* Assert that: for each checkbox there is an individual log row and value is corresponded to the status of
         * checkbox; for radio button there is a log row and value is corresponded to the status of radio button; for
         * dropdown there is a log row and value is corresponded to the selected value. */
        softly.assertThat(difElPage.getCheckBoxWater().isSelected()).isTrue();
        softly.assertThat(difElPage.getCheckBoxWind().isSelected()).isTrue();
        softly.assertThat(difElPage.getRadioButtonSelen().isSelected()).isTrue();
        softly.assertThat(difElPage.getDropdownYellow().isSelected()).isTrue();
        for (int i = 0; i < logs.size(); i++) {
            softly.assertThat(difElPage.getLogs().get(i).getText()).contains(logs.get(i));
        }
        softly.assertAll();
    }
}
