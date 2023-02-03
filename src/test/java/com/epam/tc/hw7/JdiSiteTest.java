package com.epam.tc.hw7;

import static com.epam.tc.hw7.pages.JdiHomePage.ROMAN_IOVLEV;

import org.testng.annotations.Test;

public class JdiSiteTest extends AbstractTest {

    @Test(dataProvider = "DataProviderJson", dataProviderClass = DataProviderMetalsAndColors.class)
    public void jdiHomepageTest(jdi.entities.MetalsAndColors metalsAndColors) {
        JdiSite.homePage.userName.is().text(ROMAN_IOVLEV.getFullName());
        JdiSite.openMetalsAndColorsPage();
        JdiSite.metalsAndColorsPage.fillMetalAndColorForm(metalsAndColors);
        JdiSite.verifyResultLog(metalsAndColors);
    }


}
