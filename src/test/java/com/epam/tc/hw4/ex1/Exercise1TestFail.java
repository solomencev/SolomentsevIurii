package com.epam.tc.hw4.ex1;

import static com.epam.pages.MainPage.HOME_PAGE;
import static com.epam.pages.MainPage.ID_FRAME;
import static com.epam.pages.MainPage.URL_HOME_PAGE;

import com.epam.tc.hw4.AbstractChromeTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class Exercise1TestFail extends AbstractChromeTest {

    /* Set as 3 for test fail */
    private static final int COUNT_OF_IMAGES_MAIN_PAGE = 7;

    @Test(groups = {"HW4"})
    @Description(value = "Test case for Exercise #1")
    @Feature("Feature One")
    @Story("Index Page")
    public void exercise1fail() {

        actionStep.openWebSite(URL_HOME_PAGE);
        assertStep.assertBrowserTitle(HOME_PAGE + "fdfejf4jfi4jf");
        actionStep.performLogin(user, password);
        assertStep.assertUserIsLogged(userFullName + "dfdryytrytytff"); // fail 1
        assertStep.assertItemsInHeader(LIST_ITEMS_HEADER);
        assertStep.assertImagesOnIndexPage(COUNT_OF_IMAGES_MAIN_PAGE); // fail 2
        assertStep.assertTextUnderIcons(TEXT_UNDER_IMAGES);
        assertStep.assertIframeButtonExist();
        actionStep.switchToIframe(ID_FRAME);
        assertStep.assertFrameButtonIsDisplayed();
        actionStep.switchToParentWindow();
        assertStep.assertItemsInLeftSection(leftMenuItems);
        //softAssert.assertAll();

    }
}
