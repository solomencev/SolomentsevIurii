package com.epam.tc.hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
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
