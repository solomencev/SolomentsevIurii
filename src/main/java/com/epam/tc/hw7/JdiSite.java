package com.epam.tc.hw7;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.pages.JdiHomePage;
import com.epam.tc.hw7.pages.MetalsAndColorsPage;

@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("/index.html")
    public static JdiHomePage homePage;

    @Url("metals-colors.html")
    public static MetalsAndColorsPage metalsAndColorsPage;

    public static void openHomePage() {
        homePage.open();
    }

    public static void login(jdi.entities.User user) {
        homePage.login(user);
    }

    public static String getUserName() {
        return homePage.getUserName();
    }

    public static void openMetalsAndColorsPage() {
        metalsAndColorsPage.open();
    }

    public static void verifyResultLog(jdi.entities.MetalsAndColors metalsAndColors) {
        metalsAndColorsPage.assertResultLog(metalsAndColors);
    }

}
