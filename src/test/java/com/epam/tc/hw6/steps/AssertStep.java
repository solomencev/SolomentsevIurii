package com.epam.tc.hw6.steps;

import io.qameta.allure.Step;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class AssertStep extends BaseStep {
    public AssertStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Browser title equals 'Home Page' {title}")
    public void assertBrowserTitle(String title) {
        softAssert.assertThat(webDriver.getTitle()).as("Incorrect title").isEqualTo(title);
        softAssert.assertAll();
    }

    @Step("User is logged {userFullName}")
    public void assertUserIsLogged(String userFullName) {
        softAssert.assertThat(mainPage.getUserName()).as("Incorrect user name").isEqualTo(userFullName);
        softAssert.assertAll();
    }

    @Step("Assert that there are 4 items on header section are displayed and they have proper texts {listItemsHeader}}")
    public void assertItemsInHeader(List<String> listItemsHeader) {
        for (int i = 0; i < listItemsHeader.size(); i++) {
            softAssert.assertThat(mainPage.getMenuList().get(i).getText()).as("Wrong text")
                      .isEqualTo(listItemsHeader.get(i));
            softAssert.assertThat(mainPage.getMenuList().get(i).isDisplayed()).as("Not displayed").isTrue();
        }
        softAssert.assertAll();
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed {countOfImagesOnIndexPage}")
    public void  assertImagesOnIndexPage(int countOfImagesOnIndexPage) {
        softAssert.assertThat(mainPage.getListOfImages().size()).as("Incorrect number of items")
              .isEqualTo(countOfImagesOnIndexPage);
        for (int i = 0; i < countOfImagesOnIndexPage; i++) {
            softAssert.assertThat(mainPage.getListOfTextUnderImages().get(i).isDisplayed())
                      .as("Not displayed").isTrue();
        }
        softAssert.assertAll();
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text {textUnderImages}")
    public void  assertTextUnderIcons(List<String> textUnderImages) {
        for (int i = 0; i < mainPage.getListOfTextUnderImages().size() - 1; i++) {
            softAssert.assertThat(mainPage.getListOfTextUnderImages().get(i).getText())
                      .as("Wrong text").isEqualTo(textUnderImages
                .get(i));
        }
        softAssert.assertAll();
    }

    @Step("Assert that there is the iframe with “Frame Button” exist")
    public void assertIframeButtonExist() {
        softAssert.assertThat(mainPage.getFrame().isDisplayed()).as("Not displayed").isTrue();
        softAssert.assertAll();
    }

    @Step("Check that there is 'Frame Button' in the iframe")
    public void assertFrameButtonIsDisplayed() {
        softAssert.assertThat(mainPage.getFrameButton().isDisplayed()).as("Not displayed").isTrue();
        softAssert.assertAll();
    }

    @Step("Assert that there are 5 items in the Left Section are displayed and they have proper text {leftMenuItems}")
    public void  assertItemsInLeftSection(List<String> leftMenuItems) {
        for (int i = 0; i < mainPage.getLeftMenu().size() - 1; i++) {
            softAssert.assertThat(mainPage.getLeftMenu().get(i).getText())
                      .as("Wrong text").isEqualTo(leftMenuItems.get(i));
        }
        softAssert.assertAll();
    }

    @Step("Checkbox Water is checked")
    public void assertElementCheckBoxWaterIsSelected() {
        softAssert.assertThat(differentElementsPage.isCheckBoxWaterSelected()).as("Not selected").isTrue();
        softAssert.assertAll();
    }

    @Step("Radiobutton selen is checked")
    public void assertElementRadioButtonSelenIsSelected() {
        softAssert.assertThat(differentElementsPage.isRadioButtonSelenSelected()).as("Not selected").isTrue();
        softAssert.assertAll();
    }

    @Step("Checkbox Wind is checked")
    public void assertElementCheckBoxWindIsSelected() {
        softAssert.assertThat(differentElementsPage.isCheckBoxWindSelected()).as("Not selected").isTrue();
        softAssert.assertAll();
    }

    @Step("Dropdown is selected")
    public void assertElementDropdownYellowIsSelected() {
        softAssert.assertThat(differentElementsPage.isDropdownYellowSelected()).as("Not selected").isTrue();
        softAssert.assertAll();
    }

    @Step("Log row and value is corresponded to the selected value. {textForLogs}")
    public void assertLogsForElements(List<String> textForLogs) {
        for (int i = 0; i < textForLogs.size(); i++) {
            softAssert.assertThat(differentElementsPage.getLogs().get(i).getText())
                      .as("Not selected").contains(textForLogs.get(i));
        }
        softAssert.assertAll();
    }
}
