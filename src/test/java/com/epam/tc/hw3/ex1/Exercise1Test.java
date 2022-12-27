package com.epam.tc.hw3.ex1;

import com.epam.tc.hw3.AbstractChromeTest;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MainPage;

import static pages.MainPage.*;

public class Exercise1Test extends AbstractChromeTest {


    private static int countOfImagesOnMainPage = 4;
    private static List<String> textUnderImages = List
            .of("To include good practices\nand ideas from successful\nEPAM project",
                    "To be flexible and\ncustomizable",
                    "To be multiplatform",
                    "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…");

    public Exercise1Test() throws IOException {
    }

    @Test(groups = {"HW2"})
    public void exercise1() {
        SoftAssert softly = new SoftAssert();
        /* Open test site by URL. */
        driver.get(URL_HOME_PAGE);
        MainPage mainPage = new MainPage(driver);
        /* Assert Browser title. */
        softly.assertEquals(driver.getTitle(), HOME_PAGE);
        /* Perform login. */
        mainPage.login(user, password);
        /* Assert Username is loggined.*/
        softly.assertEquals(mainPage.userLogged(), userFullName);
        /* Assert that there are 4 items on the header section are displayed and they have proper texts. */
        for (int i = 0; i < LIST_ITEMS_HEADER.size(); i++) {
            softly.assertEquals(mainPage.menuList().get(i).getText(), LIST_ITEMS_HEADER.get(i));
            softly.assertTrue(mainPage.menuList().get(i).isDisplayed());
        }
        /* Assert that there are 4 images on the Index Page and they are displayed.*/
        softly.assertEquals(mainPage.listOfImages.size(), countOfImagesOnMainPage);
        for (int i = 0; i < countOfImagesOnMainPage; i++) {
            softly.assertTrue(mainPage.listOfImages.get(i).isDisplayed());
        }
        /* Assert that there are 4 texts on the Index Page under icons and they have proper text. */
        for (int i = 0; i < mainPage.listOfTextUnderImages.size() - 1; i++) {
            softly.assertEquals(mainPage.listOfTextUnderImages.get(i).getText(), textUnderImages.get(i));
        }
        /* Assert that there is the iframe with “Frame Button” exist. */
        softly.assertTrue(mainPage.frame.isDisplayed());
        //* Switch to the iframe and check that there is “Frame Button” in the iframe. */
        driver.switchTo().frame(ID_FRAME);
        softly.assertTrue(mainPage.frameButton.isDisplayed());
        /* Switch to original window back. */
        driver.switchTo().parentFrame();
        /* Assert that there are 5 items in the Left Section are displayed and they have proper text. */
        for (int i = 0; i < mainPage.leftMenu.size() - 1; i++) {
            softly.assertEquals(mainPage.leftMenu.get(i).getText(), leftMenuItems.get(i));
        }
        softly.assertAll();
    }
}
