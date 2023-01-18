package com.epam.tc.hw4.ex2;

import static com.epam.pages.MainPage.HOME_PAGE;
import static com.epam.pages.MainPage.URL_HOME_PAGE;
import static com.epam.tc.hw4.steps.AbstractStep.differentElementsPage;

import com.epam.tc.hw4.AbstractChromeTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.util.List;
import org.testng.annotations.Test;

public class Exercise2Test extends AbstractChromeTest {

    private static final List<String> LOGS = List
        .of("Colors: value changed to Yellow", "metal: value changed to Selen", "Wind: condition changed to true",
            "Water: condition changed to true");

    @Test(groups = {"HW4"})
    @Description(value = "Test case for Exercise #2")
    @Feature("Feature One")
    @Story("Different Elements Page")
    public void exercise2()  {

        actionStep.openWebSite(URL_HOME_PAGE);
        assertStep.assertBrowserTitle(HOME_PAGE);
        actionStep.performLogin(user, password);
        assertStep.assertUserIsLogged(userFullName);
        actionStep.openDifferentElementsPage();
        actionStep.selectCheckbox(differentElementsPage.getCheckBoxWater());
        actionStep.selectCheckbox(differentElementsPage.getCheckBoxWind());
        actionStep.selectRadioButton(differentElementsPage.getRadioButtonSelen());
        actionStep.selectDropDownColor(differentElementsPage.getDropdownYellow());
        assertStep.assertElementIsSelected(differentElementsPage.getCheckBoxWater());
        assertStep.assertElementIsSelected(differentElementsPage.getCheckBoxWind());
        assertStep.assertElementIsSelected(differentElementsPage.getRadioButtonSelen());
        assertStep.assertElementIsSelected(differentElementsPage.getDropdownYellow());
        assertStep.assertLogsForElements(LOGS);

    }
}
