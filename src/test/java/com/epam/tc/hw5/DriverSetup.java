package com.epam.tc.hw5;

import com.epam.tc.hw4.BasePage;
import com.epam.tc.hw4.DifferentElementsPage;
import com.epam.tc.hw4.MainPage;
import com.epam.tc.hw4.hw4.fragments.HeaderMenu;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverSetup {

    protected static WebDriver driver;
    public static WebDriver setup() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;

    }

    public static void teardown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
