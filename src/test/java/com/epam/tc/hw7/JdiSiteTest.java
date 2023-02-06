package com.epam.tc.hw7;

import static com.epam.tc.hw7.pages.JdiHomePage.ROMAN_IOVLEV;

import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class JdiSiteTest extends AbstractTest {

    @Test(dataProvider = "DataProviderJson", dataProviderClass = DataProviderMetalsAndColors.class)
    @Description(value = "User can submit Metals & Colors form")
    public void metalColorsFormSubmittingTest(jdi.entities.MetalsAndColors metalsAndColors) {
        JdiSite.homePage.userName.is().text(ROMAN_IOVLEV.getFullName());
        JdiSite.openMetalsAndColorsPage();
        JdiSite.metalsAndColorsPage.fillMetalAndColorForm(metalsAndColors);
        JdiSite.verifyResultLog(metalsAndColors);
    }
}
