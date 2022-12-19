package com.epam.tc.hw2.ex1;

import com.epam.tc.hw2.AbstractChromeTest;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Exercise1Test extends AbstractChromeTest {

    public SoftAssertions softly = new SoftAssertions();

    /** Assert Browser title. */
    @Test
    public void exercise1() {

        /* Assert Browser title. */
        softly.assertThat(driver.getTitle()).isEqualTo("Home Page");

        /* Perform login. */
        try {
            new WebDriverWait(driver, 5)
                    .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li.uui-profile-menu"))).click();
            driver.findElement(By.id("name")).sendKeys("Roman");
            driver.findElement(By.id("password")).sendKeys("Jdi1234");
            driver.findElement(By.id("login-button")).click();
        } catch (NoSuchElementException e) {
            System.err.println("No element: " + e);
        }

        /* Assert Username is loggined.*/
        softly.assertThat(driver.findElement(By.id("user-name")).getText()).isEqualTo("ROMAN IOVLEV");

        /* Assert that there are 4 items on the header section are displayed and they have proper texts. */
        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a[href='index.html']")).isDisplayed());
        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a[href='contacts.html']")).isDisplayed());
        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a.dropdown-toggle")).isDisplayed());
        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a[href='metals-colors.html']")).isDisplayed());

        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a[href='index.html']")).getText()).isEqualTo("HOME");
        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a[href='contacts.html']")).getText()).isEqualTo("CONTACT FORM");
        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a.dropdown-toggle"))
                .getText()).isEqualTo("SERVICE");
        softly.assertThat(driver.findElement(By.cssSelector("ul.m-l8>li>a[href='metals-colors.html']")).getText()).isEqualTo("METALS & COLORS");
        softly.assertAll();


        /* Assert that there are 4 images on the Index Page and they are displayed.*/
        softly.assertThat(driver.findElement(By.className("icon-practise")).isDisplayed());
        softly.assertThat(driver.findElement(By.className("icon-custom")).isDisplayed());
        softly.assertThat(driver.findElement(By.className("icon-multi")).isDisplayed());
        softly.assertThat(driver.findElement(By.className("icon-base")).isDisplayed());
        softly.assertAll();

        /* Assert that there are 4 texts on the Index Page under icons and they have proper text. */
        softly.assertThat(driver.findElement(By.xpath("//div[normalize-space(span) = "
                + "'To include good practicesand ideas from successfulEPAM project']")).isDisplayed());
        softly.assertThat(driver.findElement(By.xpath("//div[normalize-space(span) = "
                + "'To be flexible andcustomizable']")).isDisplayed());
        softly.assertThat(driver.findElement(By.xpath("//span[(text()='To be multiplatform ')]")).isDisplayed());
        softly.assertThat(driver.findElement(By.xpath("//div[normalize-space(span) = 'Already "
                + "have good base(about 20 internal andsome external projects),wish to get more…']")).isDisplayed());
        softly.assertAll();

        /* Assert that there is the iframe with “Frame Button” exist. */
        boolean frameIsDisplayed = driver.findElement(By.id("frame")).isDisplayed();
        softly.assertThat(frameIsDisplayed).isTrue();

        /* Switch to the iframe and check that there is “Frame Button” in the iframe. */
        driver.switchTo().frame("frame");
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        boolean isFrameButtonDisplayed = frameButton.isDisplayed();
        softly.assertThat(isFrameButtonDisplayed).isTrue();

        /* 10 Switch to original window back. */
        driver.switchTo().defaultContent();

        /* Assert that there are 5 items in the Left Section are displayed and they have proper text. */
        softly.assertThat(driver.findElement(By.cssSelector(".sidebar-menu>li")).getText()).contains("Home");
        softly.assertThat(driver.findElement(By.cssSelector("ul.sidebar-menu.left > li[index='2']")).getText())
                .contains("Contact form");
        softly.assertThat(driver.findElement(By.cssSelector("ul.sidebar-menu.left > li[index='3']")).getText())
                .contains("Service");
        softly.assertThat(driver.findElement(By.cssSelector("ul.sidebar-menu.left > li[index='4']")).getText())
                .contains("Metals & Colors");
        softly.assertThat(driver.findElement(By.cssSelector("ul.sidebar-menu.left > li[index='5']")).getText())
                .contains("Elements packs");
        softly.assertAll();
    }
}
