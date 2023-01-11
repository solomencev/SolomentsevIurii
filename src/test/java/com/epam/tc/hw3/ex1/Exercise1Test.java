package com.epam.tc.hw3.ex1;


import static pages.MainPage.*;

import com.epam.tc.hw3.AbstractChromeTest;
import java.util.List;
import org.testng.annotations.Test;
import pages.MainPage;
import org.assertj.core.api.SoftAssertions;

public class Exercise1Test extends AbstractChromeTest {

    private static final int COUNT_OF_IMAGES_ON_MAIN_PAGE = 4;
    private static List<String> textUnderImages = List
            .of("To include good practices\nand ideas from successful\nEPAM project",
                    "To be flexible and\ncustomizable",
                    "To be multiplatform",
                    "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    @Test(groups = {"HW3"})
    public void exercise1() {
        SoftAssertions softly = new SoftAssertions();
        MainPage mainPage = new MainPage(driver);
        /* Assert Browser title. */
        softly.assertThat(driver.getTitle()).as("Browser title is incorrect").isEqualTo(HOME_PAGE);
        /* Perform login. */
        mainPage.login(user, password);
        /* Assert Username is loggined.*/
        softly.assertThat(mainPage.getUserName()).as("Roman Iovlev is not logged")
                .isEqualTo(userFullName);
        /* Assert that there are 4 items on the header section are displayed and they have proper texts. */
        for (int i = 0; i < LIST_ITEMS_HEADER.size(); i++) {
            softly.assertThat(mainPage.getMenuList().get(i).getText()).isEqualTo(LIST_ITEMS_HEADER.get(i));
            softly.assertThat(mainPage.getMenuList().get(i).isDisplayed());
        }

        /* Assert that there are 4 images on the Index Page and they are displayed.*/
        softly.assertThat(mainPage.listOfImages.size()).as("Incorrect number of items")
                .isEqualTo(COUNT_OF_IMAGES_ON_MAIN_PAGE);
        for (int i = 0; i < COUNT_OF_IMAGES_ON_MAIN_PAGE; i++) {
            softly.assertThat(mainPage.listOfImages.get(i).isDisplayed());
        }
        /* Assert that there are 4 texts on the Index Page under icons and they have proper text. */
        for (int i = 0; i < mainPage.listOfTextUnderImages.size() - 1; i++) {
            softly.assertThat(mainPage.listOfTextUnderImages.get(i).getText()).as("Text is incorrect")
                    .isEqualTo(textUnderImages.get(i));
        }

        /* Assert that there is the iframe with “Frame Button” exist. */
        softly.assertThat(mainPage.frame.isDisplayed()).as("There is no button");
        //* Switch to the iframe and check that there is “Frame Button” in the iframe. */
        driver.switchTo().frame(ID_FRAME);
        softly.assertThat(mainPage.frameButton.isDisplayed()).as("There is no button "
                + "in the frame");
        /* Switch to original window back. */
        driver.switchTo().parentFrame();
        /* Assert that there are 5 items in the Left Section are displayed and they have proper text. */
        for (int i = 0; i < mainPage.leftMenu.size() - 1; i++) {
            softly.assertThat(mainPage.leftMenu.get(i).getText()).as("Text is incorrect")
                    .isEqualTo(leftMenuItems.get(i));
        }

        softly.assertAll();
    }
}
