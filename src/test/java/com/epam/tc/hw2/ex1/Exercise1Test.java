package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.AbstractChromeTest;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Exercise1Test extends AbstractChromeTest {

    public SoftAssertions softly = new SoftAssertions();

    /** Assert Browser title. */
    @Test(groups = {"HW2"})
    public void exercise1() {

        /* Assert Browser title. */
        softly.assertThat(driver.getTitle()).as("Browser title is incorrect").isEqualTo("Home Page");

        /* Perform login. */
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.uui-profile-menu"))).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.id("login-button")).click();

        /* Assert Username is loggined.*/
        softly.assertThat(driver.findElement(By.id("user-name")).getText()).as("Roman Iovlev is not logged")
                .isEqualTo("ROMAN IOVLEV");

        /* Assert that there are 4 items on the header section are displayed and they have proper texts. */
        List<WebElement> items = driver.findElements(By.cssSelector(".uui-navigation.nav.navbar-nav.m-l8>li"));
        softly.assertThat(items.size() == 4).as("Elements are not displayed").isTrue();

        for (int i = 0; i < items.size(); i++) {
            if (i == 0) {
                softly.assertThat(items.get(i).getText()).as("The name of first item in menu is not 'Home'")
                        .isEqualTo("HOME");
            } else if (i == 1) {
                softly.assertThat(items.get(i).getText()).as("The name of second item in menu is not 'Contact"
                        + " form'").isEqualTo("CONTACT FORM");
            } else if (i == 2) {
                softly.assertThat(items.get(i).getText()).as("The name of third item in menu is not 'Service'")
                        .isEqualTo("SERVICE");
            } else {
                softly.assertThat(items.get(i).getText()).as("The name of fourth item in menu is not 'Metals "
                        + "& colors'").isEqualTo("METALS & COLORS");
            }

        }

        /* Assert that there are 4 images on the Index Page and they are displayed.*/
        List<WebElement> icons = driver.findElements(By.className("benefit-icon"));
        softly.assertThat(icons.size() == 4).as("The number of images is more than 4").isTrue();
        for (int i = 0; i < icons.size(); i++) {
            softly.assertThat(items.get(i).isDisplayed()).as("Image is displayed");
        }

        /* Assert that there are 4 texts on the Index Page under icons and they have proper text. */
        softly.assertThat(driver.findElement(By.xpath("//div[normalize-space(span) = "
                + "'To include good practicesand ideas from successfulEPAM project']")).isDisplayed())
                        .as("Text is incorrect");
        softly.assertThat(driver.findElement(By.xpath("//div[normalize-space(span) = "
                + "'To be flexible andcustomizable']")).isDisplayed()).as("Text is incorrect");
        softly.assertThat(driver.findElement(By.xpath("//span[(text()='To be multiplatform ')]"))
                        .isDisplayed()).as("Text is incorrect");
        softly.assertThat(driver.findElement(By.xpath("//div[normalize-space(span) = 'Already "
                + "have good base(about 20 internal andsome external projects),wish to get more…']"))
                .isDisplayed()).as("Text is incorrect");

        /* Assert that there is the iframe with “Frame Button” exist. */
        driver.findElement(By.id("frame"));
        softly.assertThat(driver.findElement(By.id("frame")).isDisplayed()).as("There is no button");

        /* Switch to the iframe and check that there is “Frame Button” in the iframe. */
        driver.switchTo().frame("frame");
        softly.assertThat(driver.findElement(By.id("frame-button")).isDisplayed()).as("There is no button "
                + "in the frame");

        /* Switch to original window back. */
        driver.switchTo().defaultContent();

        /* Assert that there are 5 items in the Left Section are displayed and they have proper text. */
        List<WebElement> itemsLeftSideBar = driver.findElements(By.cssSelector(".sidebar-menu>li"));
        softly.assertThat(itemsLeftSideBar.size() == 5).as("Wrong number of items in the left side bar")
                .isTrue();
        for (int i = 0; i < itemsLeftSideBar.size(); i++) {
            if (i == 0) {
                softly.assertThat(itemsLeftSideBar.get(i).getText()).as("The name of first item in menu is "
                        + "not 'Home'").isEqualTo("Home");
            } else if (i == 1) {
                softly.assertThat(itemsLeftSideBar.get(i).getText()).as("The name of second item in menu is "
                        + "not 'Contact form'").isEqualTo("Contact form");
            } else if (i == 2) {
                softly.assertThat(itemsLeftSideBar.get(i).getText()).as("The name of third item in menu is"
                        + " not 'Service'").isEqualTo("Service");
            } else if (i == 3) {
                softly.assertThat(itemsLeftSideBar.get(i).getText()).as("The name of third item in menu is "
                        + "not 'Metals & Colors'").isEqualTo("Metals & Colors");
            } else {
                softly.assertThat(itemsLeftSideBar.get(i).getText()).as("The name of fourth item in menu is "
                        + "not 'Elements packs'").isEqualTo("Elements packs");
            }
        }

        softly.assertAll();
    }
}
