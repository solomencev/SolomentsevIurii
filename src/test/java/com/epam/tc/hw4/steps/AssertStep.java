package com.epam.tc.hw4.steps;

import com.epam.pages.MainPage;
import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AssertStep extends AbstractStep {

    public AssertStep(WebDriver driver) {
        super(driver);
    }

    @Step("Browser title equals 'Home Page'")
    public void assertBrowserTitle(String title) {
        softAssert.assertThat(webDriver.getTitle()).isEqualTo(title);
    }

    @Step("User is logged")
    public void assertUserIsLogged(String userFullName) {
        mainPage = new MainPage(webDriver);
        softAssert.assertThat(mainPage.getUserName()).isEqualTo(userFullName);
    }

    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertItemsInHeader(List<String> listItemsHeader) {
        for (int i = 0; i < listItemsHeader.size(); i++) {
            softAssert.assertThat(mainPage.getMenuList().get(i).getText()).isEqualTo(listItemsHeader.get(i));
            softAssert.assertThat(mainPage.getMenuList().get(i).isDisplayed());
        }
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void  assertImagesOnIndexPage(int countOfImagesOnIndexPage) {
        softAssert.assertThat(mainPage.getListOfImages().size()).as("Incorrect number of items")
              .isEqualTo(countOfImagesOnIndexPage);
        for (int i = 0; i < countOfImagesOnIndexPage; i++) {
            softAssert.assertThat(mainPage.getListOfTextUnderImages().get(i).isDisplayed())
                  .as("Incorrect number of images");
        }
        softAssert.assertAll();
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void  assertTextUnderIcons(List<String> textUnderImages) {
        for (int i = 0; i < mainPage.getListOfTextUnderImages().size() - 1; i++) {
            softAssert.assertThat(mainPage.getListOfTextUnderImages().get(i).getText()).isEqualTo(textUnderImages
                .get(i));
        }
    }

    @Step("Assert that there is the iframe with “Frame Button” exist")
    public void assertIframeButtonExist() {
        softAssert.assertThat(mainPage.getFrame().isDisplayed());
    }

    @Step("Check that there is 'Frame Button' in the iframe")
    public void assertFrameButtonIsDisplayed() {
        softAssert.assertThat(mainPage.getFrameButton().isDisplayed());
    }

    @Step("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void  assertItemsInLeftSection(List<String> leftMenuItems) {
        for (int i = 0; i < mainPage.getLeftMenu().size() - 1; i++) {
            softAssert.assertThat(mainPage.getLeftMenu().get(i).getText()).isEqualTo(leftMenuItems.get(i));
        }
    }

    @Step("Element is checked")
    public void assertElementIsSelected(WebElement element) {
        softAssert.assertThat(element.isSelected()).isTrue();
    }

    @Step("Log row and value is corresponded to the selected value.")
    public void assertLogsForElements(List<String> textForLogs) {
        for (int i = 0; i < textForLogs.size(); i++) {
            softAssert.assertThat(differentElementsPage.getLogs().get(i).getText()).contains(textForLogs.get(i));
        }
    }
}
